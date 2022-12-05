package org.hdcd.controller.member.service;

import java.util.List;

import org.hdcd.vo.MemberVO;

public interface ImemberService {
	public void register(MemberVO member) throws Exception;

	public List<MemberVO> list() throws Exception;

	public MemberVO read(int userNo) throws Exception;

	public void modfiy(MemberVO member) throws Exception;

	public void remove(int userNo) throws Exception;
}
