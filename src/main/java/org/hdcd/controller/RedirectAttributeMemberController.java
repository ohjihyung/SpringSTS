package org.hdcd.controller;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectAttributeMemberController {
	
	private static Logger logger = LoggerFactory.getLogger(RedirectAttributeMemberController.class);
	
	/*
	 * 	 4. RedirectAttribute 타입
	 * 	 - RedirectAttribute 는 일회성으로 데이터를 전달하는 용도로 사용
	 *   
	 * 
	 * */
	
	@GetMapping("/redirectattribute/registerForm")
	public String registerForm() {
		
		logger.info("registerForm");
		
		return "member/registerRedirectAttributeForm";
		
	}
	
	//1. 일회성으로 데이터 전달
	@PostMapping("/redirectattribute/register")
	public String register(Member member, RedirectAttributes redirectAttributes) {
		logger.info("register");
		
		//flash == 번개 번쩍 일회성 
		redirectAttributes.addFlashAttribute("msg","success");
		
		return "redirect:/redirectattribute/result";
	}
	
	
	//2. 1 처리후  전달
	@RequestMapping(value="/redirectattribute/result", method = RequestMethod.GET)
	public String result() {
		logger.info("result");
		
		return "result";
	}
	
}
