package com.test.file.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

/*
 create table FILE_BOARD(
"BOARD_SEQ" number(7,0) not null primary key,
"TITLE"     varchar2(255) not null,
"CONTENT"   varchar2(255),
"WRITER"    varchar2(100) not null,
"PASSWORD"  varchar2(50) not null,
"REGDATE"   TIMESTAMP not null,
"READCNT"   number(5,0) default 0 not null,
"FILE_NAME" varchar2(255)
);
 */

@Alias("BoardVO")
public class BoardVO {
	private int board_seq;
	private String title;
	private String content;
	private String writer;
	private String password;
	private Timestamp regdate;
	private int readcnt;
	private String file_name;
	private MultipartFile uploadFile;
	
	public BoardVO() {}
	
	public BoardVO(int board_seq, String title, String content, String writer, String password,	Timestamp regdate, int readcnt, String file_name, MultipartFile uploadFile) {
		super();
		this.board_seq = board_seq;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.regdate = regdate;
		this.readcnt = readcnt;
		this.file_name = file_name;
		this.uploadFile = uploadFile;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	
	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "BoardVO [board_seq=" + board_seq + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", password=" + password + ", regdate=" + regdate + ", readcnt=" + readcnt + ", file_name="
				+ file_name + ", uploadFile=" + uploadFile + "]";
	}
	
	
	
}
