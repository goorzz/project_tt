package project.tt.vo;

public class ScheduleVO {

	
	private int no;
	private String p_no;
	private String date;   	 // 경기날짜
	private String w_group;  // 조 (A,B...)
	private String time;	 // 경기시간
	private String name_1; 	 // 팀1
	private String name_2;	 // 팀2
	private String score_1;  // 팀1 점수 
	private String score_2; 	 // 팀2 점수
	private String predict; // 예측결과
	
	@Override
	public String toString() {
		return "ScheduleVO [no=" + no + ", p_no=" + p_no + ", date=" + date + ", w_group=" + w_group + ", time=" + time
				+ ", name_1=" + name_1 + ", name_2=" + name_2 + ", score_1=" + score_1 + ", score_2=" + score_2 + "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getP_no() {
		return p_no;
	}
	public void setP_no(String p_no) {
		this.p_no = p_no;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getW_group() {
		return w_group;
	}
	public void setW_group(String w_group) {
		this.w_group = w_group;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getScore_1() {
		return score_1;
	}
	public void setScore_1(String score_1) {
		this.score_1 = score_1;
	}
	public String getScore_2() {
		return score_2;
	}
	public void setScore_2(String score_2) {
		this.score_2 = score_2;
	}
	public String getPredict() {
		return predict;
	}
	public void setPredict(String predict) {
		this.predict = predict;
	}
	

}
