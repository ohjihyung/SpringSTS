package org.hdcd.controller.validation;

import java.util.List;

import org.hdcd.vo.Address;
import org.hdcd.vo.Card;
import org.hdcd.vo.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/validation")
public class ValidationController {
	
	private Logger logger = LoggerFactory.getLogger(ValidationController.class);

	/**
	 *  9장 입력 유효성 검증
	 * 
	 * 
	 * 1. 입력값 검증 
	 *  스프링 MVC는 Bean Validation 기능을 이용해 요청 파라미터 값이 바인딩
	 *  된 도메인 클래스(또는 커맨드 클래스)의 입력값 검증을 한다.
	 
	 *	 [환경설정]
	 *  # 의존 관계 정의
	 *  # 입력값 검증 활성화
	 *   - 입력값 검증을 하기 위해서는 메서드 매개변수에 도메인 클래스를 정의하고 @Validated를 지정합니다.
	 *     입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의합니다.
	 *     BindingResult에는 요청 데이터의 바인딩 오류와 입력값 검증 오류 정보가 저장됩니다.
	 *     
	 *     
	 *   [환경 설정 순서 >>]
	 *   1. 입력값 검증을 위한 의존 라이브러리를 추가합니다.
	 *     - hibernate를 추가
	 *    
	 *   2. 입력값 검증 활성화
	 *      - 활성화를 할 도메인 클래스에다가 @Validated 어노테이션 지정
	 *    
	 *   3. 도메인 클래스 내 필드에다가 검증을 위한 어노테이션들로 데이터 검증을 설정합니다.
	 *   (@NotBlank, @Size, @Notnull 등등)
	 *    
	 *   4. 에러를 받을 BindingResult를 설정합니다.
	 *      - 컨트롤러 메서드 내 매개변수로 도메인 클래스를 먼저 선언하고(@Validated 어노테이션이 붙어 있는 클래스)
	 *         해당 오른쪽 매개변수 자리에 BindingResult를 선언하여 에러메세지 등을 바인딩 할 수 있도록 설정을 맞춰줍니다.
	 * 		
	 * 		
	 *       1)의존 관계 정의   
	 *   	  -pom.xml에서 hibernate 라이브러리 추가
	 *   
	 *   	 2) 입력값 검증 활성화
	 *         - Member 클래스로 넘어가서 userId, password, userName에 규칙을 활성화
	 *        
	 *       3) 컨트롤러 메소드 내 넘겨받는 자바빈즈 클레스에 @Validated 어노테이션 활성화,
	 *          그리고 바로 옆에 BindingResult 객체도 매개변수로 받는다.
	 *       
	 *       
	 */
	
	// Validation 테스트할 폼 페이지 컨트롤러 메서드
	@GetMapping("/registerValidationForm01")
	public String registerValidationForm01(Model model) {
		
		model.addAttribute("member", new Member());

		return "validation/registerValidationForm01";
	}
	
	//1. 입력값 검증 
	// 1) 테스트 하기 위한 폼 페이지에서 등록 요청을 했을 때 정상적 데이터 전송시 해당 컨트롤러에서 처리
	@PostMapping("/result")
	public String registerValidationForm01Process(@Validated Member member, BindingResult result) {
		
		logger.info("registerValidationForm01Process");
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm01";
		}
		
