package org.hdcd.controller.form.validation;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/validation")
public class JSPFormValidationController {

	private static Logger logger = LoggerFactory.getLogger(JSPFormValidationController.class);
	
	
	/**
	 *  8장 스프링 폼태그
	 *  
	 *  15. 입력값 검증 에러
	 *   - 입력값 검증 에러를 출력하려면 <form:errors> 요소를 사용한다.
	 *   
	 *   
	 *   
	 *   
	 *   값을 누락시키고 컨트롤러로 넘겼는데 결과페이지 이동????
	 *   /formtag/validation/registerFormValidation01 로  요청을 보내고 데이터 입력 폼을 다 비우고 등록 버튼 땅!
	 *   - 빈값이므로 데이터를 입력해달라느니 뭔가 에러 메세지가 form:errors 로 나타날것이라 예상했지만  안나옴? 
	 *   - 왜 why???
	 *   - 해당 이유는 아래 참조
	 *   
	 *   [이유]
	 *   클라이언트에서 서버로 modelAttribute에서 바인딩 할 객체를 설정하고 
	 *   아이디를 누락 시킨 후 서버로 요청했을 때,
	 *   form:errors 에 담길 메세지는 바인딩되서 넘어오지만,
	 *   바인딩 되었다고 출력을 위한 validation 역할자가 없기 때문에
	 *   그 역할을 담당할 validation이 역할을 다못하므로 그냥 없는체로
	 *   페이지가 출력됨
	 */
	
	// 객체를 생성하여 값을 설정한 후 화면에 전달
	@GetMapping("/registerFormValidation01")
	public String registerFormValidation01(Model model) {
		
		logger.info("registerFormValidation01");
		Member member = new Member();
		
		member.setEmail("aaa@bbb.com");
		member.setUserName("홍길동");
		
		model.addAttribute("member", member);
		
		return "form/validation/registerFormValidation01";
	}
	
	@PostMapping("/result")
	public String registerFormValidationResult(Model model,Member member) {
		
		logger.info("registerFormValidationResult");
		
		logger.info("member.getUserId() : " + member.getUserId());
		logger.info("member.getUserName() : " + member.getUserName());
		logger.info("member.getEmail() : " + member.getEmail());
		
		model.addAttribute("memeber", member);
		
		return "form/validation/result";
	}
	
}
