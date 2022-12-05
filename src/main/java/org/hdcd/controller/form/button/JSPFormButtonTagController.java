package org.hdcd.controller.form.button;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/button")
public class JSPFormButtonTagController {

	private static Logger logger = LoggerFactory.getLogger(JSPFormButtonTagController.class);
	
	@GetMapping("registerFormButton01")
	public String registerFormButton01(Model model) {
		logger.info("registerFormButton01");
		
		Member member = new Member();
		
		member.setEmail("aaa@bbb.com");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "form/button/registerFormButton01";
	}
	
	@PostMapping("/result")
	public String registerFormButtonresult(Model model, Member member) {
		logger.info("registerFormButtonresult");
		
		logger.info("member.getUserId :" + member.getUserId());
		logger.info("member.getUserName :" + member.getUserName());
		logger.info("member.getEmail :" + member.getEmail());

		
		model.addAttribute("member",member);
		
		return "form/button/result";
	}
	
}