		logger.info("member.getUserId() :" + member.getUserId());
		logger.info("member.getPassword() :" + member.getPassword());
		logger.info("member.getUserName() :" + member.getUserName());
		logger.info("member.getGender() :" + member.getGender());
		
		
		return "validation/success"; 
	}
	
	/*
	 * 2. 입력값 검증 결과 
	   
	   입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다.
	   BindingResult에는 요청 데이터의 바인딩 에러와 입력값 검증 에러 정보가 저장된다.
	   
	 */
	
	// 1) 입력값 검증 대상의 도메인 클래스 직후에 BindingResult를 정의한다.
	@GetMapping("/registerValidationForm02")
	public String registerValidationForm02(Model model) {
		
		model.addAttribute("member", new Member());
		return "validation/registerValidationForm02";
	}
	
	@PostMapping("/result2")
	public String registerValidationForm02Process(@Validated Member member, BindingResult result) {
		logger.info("registerValidationForm02Process");
		
		logger.info("result.hasError() : " + result.hasErrors());
		
		if(result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			List<ObjectError> globalErrors = result.getGlobalErrors();
			List<FieldError> fieldErrors = result.getFieldErrors();
			
			logger.info("allErrors.size() :" + allErrors.size());
			logger.info("globalErrors.size() :" + globalErrors.size());
			logger.info("fieldErrors.size() :" + fieldErrors.size());
			
			for(int i = 0 ; i <allErrors.size(); i++) {
				ObjectError objectError = allErrors.get(i);
				logger.info("allError : " + objectError);
			}
			for(int i = 0 ; i <globalErrors.size(); i++) {
				ObjectError objectError = globalErrors.get(i);
				logger.info("globalError : " + objectError);
			}
			for(int i = 0 ; i <fieldErrors.size(); i++) {
				FieldError fieldError = fieldErrors.get(i);
				logger.info("fieldError : " + fieldError);
				logger.info("fieldError.getDefaultMessage() :" + fieldError.getDefaultMessage());
			}
			return "validation/registerValidationForm02";
		}
		
		//에러 없을 시
		logger.info("member.getUserId() :" + member.getUserId());
		logger.info("member.getPassword() :" + member.getPassword());
		logger.info("member.getUserName() :" + member.getUserName());
		logger.info("member.getGender() :" + member.getGender());
		
		return "validation/success";
		
	}
	
	/*
	 *  3. 입력값 검증 규칙
	 *  
	 *  입력값 검증 규칙은 Bean Validation이 제공하는 제약 어노테이션으로 설정한다.
	 *  검사 규칙은 크게 3가지로 분류할 수 있다.
	 *    - Bean Validation 표준 제약 어노테이션
	 *    - 서드파티에서 구현한 제약 어노테이션
	 *    - 직접 구현한 제약 어노테이션
	 *    
	 *    
	 * 
	 * */
	
	// 1) Member 클래스에서 태스트 위한 어노테이션 설정(아래 명시되어 있는 내용들을 가지고 태스트 해보길)
	
	 // @NotNull      : 빈값이 아닌지를 검사한다.
	 // @Null         : null인지를 검사한다.
	 // @NotBlank     :  문자열이 null이 아니고 trim 한 길이가 0보다는 크다는 것을 감시한다.
	 // @NotEmpty     : 문자열이 null이거나 비어잇는지 검사한다.
	 // @size 
	 //  > @size(max=, min=)
	// @Max(value = ) : value 값보다 작거나 같은걸 검사
	// @Min(value = ) : value 값보다 크거나 같은걸 검사
	//Email          : 이메일 주소형식인지 검사
	//Past            : 과거 날짜인지를 검사한다.
	//Future          : 미래 날짜인지를 검사한다
	//Pattern(regxp=) : CharSequence는 지정된 정규식과 일치해야되고, 정규식은 Java 규칙을 따름
	//@Positive       : 양수여야합니다 (0 은 에러)
	//@PositiveOrZero  : 양수또는 0이어야 합니다
	//@Length(min=,max=) : 문자열의 길이가 min과 max사이인지 확인합니다.

	
	/*
	 *  
	 *   4. 중첩된 자바빈즈 입력값 검증
	 *   
	 *   중첩된 자바빈즈와 자바빈즈의 컬렉션에서 정의한 프로퍼티에 대해 입력값 검증을 할때는 @Valid를 지정한다.
	 *   
	 *   1) 중첩된 자바빈즈 클래스를 정의하고 @Valid를 지정한다
	 *     -Member 클래스 내 Address address 필드에 @Valid 어노테이션을 지정합니다
	 *     -Member 클래스 내 List<Card> cardList 필드에 @Valid 어노테이션을 지정합니다.
	 * 
	 *   2) Address 클래스에도 validation을 설정합니다.
	 *     - Address 항목에 검사할 수 있도록 규칙 어노테이션을 지정합니다.
	 * 
	 *   3) Card 클래스에도 validation을 설정합니다.
	 *     - Card 항목에 검사할 수 있도록 규칙 어노테이션을 지정합니다.
	 *     
	 *   
	 */
	
	@GetMapping("/registerValidationForm03")
	public String registerValidationForm03(Model model) {
		
		model.addAttribute("member", new Member());
		
		return "validation/registerValidationForm03";
		
	}
	@PostMapping("/result3")
	public String registerValidationForm03Result(@Validated Member member, BindingResult result) {
		logger.info("registerValidationForm02Process");
		
		if(result.hasErrors()) {
			return "validation/registerValidationForm03";
		}
		
		//에러 없을 시
		logger.info("member.getUserId() :" + member.getUserId());
		logger.info("member.getDateofBirth() :" + member.getDateofBirth());
		Address address = member.getAddress();
		
		if(address != null) {
			
			logger.info("address != null address.getPostCode() :" + address.getPostCode());
			logger.info("address != null address.getLocation() :" + address.getLocation());
		}
		
		List<Card> cardList = member.getCardList();
		
		if(cardList != null) {
			logger.info("cardList != null :" + cardList.size());
			for(int i =0; i <cardList.size(); i++) {
				Card card = cardList.get(i);
				logger.info("card.getNo() :" + card.getNo());
				logger.info("card.getValidMonth() :" + card.getValidMonth());
			}
		}else {
			logger.info("cardList == null");
		}
		
		return "validation/success";
		
	}
}
