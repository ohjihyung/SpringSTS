package org.hdcd.controller.form.password;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/password")
public class JSPFormPasswordTagController {

	private static Logger logger = LoggerFactory.getLogger(JSPFormPasswordTagController.class);
	
	/*
	 *  8장 스프링 폼 태그
	 *  
	 *  5. 패스워드 필드 요소
	 *    - html 패스워드 필드를 출력하려면 <form:password> 요소를 사용합니다.
	 * */
	
	//1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		model.addAttribute("member", new Member());
		
		return "form/password/registerForm01";
		
	}

	//2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	@GetMapping("/registerForm02")
	public String registerForm02(Model model) {
		// 값을 설정해서 뷰에 전달하더라도 패스워드 필드에 반영되지 않음 !
		logger.info("registerForm02");
		Member member= new Member();
		member.setPassword("1234sss");
		model.addAttribute("member", member);
		
		return "form/password/registerForm01";
		
	}

}
