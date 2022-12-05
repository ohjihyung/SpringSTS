package org.hdcd.controller.free;

import java.util.List;

import javax.inject.Inject;
import javax.websocket.server.PathParam;

import org.hdcd.controller.free.service.freeBoardService;
import org.hdcd.vo.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/free")
public class CrudFreeController {
	private static Logger logger = LoggerFactory.getLogger(CrudFreeController.class);
	
	//service 등록
	@Inject
	private freeBoardService service;
	
	//1. 등록 페이지 요청
	@GetMapping("/freeRegisterform")
	public String freeRegisterform(Board board, Model model) {
		logger.info("freeRegisterform");
		model.addAttribute("board", board);
		return "crud/free/register";
	}
	
	//2. 등록 
	@PostMapping("/register")
	public String register(Board board, Model model) throws Exception {
		logger.info("register");
		service.createfree(board);
	
		model.addAttribute("msg", "등록완료");
		
		return "crud/free/success";
	}
	
	@GetMapping("/list")
	public String list(Board board, Model model) throws Exception {
		
		List<Board> boardList = service.list();
		
		model.addAttribute("boardList", boardList);
		
		return "crud/free/list";			
	}
	
	//상세보기 페이지 데이터 들고 이동
	@GetMapping("/read")
	public String read(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("boardNo :" + boardNo);
		
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		
		return "crud/free/read";
		
	}
	
	//수정
	@PostMapping("/modify")
	public String modify(Model model, Board board) throws Exception {
		
		service.modify(board);
		
		model.addAttribute("msg", "수정완료");
		return "crud/free/success";
	}
	
	
	//삭제 
	@GetMapping("/delete")
	public String delete(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		
		if(boardNo >0) {
			service.delete(boardNo);
		}
		model.addAttribute("msg", "삭제완료");
		
		return "crud/free/success";
	}
}
