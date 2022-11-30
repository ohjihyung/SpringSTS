package org.hdcd.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ModelMemberController {
	
	private static Logger logger = LoggerFactory.getLogger(ModelMemberController.class);
	
	
	/*
	 *  6장. 데이터 전달자 모델
	 *  - Model 객체 이용
	 *  
	 *  1) 매개변수에 선언된 Model 객체의 addAttribute() 메서드를 호출하여 데이터를 뷰(view)에 전달한다.
	 *  
	 * 
	 * */
	
	
	@GetMapping("/read01")
	public String read01(Model model) {
		logger.info("read01");
		
		model.addAttribute("userId", "hongkd");
		model.addAttribute("password", "1234");
		model.addAttribute("email", "aaa@vbbb.com");
		model.addAttribute("userName", "홍길동");
		model.addAttribute("birthday", "2022-11-21");

		return "member/read01";
	}
	
	//2) Model 객체에 자바빈즈 클래스 객체를 값으로만 전달할 때는 뷰에서 참조할 이름을 
	//클래스명의 앞글자를 소문자로 변환하여 처리
	
	@GetMapping("/read02")
	public String read02(Model model) {
		
		logger.info("read02");
		Member member = new Member();
		member.setUserId("hong");
		member.setPassword("1234");
		member.setUserName("홍길동");
		member.setEmail("aaa@vvv.com");
		member.setBirthDay("2022-11-23");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONDAY, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateofBirth(cal.getTime());
		model.addAttribute(member);
		return "member/read02";		
	}

	// 3) Model 객체에 자바빈즈 클래스 객체를 특정한 이름을 지정하여 전달할 수 있다.
	@GetMapping("/read03")
	public String read03(Model model) {
		
		logger.info("read03");
		Member member = new Member();
		member.setUserId("hong");
		member.setPassword("1234");
		member.setUserName("홍길동");
		member.setEmail("aaa@vvv.com");
		member.setBirthDay("2022-11-23");
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONDAY, 10);
		cal.set(Calendar.DAY_OF_MONTH, 7);
		
		member.setDateofBirth(cal.getTime());
		model.addAttribute("user", member);
		
		return "member/read03";
	}
	
	//4 ) Model 객체를 통해 배열과 컬랙션 객체를 전달할 수 있다.
	@RequestMapping(value ="/read04", method = RequestMethod.GET)
	public String read04(Model model) {
		
		logger.info("read04");
		
		String[] carArray = {"benz", "bmw"};
		
		List<String> carList = new ArrayList<String>();
		carList.add("benz");
		carList.add("bmw");
		
		String[] hobbyArray = {"music", "movie"};
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("music");
		hobbyList.add("movie");
				
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);
		
		return "member/read04";
	}
	
	//5) Model 객체를 통해 중첩된 자바빈즈 클래스 객체를 전달할 수 있다.
	
	@GetMapping("/read05")
	public String read05(Model model) {
		
		Member member = new Member();
		
		Address address = new Address();
		address.setLocation("seoul");
		address.setPostCode("12345");
		
		List<Card> cardList = new ArrayList<Card>();
		
		Card card1 = new Card();
		card1.setNo("123456");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2020);
		cal.set(Calendar.MONTH, 8);
		cal.set(Calendar.DAY_OF_MONTH, 8);
		card1.setValidMonth(cal.getTime());
		cardList.add(card1);
		
		Card card2 = new Card();
		card2.setNo("321412");
		
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(Calendar.YEAR, 2021);
		cal2.set(Calendar.MONTH, 11);
		cal2.set(Calendar.DAY_OF_MONTH, 7);
		card2.setValidMonth(cal2.getTime());
		cardList.add(card2);
		
		
		member.setCardList(cardList);
		member.setAddress(address);
		model.addAttribute("user", member);

		return "member/read05";
		
	}
	
	//6) Model 객체를 통해 다양한 타입의 값을 전달할 수 있다.
	@GetMapping("/read06")
	public String read06(Model model) {
		 Member member = new Member();
		 member.setUserId("hong");
		 member.setPassword("1234");
		 member.setEmail("aaa@bbb.com");
		 member.setBirthDay("2022-11-26");
		 member.setGender("male");
		 member.setDeveloper("Y");
		 member.setForeigner(true);
		 member.setNationality("Canada");
		 member.setCars("jeep");
		 member.setHobby("축구");
		 String[] carArray = {"jeep", "bmw"};
		 member.setCarArray(carArray);
		 
		 List<String> carList = new ArrayList<String>();
		 carList.add("jeep");
		 carList.add("bmw");
		 member.setCarList(carList);
		 
		 String[] hobbyArray = {"music", "movie"};
		 member.setHobbyArray(hobbyArray);
		 
		 List<String> hobbyList = new ArrayList<String>();
		 hobbyList.add("music");
		 hobbyList.add("movie");
		 member.setHobbyList(hobbyList);
		 
		 Address address = new Address();
		 address.setPostCode("03003");
		 address.setLocation("daejeon");
		 member.setAddress(address);
		 
		 List<Card> cardList = new ArrayList<Card>();
		 Card card1 = new Card();
		 card1.setNo("123456");
		 
		 Calendar cal = Calendar.getInstance();
		 cal.set(Calendar.YEAR, 2020);
		 cal.set(Calendar.MONTH, 4);
		 cal.set(Calendar.DAY_OF_MONTH, 8);
		 cardList.add(card1);
		 
		 Card card2 = new Card();
		 card2.setNo("16756");
		 
	
		 cal.set(Calendar.YEAR, 2020);
		 cal.set(Calendar.MONTH, 4);
		 cal.set(Calendar.DAY_OF_MONTH, 8);
		 cardList.add(card2);
		 
		 member.setCardList(cardList);
		 cal.set(Calendar.YEAR, 1999);
		 cal.set(Calendar.MONTH, 11);
		 cal.set(Calendar.DAY_OF_MONTH, 2);
		 
		 member.setDateofBirth(cal.getTime());

		 
		 String introdution = "하이";
		 member.setIntroduction(introdution);
		 model.addAttribute("user", member);
		
		return "member/read06";
	}
}
