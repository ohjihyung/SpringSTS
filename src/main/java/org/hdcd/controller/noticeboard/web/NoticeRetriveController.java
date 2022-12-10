package org.hdcd.controller.noticeboard.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.hdcd.controller.noticeboard.service.InoticeService;
import org.hdcd.vo.NoticeVO;
import org.hdcd.vo.PaginationInfoVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/notice")
public class NoticeRetriveController {
	
	@Inject
	private InoticeService noticeService;
	
	@GetMapping("/list.do")
	public ModelAndView noticeListView(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord
			) {
		
		ModelAndView mav = new ModelAndView();
		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<NoticeVO>();

		if(StringUtils.isNotBlank(searchWord)) {
			if("title".equals(searchType)) {
				pagingVO.setSearchType("title"); // 제목으로 검색
			}else {
				pagingVO.setSearchType("writer"); //작성자로 검색
			}
			pagingVO.setSearchWord(searchWord);
			mav.addObject("searchType", searchType);
			mav.addObject("searchWord", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeService.selectNoticeCount(pagingVO); // 전체 게시물 수 
		
		pagingVO.setTotalRecord(totalRecord);
		List<NoticeVO> dataList = noticeService.selectNoticeList(pagingVO);
		
		pagingVO.setDataList(dataList);
		
		mav.addObject("pagingVO", pagingVO);
		mav.setViewName("notice/list");
		
		return mav;
	}

	@GetMapping("/detail.do")
	public String noticeDetailView(int boNo, ModelMap model) {
		NoticeVO noticeVO = noticeService.selectNotice(boNo);
		model.addAttribute("noticeVO", noticeVO);
		
		return "notice/detail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
