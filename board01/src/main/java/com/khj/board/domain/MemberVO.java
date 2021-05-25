package com.khj.board.domain;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

/*
create table "MEMBER" (
	"UID" number primary key,
	"NAME" varchar2(100) ,
	"PASSWORD" varchar2(100),
	"EMAIL" varchar2(100),
	"REGDATE" date default sysdate
); 
 */
@Alias("MemberVO")
public class MemberVO {
	private int uid;
	private String name;
	private String password;
	private String email;
	private Timestamp regdate;
	
	public MemberVO() {}
	
	public MemberVO(int uid, String name, String password, String email, Timestamp regdate) {
		super();
		this.uid = uid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.regdate = regdate;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	
	
}
