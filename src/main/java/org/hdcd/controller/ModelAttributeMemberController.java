package org.hdcd.controller;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ModelAttributeMemberController {
	
	private Logger logger = LoggerFactory.getLogger(ModelAttributeMemberController.class);
	/*
	 *  3. @ModelAttribute 어노테이션 
	 *   - @ModelAttribute 어노테이션은 전달받은 매개변수를 강제로 Model에 담아서
	 *   전달하도록 할 때 필요한 어노테이션
	 */
	
	// 3 @ModelAttribute 어노테이션  입력 Form 페이지
	@GetMapping("/modelattribute/registerForm")
	public String registerForm() {
		logger.info("registerForm");
		
		return "member/registerModelAttributeForm";
	}
	
	
	//1) 기본 자료형은 매개변수로 선언하더라도 기본적으로 전달되지 않는다
	@RequestMapping(value="/modelattribute/register01", method = RequestMethod.POST)
	public String register01(String userId){
		//매개변수로 기본 자료형을 선언하더라도 결과 페이지로 전달되지 않는다.
		logger.info("register01");
		logger.info("userId :" + userId);
		return "result";
	}

	//2) 기본 자료형인 매개변수에 @ModelAttribute 어노테이션을 지정해 데이터 전달
	@PostMapping("/modelattribute/register02")
	public String register02(@ModelAttribute("userId") String userId) {
		logger.info("register02");
		logger.info("userId :" + userId);
		return "result";
	}
	
	//3) 기본 자료형인 매개변수가 여러 개인 경우에 각각 매개변수에 @ModelAttribute 어노테이션을 지정해 데이터 전달
	@PostMapping("/modelattribute/register03")
	public String register03(@ModelAttribute("userId") String userId,
							 @ModelAttribute("password") String password) {
		logger.info("register03");
		logger.info("userId :" + userId);
		logger.info("password :" + password);
		return "result";
	}
	
	//4) 자바빈즈 규칙에 맞는 객체는 매개변수로 선언하면 기본적으로 전달
	@PostMapping("/modelattribute/register04")
	public String register04(Member member) {
		logger.info("register04");
		logger.info("member.getuserId() :" + member.getUserId());
		logger.info("member.getPassword() :" + member.getPassword());
		return "result";
	}
	//5) 자바빈즈 규칭에 맞는 객체는 매개변수로 선언하면 기본적으로 전달된다 
	@PostMapping("/modelattribute/register05")
	public String register05(Member member) {
		logger.info("register05");
		logger.info("member.getuserId() :" + member.getUserId());
		logger.info("member.getPassword() :" + member.getPassword());
		logger.info("member.getAddress().getPostCode() :" + member.getAddress().getPostCode());
		logger.info("member.getAddress().getLocation() :" + member.getAddress().getLocation());
		return "result";
	}
	
}
