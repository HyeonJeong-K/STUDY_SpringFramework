package com.test.board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

/*
create table REPLY(
"REP_SEQ" number(7,0) not null primary key, 
"BOARD_SEQ" number(7,0) not null, 
"REP_TEXT" varchar(255), 
"REP_WRITER" varchar(100) not null,
"REP_DATE" TIMESTAMP not null
); 
 */

@Alias("ReplyVO")
public class ReplyVO {
	private int rep_seq;
	private int board_seq;
	private String rep_text;
	private String rep_writer;
	private Timestamp rep_date;
	
	public ReplyVO() {}
	
	public ReplyVO(int rep_seq, int board_seq, String rep_text, String rep_writer, Timestamp rep_date) {
		super();
		this.rep_seq = rep_seq;
		this.board_seq = board_seq;
		this.rep_text = rep_text;
		this.rep_writer = rep_writer;
		this.rep_date = rep_date;
	}
	
	public int getRep_seq() {
		return rep_seq;
	}
	public void setRep_seq(int rep_seq) {
		this.rep_seq = rep_seq;
	}
	
	public int getBoard_seq() {
		return board_seq;
	}
	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}
	
	public String getRep_text() {
		return rep_text;
	}
	public void setRep_text(String rep_text) {
		this.rep_text = rep_text;
	}
	
	public String getRep_writer() {
		return rep_writer;
	}
	public void setRep_writer(String rep_writer) {
		this.rep_writer = rep_writer;
	}
	
	public Timestamp getRep_date() {
		return rep_date;
	}
	public void setRep_date(Timestamp rep_date) {
		this.rep_date = rep_date;
	}
	
}
