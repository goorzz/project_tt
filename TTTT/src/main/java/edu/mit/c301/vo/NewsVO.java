package edu.mit.c301.vo;

public class NewsVO {
	
	
	private int no;
	private String n_date;
	private String n_title;   // new title
	private String n_no; //news 순위?
	private String n_url; //url 
	
	
	@Override
	public String toString() {
		return "NewsVO [no=" + no + ", n_date=" + n_date + ", n_title=" + n_title + ", n_no=" + n_no + ", n_url="
				+ n_url + "]";
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getN_date() {
		return n_date;
	}


	public void setN_date(String n_date) {
		this.n_date = n_date;
	}


	public String getN_title() {
		return n_title;
	}


	public void setN_title(String n_title) {
		this.n_title = n_title;
	}


	public String getN_no() {
		return n_no;
	}


	public void setN_no(String n_no) {
		this.n_no = n_no;
	}


	public String getN_url() {
		return n_url;
	}


	public void setN_url(String n_url) {
		this.n_url = n_url;
	}
	


	
	
	
	
	
	
	
	
	
//	private int bno;
//	private String title;
//	private String content;
//	private String writer;
//	private String regdate;
//	private String updatedate;
//	
//	public int getBno() {
//		return bno;
//	}
//	public void setBno(int bno) {
//		this.bno = bno;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getContent() {
//		return content;
//	}
//	public void setContent(String content) {
//		this.content = content;
//	}
//	public String getWriter() {
//		return writer;
//	}
//	public void setWriter(String writer) {
//		this.writer = writer;
//	}
//	public String getRegdate() {
//		return regdate;
//	}
//	public void setRegdate(String regdate) {
//		this.regdate = regdate;
//	}
//	public String getUpdatedate() {
//		return updatedate;
//	}
//	public void setUpdatedate(String updatedate) {
//		this.updatedate = updatedate;
//	}
//	

	
}