package org.hdcd.controller.noticeboard.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.hdcd.controller.noticeboard.service.InoticeService;
import org.hdcd.serviceResult.ServiceResult;
import org.hdcd.vo.NoticeVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {

	@Inject
	private InoticeService noticeservice;
	
	@GetMapping("/form.do")
	public String noticeFormView() {
		return "notice/form";
	}
	
	@PostMapping("/insert.do")
	public String noticeInsert(NoticeVO noticeVO, ModelMap model) {
		String goPage = "";
		Map<String, String> errors = new HashMap<>();
		if(StringUtils.isBlank(noticeVO.getBoTitle())) {
			errors.put("botitle", "제목을 입력해주세요");
		}
		if(StringUtils.isBlank(noticeVO.getBoContent())) {
			errors.put("boContent", "내용을 입력해주세요");
		}
		
		//에러가 있을 때
		if(errors.size() > 0) {
			model.addAttribute("errors", errors);
			model.addAttribute("noticeVO", noticeVO);
			goPage = "notice/form";
		}else{ //정상
			 noticeVO.setBoWriter("a001");
			 ServiceResult result = noticeservice.insertNotice(noticeVO);
			 if(result.equals(ServiceResult.OK)) {
				 goPage = "redirect:/notice/list.do";
			 }else {
				 model.addAttribute("message", "서버에러 , 다시 시도");
				 goPage = "notice/form";
			 }
		}
		
		return goPage;
	}
}
