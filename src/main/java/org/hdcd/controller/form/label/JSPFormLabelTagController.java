package org.hdcd.controller.form.label;


import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/label")
public class JSPFormLabelTagController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPFormLabelTagController.class);
	
	@GetMapping("/registerFormLabel01")
	public String registerFormLabel01(Model model) {
		logger.info("registerFormLabel01");
		
		model.addAttribute("member", new Member());
		
		return "form/label/registerFormLabel01";
		
	}
	
	// 객체를 생성하여 값을 설정한 후 화면에 전달
	
	@GetMapping("/registerFormLabel02")
	public String registerFormLabel02(Model model) {
		logger.info("registerFormLabel02");
		Member member = new Member();
		member.setUserId("hongkd");
		member.setUserName("홍길동");
		member.setEmail("aaa@bbb.com");
		
		model.addAttribute("member", member);
		
		return "form/label/registerFormLabel01";
		
	}
	
	@PostMapping("/result")
	public String registerFormLabelresult(Model model, Member member) {
		logger.info("registerFormLabelresult");
		
		logger.info("member.getUserId :" + member.getUserId());
		logger.info("member.getUserName :" + member.getUserName());
		logger.info("member.getEmail :" + member.getEmail());
		
		//자바빈즈 클래스는 매개변수로 선언해놓으면 model 전달자로 데이터
		//옮기지 않아도됨
		//여기서는 옮겨보자
		model.addAttribute("member", member);
		
		return "form/label/result";
		
	}
	
	
}
