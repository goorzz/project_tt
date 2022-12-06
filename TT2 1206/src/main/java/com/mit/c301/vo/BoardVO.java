package com.mit.c301.vo;

import java.util.Date;

import lombok.Data;

public class BoardVO {
	private int rno; // 마이페이지 내가 쓴갯수
	private int bno;  //글번호
	private String title; // 제목
	private String content; // 내용
	private String user_nickname; //닉네임
	private Date date; //날짜
	private int good; //좋아요
	private int bad; //싫어요
	private int view_count; //조회수
	private Integer mypage_board_count; // 마이페이지 갯수
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
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
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public int getBad() {
		return bad;
	}
	public void setBad(int bad) {
		this.bad = bad;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public Integer getMypage_board_count() {
		return mypage_board_count;
	}
	public void setMypage_board_count(Integer mypage_board_count) {
		this.mypage_board_count = mypage_board_count;
	}
	
}
