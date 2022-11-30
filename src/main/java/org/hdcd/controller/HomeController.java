package org.hdcd.controller;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.AddressingFeature.Responses;

import org.apache.commons.io.IOUtils;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/formHome", method = RequestMethod.GET)
	public String formHome() {
		
		return "formHome";
	}
	
	@RequestMapping(value="/ajaxHome", method = RequestMethod.GET)
	public String ajaxHome() {
		
		return "ajaxHome";
	}
	// 4. 컨트롤러 응답
    
	   // 1) void 타입 : 호출하는 URL과 동일한 뷰 이름을 나타내기위해 사용합니다.
	   // requesetMapping에 value를 이용해서 jsp를 찾음
	   // return 타입이 없고 void 형태면 url 값으로 해당 페이지 찾음  (근데 view의 경로랑 무조건 같아야함)
	   @RequestMapping(value = "/goHome0101",method = RequestMethod.GET)
	   public void goHome0101() {
	      logger.info("gohome0101");
	   }
	   
	   @RequestMapping(value = "/sub/goHome0102",method = RequestMethod.GET)
	   public void goHome0102() {
	      logger.info("gohome0102");
	   }
	   // void타입 end
	   
	   
	   
	   
	   // 2) String 타입 : 뷰 파일의 경로와 파일 이름을 나타내기 위해 사용함.
	   @RequestMapping(value = "/goHome0201",method = RequestMethod.GET)
	   public String goHome0201() {
	      logger.info("gohome0201");
	      return "home0201";
	   }
	   
	   @RequestMapping(value = "/goHome0202",method = RequestMethod.GET)
	   public String goHome0202() {
	      logger.info("gohome0201");
	      return "home0201";
	   }
	  
	   
	   // 반환값이 "sub/home0203" 이므로 뷰 (/sub/home0203.jsp)를 가르킨다
	   @RequestMapping(value = "/sub/goHome0203",method = RequestMethod.GET)
	   public String goHome0203() {
	      logger.info("gohome0203");
	      return "sub/home0203";
	   }
	   
	   
	   // 반환값이 "redirect:" 로 시작하면 리다이렉트 방식으로 처리한다.
	   // 클라이언트에서 출발지를 /sub/goHome0204로 요청하고 해당 URL을 매핑하는 컨트롤러 메서드가 실행되는데,
	   // 이때, 처리 부분에서 "redirect:"가 이뤄지면 처음 요청된 요청(/sub/goHome0204)이 출발지에서 시작되고
	   // 서버에서 redirect 하고자 하는 URL을 재차 클라이언트에게 물어봅니다.
	   // 클라이언트는 재차 물어본 해당 url 이 맞으면 서버측으로 다시 최종 도착지 URL(/sub/goHome0203)을 다시
	   // 요청합니다(여기서 새로운 요청/ 응답이 생김)
	   
	   // 서버는 최종 도착지 url을 요청으로 받아 해당 요청에 맞는 페이지를 응답으로 만들어서 클라이언트로 최종 리턴합니다.
	   @RequestMapping(value = "/sub/goHome0204",method = RequestMethod.GET)
	   public String goHome0204() {
		   logger.info("gohome0204");
		   return "redirect:/sub/goHome0203";
	   }
	   
	   
	   // "/" 로 시작하면 웹 어플리케이션의 컨텍스트 경로에 영향을 받지 않는 절대경로를 의미
	   // 해당 경로 예) D:\Class\Spring2\workspace\.metadata\.plugins\org.eclipse.wst.server.core\....
	   					 // WEB-INF\views\sub\home0205.jsp
	   @GetMapping("/sub/goHome0205")
	   public String goHome0205() {
		   
		   logger.info("goHome0205");
		   
		   return "/sub/home0205";
	   }
	   
	   //  String 타입 End
	   
	   /* 3) 자바 빈즈 클래스 타입 */
	   // 어노테이션 ResponseBody를 지정하지 않으면 HTTP 404 에러가 발생합니다.
	   // 어노테이션 ResponseBody가 객체를 리턴하여 객체를 응답 데이터로 보내는 역할을 합니다.
	   // 어노테이션 ResponseBody의 리턴 default 데이터 형식은 json입니다.
	   //
	   // 어노테이션 ResponseBody 대신에 어노테이션 RestController를 이용하여 대체할 수 있습니다.
	   
	   @ResponseBody
	   @GetMapping("/goHome0301")
	   public Member goHome0301() {
		   logger.info("goHome0301");
		   Member member = new Member();
		   logger.info(member.getUserId());
		   logger.info(member.getPassword());
		   logger.info(member.getUserName());
		   
		   return member;
	   }
	   
	   /* 자바 빈즈 클래스 타입 end*/
	   
	   
	   /* 4) 컬렉션 List 타입 */
	   
	   // 1) @ResponseBody를 이용한 방식
	   // 반환값이 컬렉션 List 타입이면 JSON 객체 배열 타입으로 자동으로 변환한다.
	   @ResponseBody
	   @RequestMapping(value="/goHome0401", method = RequestMethod.GET)
	   public List<Member> goHome0401(){
		   logger.info("goHome0401");
		   List<Member> list = new ArrayList<Member>();
		   Member member = new Member();
		   list.add(member);
		  
		   Member member2 = new Member();
		   list.add(member2);
		   
		   return list;
		   
	   }
	   
	   /*   컬렉션 List 타입 end  */
	   
	   
	   /* 4) 컬렉션 Map 타입 */
	   @ResponseBody
	   @GetMapping("/goHome0501")
	   public Map<String, Member> goHome0501(){
		   logger.info("goHome0501");
		   
		   Map<String, Member> map = new HashMap<String, Member>();
		   Member member =  new Member();
		   map.put("member1", member);

		   Member member2 =  new Member();
		   map.put("member2", member2);
		   
		   return map;
	   }
	   
	   
	   /*   컬렉션 Map 타입 end  */
	   
	   
	   /* 6)  ResponseEntitiy<void> 타입 */
	   
	   // 1) ResponseBody를 이용하는 방식
	   
	   // Void 타입은 아무런 형태가 아닌데 제네릭타입의 뭔가는 채워야겠어서 채우는 Placeholder 같은 느낌임
	   
	   
	   @ResponseBody
	   @GetMapping("/goHome0601")
	   public ResponseEntity<Void> goHome0601(){
		   logger.info("goHome0601");
		   
		   return new ResponseEntity<Void>(HttpStatus.OK);
		   //내가 요청한 url로 응답이 가면서 응답데이터로 아무런 값이 전달되지 않는다
		   // 해당 URL 요청 후 , 브라우저에서 개발자 도구를 이용해 네트워크 탭을 확인해보면
		   // 응답으로 해당 URL이 응답으로 나간걸 확인할 수 있다.
	   }
	   
	   /*  ResponseEntitiy<void> 타입 end*/
	   
	   
	   /*  7) ResponseEntity<String> 타입*/ 
	   
	   @ResponseBody
	   @GetMapping("/goHome0701")
	   public ResponseEntity<String> goHome0701(){
		   
		   logger.info("goHome0701");
		   return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		   
	   }
	   

	   /*  ResponseEntitiy<String> 타입 end*/
	   
	   /*  8) ResponseEntity<자바빈즈 클래스> 타입*/ 
	  // response 할 때, HTTP 헤더 정보와 객체 데이터를 전달하는 용도로 사용
	   
	   @GetMapping("/goHome0801")
	   public ResponseEntity<Member> goHome0801(){
		   
		   logger.info("goHome0801");
		   
		   Member member = new Member();
		   
		   return new ResponseEntity<Member>(member, HttpStatus.OK);
		   
	   }
	   
	   
	   /*  ResponseEntitiy<자바빈즈 클래스> 타입 end*/
	   
	   /*  9) ResponseEntity<List<Member>> 타입*/ 
	   @GetMapping("/goHome0901")
	   public ResponseEntity<List<Member>> goHome0901(){
		   
		   logger.info("goHome0901");
		   
		    List<Member> list = new ArrayList<Member>();
		   
		    Member member = new Member();
		    list.add(member);
		    
		    Member member2 = new Member();
		    list.add(member2);
		   
		    return new ResponseEntity<List<Member>>(list, HttpStatus.OK);
	   }
	   
	   /*  ResponseEntitiy<List<Member>> 타입 end*/
	   
	   /* 10) ResponseEntitiy<Map> 타입*/
	   // response 할 때 , HTTP 헤더 정보와 객체 데이터를 Map 형태로 전달하는 용도로 사용한다.
	   @GetMapping("/goHome1001")
	   public ResponseEntity<Map<String,Member>> goHome1001(){
		   logger.info("goHome1001");
		   
		   Map<String, Member> map = new HashMap<String, Member>();
		   
		   Member member = new Member();
		   map.put("member1", member);
		   
		   Member member2 = new Member();
		   map.put("member2", member2);
		   
		   
		   return new ResponseEntity<Map<String,Member>>(map, HttpStatus.OK);
		   
	   }
	   /* ResponseEntitiy<Map> 타입 end*/
	   
	   /* 11) ResponseEntitiy<byte[]> 타입  (이미지 보여주기)*/
	   
	   @GetMapping("/goHome1101")
	   public ResponseEntity<byte[]> goHome1101() throws IOException{
		   
		   logger.info("goHome1101");
		   
		   InputStream in = null;
		   ResponseEntity<byte[]> entity = null;
		   
		   HttpHeaders headers = new HttpHeaders();
		   try {
			   
			   in = new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\02_SPRING2\\study_img\\홍준표.jpg");
			   headers.setContentType(MediaType.IMAGE_JPEG);
			   entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		   }catch (FileNotFoundException e) {
			    e.printStackTrace();
		   }catch(IOException e) {
			   entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		   }finally {
			   in.close();
		   }
		   return entity;
	   }
	   
	   @GetMapping("/goHome1102")   // 압축파일 다운받기 ( 나한태 zip 파일이 있어야함)
	   public ResponseEntity<byte[]> goHome1102() throws IOException{
		   logger.info("goHome1102");
		   String fileName = "푸틴.zip";
		   ResponseEntity<byte[]> entity = null;
		   InputStream in = null;
		   
		   try {
			   
			   HttpHeaders headers = new HttpHeaders();
			   in =  new FileInputStream("D:\\A_TeachingMaterial\\08_Framework\\02_SPRING2\\study_img\\" + fileName);
			   //MediaType.APPLICATION_OCTET_STREAM은 이진 파일을 위한 기본값입니다.
			   headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			   headers.add("Content-Disposition", "attachment; filename=\"" +new String(fileName.getBytes("UTF-8"),"ISO-8859-1") + "\"");
			   
			   entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
		   }catch (Exception e) {
			    e.printStackTrace();
			    entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		   }finally {
				in.close();
		   }
		   return entity;
	   }
	   
	   /* ResponseEntitiy<byte[]> 타입 end*/
	   
	   @GetMapping("/purejsGet")
	   public String purejsGetForm() {
		   
		   return  "purejs/pureget";
	   }
	   @GetMapping("/purejsGet2")
	   public String purejsGetForm2() {
		   
		   return  "purejs/pureget2";
	   }
	   
	    @RequestMapping( value = "/getname", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	    @ResponseBody
	    public String makeGet(@RequestParam("name") String name) {
	    	
	        return name;
	    }
	 
	    @GetMapping("/purejspost")
		   public String purejspostForm() {
			   
			   return  "purejs/purepost";
		   }

	    
	    @RequestMapping(value ="/postname", method = RequestMethod.POST, produces = "application/text; charset=utf8" )
	    public ResponseEntity<String> makepost(@RequestBody Map<String, Object> map, MultipartFile file){
	    	logger.info("map " + map);
	    	logger.info("file " + file);
	    	
	    	
	    	String password2 = (String) map.get("password2");
	    	return new ResponseEntity<String>(password2, HttpStatus.OK);
	    }
	    
	  
}
