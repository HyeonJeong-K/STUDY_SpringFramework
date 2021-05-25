package com.khj.board.dao;

import com.khj.board.domain.MemberVO;

public interface MemberDao {
	
	// 회원가입
	public abstract void insertMember(MemberVO memberVO);
	// 로그인
	public abstract MemberVO selectMember(MemberVO memberVO);
	// 아이디 중복확인
	public abstract int idChk(MemberVO memberVO);
	// 비밀번호 확인
	
}
