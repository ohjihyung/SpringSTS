package org.hdcd.controller.form.checkboxes;


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
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/formtag/checkboxes")
public class JSPFormCheckboxesTagController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPFormCheckboxesTagController.class);
	
	/*
	 *  8장 스프링 폼 태그
	 *  
	 *    7. 여러개의 체크박스 요소
	 *    
	 *    - html 여러개의 체크박스를 출력하려면 <form:checkboxes> 요소를 사용
	 *    
	 */
	
	//1) 모델에 Map 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@GetMapping("/registerForm01")
	public String registerForm01(Model model) {
		logger.info("registerForm01");
		
		Map<String, String> hobbyMap = new HashMap<String, String>();
		hobbyMap.put("01", "sports");
		hobbyMap.put("02", "movie");
		hobbyMap.put("03", "music");
		
		model.addAttribute("hobbyMap", hobbyMap);
		model.addAttribute("member", new Member());
		
		return "form/checkboxes/registerForm01";
	}
	
	//2) 모델에 List 타입의 데이터를 생성하여 추가한 후에 화면에 전달한다.
	@GetMapping("/registerForm02")
	public String registerForm02(Model model) {
		
		List<CodeLabelValue> hobbyCodeList = new ArrayList<>();
		hobbyCodeList.add(new CodeLabelValue("01", "SPORT"));
		hobbyCodeList.add(new CodeLabelValue("02", "MOVIE"));
		hobbyCodeList.add(new CodeLabelValue("03", "MUSIC"));
		
		model.addAttribute("hobbyCodeList",hobbyCodeList);
		model.addAttribute("member", new Member());
		return "form/checkboxes/registerForm02";
		
	}
	
}
