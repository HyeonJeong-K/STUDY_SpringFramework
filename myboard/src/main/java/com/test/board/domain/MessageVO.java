package com.test.board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

/*
create table MESSAGE(
"MSG_SEQ" number(7,0) not null primary key, 
"BOARD_SEQ" number(7,0) not null, 
"MSG_TITLE" varchar2(100) not null, 
"MSG_TEXT" varchar2(255) not null, 
"MSG_WRITER" varchar2(100) not null,
"MSG_DATE" TIMESTAMP not null
); 
 */

@Alias("MessageVO")
public class MessageVO {
	private int msg_seq;
	private int board_seq;
	private String msg_title;
	private String msg_text;
	private String msg_writer;
	private Timestamp msg_date;
	
	public MessageVO() {}
	
	public MessageVO(int msg_seq, int board_seq, String msg_title, String msg_text, String msg_writer, Timestamp msg_date) {
		super();
		this.msg_seq = msg_seq;
		this.board_seq = board_seq;
		this.msg_title = msg_title;
		this.msg_text = msg_text;
		this.msg_writer = msg_writer;
		this.msg_date = msg_date;
	}
	
	public int getMsg_seq() {
		return msg_seq;
	}
	public void setMsg_seq(int msg_seq) {
		this.msg_seq = msg_seq;
	}
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	
	public String getMsg_title() {
		return msg_title;
	}
	public void setMsg_title(String msg_title) {
		this.msg_title = msg_title;
	}
	
	public String getMsg_text() {
		return msg_text;
	}
	public void setMsg_text(String msg_text) {
		this.msg_text = msg_text;
	}
	
	public String getMsg_writer() {
		return msg_writer;
	}
	public void setMsg_writer(String msg_writer) {
		this.msg_writer = msg_writer;
	}
	
	public Timestamp getMsg_date() {
		return msg_date;
	}
	public void setMsg_date(Timestamp msg_date) {
		this.msg_date = msg_date;
	}
	
}
