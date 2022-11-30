package org.hdcd.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.FileMember;
import org.hdcd.vo.Member;
import org.hdcd.vo.Member2;
import org.hdcd.vo.MultiFileMember;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/*
    1. 컨트롤러 메서드 매개변수
    
     Model 
       - 이동 대상에 전달할 데이터를 가지고 있는 인터페이스
       
     RedirectAttributes
       - 리다이렉트 대상에 전달할 데이터를 가지고 있는 인터페이스
       
     자바빈즈 클래스
       - 요청 파라미터를 가지고 잇는 자바빈즈 클래스
     
      MultipartFile  ( 파일을 넘겼을 때 파일을 받을 수 있다)
       - Multipart 요청을 사용해 업로드 된 파일 정보를 가지고 있는 인터페이스
      
      BindingResult  (입력값 검증)
        -  도메인 클래스의 입력값 검증을 가지고 있는 인터페이스
      
      java.security.Principal
        - 클라이언트 인증을 위한 사용자 정보를 가지고 있는 인터페이스
       
       
     2. 요청 데이터 처리 어노테이션 
     
     @PathVariable 
       - URL에서 경로 변수 값을 가져오기 위한 어노테이션
     
     @RequestParam
        - 요청 파라미터 값을 가져오기 위한 어노테이션
     
     @RequestHeader 
        -  요청 해더 값을 가져오기 위한 어노테이션
        
     @RequestBody
         - 요청 본문 내용을 가져오기 위한 어노테이션
         
     @CookieValue
         - 쿠키 값을 가져오기 위한 어노테이션 
      
   
  */


