package com.nuri.s4.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.nuri.s4.dao.MemberDAOImpl;
import com.nuri.s4.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAOImpl memberDAOImpl;
	
	@Override
	public MemberVO memberIdCheck(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberIdCheck(memberVO);
	}
	
	@Override
	public int memberJoin(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberJoin(memberVO);
	}

	@Override
	public MemberVO memberLogin(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberLogin(memberVO);
	}

	@Override
	public int memberUpdate(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberUpdate(memberVO);
	}

	@Override
	public int memberDelete(MemberVO memberVO) throws Exception {
		return memberDAOImpl.memberDelete(memberVO);
	}

	@Override
	public int memberPointUpdate(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
