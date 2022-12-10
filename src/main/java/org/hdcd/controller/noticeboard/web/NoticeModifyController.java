package org.hdcd.controller.noticeboard.web;

import javax.inject.Inject;

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
public class NoticeModifyController {

	@Inject
	private InoticeService noticeService;
	
	@GetMapping("/update.do")
	public String noticeUpdateView(int boNo, ModelMap model) {
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status", "u");
		return "notice/form";
	}
	
	@PostMapping("/update.do")
	public String  noticeUpdate(NoticeVO noticeVO, ModelMap model) {
		String goPage = "";
		ServiceResult  result = noticeService.updateNotice(noticeVO);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/detail.do?boNo=" + noticeVO.getBoNo();
		}else {
			model.addAttribute("message", "수정 실패!");
			model.addAttribute("noticeVO", noticeVO);
			goPage = "notice/form";
		}
		return goPage;
	}
	
	@PostMapping("/delete.do")
	public String noticeDelete(int boNo, ModelMap model) {
		
		String goPage = "";
		ServiceResult  result = noticeService.deleteNotice(boNo);
		
		if(result.equals(ServiceResult.OK)) {
			goPage = "redirect:/notice/list.do";
		}else {
			model.addAttribute("message", "서버 오류 다시 시도!");
			goPage = "redirect:/notice/detail.do?boNo="+boNo;
		}
		return goPage;
	
	}
}
