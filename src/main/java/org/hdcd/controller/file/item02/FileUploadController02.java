package org.hdcd.controller.file.item02;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.hdcd.controller.file.item02.service.ItemService2;
import org.hdcd.vo.Item2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/item2")
public class FileUploadController02 {
	
	@Resource(name="uploadPath") // servlet-content에서 등록한 빈중 id = uploadPath 빈이 주입이 됨 
	private String uploadPath;
	
	@Inject
	private ItemService2 ItemService;
	
		private static Logger logger = LoggerFactory.getLogger(FileUploadController02.class);
		/*
		 *	13장  파일 업로드
		 *
		 *  3. 여러 개의 이미지 업로드
		 *     - 한번에 여러 개의 이미지를 업로드 하는 파일 업로드 기능 구현
		 *   
		 *   
		 *     1. 파일 업로드 구현 설명 
		 *       - 파일 업로드 등록 화면 컨트롤러 만들기 (FileUploadController02)
		 *       - 파일 업로드 등록 화면 컨트롤러 메소드 만들기 (item2RegisterForm:get)
		 *       - 파일 업로드 등록 화면 만들기 (item2/register.jsp)
		 *       -             여기까지 확인 
		 *      
		 *       - 파일업로드 등록 기능 컨트롤러 메소드 만들기 (item2Register:post)
		 *       - 파일업로드 등록 기능 서비스 인터페이스만들기
		 *       - 파일업로드 등록 기능 서비스 클래스 메소드 만들기
		 *       - 파일업로드 등록 기능 Mapper 인터페이스 메소드 만들기
		 *       - 파일업로드 등록 기능 Mapper xml  쿼리 만들기
		 *       - 파일업로드 등록 완료 페이지 만들기 
		 *       -        여기까지 확인
		 *       
		 *       - 파일업로드 목록 화면 컨트롤러 메소드 만들기 (item2List:get)
		 *       - 파일업로드 목록 화면 서비스 인터페이스만들기
		 *       - 파일업로드 목록 화면 서비스 클래스 메소드 만들기
		 *       - 파일업로드 목록 화면 Mapper 인터페이스 메소드 만들기
		 *       - 파일업로드 목록 화면 Mapper xml  쿼리 만들기
		 *       - 파일업로드 목록 화면 페이지 만들기 
		 *       
		 *       -        여기까지 확인
		 *       
		 *       - 파일업로드 수정 화면 컨트롤러 메소드 만들기 (item2Modify:get)
		 *       - 파일업로드 수정 화면 서비스 인터페이스만들기
		 *       - 파일업로드 수정 화면 서비스 클래스 메소드 만들기
		 *       - 파일업로드 수정 화면 Mapper 인터페이스 메소드 만들기
		 *       - 파일업로드 수정 화면 Mapper xml  쿼리 만들기
		 *       - 파일업로드 수정 화면 만들기 (item2/modify)
		 *       - 파일업로드 수정 기능 컨트롤러 메소드 만들기 
		 *       - 파일업로드 수정 기능 서비스 인터페이스 메소드 만들기
		 *       - 파일업로드 수정 기능 서비스 클래스 메소드 만들기
		 *       - 파일업로드 수정 기능 Mapper 인터페이스 메소드 만들기
		 *       - 파일업로드 수정 기능 Mapper xml  쿼리 만들기
		 *       -        여기까지 확인
		 *       
		 *       - 파일업로드 삭제 화면 컨트롤러 메소드 만들기 
		 *       - 파일업로드 삭제 화면 서비스 인터페이스 메소드 만들기 
		 *       - 파일업로드 삭제 화면 서비스 클래스메소드 만들기 
		 *       - 파일업로드 삭제 화면 Mapper 인터페이스 메소드 만들기 
		 *       - 파일업로드 삭제 화면 Mapper xml 쿼리 만들기 
		 *       - 파일업로드 삭제 기능 컨트롤러 메소드 만들기 
		 *       - 파일업로드 삭제 기능 서비스 인터페이스 메소드 만들기
		 *       - 파일업로드 삭제 기능 서비스 클래스 메소드 만들기
		 *       - 파일업로드 삭제 기능 Mapper 인터페이스 메소드 만들기
		 *       - 파일업로드 삭제 기능 Mapper xml  쿼리 만들기
		 *       
		 *          --- 여기까지 완료
		 *       
		 *       
		 */


