package project.tt.vo;

public class TotoVO {
	
	private int point_no;
	private String user_id;
	private String date;   	 // 경기날짜
	private String name_1; 	 // 팀1
	private String name_2;	 // 팀2
	private String predict_w; // 예측결과
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName_1() {
		return name_1;
	}
	public void setName_1(String name_1) {
		this.name_1 = name_1;
	}
	public String getName_2() {
		return name_2;
	}
	public void setName_2(String name_2) {
		this.name_2 = name_2;
	}
	public String getPredict_w() {
		return predict_w;
	}
	public void setPredict_w(String predict_w) {
		this.predict_w = predict_w;
	}
	public int getPoint_no() {
		return point_no;
	}
	public void setPoint_no(int point_no) {
		this.point_no = point_no;
	}

}
