package com.khj.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khj.board.dao.ContentDao;
import com.khj.board.domain.ContentVO;

@Service
public class ContentServiceImpl implements ContentService{
	
	private ContentDao contentDao;
	
	@Autowired
	public ContentServiceImpl (ContentDao contentDao) {
		this.contentDao = contentDao;
	}
	
	// 게시판 기능
	
	@Override
	public List<ContentVO> list() {
		return contentDao.list();
	}
	
	@Override
	public void insert(ContentVO contentVO) {
		contentDao.insert(contentVO);
	}
	
	@Override
	public ContentVO select(int board_seq) {
		contentDao.updateReadCount(board_seq);
		return contentDao.select(board_seq);
	}
	
	@Override
	public int update(ContentVO contentVO) {
		return contentDao.update(contentVO);
	}
	
	@Override
	public int delete(ContentVO contentVO) {
		return contentDao.delete(contentVO);
	}

	@Override
	public int updateReadCount(int cid) {
		return contentDao.updateReadCount(cid);
	}
	
	
	
	// 댓글 기능
	/*
	@Override
	public List<ReplyVO> repList(int board_seq) {
		return boardDao.repList(board_seq);
	}

	@Override
	public int repDelete(int rep_seq) {
		return boardDao.repDelete(rep_seq);
	}

	@Override
	public int repUpdate(ReplyVO replyVO) {
		return boardDao.repUpdate(replyVO);
	}

	@Override
	public void repInsert(ReplyVO replyVO) {
		boardDao.repInsert(replyVO);
	}
	*/
}