	@GetMapping("/register")
	public String item2RegisterForm(Model model) {
		model.addAttribute("item", new Item2());
		
		return "item2/register";
	}
	
	@PostMapping("/register")
	public String item2Register(Item2 item, Model model) throws Exception {
		
		List<MultipartFile> pictures = item.getPictures();
		
		for(int i = 0; i <pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			logger.info("originalName : " + file.getOriginalFilename());
			logger.info("size : " + file.getSize());
			logger.info("contentType : " + file.getContentType());
			
			String savedName = uploadFile(file.getOriginalFilename(),file.getBytes());
		
			if(i == 0) {
				item.setPictureUrl(savedName);
			}else if(i == 1) {
				item.setPictureUrl2(savedName);
			}
		}
		ItemService.register(item);
		model.addAttribute("msg", "등록이 완료!");
		
		return "item2/success";
	}

	@GetMapping("/list")
	public String item2List(Model model) throws Exception {
		List<Item2> itemList = ItemService.list();
		model.addAttribute("itemList", itemList);
		
		return "item2/list";
	}
	
	@GetMapping("/remove")
	public String item2RemoveForm(int itemId, Model model) throws Exception{
		Item2 item = ItemService.read(itemId);
		model.addAttribute("item", item);
		return "item2/remove";
	}
	
	@PostMapping("/remove")
	public String item2Remove(Item2 item, Model model) throws Exception{
		ItemService.remove(item.getItemId());
		model.addAttribute("msg", "삭제 완료!");
		return "item2/success";
	}
	
	@GetMapping("/modify")
	public String item2ModifyForm(int itemId, Model model) throws Exception{
		Item2 item = ItemService.read(itemId);
		model.addAttribute("item", item);
		return "item2/modify";
	}
	
	@PostMapping("/modify")
	public String item2Modify(Item2 item, Model model) throws Exception {
		List<MultipartFile> pictures = item.getPictures();
			
		for(int i =0; i< pictures.size(); i++) {
			MultipartFile file = pictures.get(i);
			if(file !=null && file.getSize() >0) {
				logger.info("originName :" + file.getOriginalFilename());
				logger.info("size :" + file.getSize());
				logger.info("contentType :" + file.getContentType());
				
				//넘겨받은 파일을 이용하여 파일 업로드(복사)를 진행
				// return : UUID + '_'+ 파일원본명
				String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
				if(i == 0) {
					item.setPictureUrl(createdFileName);					
				}else if(i == 1) {
					item.setPictureUrl2(createdFileName);
				}
			}
		}
			ItemService.modify(item);
			model.addAttribute("msg", "수정완료");
			
			return "item2/success";
	}
	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		
		UUID uuid = UUID.randomUUID();
		String createdFileName = uuid.toString() + "_" + originalName;
		File target = new File(uploadPath, createdFileName);
		FileCopyUtils.copy(fileData, target);
		
		return createdFileName;
		
	}
	@ResponseBody
	@RequestMapping("/display")
	public ResponseEntity<byte[]> displayFile(int itemId) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = ItemService.getPicture(itemId);
		logger.info("file name : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자 추출 
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + File.separator + fileName);
			
			if(mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	@ResponseBody
	@RequestMapping("/display2")
	public ResponseEntity<byte[]> displayFile2(int itemId) throws Exception{
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		String fileName = ItemService.getPicture2(itemId);
		logger.info("file name : " + fileName);
		
		try {
			String formatName = fileName.substring(fileName.lastIndexOf(".") + 1); // 확장자 추출 
			MediaType mType = getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + File.separator + fileName);
			
			if(mType != null) {
				headers.setContentType(mType);
			}
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}finally {
			in.close();
		}
		return entity;
	}
	
	public MediaType getMediaType(String formatName) {
		if(formatName != null) {
			if(formatName.toUpperCase().equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}else if(formatName.equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}else if(formatName.equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}
		}
		return null;
	}
	
	
}

