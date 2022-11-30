package org.hdcd.controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPHomeController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPHomeController.class);
	
	/*
	   7장 JSP
	   
	   1. 지시자
	  
	 */
	
	// 지시자 시작 페이지
	// 최초 home.jsp 페이지입니다.
	@GetMapping("/jsp")
	public String home(Locale locale, Model model) {
		
		logger.info("Welcome home! is locale {}", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		String formatterDate = dateFormat.format(date);
		model.addAttribute("serverTime", formatterDate);
		return "home";
	}
	
	// 7장 1)지시자, 스크립틀릿 내용 페이지
	@GetMapping("/home01")
	public String home01(Locale locale, Model model) {
		
		logger.info("Welcome home! is locale {}", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		String formatterDate = dateFormat.format(date);
		model.addAttribute("serverTime", formatterDate);
		return "home/home01";
	}
	
	
	// 지시자 & 스크립틀릿
	@GetMapping("/home02")
	public String home02(Model model) {
		
		Member member = new Member();
		member.setUserId("hong");
		member.setPassword("1234");
		member.setEmail("aaa@ddd.com");
		member.setUserName("홍길동");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateofBirth(cal.getTime());
		model.addAttribute(member);
		
		return "home/home02";
	}

	
	// 3.includes/footer.jsp includes/header.jsp
	@GetMapping("/home03")
	public String home03(Locale locale, Model model) {
		
		logger.info("Welcome home! is locale {}", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		String formatterDate = dateFormat.format(date);
		model.addAttribute("serverTime", formatterDate);
		return "home/home03";
	}
	/*
		3. 커스텀 태그 라이브러리 
		스크립트 요소가 많아지면 많아질 수록 JSP 코드는 복잡해진다
		이문제를 해결하는 한가지 방법은 커스텀 태그를 사용하는 것
		커스텀 태그를 사용하면 뷰를 표시하기위 한 로직을 공통화하거나 표현하기가 복잡한
		로직을 캡슐화 할 수 있어서
		JSP의 구현 코드를 간결하게 만들 수 있다.
		
		그리고, 커스텀 태그를 모아놓은 것을 커스텀 태그 라이브러리 라고 한다.
		
		# 대표적인 태그 라이브러리
		 -JSTL(JAVA SERVER TAG LIBRARY)
		 - spring-form JSP Tag Library
		 - spring JSP Tag library
		 - spring Security JSP Tag Library
	 * */
	

	
	/*
	 * 	4. 표현언어 (EL)
	 *  jsp 는 EL (Expression language) 이라는 표현 언어를 사용해 값의 참조, 출력 ,연산  
	 *  할 수 있다.
	 *  
	 *  EL식은 ${...} 또는 #{..}형식으로 작성
	 * */
	
	
	// 1) 자바빈즈 프로퍼티를 조회하는 경우 '속성명.프로퍼티명'을 지정
	@GetMapping("/home0101")
	public String home0101(Model model) {
		Member member = new Member();
		member.setUserId("hong123");
		member.setPassword("1234");
		member.setEmail("aaa@vbb.com");
		member.setUserName("홍길동");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateofBirth(cal.getTime());
		model.addAttribute(member);
		
		return "home/home0101";
	}
	
	@GetMapping("/home0102")
	public String home0102(Model model) {
		Member member = new Member();
		
		String[] hobbyArray = {"movie", "sport"};
		member.setHobbyArray(hobbyArray);
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("movie");
		hobbyList.add("sport");
		member.setHobbyList(hobbyList);
		
		model.addAttribute(member);
		
		return "home/home0102";
	}
	
	@GetMapping("/home0103")
	public String home0103(Model model) {
		Member member = new Member();
		
		Address address = new Address();
		address.setPostCode("03201");
		address.setLocation("대전");
		member.setAddress(address);
		
		model.addAttribute(member);
		
		return "home/home0103";
		
	}
	@GetMapping("/home0104")
	public String home0104(Model model) {
		Member member = new Member();
		
		List<Card> cardList = new ArrayList<Card>();
		
		Card card1 = new Card();
		card1.setNo("1234");
				
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2022);
		cal.set(Calendar.MONTH, 5);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("421421");
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 6);
		
		card2.setValidMonth(cal.getTime());
		cardList.add(card2);
		
		member.setCardList(cardList);
		model.addAttribute(member);
		
		return "home/home0104";
		
	}
	
	//1-5) 
	@GetMapping("/home0105")
	public String home0105(Model model) {
		Map memberMap = new HashMap();
		memberMap.put("userId", "hong12");
		memberMap.put("password", "1234");
		memberMap.put("email", "aaa@asd.com");
		memberMap.put("userName", "홍길동");
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 11);
		cal.set(Calendar.DAY_OF_MONTH, 12);
		
		memberMap.put("dateofBirth", cal.getTime());
		
		model.addAttribute("memberMap",memberMap);
		
		return "home/home0105";
	}
	
	//2) 산술 연산자 사용
	@GetMapping("/home0201")
	public String home0201(Model model) {
		int coin = 1000;
		model.addAttribute("coin",coin);
		
		return "home/home0201";
	}
	
	//3) 비교연산자 사용
	@GetMapping("/home0202")
	public String home0202(Model model) {
		int coin = 1000;
		model.addAttribute("coin",coin);
		
		return "home/home0202";
	}
	
	// 3-2 ) 비교 연산자 사용
	@GetMapping("/home0203")
	public String home0203(Model model) {
		String userId = "hongkd";
		model.addAttribute("userId", userId);
		
		return "home/home0203";
	}
	
	//4) empty 연산자 이용 
	@GetMapping("/home0301")
	public String home0204(Model model) {
		Member member = new Member();
		member.setUserId("hongkd");
		
		model.addAttribute(member);
		
		return "home/home0301";
	}
	
	//4-2 empty 연산자 사용 
	@GetMapping("/home0302")
	public String home0302(Model model) {
		Member member = new Member();
		model.addAttribute(member);
		
		return "home/home0302";
	}
	
	//4-3) empty 연산자 사용
	
	@GetMapping("/home0303")
	public String home0303(Model model) {
		Member member = new Member();
		member.setUserId("hongkd");
		model.addAttribute(member);
		
		return "home/home0303";
	}
	
	//4-5
	@GetMapping("/home0305")
	public String home0305(Model model) {
		Member member = new Member();
		
		String[] hobbyArray = null;
		member.setHobbyArray(hobbyArray);
		member.setUserId("hongkd");
		
		model.addAttribute(member);
		
		return "home/home0305";
	}
	//4-6
	@GetMapping("/home0306")
	public String home0306(Model model) {
		Member member = new Member();
		
		String[] hobbyArray = {};
		member.setHobbyArray(hobbyArray);
		model.addAttribute(member);
		
		return "home/home0306";
	}
	//4-7
	@GetMapping("/home0307")
	public String home0307(Model model) {
		Member member = new Member();
		
		String[] hobbyArray = {"music", "movie"};
		member.setHobbyArray(hobbyArray);
		model.addAttribute(member);
		
		return "home/home0307";
	}
	//4-8
	@GetMapping("/home0308")
	public String home0308(Model model) {
		Member member = new Member();
		model.addAttribute(member);
	
		return "home/home0308";
	}
	
	//4-9
	@GetMapping("/home0309")
	public String home0309(Model model) {
		Member member = new Member();
		List<String> hobbyList = new ArrayList<String>();
		member.setHobbyList(hobbyList); 
		model.addAttribute(member);
		
		return "home/home0309";
	}
	
	//4-10
	@GetMapping("/home0311")
	public String home0311(Model model) {
		Member member = new Member();
		Map memeberMap = new HashMap();
		model.addAttribute(memeberMap);
		return "home/home0311";
	}
	
	
}
