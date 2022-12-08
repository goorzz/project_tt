package project.tt.dao;

import lombok.Data;

@Data
public class Criteria {
	
	private int pageNum=1; //현재페이지
	private int amount=10; // 한페이지당 게시물 갯수
	private int skip=0; //  (현재페이지-1) * 한페이지당 게시물수 )
	private String type; 	//   타입 
	private String keyword; //검색어 키워드	
	private String user_id;

	public void set_skip() {
		this.skip=(pageNum-1)*amount;
	}
	public String[] getTypeArr() {
		if(type==null)
			return	new String[] {};
		else 
			return type.split(""); 
		}
	}


	