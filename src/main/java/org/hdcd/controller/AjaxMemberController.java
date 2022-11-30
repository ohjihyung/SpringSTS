package org.hdcd.controller;

import java.util.List;


import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxMemberController {
	
	private static Logger logger = LoggerFactory.getLogger(AjaxMemberController.class);
	
	
	// 9. Ajax 방식 요청 처리 시작 페이지
	// url : /ajax/registerForm
	@RequestMapping("/registerForm")
	public String ajaxRegisterForm() {
		return "member/ajaxRegisterForm";
	}
	
	
	//1)
	// URL 경로 상의 경로 변수값을 @PathVariable 어노테이션을 지정하여
	// 문자열 매개변수로 처리한다.
	@GetMapping("/register/{userId}")
	public ResponseEntity<String> ajaxRegister01(@PathVariable("userId") String userId){
		
		logger.info("ajaxRegister01");
		logger.info("userId : " + userId );
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
		
	}
	
	
	@PostMapping("/register/{userId}/{password}")
	public ResponseEntity<String> ajaxRegister02(@PathVariable("userId") String userId, @PathVariable("password") String password){
		
		logger.info("ajaxRegister02");
		logger.info("userId : " + userId );
		logger.info("password : " + password );
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
		
	}
	
	
	@PostMapping("/register03")
	public ResponseEntity<String> ajaxRegister03(@RequestBody Member member){
		
		logger.info("ajaxRegister03");
		logger.info("userId : " + member.getUserId() );
		logger.info("password : " + member.getPassword());
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	//4)
	// 객체 타입의 JSON 요청 데이터는 문자열 매개변수로 처리할 수 없다
	@PostMapping("/register04")
	public ResponseEntity<String> ajaxRegister04(String userId){
		// 요청 본문에서 데이터가 바인딩 되지 않아 userId가 null 이 나온다.
		// 요청 본문에서 데이터를 가져오려면 @RequestBody 어노테이션이 필요하다.
		logger.info("ajaxRegister04");
		logger.info("userId :" + userId);
	
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	//5)
	// 요청 URL에 쿼리파라미터를 붙여서 전달하면 문자열 매개변수로 처리한다
	@PostMapping("/register05")
	public ResponseEntity<String> ajaxRegister05(String userId, String password){
		// userId 쿼리스트링에 담겨져 오는 데이터이기 때문에, 일반적인 방식으로도 
		//데이터를 받을 수 있지만, 
		//password는 요청 본문에서 데이터를 바인딩해 받아오지 못하므로 null이 출력
		logger.info("ajaxRegister05");
		logger.info("userId :" + userId);
		logger.info("password :" + password);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	// 6) 객체 타입의 JSON 요청 데이터를 @PathVariable 어노테이션을 지정한 문자열 매개변수와 <br/>
	//@RequestBody 어노테이션을 지정한 자바빈즈 매개변수로 처리한다.)
	@PostMapping("/register06/{userId}")
	public ResponseEntity<String> ajaxRegister06(@PathVariable("userId") String userId, @RequestBody Member member){
		
		logger.info("ajaxRegister06");
		logger.info("userId :" + userId);
		logger.info("member.getuserId :" + member.getUserId());
		logger.info("member.getpassword :" + member.getPassword());
	
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}

	//7)객체 배열 타입의 JSON 요청 데이터를 자바빈즈 요소를 가진 리스트 컬랙션 
		//매개변수에 @RequestBody 어노테이션을 지정하여 처리한다
	@PostMapping("/register07")
	public ResponseEntity<String> ajaxRegister07(@RequestBody List<Member> memberList){
		logger.info("ajaxRegister07");
		
		for(Member member : memberList) {
			logger.info("userId :" + member.getUserId());
			logger.info("password : " + member.getPassword());
		}

		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/register08")
	public ResponseEntity<String> ajaxRegister08(@RequestBody Member member){
		
		logger.info("ajaxRegister08");
		logger.info("userId :" + member.getUserId());
		logger.info("password :" + member.getPassword());
		
		Address address = member.getAddress();
		if(address != null) {
			logger.info("address.getPostCode :" + address.getPostCode());
			logger.info("address.getLocation :" + address.getLocation());
		}else {
			logger.info("address == null");
		}
		
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	@PostMapping("/register09")
	public ResponseEntity<String> ajaxRegister09(@RequestBody Member member){
		
		logger.info("ajaxRegister09");
		logger.info("userId :" + member.getUserId());
		logger.info("password :" + member.getPassword());
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() :" + cardList.size());
			
			for(int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() :" + card.getNo());
				logger.info("card.getValidMonth() :" + card.getValidMonth());
			}
		}else {
			logger.info("cardList == null");
		}
		ResponseEntity<String> entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		
		return entity;
	}
	
	
	
}
