package com.khj.board.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hsqldb.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.khj.board.domain.ContentVO;
import com.khj.board.domain.MemberVO;
import com.khj.board.service.ContentService;
import com.khj.board.service.MemberService;


@Controller
public class MainController {

	@Autowired 
	private MemberService memberService;

	@Autowired
	private ContentService contentService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale) {

		return "home";
	}

	// 회원가입
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model) {

		model.addAttribute("memberVO", new MemberVO());

		return "member/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(MemberVO memberVO, BindingResult bindingResult) {

		if(bindingResult.hasErrors()) {
			return "member/register";
		}

		memberService.register(memberVO);

		return "redirect:/";
	}

	// 로그인
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {

		model.addAttribute("member", new MemberVO());

		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO memberVO, HttpServletRequest req) throws Exception {

		HttpSession session = req.getSession();
		MemberVO loginUser = memberService.login(memberVO);

		if(loginUser == null) {
			session.setAttribute("member", null);  
		} else {
			session.setAttribute("member", loginUser);
		}

		return "redirect:/";
	}

	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {

		session.invalidate();

		return "redirect:/";
	}

	// 글 목록
	@RequestMapping(value = "/list") // 글 목록
	public String list(Model model) {
		model.addAttribute("list", contentService.list());
		return "/board/list"; // view에 대한 경로
	}

	// 글 읽기 + 댓글 작성 및 읽기
	@RequestMapping(value = "/read/{cid}", method = RequestMethod.GET) // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String read(Model model, @PathVariable int cid) {
		model.addAttribute("contentVO", contentService.select(cid));
		//model.addAttribute("repListd", contentService.repList(board_seq));
		//model.addAttribute("replyVO", new ReplyVO());
		return "/board/read";
	}

	// 글 읽기 + 댓글 등록 요청
	@RequestMapping(value = "/read/{cid}", method = RequestMethod.POST) // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String read(@PathVariable int board_seq, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/board/read";
		}
		//contentService.repInsert(replyVO);
		return "redirect:/read/{board_seq}";
	}

	// 새 글 작성을 위한 요청 처리
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("contentVO", new ContentVO()); // Board 객체를 생성하여 Model에 추가하여 객체가 없을 떄 예외 제거
		return "/board/write";
	}

	// 새 글 등록을 위한 요청 등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(ContentVO contentVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/board/write";
		}
		contentService.insert(contentVO);
		return "redirect:/list";
	}

	// 수정할 글 가져오기
	@RequestMapping(value = "/edit/{cid}", method = RequestMethod.GET)
	public String edit(@PathVariable int cid, Model model) {
		ContentVO contentVO = contentService.select(cid);
		model.addAttribute("contentVO", contentVO);
		return "/board/edit";
	}

	// 글 수정하기
	@RequestMapping(value = "/edit/{cid}/{uid}", method = RequestMethod.POST)
	public String edit(ContentVO contentVO, BindingResult result, String password, Model model, @PathVariable int cid) {
		if (result.hasErrors()) {
			return "/board/edit";
		} else {
			if (contentVO.getCid() == cid) {
				contentService.update(contentVO);
				return "redirect:/list";
			}
		}
		model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
		return "/board/edit";
	}

	// 글 삭제 요청을 처리할 메서드
	@RequestMapping(value = "/delete/{cid}", method = RequestMethod.GET)
	public String delete(@PathVariable int cid, Model model) {
		model.addAttribute("cid", cid);
		return "/board/delete";
	}

	@RequestMapping(value="/delete/{cid}", method = RequestMethod.POST)
	public String delete(@PathVariable int cid, String password, Model model) {
		int rowCount;
		ContentVO contentVO = new ContentVO();
		contentVO.setCid(cid);
		//contentVO.setPassword(password);

		rowCount = contentService.delete(contentVO);

		if(rowCount == 0) {
			model.addAttribute("cid", cid);
			//model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "/board/delete";
		} else {
			return "redirect:/list";
		}
	}


}