@Controller
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	
	
	@GetMapping("/registerAllForm")
	public String registerAllForm() {
		logger.info("registerAllForm()");
		
		return "member/registerAllForm";
	}
	
	
	//5장 컨트롤러 요청 처리
	
	// 1. 컨트롤러 메서드 매개변수 / 2. 요청 처리
	// 컨트롤러 요청 처리를 위한 registerForm 시작점(시작 페이지)
	@GetMapping("/registerForm")
	public String registerForm() {
		logger.info("registerForm()");
		return "member/registerForm";
	}
	
	
	
	@GetMapping("/register")
	public String registerByParameter(String userId, String password) {
		
		logger.info("registerByParameter()");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		
		return "success";
		
	}
	
	//2)
	// URL 경로 상의 경로 변수로부터 요청 데이터를 취득할 수 없다.
	@GetMapping("/register/{userId}")
	public String registerByPath(String userId, String password) {
		//userId가  null 로 표시됩니다.
		// 넘겨받은 id를 위와 같은 현태로 받을라면
		// @PathValues 사용
		
		logger.info("registerByPath()");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		
		return "success";
	}
	
	// 3)
	// HTML 폼 필드명과 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@PostMapping("/register01")
	public String register01(String userId) {
		
		logger.info("register01()");
		logger.info("userId : " + userId);
		return "success";
	}
	
	// 4)
	// HTML 폼 필드가 여러 개일 경우에도 컨트롤러 매개변수명이 일치하면 요청 데이터를 취득할 수 있다.
	@PostMapping("/register02")
	public String register02(String userId, String password) {
		
		logger.info("register02()");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		
		return "success";
	}
	
	// 5)
	// HTML 폼 필드가 여러개일 경우에 컨트롤러 매개변수 위치는 상관없다...
	
	@PostMapping("/register03")
	public String register03(String password ,String userId) {
		
		logger.info("register03()");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		
		
		return "success";
		
	}

	// 6)
	// HTML Form 필드값이 숫자일 경우에는 컨트롤러 매개변수 타입이 문자열이면 그대로 문자열 형태로 요청
	//데이터 취급
	
	@PostMapping("/register04")
	public String register04(String password ,String userId, String coin) {
		
		logger.info("register04()");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		logger.info("coin : " + coin);
		
		
		return "success";
		
	}
	
	// 7)
	@PostMapping("/register05")
	public String register05(String password ,String userId, int coin) {
		
		logger.info("register05()");
		logger.info("userId : " + userId);
		logger.info("password : " + password);
		logger.info("coin : " + coin);
		
		
		return "success";
		
	}
	

	//3. 요청 데이터 처리 어노테이션
	//1) register/100 위에서 이미 요청 처리를 했기 에 여기선 처리 안함 
	
	// 2)
	// URL 경로 상의 경로 변수가 여러 개일 때 , @PathVariable 어노테이션을 사용하여 특정한 경로 변수명을 지정해준다
	@RequestMapping(value="/register/{userId}/{coin}")
	public String registerByPath(@PathVariable("userId") String userId,
			@PathVariable("coin") int  coin) {
		
		logger.info("registerByPath() - @PathVarible");
		logger.info("userId : " + userId);
		logger.info("coin : " + coin);
		
		return "success";
	}
	
	//3)
	// HTML 폼 필드명과 컨트롤러 매개변수명이 일치하면 요청을 처리할 수 있다.
	@PostMapping(value="/register0101")
	public String register0101(String userId) {
		
		logger.info("register0101()");
		logger.info("userId : " + userId);
	
		
		return "success";
	}
	
	// 4)
	// HTML 폼 필드명과 컨트롤러 매개변수명이 일치 (대소문자 구분)하지 않으면 요청을 처리할 수 없다
	@PostMapping(value="/register0201")
	public String register0201(String userid, String coins) {
		
		logger.info("register0201()");
		logger.info("userId : " + userid);
		logger.info("coins : " + coins);
		
		return "success";
	}
	
	//5)
	//@requestParam 어노테이션을 사용하여 특정한 HTML Form의 필드명을 지정하여 요청을 처리
	
	@PostMapping(value="/register0202")
	public String register0202(@RequestParam("userId") String username) {
		
		logger.info("register0202()");
		logger.info("userId :" + username);
		
		return "success";
	}
	
	// 4. 요청 처리 자바빈즈
	//1) 
	// 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다.
	
	@PostMapping("/beans/register01")
	public String registerJavaBeans01(Member member) {
		logger.info("registerBeans01()");
		logger.info("member.getUserId():" + member.getUserId());
		logger.info("member.getpassword():" + member.getPassword());
		logger.info("member.getCoin():" + member.getCoin());
		
		return "success";
		
	}
	
	// 2) 
	// 폼 텍스트 필드 요소값을 자바빈즈 매개변수와 기본 데이터 타입인 정수 타입 매개변수로 처리한다.
	@PostMapping("/beans/register02")
	public String registerJavaBeans02(Member member, int coin) {
		logger.info("registerBeans02()");
		logger.info("member.getUserId():" + member.getUserId());
		logger.info("member.getpassword():" + member.getPassword());
		logger.info("member.getCoin():" + member.getCoin());
		logger.info("coin:" + coin);
		
		return "success";
		
	}
	
	//3)
	// 여러 개의 폼 텍스트 필드 요소값을 매개변수 순서와 상관없이 매개변수명을 기준으로 처리한다.
	// 이름으로 처리한다.
	@PostMapping("/beans/register03")
	public String registerJavaBeans03(int uid ,Member member) {
		logger.info("registerBeans03()");
		logger.info("member.getUserId():" + member.getUserId());
		logger.info("member.getpassword():" + member.getPassword());
		logger.info("member.getCoin():" + member.getCoin());
		logger.info("uid:" + uid);
		
		return "success";
		
	}
	
	
	// 5. Date 타입 처리 
	// 1) 
	// 쿼리 파라미터(dateOfBirth=1234)로 전달받은 값이 날짜 문자열 형식에 맞지 않아 Date타입으로 변환 실패한다.

	@GetMapping("/registerByGet01")
	public String registerByGet01(String userId, @DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth ) {
		
		logger.info("registerByGet01()");
		logger.info("userId :" + userId);
		logger.info("dateOfBirth" + dateOfBirth);
		
		return "success";
	}
	
	
	@GetMapping("/registerByGet02")
	public String registerByGet02(Member member) {
		
		logger.info("registerByGet02()");
		logger.info("member.getUserId :" + member.getUserId());
		logger.info("member.getDateOfBirth" + member.getDateofBirth());
		
		return "success";
	}
	
	
	
	
	// 7. 폼 방식 요청 처리
	
	// 1)
	// 폼 텍스트 필드 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	
	@PostMapping("/registerUserId")
	public String registerUserId(String userId) {
		
		logger.info("registerUserId()");
		logger.info("userId : " + userId);
		

		return "success";
	}
	
	//2)
	// 
	@PostMapping("/registerMemberUserId")
	public String registerMemberUserId(Member member) {
		
		logger.info("registerMemberUserId");
		logger.info("member.getUserId() : " + member.getUserId());
		
		return "success";
	}
	
	
	//3)
	// 폼 비밀번호 필드 요소값을 자바빈즈 매개변수로 처리한다
	@PostMapping("/registerPassword")
	public String registerPassword(Member member) {
		
		logger.info("registerPassword");
		logger.info("password : " + member.getPassword());
		
		return "success";
	}
	
	
	//4)
	// 폼 라디오 버튼 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다
	@PostMapping("/registerRadio")
	public String registerRadio(String gender) {
		
		logger.info("registerRadio");
		logger.info("gender : " + gender);
		
		return "success";
	}
	
	
	//5)
	// 폼 셀렉트박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	
	@PostMapping("/registerSelect")
	public String registerSelect(String nationality) {
		
		logger.info("/registerSelect");
		logger.info("nationality : " + nationality);
		
		return "success";
	}
	
	//6)
	//복수 선택이 가능한 폼 셀렉트 박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다
	
	@PostMapping("/registerMultiSelect01")
	public String registerMultiSelect01(String cars){
		
		logger.info("registerMultiSelect01");
		logger.info("cars :" + cars);
		
		return "success";
	}
	
	//7)
	@PostMapping("/registerMultiSelect02")
	public String registerMultiSelect02(String[] carArray){
		
		logger.info("registerMultiSelect02");
		
		if(carArray != null) {
			logger.info("carArray.length :" + carArray.length);
			for(int i = 0; i < carArray.length;i++) {
				logger.info("carArray[" + i+ "] : " + carArray[i] );
			}
		}else {
			logger.info("carArray == null");
		}
		
		return "success";
	}
	
	//8)
	@PostMapping("/registerMultiSelect03")
	public String registerMultiSelect03(ArrayList<String> carList){

		logger.info("registerMultiSelect03");
		
		//리스트로는 셀렉트 박스 값을 가져올수 없습니다.
		// 배열 형태를 사용하거나 객체를 이용하세요
		if(carList != null && carList.size() > 0) {
			logger.info("carList.size()  : " + carList.size());
			for(int i = 0; i < carList.size(); i++) {
				logger.info("carList[" + i+ "] : " + carList.get(i) );
			}
		}else {
			logger.info("carList == null");
		}
		
		return "success";
	}
	
	
	//9)
	@PostMapping("/registerCheckBox01")
	public String registerCheckBox01(String hobby) {
		
		logger.info("registerCheckBox01");
		logger.info("hobby : " + hobby);
		
		return "success";
	}
	
	//10)
	@PostMapping("/registerCheckBox02")
	public String registerCheckBox02(String[] hobbyArray) {
		
		logger.info("registerCheckBox02");
		if(hobbyArray != null) {
			logger.info("hobbyArray.length :" + hobbyArray.length);
			for(int i = 0; i < hobbyArray.length;i++) {
				logger.info("hobbyArray[" + i+ "] : " + hobbyArray[i] );
			}
		}else {
			logger.info("hobbyArray == null");
		}
		
		return "success";
	}
	
	//11)
	// 폼 체크 박스 요소 값을 문자열 요소를 가진 리스트 컬렉션 타입 매개변수로 처리한다
	@PostMapping("/registerCheckBox03")
	public String registerCheckBox03(List<String> hobbyList) {
		
		// 1) ArrayList로 값을 받는 경우
		// 값이 넘어오지 않아 size = 0
		
		
		// 2) List로 받는 경우 
		//NO primary or default constructor found for interface java.util.List ] 에러 발생
		// Spring에서 List로는 데이터를 받는게 xxxxxxxxxxx
		// 리스트와 같은 형태의 값을 받으려면 String[] 로 여러 데이터를 받아서 List에 담는 방법이 있습니다.
		
		logger.info("registerCheckBox03");
		if(hobbyList != null) {
			logger.info("hobbyList.size()  : " + hobbyList.size());
			for(int i = 0; i < hobbyList.size(); i++) {
				logger.info("hobbyList[" + i+ "] : " + hobbyList.get(i) );
			}
		}else {
			logger.info("hobbyList == null");
		}
		
		return "success";
	}
	
	// 12)
	// 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@PostMapping("/registerCheckBox04")
	public String registerCheckBox04(String developer) {
		
		logger.info("registerCheckBox04");
		logger.info("developer : " + developer);
		
		return "success";
	}
	
	// 13)
	// 폼 체크박스 요소값을 기본 데이터 타입인 문자열 타입 매개변수로 처리한다.
	@PostMapping("/registerCheckBox05")
	public String registerCheckBox05(boolean foreigner) {
		
		logger.info("registerCheckBox04");
		logger.info("developer : " + foreigner);
		
		return "success";
	}
	
	// 14)
	// 폼 텍스트 필드 요소값을 자바빈즈 매개변수로 처리한다
	@PostMapping("/registerAddress")
	public String registerAddress(Address address) {
		
		logger.info("registerUserAddress");
		if(address != null) {
			logger.info("address.getPostCode : "+address.getPostCode());
			logger.info("address.getLocation : "+address.getLocation());
		}else {
			logger.info("address == null");
		}
		
		return "success";
	}
	
	// 15)
	// 폼 체크박스 요소값을 중첩된 자바빈즈 매개변수로 처리한다
	@PostMapping("/registerUserAddress")
	public String registerUserAddress(Member member) {
		
		logger.info("registerUserAddress");
		Address address = member.getAddress();
		
		if(address != null) {
			logger.info("address.getPostCode() : " + address.getPostCode());
			logger.info("address.getLocation() : " + address.getLocation());
		}else {
			logger.info("address == null");
		}
		return "success";
	}
	
	// 16)
	// 폼 텍스트 필드 요소값을 중첩된 자바빈즈 매개변수로 처리한다
	@PostMapping("/registerUserCardList")
	public String registerUserCardList(Member member) {
		
		logger.info("registerUserCardList");
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList.size() : " + cardList.size());
			for(int i = 0; i <cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo : " + card.getNo());
				logger.info("card.getValidMonth : " + card.getValidMonth());
				
			}
		}
		return "success";
	}
	
	// 17) 
	// 폼 텍스트 영역 요소값을 기본 데이터 타입인 문자여 타입 매개변수로 처리한다.
	@PostMapping("/registerTextArea")
	public String registerTextArea(String introduction) {
		
		logger.info("registerTextArea");
		logger.info("introduction" + introduction);
		return "success";
	}
	
	// 18) 
	// 폼 택스트 영역 요소값을 Date 타입 매개변수로 처리한다.
	// 정상적인 날짜 데이터를 출력하기 위해서는 날짜 문자열 형식을 'yyyy/MM/dd'형식으로 지정해야한다.
	// 내가 원하는 문자열 형식을 지정하려면  @DateTimeFormat 어노테이션을 이용하여 해당 형식에 맞춰 데이터를 보내면 된다.
	

	@PostMapping("/registerDate01")
	//public String registerDate01(Date dateOfBirth) {
	public String registerDate01(@DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth) {
		logger.info("/registerDate01");
	
		if(dateOfBirth != null) {
			logger.info("dataOfBirth : " + dateOfBirth);
		}else {
			 logger.info("dateOfBirth == null");
		}
		return "success";
	}
	
