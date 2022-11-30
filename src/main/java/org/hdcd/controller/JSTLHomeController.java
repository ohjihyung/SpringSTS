package org.hdcd.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jstl")
public class JSTLHomeController {
	
	private static Logger logger = LoggerFactory.getLogger(JSTLHomeController.class);
	
	@GetMapping("/home0101")
	public String home0101(Model model) {
		logger.info("home0101");
		Member member = new Member();
		member.setUserId("hongkd");
		model.addAttribute("member", member);
		
		return "home/jstl/home0101";
	}
	
	//2) escapeXml 속성의 기본값은 true이므로 특수문자를 변환한다
	@GetMapping("/home0102")
	public String home0102(Model model) {
		logger.info("home0102");
		Member member = new Member();
		member.setUserId("hongkd<>&%0102");
		model.addAttribute("member", member);
		
		return "home/jstl/home0102";
	}
	
	//2) escapeXml 속성값을  false로 지정하면 특수문자를 변환되지 않음
	@GetMapping("/home0103")
	public String home0103(Model model) {
		logger.info("home0103");
		Member member = new Member();
		member.setUserId("<p>hongkd<>&%0103</p>");
		model.addAttribute("member", member);
		
		return "home/jstl/home0103";
	}
	
	@GetMapping("/home0105")
	public String home0105(Model model) {
		logger.info("home0105");
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "home/jstl/home0105";
	}
	
	//jsp에서 사용될 변수를 설정하지 않고 자바빈즈 프로퍼티 값을 바로 표시
	@GetMapping("/home0201")
	public String home0201(Model model) {
		logger.info("home0201");
		Member member = new Member();
		member.setUserId("hong0201");
		model.addAttribute("member", member);
		
		return "home/jstl/home0201";
	}
	//jsp에서 사용될 변수 memberId를 설정해서 사용한다.
	@GetMapping("/home0202")
	public String home0202(Model model) {
		logger.info("home0202");
		Member member = new Member();
		member.setUserId("hong0202");
		model.addAttribute("memberId", member);
		
		return "home/jstl/home0202";
	}
	
	//jsp에서 사용될 변수 memberId를 설정해서 사용한다.
	@GetMapping("/home0203")
	public String home0203(Model model) {
		logger.info("home0203");
		Member member = new Member();
		member.setUserId("hong0203");
		model.addAttribute("member", member);
		
		return "home/jstl/home0203";
	}
	
	//member 객체의 userId 프로퍼티 값을 설정한다.
	@GetMapping("/home0204")
	public String home0204(Model model) {
		logger.info("home0204");
		Member member = new Member();
		model.addAttribute("member", member);

		return "home/jstl/home0204";
	}
	
	// c:set 태그로 지정한 변수 memberId를 삭제한다.
	@GetMapping("/home0301")
	public String home0301(Model model) {
		logger.info("home0301");
		Member member = new Member();
		member.setUserId("hongkd0301");
		
		model.addAttribute("member", member);
		return "home/jstl/home0301";
	}
	
	// el 식 내부에서 발생한 예외는 el식 내부에서 처리하므로 catch 변수
	// 'ex'에 저장되지 않는다.
	@GetMapping("/home0401")
	public String home0401(Model model) {
		logger.info("home0401");
		Member member = new Member();
		member.setUserId("hongkd0401");
		String[] hobbyArray0401 = {"music0401","movie0401"};
		member.setHobbyArray(hobbyArray0401);
		model.addAttribute("member", member);
		return "home/jstl/home0401";
	}
	
	//jsp 표현식에서 발생한 예외는 catch변수 'ex'에 저장된다.
	@GetMapping("/home0402")
	public String home0402(Model model) {
		logger.info("home0402");
		
		return "home/jstl/home0402";
	}
	
	//test 속성에 true false를 리턴하는 조건문이 온다
	@GetMapping("/home0501")
	public String home0501(Model model) {
		logger.info("home0501");
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "home/jstl/home0501";
	}
	
	//test 속성에 true나 false를 값으로 가지는 불리언 변수가 올 수 있다.
	@GetMapping("/home0502")
	public String home0502(Model model) {
		logger.info("home0502");
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "home/jstl/home0502";
	}
	//모든 c:when 태그의 test 결과값이 false 이면 c:otherwise가 실행된다.
	@GetMapping("/home0601")
	public String home0601(Model model) {
		logger.info("home0601");
		
		Member member = new Member();
		model.addAttribute("member", member);
		
		return "home/jstl/home0601";
	}
	//모든 c:when 태그의 test 결과값이 false 이면 c:otherwise가 실행된다.
	@GetMapping("/home0602")
	public String home0602(Model model) {
		logger.info("home0602");
		
		Member member = new Member();
		member.setGender("M");
		model.addAttribute("member", member);
		
		return "home/jstl/home0601";
	}
	
	//배열값을 순차적으로 처리한다
	@GetMapping("/home0701")
	public String home0701(Model model) {
		logger.info("home0701");
		
		Member member = new Member();
		String[] hobbyArray0701 = {"Music","drive","movie","game"};
		member.setHobbyArray(hobbyArray0701);

		model.addAttribute("member", member);
		
		return "home/jstl/home0701";
	}
	
	//List에 저장되어 있는 값을 순차적으로 처리한다.
	@GetMapping("/home0702")
	public String home0702(Model model) {
		logger.info("home0702");
		
		Member member = new Member();
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("music");
		hobbyList.add("drive");
		hobbyList.add("movie");
		hobbyList.add("game");
		hobbyList.add("development");
		
		member.setHobbyList(hobbyList);
		
		model.addAttribute("member", member);
		
		return "home/jstl/home0702";
	}
	
	// 객체를 요소값으로 가지는 list인 경우에 var 속성에 객체 변수를 지정하여 처리한다.
	@GetMapping("/home0703")
	public String home0703(Model model) {
		logger.info("home0703");
		
		Member member = new Member();
		List<Card> cardList = new ArrayList<Card>();
		Card card1 = new Card();
		card1.setNo("12345");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONDAY, 12);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("6764");
		
	
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONDAY, 5);
		cal.set(Calendar.DAY_OF_MONTH, 4);
		
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		
		model.addAttribute("member", member);
		
		return "home/jstl/home0703";
	}
	
	//delims 속성에 지정된 구분자를 사용하여 items 속성에 전달된 
	//문자열을 나누고 var 속성에 명시한 변수에 나눠진 문자열을 지정한다
	
	@GetMapping("/home0801")
	public String home0801(Model model) {
		logger.info("home0801");
		
		Member member = new Member();
		String hobby = "music,movie,drive";
		member.setHobby(hobby);
		
		model.addAttribute("member", member);
		
		return "home/jstl/home0801";
	}
	
	//특정 URL의 결과를 읽어와서 현재 위치에 삽입한다.
	// c:import
	@GetMapping("/home0901")
	public String home0901(Model model) {
		logger.info("home0901");
		
		return "home/jstl/home0901";
	}
	// 웹 어플리케이션 내에서의 절대 경로를 사용하면 실제로 생성된 컨텍스트 경로가 포함된다.
	@GetMapping("/home1001")
	public String home1001(Model model) {
		logger.info("home1001");
		
		return "home/jstl/home1001";
	}
	
	//지정한 페이지로 리다이렉트 시킨다.
	@GetMapping("/home1101")
	public String home1101() {
		
		return "home/jstl/home1101";
	}
	
	//지정한 페이지로 리다이렉트 시킨다.
	@GetMapping("/home1102")
	public String home1102() {
		
		return "home/jstl/home1102";
	}
}
