package project.tt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.ScheduleVO;
import project.tt.vo.UserVO;


public interface UserDAO {

	//목록가져오기
	/* @Select("select * from tbl_board") */
	public List<UserVO> getUser();
	
	void register(UserVO vo);
//	아이디/닉네임 정보 가져오기
	UserVO idCheck(String id);
	UserVO nicknameCheck(String nickname);
	UserVO telCheck(String tel);
	UserVO nameCheck(String name);	
//	아이디/비밀번호 찾기
	UserVO idSearch(UserVO vo);
	UserVO pwSearch(UserVO vo);
//	로그인
	public UserVO loginidpw(UserVO vo);
	
	public UserVO pw(UserVO uservo);//비밀번호 확인
	int modify(UserVO uservo);//회원 수정
	int delete(UserVO uservo);//회원 탈퇴
	
	List<GroupVO> userrVO();
	
	List<GroupVO> a(String alpha);
	
	List<NewsVO> allnews();
	
	List<ScheduleVO> allSchedule(@Param("month1") String month1,@Param("alpha1") String alpha1);
	List<ScheduleVO> allSchedule1(String alpha2);
	
}
