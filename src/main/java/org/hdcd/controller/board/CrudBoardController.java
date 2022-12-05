package org.hdcd.controller.board;


import java.util.List;

import javax.inject.Inject;

import org.hdcd.controller.board.service.IBoardService;
import org.hdcd.vo.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/crud/board")
public class CrudBoardController {
	private static Logger logger = LoggerFactory.getLogger(CrudBoardController.class);
	
	@Inject
	private IBoardService service;
	
	@GetMapping("/register")
	public String crudRegisterForm() {
		logger.info("crudRegister");
		return "crud/register";
	}
	
	@PostMapping("/register")
	public String crudRegister(Board board, Model model) throws Exception {
		logger.info("crudRegister");
		service.register(board);
		
		if(board.getBoardNo() > 0) {
			return "redirect:/crud/board/read?boardNo=" + board.getBoardNo();
		}
		
		model.addAttribute("msg", "등록 완료!");
		
		return "crud/success";
	}
	
	@GetMapping("/list")
	public String crudList(Model model) throws Exception {
		logger.info("crudList");
		List<Board> boardList = service.list();
		model.addAttribute("list", boardList);
		
		return "crud/list";
		
	}
	
	@GetMapping("/read")
	public String crudRead(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("crudRead");
		Board board = service.read(boardNo);
		model.addAttribute("board", board);
		
		return "crud/read";
		
	}
	
	@GetMapping("/modify")
	public String crudModifyForm(int boardNo, Model model) throws Exception {
		logger.info("crudModifyForm");
		Board board = service.read(boardNo);
		
		model.addAttribute("board", board);
		model.addAttribute("status", "u");
		
		return "crud/register";
	}
	
	@PostMapping("/modify")
	public String crudModify(Board board, Model model) throws Exception{
		logger.info("crudModify");
		service.update(board);
		model.addAttribute("msg", "수정완료!");
		
		return "crud/success";
	
	}
	
	@PostMapping("/remove")
	public String crudDelete(@RequestParam("boardNo") int boardNo, Model model) throws Exception {
		logger.info("crudDelete");
		service.delete(boardNo);
		
		model.addAttribute("msg", "삭제가 완료되었습니다");
		
		return "crud/success";
	}
	@PostMapping("/search")
	public String crudSearch(@RequestParam("title") String title, Model model) throws Exception {
		logger.info("crudSearch");
		
		Board board = new Board();
		board.setTitle(title);
		
		List<Board> boardList = service.search(title);
		
		model.addAttribute("board", board);
		model.addAttribute("list", boardList);
		
		return "crud/list";
		
	}
}
