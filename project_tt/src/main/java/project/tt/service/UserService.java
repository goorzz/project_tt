package project.tt.service;

import java.util.List;

import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
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

}
