package com.test.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.board.dao.MessageDao;
import com.test.board.domain.MessageVO;

@Service
public class MessageServiceImpl implements MessageService{
	
	private MessageDao messageDao;
	
	@Autowired
	public MessageServiceImpl (MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	// 쪽지 기능
	@Override
	public List<MessageVO> msgList(int board_seq) {
		return messageDao.msgList(board_seq);
	}

	@Override
	public void msgInsert(MessageVO messageVO) {
		messageDao.msgInsert(messageVO);
	}

	@Override
	public MessageVO msgSelect(int msg_seq) {
		return messageDao.msgSelect(msg_seq);
	}

	@Override
	public int msgDelete(int msg_seq) {
		return messageDao.msgDelete(msg_seq);
	}

}
