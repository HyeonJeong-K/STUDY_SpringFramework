package com.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.test.board.domain.BoardVO;
import com.test.board.service.BoardService;

@Controller
public class BoardController {

	private BoardService boardService;

	@Autowired 
	public BoardController(BoardService boardService) {
		this.boardService = boardService; 
	}

	// 글 목록
	@RequestMapping(value = "/list") // 글 목록
	public String list(Model model) {
		model.addAttribute("list", boardService.list());
		return "/board/list"; // view에 대한 경로
	}

	// 글 읽기
	@RequestMapping(value = "/read/{board_seq}") // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String read(Model model, @PathVariable int board_seq) {
		model.addAttribute("boardVO", boardService.select(board_seq));
		return "/board/read";
	}

	// 새 글 작성을 위한 요청 처리
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO()); // Board 객체를 생성하여 Model에 추가하여 객체가 없을 떄 예외 제거
		return "/board/write";
	}

	// 새 글 등록을 위한 요청 등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO, BindingResult bindingResult) { // @Valid : 유효성 검증 기능
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/board/write";
		}
		boardService.insert(boardVO);
		return "redirect:/board/list";
	}

	// 수정할 글 가져오기
	@RequestMapping(value = "/edit/{board_seq}", method = RequestMethod.GET)
	public String edit(@PathVariable int board_seq, Model model) {
		BoardVO boardVO = boardService.select(board_seq);
		model.addAttribute("boardVO", boardVO);
		return "/board/edit";
	}

	// 글 수정하기
	@RequestMapping(value = "/edit/{board_seq}", method = RequestMethod.POST)
	public String edit(BoardVO boardVO, BindingResult result, String password, Model model, @PathVariable int board_seq) {
		if (result.hasErrors()) {
			return "/board/edit";
		} else {
			if (boardVO.getPassword() == password) {
				boardService.update(boardVO);
				return "redirect:/list";
			}
		}
		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		return "/board/edit";
	}

	// 글 삭제 요청을 처리할 메서드
	@RequestMapping(value = "/delete/{board_seq}", method = RequestMethod.GET)
	public String delete(@PathVariable int board_seq, Model model) {
		model.addAttribute("board_seq", board_seq);
		return "/board/delete";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(int board_seq, String password, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		rowCount = boardService.delete(boardVO);

		if (rowCount == 0) {
			model.addAttribute("board_seq", board_seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/delete";
		} else {
			return "redirect:/board/list";
		}
	}
}
