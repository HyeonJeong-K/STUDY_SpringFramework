package com.test.file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.file.domain.BoardVO;
import com.test.file.service.BoardService;

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
	@RequestMapping(value = "/read/{board_seq}", method = RequestMethod.GET) // 페이지 링크 값 c:url value="/board/read/${board.seq}" 글 읽기
	public String read(Model model, @PathVariable int board_seq) {
		model.addAttribute("boardVO", boardService.select(board_seq));
		
		return "/board/read";
	}
	
	// 파일 다운로드 기능
	@RequestMapping(value = "/down/{file_name}", method = RequestMethod.GET) // {file_name}로 받은 값으로 이름이 저장됨..왜???
	public void down(Model model, @PathVariable String file_name, HttpServletRequest request, HttpServletResponse response) {
		//String path =  request.getSession().getServletContext().getRealPath("저장경로");
        
        file_name = request.getParameter("fileName");
        String realFilename="";
        System.out.println(file_name);
         
        try {
            String browser = request.getHeader("User-Agent"); 
            //파일 인코딩 
            if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
            	file_name = URLEncoder.encode(file_name, "UTF-8").replaceAll("\\+", "%20");
            } else {
            	file_name = new String(file_name.getBytes("UTF-8"), "ISO-8859-1");
            }
        } catch (UnsupportedEncodingException ex) {
            System.out.println("UnsupportedEncodingException");
        }
        realFilename = "D:\\file\\" + file_name;
        System.out.println(realFilename);
        
        File file1 = new File(realFilename);
        if (!file1.exists()) {
            return ;
        }
         
        // 파일명 지정        
        response.setContentType("application/octer-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Content-Disposition", "attachment; file_name=\"" + file_name + "\"");
        try {
            OutputStream os = response.getOutputStream();
            FileInputStream fis = new FileInputStream(realFilename);
 
            int ncount = 0;
            byte[] bytes = new byte[512];
 
            while ((ncount = fis.read(bytes)) != -1 ) {
                os.write(bytes, 0, ncount);
            }
            fis.close();
            os.close();
        } catch (Exception e) {
            System.out.println("FileNotFoundException : " + e);
        }
    }
	
	// 새 글 작성을 위한 요청 처리
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("boardVO", new BoardVO()); // Board 객체를 생성하여 Model에 추가하여 객체가 없을 떄 예외 제거
		return "/board/write";
	}

	// 새 글 등록을 위한 요청 등록
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO, BindingResult bindingResult) throws IOException {
		if (bindingResult.hasErrors()) { // 사용자가 입력한 값 중 타입이 맞지 않거나 null 값인 경우 예외처리
			return "/board/write";
		}
		
		String file_name = null;
		MultipartFile uploadFile = boardVO.getUploadFile();
		System.out.println(uploadFile);
		
		if (!uploadFile.isEmpty()) {
			String orgFileName = uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(orgFileName);
			UUID uuid = UUID.randomUUID();
			file_name = uuid + "." + ext;
			uploadFile.transferTo(new File("D:\\file\\" + file_name));
		} else {
			file_name = "";
		}
		
		boardVO.setFile_name(file_name);
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
}
