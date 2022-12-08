package project.tt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.PointVO;
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
	void delete_point(String user_id); // 탈퇴시 포인트내역삭제
	
	//조별 경기 가져오기
	List<GroupVO> getGroup_main();
	List<GroupVO> getGroup(String group);

	//월드컵뉴스 가져오기
	List<NewsVO> getNews();

	//월드컵 일정가져오기
	List<ScheduleVO> getSchedule(String date);
	List<ScheduleVO> getSchedule_date();
	List<ScheduleVO> getSchedule_name(String name_1);
	//예측결과 포함 일정
	List<ScheduleVO> getSchedule_predict(String date);
	List<ScheduleVO> getSchedule_predict2(String name_1);
	List<ScheduleVO> getSchedule_predict3(String date);
	List<ScheduleVO> getSchedule_predict4(String name_1);
	//포인트 관련
	void point_join(String user_id);
	void point_login(String user_id);
	List<PointVO> login_check(@Param("user_id") String user_id, @Param("date") String date);
	void point_write(String user_id);
	List<PointVO> write_check(@Param("user_id") String user_id, @Param("date") String date);
	void point_reply(String user_id);
	List<PointVO> reply_check(@Param("user_id") String user_id, @Param("date") String date);
	List<PointVO> getPoint_list(String user_id);
	void insertPoint_list(PointVO vo);
	UserVO getPoint(String user_id);
	
	int getTotal(Criteria cri);
	List<PointVO> pointPaging(Criteria cri);
}
