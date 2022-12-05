package org.hdcd.controller.form.hidden;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/hidden")
public class JSPFormHiddenTagController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPFormHiddenTagController.class);

	
	/*
	 *  8장 스프링 폼 태그
	 *  
	 *  12. 숨겨진 필드 요소
	 *  
	 *  HTML 숨겨진 필드를 출력하려면 <form:hidden> 요소를 사용한다.
	 *  
	 * 
	 */
	
	
	//객체를 생성하여 값을 설정한 후 화면에 전달한다.
	@GetMapping("/registerFormHidden01")
	public String registerFormHidden01(Model model) {
		logger.info("registerFormHidden01");
		
		Member member = new Member();
		member.setUserId("hongkd");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "form/hidden/registerFormHidden01";
	
	}
	
	@PostMapping("/result")
	public String registerFormHiddenResult(Model model, Member member) {
		
		logger.info("registerFormHiddenResult");
		
		logger.info("member.getUserId() :" + member.getUserId());
		logger.info("member.getUserName() :" + member.getUserName());
		
		//자바빈즈는 이렇게 안해도 넘어감
		model.addAttribute("member", member);
		
		return "form/hidden/result";
	}
	
}
