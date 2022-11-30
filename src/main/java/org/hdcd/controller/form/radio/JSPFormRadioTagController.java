package org.hdcd.controller.form.radio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.vo.CodeLabelValue;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/radio")
public class JSPFormRadioTagController {

	private static Logger logger = LoggerFactory.getLogger(JSPFormRadioTagController.class);
	
	/*
	 *  8장 스프링 폼 태그
	 *  
	 *  9. 여러개의 라디오 버튼 요소
	 *    - html 패스워드 필드를 출력하려면 <form:radiobuttons> 요소를 사용합니다.
	 * */
	
	//1) 모델에 기본생성자로 생성한 폼 객체를 추가한 후에 화면에 전달한다.
	
	@GetMapping("/registerRadiosForm01")
	public String registerRadiosForm01(Model model) {
		logger.info("registerRadiosForm01");
		
		// 컨트롤러에서 Map 타입으로 라디오버튼에서 사용될 내용을 구성 후 브라우저로 보내주면
		// 브라우저 JSP단에서 form:radiobuttons 라디오 버튼 여러개를 취급하는 요소가
		// 객수만큼 해당 내용들을 가지고 작성해 준다.
		Map<String, String> genderCodeMap = new HashMap<String, String>();
		genderCodeMap.put("01", "Male");
		genderCodeMap.put("02", "Female");
		genderCodeMap.put("03", "Other");
		model.addAttribute("genderCodeMap",genderCodeMap);
		model.addAttribute("member", new Member());
		
		return "form/radio/registerRadiosForm01";
		
	}

	//2) 폼 객체를 생성하여 값을 설정한 후에 전달한다.
	@GetMapping("/registerRadiosForm02")
	public String registerRadiosForm02(Model model) {
	
		logger.info("registerRadiosForm02");
		List<CodeLabelValue> genderCodeList = new ArrayList<CodeLabelValue>();
		genderCodeList.add(new CodeLabelValue("01", "Male"));
		genderCodeList.add(new CodeLabelValue("02", "Female"));
		genderCodeList.add(new CodeLabelValue("03", "Other"));
		
		model.addAttribute("genderCodeList", genderCodeList);
		model.addAttribute("member", new Member());
		
		return "form/radio/registerRadiosForm02";
		
	}
	
	@PostMapping("/result")
	public String registerRadiosFormresult(Member member, Model model) {
		
		
		logger.info("member.getGender" + member.getGender());
		model.addAttribute("gender", member.getGender());
		
		return "form/radio/result";
	}
	@GetMapping("/registerRadioForm01")
	public String registerRadioForm01(Model model) {
		logger.info("registerRadioForm01");

		model.addAttribute("member", new Member());
		
		return "form/radio/registerRadioForm01";
		
	}
	
	@GetMapping("/registerRadioForm02")
	public String registerRadioForm02(Model model) {
	
		logger.info("registerRadioForm02");
		Member member = new Member();
		member.setGender("female");
		
		model.addAttribute("member", member);
		
		return "form/radio/registerRadioForm01";
		
	}
	
	@PostMapping("/result2")
	public String registerRadioFormresult(Member member, Model model) {
		
		logger.info("member.getGender" + member.getGender());
		model.addAttribute("member", member);
		
		return "form/radio/result2";
	}

}
