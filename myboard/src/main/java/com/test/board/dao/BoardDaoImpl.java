package com.test.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.domain.BoardVO;
import com.test.board.domain.ReplyVO;

@Repository
public class BoardDaoImpl implements BoardDao{

	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public BoardDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 게시판 기능
	
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
		BoardVO boardVO = (BoardVO) sqlSessionTemplate.selectOne("select", board_seq);
		return boardVO;
	}

	@Override
	public int updateReadCount(int board_seq) {
		return sqlSessionTemplate.update("updateCount", board_seq);
	}



	// 댓글기능
	
	@Override
	public List<ReplyVO> repList(int board_seq) {
		return sqlSessionTemplate.selectList("repList", board_seq);
	}

	@Override
	public int repDelete(int rep_seq) {
		return sqlSessionTemplate.delete("repDelete", rep_seq);
	}

	@Override
	public int repUpdate(ReplyVO replyVO) {
		return sqlSessionTemplate.update("repUpdate", replyVO);
	}

	@Override
	public void repInsert(ReplyVO replyVO) {
		sqlSessionTemplate.insert("repInsert", replyVO);
	}

}
