package com.khj.board.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khj.board.domain.MemberVO;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public MemberDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSessionTemplate.insert("insertMember", memberVO);
	}

	@Override
	public MemberVO selectMember(MemberVO memberVO) {
		return sqlSessionTemplate.selectOne("selectMember", memberVO);
	}
	
}
