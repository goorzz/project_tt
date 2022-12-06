package com.mit.c301.domain;

import lombok.Data;

@Data

public class Criteria {
	
	private int pageNum=1; //현재페이지
	private int amount=10; // 한페이지당 게시물 갯수
	private int skip=0; //  (현재페이지-1) * 한페이지당 게시물수 )
	private String type; 	//   타입 
	private String keyword; //검색어 키워드

	public void set_skip() {
		this.skip=(pageNum-1)*amount;
	}
	//split()은 어떤 문자 기준으로 문자열을 자르고 배열로 리턴해 줍니다.
	//검색방법 문자열을 분해해서 리턴해주는 메소드
	public String[] getTypeArr() {
		if(type==null)
			return	new String[] {};
		else 
			return type.split(""); 
		}
	}
	