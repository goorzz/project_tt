package project.tt.service;

import java.util.List;

import project.tt.dao.Criteria;
import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.PointVO;
import project.tt.vo.ScheduleVO;
import project.tt.vo.UserVO;


public interface UserService {

	//글 목록보기
	List<UserVO> getUser();
	void register(UserVO vo);
	
	UserVO idCheck(UserVO vo);
	UserVO nicknameCheck(UserVO vo);
	UserVO nameCheck(UserVO vo);	
	UserVO telCheck(UserVO vo);

	
	UserVO idSearch(UserVO vo);
	UserVO pwSearch(UserVO vo);
	
	public UserVO loginidpw(UserVO vo);
	
	public UserVO pw(UserVO uservo);//비밀번호 확인
	public void modify(UserVO uservo);//회원 수정
	public void delete(UserVO uservo);//회원 탈퇴
	void delete_point(String user_id); // 탈퇴시 포인트내역삭제
	
	//조별리그 쿼리 list
    public List<GroupVO> getGroup_main();
    public List<GroupVO> getGroup(String group);
    
	
	//Schedule 쿼리 list
	List<ScheduleVO> getSchedule_date(); // 경기일정만 뽑아옴(중복제외)
	List<ScheduleVO> getSchedule(String date);
	List<ScheduleVO> getSchedule_name(String name_1);
	//승부예측용
	List<ScheduleVO> getSchedule_predict(String date);	
	List<ScheduleVO> getSchedule_predict2(String name_1);	
	List<ScheduleVO> getSchedule_predict3(String date);	
	List<ScheduleVO> getSchedule_predict4(String name_1);	
	//news 쿼리 list
	public List<NewsVO> getNews();
	//포인트용
	void point_join(String user_id);
	void point_login(String user_id);
	List<PointVO> login_check(String user_id, String date);
	void point_write(String user_id);
	List<PointVO> write_check(String user_id, String date);
	void point_reply(String user_id);
	List<PointVO> reply_check(String user_id, String date);
	List<PointVO> getPoint_list(String user_id);
	void insertPoint_list(PointVO pvo);
	UserVO getPoint(String user_id);
	
	int getTotal(Criteria cri);
	List<PointVO> pointPaging(Criteria cri);
}
