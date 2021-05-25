package com.khj.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.khj.board.domain.ContentVO;

@Repository
public class ContentDaoImpl implements ContentDao{
	
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public ContentDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 게시판 기능
	
	@Override
	public List<ContentVO> list() {
		return sqlSessionTemplate.selectList("list");
	}
	
	@Override
	public void insert(ContentVO contentVO) {
		sqlSessionTemplate.insert("insert", contentVO);
	}
	
	@Override
	public ContentVO select(int cid) {
		ContentVO contentVO = (ContentVO) sqlSessionTemplate.selectOne("select", cid);
		return contentVO;
	}
	
	@Override
	public int update(ContentVO contentVO) {
		return sqlSessionTemplate.update("update", contentVO);
	}

	@Override
	public int delete(ContentVO contentVO) {
		return sqlSessionTemplate.delete("delete", contentVO);
	}

	@Override
	public int updateReadCount(int cid) {
		return sqlSessionTemplate.update("updateCount", cid);
	}



	// 댓글기능
	/*
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
	*/
}
