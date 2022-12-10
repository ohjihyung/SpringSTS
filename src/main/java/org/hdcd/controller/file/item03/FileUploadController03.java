package org.hdcd.controller.file.item03;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.hdcd.controller.file.item03.service.ItemService3;
import org.hdcd.vo.Item3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/item3")
public class FileUploadController03 {

	@Inject
	private ItemService3 itemService;
	
	private String uploadPath = "C://upload";
	private static Logger logger = LoggerFactory.getLogger(FileUploadController03.class);
   /*
    * 13. 창 파일업로드
    * 
    * 4. 비동기 방식 업로드
    *    - 비동기 방식으로 여러개의 이미지를 업로드하는 파일 업로드 기능을 구현한다.
    * 
    *       1. 환경 설정
    *          
    *          1-1) 의존 관계 정의
    *             - commons-io         : 파일을 처리하기 위한 라이브러리
    *             - imgscalr-lib         : 이미지 변환을 처리하기 위한 의존 라이브리
    *             - jackson-databind      : json 데이터 바인딩을 위한 의존 라이브러리
    *          *** Maven > Update Projects 진행하여 의존 등록 완료
    * 
    *       2. 파일 업로드 구현 설명
    *          - 파일 업로드 등록 화면 컨트롤러 만들기 (FileUploadController03)
    *          - 파일 업로드 등록 화면 컨트롤러 메소드 만들기 (item3RegisterForm:get)
    *          - 파일 업로드 등록 화면  만들기 (item3/register.jsp)
    *          -       여기까지 확인
    *          
    *          - 파일업로드 등록 기능 컨트롤러 메소드 만들기 (item3Register:post)
    *          - 파일업로드 등록 기능 서비스 인터페이스 만들기 
    *          - 파일업로드 등록 기능 서비스 클래스 만들기 
    *          - 파일업로드 등록 기능 Mapper 인터페이스 메소드 만들기 
    *          - 파일업로드 등록 기능 Mapper xml 쿼리 만들기 
    *          - 파일업로드 등록 기능 컨트롤러 메소드 만들기 
    *          -   여기 까지 확인
    *          
    *          
    *          - 파일업로드 목록 화면 컨트롤러 메소드 만들기 (item3List:get)
    *          - 파일 업로드 목록 화면 서비스 인터페이스 메소드 만들기
    *          - 파일 업로드 목록화면 서비스 클래스 만들기
    *          - 파일 업로드 목록화면 Mapper 만들기
    *          - 파일 업로드 목록화면 Mapper xml 만들기
    *          - 파일 업로드 목록 화면 만들기 (item3/list.jsp)
    *               - 여기 까지 확인
    *               
    *          - 파일 업로드 수정화면 컨트롤러 메소드 만들기 (item3Modify:get)
    *          - 파일 업로드 수정화면 서비스 인터페이스 메소드 만들기
    *          - 파일 업로드 수정화면 서비스 클래스 만들기
    *          - 파일 업로드 수정화면 Mapper 만들기
    *          - 파일 업로드 수정화면 Mapper xml 만들기
    *          - 파일 업로드 수정 화면 만들기 (item3/Modify.jsp)
    *          
    *          
    *          
    *          
    */
   
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public String item3RegisterForm(Model model) {
      model.addAttribute("item", new Item3());
      return "item3/register";
   }
   
   @PostMapping("/register")
   public String item3Register(Item3 item, Model model)throws Exception {
	   String[] files = item.getFiles();
	   
	   for(int i = 0; i < files.length; i++) {
		   logger.info("files[" + i +"] :" + files[i]);
	   }
	   
	   itemService.register(item);
	   model.addAttribute("msg", "등록완료!");
	   
	   return "item3/success";
   }
   
   @PostMapping(value="/uploadAjax", produces = "text/plain;charset=utf-8")
   @ResponseBody
   public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
	   logger.info("originalName :" + file.getOriginalFilename());
	   String savedName = _OJHUploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
	   return new ResponseEntity<String>(savedName, HttpStatus.CREATED);
   
   }
   @ResponseBody
   @GetMapping("/displayFile")
   public ResponseEntity<byte[]> display(String fileName) throws Exception{
	   InputStream in = null;
	   ResponseEntity<byte[]> entity = null;
	   logger.info("FileName : " + fileName);
	   
	   try {
		   String formatName = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자 추출
		   MediaType mType = MediaUtils.getMediaType(formatName);
		   HttpHeaders headers = new HttpHeaders();
		   in = new FileInputStream(uploadPath + fileName);
		   
		   if(mType != null) {
			   headers.setContentType(mType);
		   }else {
			   headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			   headers.add("Content-Disposition", "attachment; filename=\""+
					   new String(fileName.getBytes("UTF-8"),"ISO-8859-1") + "\"");
			   
		   }
		   entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in),headers,HttpStatus.CREATED);
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   in.close();
	   }
	   return entity;
   }
   
   @GetMapping("/list")
   public String item3List(Model model) throws Exception {
	   
	   List<Item3> itemList = itemService.list();
	   model.addAttribute("itemList", itemList);
	   
	   return "item3/list";
	
   }
   @GetMapping("/modify")
   public String item3ModifyForm(int itemId, Model model) throws Exception {
	   
	   Item3 item = itemService.read(itemId);
	   model.addAttribute("item", item);
	   
	   return "item3/modify";
   }
   
   @ResponseBody
   @GetMapping("/getAttach/{itemId}")
   public List<String> getAttach(@PathVariable("itemId") int itemId) throws Exception {
	   logger.info("getAttach itemId :" + itemId);
	   	//item_attach 테이블에서 fullname 추출 
	   // itemId 하나에 들어있는 파일들(여러개가 될 수 있음)
	    // 리스트로 받아 보냄 
	   return itemService.getAttach(itemId);
	   
   }
   
   @PostMapping("/modify")
   public String item3Modify(Item3 item, Model model)throws Exception {
	   
	   String[] files = item.getFiles();
	   
	   for(int i = 0; i < files.length; i++) {
		   logger.info("files[" + i + "] :" + files[i]);
	   }
	   
	   itemService.modify(item);
	   model.addAttribute("msg", "수정 끝~");
	   
	   return "item3/success";
	   
   }
   
   @GetMapping("/remove")
   public String itemRemoveForm(int itemId, Model model) throws Exception {
	   Item3 item = itemService.read(itemId);
	   model.addAttribute("item", item);
	   
	   return "item3/remove";
	   
   }
   @PostMapping("/remove")
   public String itemRemove(int itemId, Model model) throws Exception {
	   Item3 item = itemService.read(itemId);
	   itemService.remove(itemId);
	   model.addAttribute("msg", "삭제완료~");
	   
	   return "item3/success";
	   
   }
   
   
   
}