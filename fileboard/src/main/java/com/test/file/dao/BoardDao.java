package com.test.file.dao;

import java.util.List;

import com.test.file.domain.BoardVO;

public interface BoardDao {
	
	// 파일업로드 기능
	
	public abstract List<BoardVO> list();
	
	public abstract void insert(BoardVO boardVO);
	
	public abstract BoardVO select(int board_seq);
	
	public abstract int update(BoardVO boardVO);
	
	public abstract int delete(BoardVO boardVO);
	
}
