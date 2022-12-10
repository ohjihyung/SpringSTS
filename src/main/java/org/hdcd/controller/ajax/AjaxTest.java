package org.hdcd.controller.ajax;

import java.util.List;
import java.util.Map;

import org.hdcd.vo.Merong;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ajax")
public class AjaxTest {
	
	@GetMapping("/test")
	public String getAjax() { // Get은 보통 사용자 요청화면이나, 리스트를 처리할 때 사용 
		return "ajaxTest";
	}
	
	
	// produces =  잭슨 라이브러리한태 일반 text로 처리하고 charset은 utf-8로 해라
	@PostMapping(value="/getTest", produces = "text/plain;charset=utf-8")
	@ResponseBody   // ajax 요청 URL엔 이게 꼭 있어야 해용 , response.getWriter / 포워딩 방법이 아닌 진짜 완전매롱이 전달됨
	public String ajaxPost(@RequestBody Map<String, String> aVO) {  
		
		//잘넘어왔는지 확인 
		System.out.println(aVO.get("name"));
		System.out.println(aVO.get("age"));
		
		return "완전 메롱";
	}
	
	@PostMapping(value="/getTest2", produces = "application/json;charset=utf-8")
	@ResponseBody   // ajax 요청 URL엔 이게 꼭 있어야 해용 , response.getWriter / 포워딩 방법이 아닌 진짜 완전매롱이 전달됨
	public List<String> ajaxPost2(@RequestBody List<String> bVO) {  
		//잘넘어왔는지 확인 
		
		for(String str : bVO) {
			System.out.println(str);
		}
			
		
		return bVO;
	}
	@PostMapping(value="/getTest3", produces = "application/json;charset=utf-8")
	@ResponseBody   // ajax 요청 URL엔 이게 꼭 있어야 해용 , response.getWriter / 포워딩 방법이 아닌 진짜 완전매롱이 전달됨
	public List<Map<String, String>> ajaxPost3(@RequestBody List<Map<String, String>> cVO) {  
		for(Map<String, String> merong : cVO) {
			System.out.println(merong.get("name"));
			System.out.println(merong.get("age"));
			System.out.println("--------------------------");
		}
		return cVO;
	}
	
	@PostMapping(value="/getTest4", produces = "application/json;charset=utf-8")
	@ResponseBody   // ajax 요청 URL엔 이게 꼭 있어야 해용 , response.getWriter / 포워딩 방법이 아닌 진짜 완전매롱이 전달됨
	public Map<String, Object> ajaxPost4(@RequestBody Map<String, Object> dVO) {  
		
		System.out.println(dVO.get("name"));
		List<String> idols =   (List<String>)dVO.get("idols");
		for(int i = 0; i < idols.size();i++) {
			System.out.println(idols.get(i));
		}
		
		return dVO;
	}
	
	@PostMapping(value="/getTest5", produces = "application/json;charset=utf-8")
	@ResponseBody   // ajax 요청 URL엔 이게 꼭 있어야 해용 , response.getWriter / 포워딩 방법이 아닌 진짜 완전매롱이 전달됨
	public Merong ajaxPost5(@RequestBody Merong merong) {  
		
	
		System.out.println(""+merong);
		
		return merong;
	}
	
	
}
