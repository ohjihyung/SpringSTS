package org.hdcd.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Test01Controller {

	private static final Logger logger = LoggerFactory.getLogger(Test01Controller.class);
	
	
	@RequestMapping("/login")
	public String startPage() {
		logger.info("startPage()");
		
		return "test01/start";
	}
	
	
	@PostMapping("/main")
	public String goMain(@RequestParam("id") String id, @RequestParam("name") String name, Model model) throws UnsupportedEncodingException {
		
		model.addAttribute("id", id );
		model.addAttribute("name", name);
		
		return "test01/main1";
		
	}


	@RequestMapping("/myBox")
	public ModelAndView allFile() throws IOException {
		ModelAndView mav = new ModelAndView();
		
		String DATA_DIRECTORY = "D:\\mybox\\image";

		List<String> fileList = new ArrayList<String>();
		fileList = showFilesInDIr(DATA_DIRECTORY, fileList);		
		
		mav.setViewName("test01/myBox");
		mav.addObject("fileList" , fileList);
		
		return mav;
	}
	

	public static List<String> showFilesInDIr(String dirPath, List<String> fileList) throws IOException {
	  
		File dir = new File(dirPath);
	    File files[] = dir.listFiles();
	  
	    for (int i = 0; i < files.length; i++) {
	        File file = files[i];
	        System.out.println(file);
	        if (file.isDirectory()) {
	        	
	            showFilesInDIr(file.getPath(),fileList);
	        } else {
	        	System.out.println("fileName = "+file.getName());
	        	fileList.add(file.getName());
	        }
	    }
		return fileList;
	}
	
	//사진을 띄워주는 myGallary
	@RequestMapping("/myGallary")
	public ModelAndView gallary() throws IOException {
		
		ModelAndView mav = new ModelAndView();
		String DATA_DIRECTORY = "D:\\mybox\\image";
        Path dirPath = Paths.get(DATA_DIRECTORY);
        List<String> photos = new ArrayList<String>();
        List<Path> result;
        Stream<Path> walk = Files.walk(dirPath);
        result = walk.filter(Files::isRegularFile)
        		     .filter(p -> p.getFileName().toString().contains(".jpg"))
        		     .collect(Collectors.toList());

        for (Path path : result) {	
        	System.out.println(path.getFileName());
        	photos.add(path.getFileName().toString());
            
        }
     
		mav.addObject("photos",photos);
		mav.setViewName("test01/myGallary");
		return mav;
		
	}
	
	@RequestMapping("/download")
	public ResponseEntity<byte[]> download(@RequestParam String image) throws IOException{
		 String fileName = image; 
		 ResponseEntity<byte[]> entity = null;
		 InputStream in = null;
		   
		   try {
			   
			   HttpHeaders headers = new HttpHeaders();
			   in =  new FileInputStream("D:\\mybox\\image\\" + fileName);
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
	

	
}
