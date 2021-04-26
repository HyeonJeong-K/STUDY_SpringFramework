package com.test.board.dao;

import java.util.List;

import com.test.board.domain.MessageVO;

public interface MessageDao {
	
	public abstract List<MessageVO> msgList(int board_seq);
	
	public abstract void msgInsert(MessageVO messageVO);
	
	public abstract MessageVO msgSelect(int msg_seq);
	
	public abstract int msgDelete(int msg_seq);
	
}
