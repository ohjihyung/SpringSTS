package org.hdcd.controller.board;



import java.util.Date;

import org.hdcd.vo.Board;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger =  LoggerFactory.getLogger(BoardController.class);

	/*
	 	1. 요청 경로 매핑 
	 		@RequestMapping(value="board/register")
	 		@RequestMapping(value="board/modify")
	 		@RequestMapping(value="board/remove")
	 		
	 	  해당 경로로 요청시, 페이지를 리턴하는 부분이 없기 때문에 404에러가 발생하는 걸로 생각되나
	 	  스프링 View Resolver 라는 녀석이 리턴된 페이지 Name이 존재하지 않는 경우,
	 	  요청된 url을 가지고 매핑정보로 삼아 페이지를 찾아서 앞에는 '/WEB-INF/views/'를 
	 	  뒤에는 '.jsp'를 붙여서 페이지 정보를 찾아 응답 리소스 데이터를 구성하여 응답 데이터로 리턴됩니다.
	 	
	 */
	
	
	
	
	//@RequestMapping(value="/register",method = RequestMethod.GET)
	@GetMapping("/register")
	public String registerForm() {
		logger.info("registerForm() 실행..");
		
		return "success";
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public String registerFormPost() {
		logger.info("registerFormPost() 실행..");

		return "success";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String modifyForm() {
		logger.info("modifyForm() 실행..");

		return "success";
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modifyFormPost() {
		logger.info("modifyFormPost() 실행..");

		return "success";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.GET)
	public String removeForm() {
		logger.info("removeForm() 실행");
		return "success";
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.POST)
	public String removeFormPost() {
		logger.info("removeFormPost() 실행");
		return "success";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list() {
		logger.info("list() 실행..");
		
		return "success";
	}
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String search(String keyword, Model model) {
		logger.info("search() 실행..");
		model.addAttribute("keyword", keyword);
		return "board/search";
	}
	
	@RequestMapping(value="/read/{boardNo}")
	public String read(@PathVariable int boardNo) { // url로 넘어온 값을 안에서 사용가능하다
		logger.info("read boardNo :" + boardNo);
		return "board/read";
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "register")
	public String registerParamGet() {
		logger.info("registerParamsGet() 실행...");
		return "board/register";
	}
	
	@RequestMapping(value="/post", method = RequestMethod.POST, params = "register")
	public String registerParamPost() {
		logger.info("registerParamsPost() 실행...");
		return "board/register";
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "modify")
	public String modifyParamsGet() {
		logger.info("modifyParamsGet() 실행...");
		return "board/modify";	
	}
	@RequestMapping(value="/post", method = RequestMethod.POST, params = "modify")
	public String modifyParamsPost() {
		logger.info("modifyParamsPost() 실행...");
		return "board/modify";	
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "remove")
	public String removeParamsGet() {
		logger.info("removeParamsGet() 실행...");
		return "board/remove";	
	}
	@RequestMapping(value="/post", method = RequestMethod.POST, params = "remove")
	public String removeParamsPost() {
		logger.info("removeParamsPost() 실행...");
		return "board/remove";	
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "list")
	public String listParamsGet() {
		logger.info("listParamsGet() 실행...");
		return "board/list";	
	}
	
	@RequestMapping(value="/get", method = RequestMethod.GET, params = "read")
	public String readParamsGet() {
		logger.info("readParamsGet() 실행...");
		return "board/read";	
	}
	
	//  ====================== 5. Headers 매핑
	// 1) 
	@RequestMapping(value="/{boardNo}", method =RequestMethod.PUT)
	public ResponseEntity<String> modifyAjax(@PathVariable("boardNo") int boardNo, 
			@RequestBody Board board){
		
		logger.info("Headers 매핑 : modifyAjax");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		
		return entity;
	}
	
	//2)
	//Headers 매핑을 이용한 PUT 통신
	@RequestMapping(value="/{boardNo}", method= RequestMethod.PUT, headers = "X-HTTP-Method-Override=PUT")
	public ResponseEntity<String> modifyAjaxByHeader(@PathVariable("boardNo") int boardNo, @RequestBody Board board){
		logger.info("Headers 매핑 : modifyAjaxByHeader");
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
		
	}
	
	
	//=====================6 . content-Type 매핑
	// 1)
	//요청 본문의 미디어 탑입을 지정하지 않으면 기본값인 "application/json" 미디어 타입으로 지정됩니다.
	@RequestMapping(value="/{boardNo}", method = RequestMethod.POST)
	public ResponseEntity<String>modifyContentTypePost(@PathVariable("boardNo") int boardNo, 
			@RequestBody Board board){
		
		logger.info("Content-Type 매핑 : modifyContentTypePost ");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
		
	}
	
	// 2)
	// ContentType 매칭을 이용한 PUT 통신(json)
	// consumes 속성값에 "application/json" 미디어 타입을 지정한다.
	// 요청에서 설정한 ContentType으로 설정한 설정값 "application/json" 타입을 받기 위한 속성
	@RequestMapping(value="/{boardNo}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> modifyContentTypeByJson(@PathVariable("boardNo") int boardNo, 
			@RequestBody Board board){
		logger.info("Content-Type 매핑 : modifyContentTypeByJson ");
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	//3 )
	// ContentType 매핑을 이용한 PUT 통신(xml)
	// consumes 속성값에 "application/xml" 미디어 타입을 지정한다.
	
	@RequestMapping(value="/{boardNo}",method = RequestMethod.PUT, consumes = "application/xml")
	public ResponseEntity<String> modifyContentTypeByXml(@PathVariable("boardNo") int boardNo, 
			@RequestBody Board board){
		logger.info("Content-Type 매핑 : modifyContentTypeByXml ");
		logger.info(" modifyContentTypeByXml : boardNo " + boardNo);
		logger.info(" modifyContentTypeByXml : board " + board);
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	// 7.Accept 매핑
	//1) 
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET)
	public ResponseEntity<Board> readAccept(@PathVariable("boardNo") int boardNo){
		logger.info("readAccept 실행");
		Board board = new Board();
		board.setTitle("제목입니다1");
		board.setContent("내용입니다");
		board.setWriter("작성자입니다1");
		board.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(board,HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET,produces = "application/json")
	public ResponseEntity<Board> readToJson(@PathVariable("boardNo") int boardNo, Board board){
		logger.info("readToJson 실행");
		String addStr = "_json";
		Board boardVO = new Board();
		boardVO.setTitle("제목" + addStr);
		boardVO.setContent("내용" + addStr);
		boardVO.setWriter("제목" + addStr);
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO,HttpStatus.OK);
		
		return entity;
	}
	
	@RequestMapping(value="/{boardNo}", method = RequestMethod.GET, produces = "application/xml")
	public ResponseEntity<Board> readToXml(@PathVariable("boardNo") int boardNo, Board board){
		logger.info("readToXml 실행");
		
		String addStr = "_xml";
		Board boardVO = new Board();

		boardVO.setTitle("제목" + addStr);
		boardVO.setContent("내용" + addStr);
		boardVO.setWriter("제목" + addStr);
		boardVO.setRegDate(new Date());
		
		ResponseEntity<Board> entity = new ResponseEntity<Board>(boardVO,HttpStatus.OK);
		
		return entity;
	}

}
