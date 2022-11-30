package org.hdcd.controller.form.textarea;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/textarea")
public class JSPFormTextareaTagController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPFormTextareaTagController.class);

	/*
	 *  8장 스프링 폼 테그
	 *  
	 *  6. 택스트 영역 요소(textarea)
	 *  - HTML 텍스트 영역을 출력하려면 <form:textarea> 요소를 사용
	 * 	
	 * */
	
	//1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		logger.info("registerForm01()");
		
		model.addAttribute("member", new Member());
		
		return "form/textarea/registerForm01";
		
	}
	
	//2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	@GetMapping("/registerForm02")
	public String registerForm02(Model model) {
		logger.info("registerForm01()");
		Member member = new Member();
		member.setIntroduction("안녕하세요~\n방가방가");
	
		model.addAttribute("member", member);
		
		return "form/textarea/registerForm01";
	}
}
