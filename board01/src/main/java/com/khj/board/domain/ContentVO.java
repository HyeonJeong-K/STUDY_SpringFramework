package com.khj.board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;


/*
 create table "CONTENTS" (
"CID" number not null primary key,
"UID"    number references "MEMBER"("UID"),
"TITLE"     varchar2(255) not null,
"CONTENT"   varchar2(255),
"CONDATE"   TIMESTAMP not null,
"READCNT"   number(5,0) default 0 not null
); 
 */
@Alias("ContentVO")
public class ContentVO {
	private int cid;
	private int uid;
	private String title;
	private String content;
	private Timestamp condate;
	private int readcnt;
	
	public ContentVO() {}
	
	public ContentVO(int cid, int uid, String title, String content, Timestamp condate, int readcnt) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.title = title;
		this.content = content;
		this.condate = condate;
		this.readcnt = readcnt;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public Timestamp getCondate() {
		return condate;
	}

	public void setCondate(Timestamp condate) {
		this.condate = condate;
	}

	public int getReadcnt() {
		return readcnt;
	}

	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	
}
