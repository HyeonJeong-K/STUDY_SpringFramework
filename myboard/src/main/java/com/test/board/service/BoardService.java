package com.test.board.service;

import java.util.List;

import com.test.board.domain.BoardVO;

public interface BoardService {
	public abstract List<BoardVO> list();
	
	public abstract void insert(BoardVO boardVO);
	
	public abstract BoardVO select(int board_seq);
	
	public abstract int update(BoardVO boardVO);
	
	public abstract int delete(BoardVO boardVO);
	
	public abstract int updateReadCount(int board_seq);
	
}
