package org.hdcd.mapper;

import java.util.List;

import org.hdcd.vo.MemberAuth;
import org.hdcd.vo.MemberVO;

public interface MemberMapper {
	public void create(MemberVO member) throws Exception;
	public void createAuth(MemberAuth memberAuth) throws Exception;
	public List<MemberVO> list() throws Exception;
	public MemberVO read(int userNo) throws Exception;
	public void update(MemberVO member) throws Exception;
	public void deleteAuth(int userNo) throws Exception;
	public void delete(int userNo) throws Exception;
}
