package com.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.board.domain.BoardVO;
import com.test.board.domain.MessageVO;
import com.test.board.domain.ReplyVO;
import com.test.board.service.BoardService;
import com.test.board.service.MessageService;

@Controller
public class BoardController {

	private BoardService boardService;
	private MessageService messageService;

	@Autowired 
	public BoardController(BoardService boardService, MessageService messageService) {
		this.boardService = boardService; 
		this.messageService = messageService;
	}
	
	// 글 목록
	@RequestMapping(value = "/list") // 글 목록
	public String list(Model model) {
		model.addAttribute("list", boardService.list());
		return "/board/list"; // view에 대한 경로
	}

	// 글 읽기 + 댓글 작성 및 읽기
	@RequestMapping(value = "/read/{board_seq}", method = RequestMethod.GET) // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String read(Model model, @PathVariable int board_seq) {
		model.addAttribute("boardVO", boardService.select(board_seq));
		model.addAttribute("repList", boardService.repList(board_seq));
		model.addAttribute("replyVO", new ReplyVO());
		return "/board/read";
	}
	
	// 글 읽기 + 댓글 등록 요청
	@RequestMapping(value = "/read/{board_seq}", method = RequestMethod.POST) // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String read(@PathVariable int board_seq, ReplyVO replyVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/board/read";
		}
		boardService.repInsert(replyVO);
		return "redirect:/read/{board_seq}";
	}

	// 새 글 작성을 위한 요청 처리
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO()); // Board 객체를 생성하여 Model에 추가하여 객체가 없을 떄 예외 제거
		return "/board/write";
	}

	// 새 글 등록을 위한 요청 등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/board/write";
		}
		boardService.insert(boardVO);
		return "redirect:/list";
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

	@RequestMapping(value="/delete/{board_seq}", method = RequestMethod.POST)
	public String delete(@PathVariable int board_seq, String password, Model model) {
		int rowCount;
		BoardVO boardVO = new BoardVO();
		boardVO.setBoard_seq(board_seq);
		boardVO.setPassword(password);
		
		rowCount = boardService.delete(boardVO);
		
		if(rowCount == 0) {
			model.addAttribute("board_seq", board_seq);
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/delete";
		} else {
			return "redirect:/list";
		}
	}
	
	
	
	// 쪽지 목록
	@RequestMapping(value = "/msgList/{board_seq}") // 글 목록
	public String msgList(Model model, @PathVariable int board_seq) {
		model.addAttribute("msgList", messageService.msgList(board_seq));
		return "/message/msgList"; // view에 대한 경로
	}
	
	// 쪽지 보내기 요청을 위한 처리
	@RequestMapping(value = "/msgWrite/{board_seq}", method = RequestMethod.GET)
	public String msgWrite(Model model, @PathVariable int board_seq, BoardVO boardVO) {
		model.addAttribute("board_seq", board_seq);
		model.addAttribute("messageVO", new MessageVO());
		return "/message/msgWrite";
	}

	// 쪽지 등록을 위한 요청 등록
	@RequestMapping(value = "/msgWrite/{board_seq}", method = RequestMethod.POST)
	public String msgWrite(@PathVariable int board_seq, MessageVO messageVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/message/msgWrite";
		}
		messageService.msgInsert(messageVO);
		return "redirect:/list";
	}
	
	// 쪽지 읽기
	@RequestMapping(value = "/{board_seq}/msgRead/{msg_seq}", method = RequestMethod.GET) // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String msgRead(Model model, @PathVariable int msg_seq, @PathVariable int board_seq) {
		model.addAttribute("messageVO", messageService.msgSelect(msg_seq));
		model.addAttribute("board_seq", board_seq);
		return "/message/msgRead";
	}
	
	// 쪽지 삭제
	@RequestMapping(value = "/{board_seq}/msgDelete/{msg_seq}", method = RequestMethod.GET)
	public String msgDelete(@PathVariable int msg_seq, @PathVariable int board_seq, Model model) {
		model.addAttribute("msg_seq", msg_seq);
		return "/message/msgDelete";
	}
	
	@RequestMapping(value="/{board_seq}/msgDelete/{msg_seq}", method = RequestMethod.POST)
	public String msgDelete(@PathVariable int msg_seq, @PathVariable int board_seq, Model model, boolean check) {
		//model.addAttribute("board_seq", board_seq);	// msgList?board_seq=7이라고 나옴........ㅠㅡㅠ
		
		if(check == false) {
			model.addAttribute("msg_seq", msg_seq);
			return "/message/msgDelete";
		} else {
			messageService.msgDelete(msg_seq);
			return "redirect:/msgList/{board_seq}";
		}
	}
	
	
}
