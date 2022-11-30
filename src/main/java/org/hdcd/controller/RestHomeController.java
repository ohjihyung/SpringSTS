package org.hdcd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Controller
public class RestHomeController {
	private static final Logger logger = LoggerFactory.getLogger(RestHomeController.class);
	
	
	@RequestMapping("/goRestHome0301")
	public Member restHome0301() {
		logger.info("restHome0301");
		Member member = new Member();
		
		return member;
	}
	
	//반환값이 컬렉션 List 타입이면 Json 객체 배열 타입으로 자동으로 변환된다.
	 @RequestMapping(value="/goRestHome0401")
	  public List<Member> restHome0401(){
		  logger.info("goHome0401");
		  List<Member> list = new ArrayList<Member>();
		  Member member = new Member();
		  list.add(member);
		 
		  Member member2 = new Member();
		  list.add(member2);
		   
		  return list;
		   
	  }
	 
	 	
	   @RequestMapping("/goRestHome0501")
	   public Map<String, Member> restHome0501(){
		   logger.info("goRestHome0501");
		   
		   Map<String, Member> map = new HashMap<String, Member>();
		   Member member =  new Member();
		   map.put("member1", member);

		   Member member2 =  new Member();
		   map.put("member2", member2);
		   
		   return map;
	   }
	   
	   @RequestMapping("/goRestHome0601")
	   public ResponseEntity<Void> restHome0601(){
		   logger.info("restHome0601");
		   
		   return new ResponseEntity<Void>(HttpStatus.OK);
		   //내가 요청한 url로 응답이 가면서 응답데이터로 아무런 값이 전달되지 않는다
		   // 해당 URL 요청 후 , 브라우저에서 개발자 도구를 이용해 네트워크 탭을 확인해보면
		   // 응답으로 해당 URL이 응답으로 나간걸 확인할 수 있다.
	   }
	   
	   @RequestMapping("/goRestHome0701")
	   public ResponseEntity<String> restHome0701(){
		   
		   logger.info("restHome0701");
		   return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		   
	   }
	   
	   @RequestMapping("/goRestHome0801")
	   public ResponseEntity<Member> restHome0801(){
		   
		   logger.info("restHome0801");
		   
		   Member member = new Member();
		   
		   return new ResponseEntity<Member>(member, HttpStatus.OK);
		   
	   }
	   
	   @RequestMapping("/goRestHome0901")
	   public ResponseEntity<List<Member>> restHome0901(){
		   
		   logger.info("restHome0901");
		   
		    List<Member> list = new ArrayList<Member>();
		   
		    Member member = new Member();
		    list.add(member);
		    
		    Member member2 = new Member();
		    list.add(member2);
		   
		    return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	   }
	   
	   @RequestMapping("/goRestHome1001")
	   public ResponseEntity<Map<String,Member>> restHome1001(){
		   logger.info("restHome1001");
		   
		   Map<String, Member> map = new HashMap<String, Member>();
		   
		   Member member = new Member();
		   map.put("member1", member);
		   
		   Member member2 = new Member();
		   map.put("member2", member2);
		   
		   
		   return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK);
		   
	   }
}
