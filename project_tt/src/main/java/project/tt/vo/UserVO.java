package project.tt.vo;

public class UserVO {
	private String user_id;
	private String user_pw;
	private String user_pw2;
	private String user_name;
	private String user_nickname;
	private String user_tel;
	private int user_point;
	
	private String pw_check2;	
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_pw2() {
		return user_pw2;
	}
	public void setUser_pw2(String user_pw2) {
		this.user_pw2 = user_pw2;
	}	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_tel() {
		return user_tel;
	}
	public void setUser_tel(String user_tel) {
		this.user_tel = user_tel;
	}
	public String getPw_check2() {
		return pw_check2;
	}
	public void setPw_check2(String pw_check2) {
		this.pw_check2 = pw_check2;
	}
	public int getUser_point() {
		return user_point;
	}
	public void setUser_point(int user_point) {
		this.user_point = user_point;
	}
	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
//		result = prime * result + ((user_name == null) ? 0 : user_name.hashCode());
//		result = prime * result + ((user_nickname == null) ? 0 : user_nickname.hashCode());
//		result = prime * result + ((user_pw == null) ? 0 : user_pw.hashCode());
//		result = prime * result + ((user_tel == null) ? 0 : user_tel.hashCode());
//		return result;
//	}
}
