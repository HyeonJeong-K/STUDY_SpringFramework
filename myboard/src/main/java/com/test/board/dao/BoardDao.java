package com.test.board.dao;

import java.util.List;

import com.test.board.domain.BoardVO;
import com.test.board.domain.ReplyVO;

public interface BoardDao {
	
	// 게시판 기능
	
	public abstract List<BoardVO> list();
	
	public abstract void insert(BoardVO boardVO);
	
	public abstract BoardVO select(int board_seq);
	
	public abstract int update(BoardVO boardVO);
	
	public abstract int delete(BoardVO boardVO);
	
	public abstract int updateReadCount(int board_seq);
	
	
	
	// 댓글 기능
	
	public abstract List<ReplyVO> repList(int board_seq);
	
	public abstract void repInsert(ReplyVO replyVO);
	
	public abstract int repUpdate(ReplyVO replyVO);
	
	public abstract int repDelete(int rep_seq);
}
