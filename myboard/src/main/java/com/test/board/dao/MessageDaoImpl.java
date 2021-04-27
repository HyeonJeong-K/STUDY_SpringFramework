package com.test.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.board.domain.MessageVO;

@Repository
public class MessageDaoImpl implements MessageDao{
	
	private SqlSessionTemplate sqlSessionTemplate;

	@Autowired
	public MessageDaoImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	// 쪽지 기능
	
	@Override
	public List<MessageVO> msgList(int board_seq) {
		return sqlSessionTemplate.selectList("msgList", board_seq);
	}

	@Override
	public void msgInsert(MessageVO messageVO) {
		sqlSessionTemplate.insert("msgInsert", messageVO);
	}

	@Override
	public MessageVO msgSelect(int msg_seq) {
		MessageVO messageVO = (MessageVO) sqlSessionTemplate.selectOne("msgSelect", msg_seq);
		return messageVO;
	}

	@Override
	public int msgDelete(int msg_seq) {
		return sqlSessionTemplate.delete("msgDelete", msg_seq);
	}
	
}
