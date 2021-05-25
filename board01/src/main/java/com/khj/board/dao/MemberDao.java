package com.khj.board.dao;

import com.khj.board.domain.MemberVO;

public interface MemberDao {
	
	// 회원가입
	public abstract void insertMember(MemberVO memberVO);
	// 로그인
	public abstract MemberVO selectMember(MemberVO memberVO);
	
}
