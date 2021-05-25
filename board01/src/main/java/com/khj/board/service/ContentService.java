package com.khj.board.service;

import java.util.List;

import com.khj.board.domain.ContentVO;


public interface ContentService {
	// 게시판 기능

	public abstract List<ContentVO> list();

	public abstract void insert(ContentVO contentVO);

	public abstract ContentVO select(int cid);

	public abstract int update(ContentVO contentVO);

	public abstract int delete(ContentVO contentVO);

	public abstract int updateReadCount(int cid);


	// 댓글 기능
	/*
	public abstract List<ReplyVO> repList(int board_seq);

	public abstract int repDelete(int rep_seq);

	public abstract int repUpdate(ReplyVO replyVO);

	public abstract void repInsert(ReplyVO replyVO);
	*/
}
