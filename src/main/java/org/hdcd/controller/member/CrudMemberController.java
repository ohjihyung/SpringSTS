package org.hdcd.controller.member;


import java.util.List;

import javax.inject.Inject;

import org.hdcd.controller.member.service.ImemberService;
import org.hdcd.vo.MemberVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/crud/member")
public class CrudMemberController {


	private static Logger logger = LoggerFactory.getLogger(CrudMemberController.class);	
	
	// 주입 하는거 까먹지 말기!
	@Inject
	private ImemberService service;
	
	//회원 등록 페이지
	@GetMapping("/register")
	public String crudMemberRegisterForm(MemberVO member, Model model) {
		model.addAttribute("member", member);
		return "crud/member/register";
	}
	
	//회원 등록 기능
	@PostMapping("/register")
	public String crudMemberRegister(MemberVO member, Model model) throws Exception {
		logger.info("crudMemberRegister");
		service.register(member);
		model.addAttribute("msg", "등록이 완료!");
		return "crud/member/success";
	}
	
	//회원 목록 페이지
	@GetMapping("/list")
	public String crudMemberList(Model model) throws Exception{
		List<MemberVO> memberList = service.list();
		model.addAttribute("list", memberList);
		return "crud/member/list";
		
	}
	
	@GetMapping("/read")
	public String crudMemberRead(int userNo, Model model) throws Exception {
		MemberVO member = service.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/read";
	}
	
	@GetMapping("/modify")
	public String crudMemberModifyForm(int userNo, Model model) throws Exception {
		MemberVO member = service.read(userNo);
		model.addAttribute("member", member);
		return "crud/member/modify";
	}
	
	@PostMapping("/modify")
	public String crudMemberModify(MemberVO member, Model model) throws Exception {
		service.modfiy(member);
		model.addAttribute("msg", "수정 완료!");
		return "crud/member/success";
		
	}
	
	@PostMapping("/remove")
	public String crudMemberDelete(int userNo, Model model) throws Exception {
		service.remove(userNo);
		model.addAttribute("msg", "삭제 완료!");
		return "crud/member/success";
	}
}
