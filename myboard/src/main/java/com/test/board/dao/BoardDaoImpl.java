package com.test.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.domain.BoardVO;

@Repository
public class BoardDaoImpl implements BoardDao{

	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public BoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardVO> list() {
		return sqlSessionTemplate.selectList("list");
	}
	
	@Override
	public int delete(BoardVO boardVO) {
		return sqlSessionTemplate.delete("delete", boardVO);
	}
	
	
	@Override
	public int update(BoardVO boardVO) {
		return sqlSessionTemplate.update("update", boardVO);
	}
	
	@Override
	public void insert(BoardVO boardVO) {
		sqlSessionTemplate.insert("insert", boardVO);
	}
	
	@Override
	public BoardVO select(int board_seq) {
		BoardVO boardVo = (BoardVO) sqlSessionTemplate.selectOne("select", board_seq);
		return boardVo;
	}
	
	@Override
	public int updateReadCount(int board_seq) {
		return sqlSessionTemplate.update("updateCount", board_seq);
	}
	
}
