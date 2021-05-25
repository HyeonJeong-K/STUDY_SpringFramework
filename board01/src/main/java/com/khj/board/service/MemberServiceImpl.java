package com.khj.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khj.board.dao.MemberDao;
import com.khj.board.domain.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public void register(MemberVO memberVO) {
		memberDao.insertMember(memberVO);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		return memberDao.selectMember(memberVO);
	}

	@Override
	public int idChk(MemberVO memberVO) {
		int idChk = memberDao.idChk(memberVO);
		return idChk;
	}
	
}
