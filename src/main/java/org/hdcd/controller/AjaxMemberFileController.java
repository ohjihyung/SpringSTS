package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/ajax")
public class AjaxMemberFileController {
	
	private static Logger logger = LoggerFactory.getLogger(AjaxMemberFileController.class);

	
	@GetMapping("/registerFileForm")
	public String ajaxRegisterFileForm() {
		
		return "member/ajaxRegisterFile";
	}
	
	@RequestMapping(value ="/uploadAjax", method = RequestMethod.POST, produces = "text/plain; charset=utf-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file){
		String originalFileName = file.getOriginalFilename();
		logger.info("originalFileName :" + originalFileName);
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS",HttpStatus.OK);
		
		return entity;		
	}
}
