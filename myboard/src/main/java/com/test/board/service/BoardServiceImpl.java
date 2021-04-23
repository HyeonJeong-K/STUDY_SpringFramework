package com.test.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.BoardDao;
import com.test.board.domain.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	
	private BoardDao boardDao;
	
	@Autowired
	public BoardServiceImpl (BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	@Override
	public List<BoardVO> list() {
		return boardDao.list();
	}
	
	@Override
	public void insert(BoardVO boardVO) {
		boardDao.insert(boardVO);
	}
	
	@Override
	public BoardVO select(int board_seq) {
		boardDao.updateReadCount(board_seq);
		return boardDao.select(board_seq);
	}
	
	@Override
	public int update(BoardVO boardVO) {
		return boardDao.update(boardVO);
	}
	
	@Override
	public int delete(BoardVO boardVO) {
		return boardDao.delete(boardVO);
	}

	@Override
	public int updateReadCount(int board_seq) {
		return boardDao.updateReadCount(board_seq);
	}
	
}
