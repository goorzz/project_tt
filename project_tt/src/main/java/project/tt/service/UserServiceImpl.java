package project.tt.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import project.tt.dao.UserDAO;
import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.ScheduleVO;
import project.tt.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO dao;
	
	@Override
	public List<UserVO> getUser() {
		
		return dao.getUser();
	}

	@Override
	public void register(UserVO vo) {
		dao.register(vo);
		
	}

	@Override
	public UserVO idCheck(UserVO vo) {
	
		return dao.idCheck(vo.getUser_id());
	}

	@Override
	public UserVO nicknameCheck(UserVO vo) {
		
		return dao.nicknameCheck(vo.getUser_nickname());
	}
	@Override
	public UserVO nameCheck(UserVO vo) {
		
		return dao.nameCheck(vo.getUser_name());
	}	
	
	@Override
	public UserVO telCheck(UserVO vo) {
		
		return dao.telCheck(vo.getUser_tel());
	}	

	@Override
	public UserVO idSearch(UserVO vo) {
		
		return dao.idSearch(vo);
	}
	@Override
	public UserVO pwSearch(UserVO vo) {
		
		return dao.pwSearch(vo);
	}
	@Override
	public UserVO loginidpw(UserVO vo) {	
		return dao.loginidpw(vo);
		}
	
	@Override//수정
	public void modify(UserVO uservo) {
		dao.modify(uservo);
		
	}

	@Override//탈퇴
	public void delete(UserVO uservo) {
		dao.delete(uservo);
		
	}

	@Override//비밀번호 확인
	public UserVO pw(UserVO uservo) {		
		return dao.pw(uservo);
	}
	
	@Override // 그룹가져오기(메인)
	public List<GroupVO> getGroup_main() {
		return dao.getGroup_main();
	}
	@Override // 그룹가져오기(메인)
	public List<GroupVO> getGroup(String group) {
		return dao.getGroup(group);
	}

	
	@Override // 스케쥴가져오기(메인)
	public List<ScheduleVO> getSchedule_main() {
		return dao.getSchedule_main();
	}

	@Override // news가져오기
	public List<NewsVO> getNews() {
		return dao.getNews();
	}

//	@Override
//	public List<ScheduleVO> selectUserSchedule(String month1, String alpha1) throws Exception {
//		if(alpha1.equals("없어")) {
//			SimpleDateFormat date = new SimpleDateFormat("d"); // 날짜 부분  dd=03일 04일   MM = 월 / mm = 분 
//			Calendar c1 = Calendar.getInstance();
//			String today=date.format(c1.getTime());
//			alpha1=today;
//		}
//		if(month1.equals("없어")) {
//			SimpleDateFormat date = new SimpleDateFormat("M"); // 날짜 부분  dd=03일 04일   MM = 월 / mm = 분 
//			Calendar c1 = Calendar.getInstance();
//			String today=date.format(c1.getTime());
//			month1=today;
//		}
//
//		
//		return dao.allSchedule(month1,alpha1);
//	}
}
