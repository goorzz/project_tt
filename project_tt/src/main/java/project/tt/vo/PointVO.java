package project.tt.vo;

import java.util.Date;

public class PointVO {

	private int point_no; //포인트 번호 
	private int no;
	private String user_id;
	private String point_content;// 포인트내용
	private int point_point;// 포인트
	private Date date;
	
	public int getPoint_no() {
		return point_no;
	}
	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}
	public String getPoint_content() {
		return point_content;
	}
	public void setPoint_content(String point_content) {
		this.point_content = point_content;
	}
	public int getPoint_point() {
		return point_point;
	}
	public void setPoint_point(int point_point) {
		this.point_point = point_point;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

}
