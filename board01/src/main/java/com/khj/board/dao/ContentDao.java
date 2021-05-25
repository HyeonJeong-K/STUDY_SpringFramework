package com.khj.board.dao;

import java.util.List;

import com.khj.board.domain.ContentVO;


public interface ContentDao {
	// 게시판 기능

	public abstract List<ContentVO> list();

	public abstract void insert(ContentVO contentVO);

	public abstract ContentVO select(int cid);

	public abstract int update(ContentVO contentVO);

	public abstract int delete(ContentVO contentVO);

	public abstract int updateReadCount(int cid);



	// 댓글 기능
	/*
		public abstract List<ReplyVO> repList(int cid);

		public abstract void repInsert(ReplyVO replyVO);

		public abstract int repUpdate(ReplyVO replyVO);

		public abstract int repDelete(int rid);
	 */
}
