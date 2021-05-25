package com.khj.board.service;

import com.khj.board.domain.MemberVO;

public interface MemberService {
	// 회원가입
	public abstract void register(MemberVO memberVO);
	// 로그인
	public abstract MemberVO login(MemberVO memberVO);
}