//	
//	// 하나의 폼처리
//	@PostMapping("/registerUser")
//	public String registerUser(Member2 member, Model model) {
//		
//		Address address = member.getAddress();
//		Card card = member.getCard();
//		
//		logger.info("registerAllResult()");
//		logger.info("userId :" + member.getUserId());
//		logger.info("password :" + member.getPassword());
//		logger.info("userName :" + member.getUserName());
//		logger.info("email :" + member.getEmail());
//		logger.info("dateOfBirth :" + member.getDateOfBirth());
//		logger.info("gender : " + member.getGender());
//		logger.info("developer : " + member.getDeveloper());
//		logger.info("foreigner :" + member.isForeigner());
//		logger.info("nationality : " + member.getNationality() );
//		logger.info("hobbys :" + member.getHobby()[0]);
//		logger.info("cars :" + member.getCars()[0]);
//		logger.info("postCode: " + address.getPostCode());
//		logger.info("location: " + address.getLocation());
//		logger.info("cardNo: " + card.getCardNo());
//		logger.info("cardValid: " + card.getValidMonth());
//		logger.info("introduction :" + member.getIntroduction());
//		
//		return "member/registerAllResult";
//	}
	@PostMapping("/registerUser")
	public ModelAndView registerUser(Member2 member) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/registerAllResult");
		mav.addObject("user", member);
		
		return mav;
		
	}
	
	
	//8. 파일업로드 폼 방식 요청 처리
	// 파일 업로드 폼 방식
	// 1)
	// 파일 업로드 폼 파일 요소값을 스프링 MVC가 지원하는 MultipartFile 매개변수로 처리한다.
	@PostMapping("/registerFile01")
	public String registerFile01(MultipartFile picture) {
		
		logger.info("registerFile01");
		logger.info("originalName : " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentType :" + picture.getContentType());
		
		return "success";
		
	}
	
	
	//파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiPartFile 매개변수와
	// 문자열 매개변수로 처리한다.
	@PostMapping("/registerFile02")
	public String registerFile02(String userId, String password, MultipartFile picture) {
		logger.info("registerFile02");
		logger.info("userId :" + userId);
		logger.info("password :" + password);
		
		logger.info("originalName : " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentType :" + picture.getContentType());
		
		return "success";
		
	}
	
	//)파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultipartFile 매개변수와 문자열 매개변수로 처리한다
	@PostMapping("/registerFile03")
	public String registerFile03(Member member, MultipartFile picture) {
		logger.info("registerFile03");
		logger.info("userId :" + member.getUserId());
		logger.info("password :" + member.getPassword());
		
		logger.info("originalName : " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentType :" + picture.getContentType());
		
		return "success";
		
	}
	
	//4) 파일 업로드 폼 파일 요소값과 텍스트 필드 요소값을 FileMember 타입의 자바빈즈 매개변수로 처리한다
	@PostMapping("/registerFile04")
	public String registerFile04(FileMember fileMember) {
		logger.info("registerFile04");
		logger.info("userId :" + fileMember.getUserId());
		logger.info("password :" + fileMember.getPassword());
		
		MultipartFile picture = fileMember.getPicture();
		
		logger.info("originalName : " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentType :" + picture.getContentType());
		
		return "success";
		
	}
	
	//5) 여러개의 파일업로드를 폼 파일 요소값을 여러 개의 MultipartFile 매개변수로 처리한다
	@PostMapping("/registerFile05")
	public String registerFile05( MultipartFile picture, MultipartFile picture2) {
		logger.info("registerFile05");
	
	
		logger.info("originalName : " + picture.getOriginalFilename());
		logger.info("size: " + picture.getSize());
		logger.info("contentType :" + picture.getContentType());
		
		logger.info("originalName : " + picture2.getOriginalFilename());
		logger.info("size: " + picture2.getSize());
		logger.info("contentType :" + picture2.getContentType());
		
		return "success";
		
	}
	
	//6) 여러 개의 파일업로드를 폼 파일 요소값을 MultiPartFile 타입의 요소를 가진 리스트 컬랙션 타입 매개변수로 처리한다
	@PostMapping("/registerFile06")
	public String registerFile06(List<MultipartFile> pictureList ) {
		
		//컬랙션 리스트로는 이미지 파일을 가져올수 없습니다.
		logger.info("registerFile06");
		
		
		logger.info("registerFile06 pictureList.size() :" + pictureList.size());
		
		
		for(int i = 0 ; i < pictureList.size(); i++) {
			
			logger.info("originalName : " + pictureList.get(i).getOriginalFilename());
			logger.info("size: " + pictureList.get(i).getSize());
			logger.info("contentType :" + pictureList.get(i).getContentType());
		}
		
		
		return "success";
		
	}
	
	
	//7) 여러 개의 파일업로드 폼 파일 요소값과 텍스트 필드 요소값을 MultiPartFileMember 타입의 자바빈즈 매개변수로 처리
	//7-2) 파일업로드 폼 파일 요소값과 택스트 필드 요소값을 MultiFileMemnber 타입의 자바빈즈 매개변수로 처리한다
	// 7) 은 input file 2개로 객체에 mapping
	// 7-2 는 multiple 요소 이용하여 객체에 mapping
	@PostMapping("/registerFile07")
	public String registerFile07(MultiFileMember multiFileMember) {
		
		logger.info("registerFile07");
		
		List<MultipartFile> pictureList = multiFileMember.getPictureList();
		
		for(MultipartFile picture : pictureList) {
			logger.info("originalName : " + picture.getOriginalFilename());
			logger.info("size: " + picture.getSize());
			logger.info("contentType :" + picture.getContentType());
		}
		
		return "success";
		
	}
	
	//8) 파일 업로드 폼 파일 요소값과 택스트 필드 요소값을 MultiPartFile 타입의 배열 매개변수로 처리한다
	@PostMapping("/registerFile08")
	public String registerFile08(MultipartFile[] pictureList) {
		
		logger.info("registerFile08");
		
		logger.info("register08 pictureList.size() : " + pictureList.length);
	
		for(MultipartFile picture : pictureList) {
			logger.info("originalName : " + picture.getOriginalFilename());
			logger.info("size: " + picture.getSize());
			logger.info("contentType :" + picture.getContentType());
		}
		
		return "success";
		
	}
	
	
		
}

