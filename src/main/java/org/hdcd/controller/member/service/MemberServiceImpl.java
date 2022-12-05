package org.hdcd.controller.member.service;

import java.util.List;

import javax.inject.Inject;

import org.hdcd.mapper.MemberMapper;
import org.hdcd.vo.MemberAuth;
import org.hdcd.vo.MemberVO;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements ImemberService {

	@Inject
	private MemberMapper mapper;
	
	@Override
	public void register(MemberVO member) throws Exception {
		mapper.create(member);
		
		//회원 등급
		MemberAuth memberAuth = new MemberAuth();
		memberAuth.setUserNo(member.getUserNo());
		memberAuth.setAuth("ROLE_USER");
		mapper.createAuth(memberAuth);

	}


	@Override
	public List<MemberVO> list() throws Exception {
		return mapper.list();
	}


	@Override
	public MemberVO read(int userNo) throws Exception {
		
		return mapper.read(userNo);
	}


	@Override
	public void modfiy(MemberVO member) throws Exception {
		mapper.update(member);

		int userNo = member.getUserNo();
		mapper.deleteAuth(userNo); //역할명들 지우고
		List<MemberAuth> authList = member.getAuthList(); // 새롭게 생성된 auth 집어넣음
		
		for(int i = 0; i < authList.size();i++) {
			MemberAuth memberAuth = authList.get(i);
			String auth = memberAuth.getAuth();
			if(auth == null) {
				continue;
			}
			if(auth.trim().length() == 0) {
				continue;
			}
			memberAuth.setUserNo(userNo);
			mapper.createAuth(memberAuth);
		}
	}


	@Override
	public void remove(int userNo) throws Exception {
		
		mapper.deleteAuth(userNo);
		mapper.delete(userNo);
		
	}

}
