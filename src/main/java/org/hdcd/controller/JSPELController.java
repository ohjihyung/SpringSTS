package org.hdcd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jspel")
public class JSPELController {
	
	private static Logger logger = LoggerFactory.getLogger(JSPELController.class);
	
	@GetMapping("/home0101")
	public String home0101(Model model) {
		
		logger.info("home0101");
		String str = "<font>Hello World!</font>";
		model.addAttribute("str", str);
		
		return "home/el/home0101";
	}
	
}
