package project.tt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.tt.dao.Criteria;
import project.tt.dao.UserDAO;
import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.PointVO;
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
	@Override//탈퇴시 포인트삭제
	public void delete_point(String user_id) {
		dao.delete_point(user_id);
		
	}

	@Override//비밀번호 확인
	public UserVO pw(UserVO uservo) {		
		return dao.pw(uservo);
	}
	
	@Override // 그룹가져오기(메인)
	public List<GroupVO> getGroup_main() {
		return dao.getGroup_main();
	}
	
	@Override // 그룹가져오기
	public List<GroupVO> getGroup(String group) {
		return dao.getGroup(group);
	}

	@Override // news가져오기
	public List<NewsVO> getNews() {
		return dao.getNews();
	}
	
	@Override // 스케쥴가져오기(메인)
	public List<ScheduleVO> getSchedule_date() {
		return dao.getSchedule_date();
	}
	
	@Override // 스케쥴가져오기
	public List<ScheduleVO> getSchedule(String date) {
		return dao.getSchedule(date);
	}
	
	@Override // 스케쥴가져오기
	public List<ScheduleVO> getSchedule_name(String name_1) {
		return dao.getSchedule_name(name_1);
	}
	
	@Override // 스케쥴가져오기(승부예측용)
	public List<ScheduleVO> getSchedule_predict(String date) {
		return dao.getSchedule_predict(date);
	}
	
	@Override // 스케쥴가져오기(승부예측용)
	public List<ScheduleVO> getSchedule_predict2(String name_1) {
		return dao.getSchedule_predict2(name_1);
	}
	
	@Override // 스케쥴가져오기(승부예측용)
	public List<ScheduleVO> getSchedule_predict3(String date) {
		return dao.getSchedule_predict3(date);
	}
	
	@Override // 스케쥴가져오기(승부예측용)
	public List<ScheduleVO> getSchedule_predict4(String name_1) {
		return dao.getSchedule_predict4(name_1);
	}
	//	포인트용
	@Override //회원가입
	public void point_join(String user_id) {
		dao.point_join(user_id);
	}
	@Override //로그인
	public void point_login(String user_id) {
		dao.point_login(user_id);
	}
	@Override
	public List<PointVO> login_check(String user_id, String date) {
		return dao.login_check(user_id, date);
	}
	@Override //글작성
	public void point_write(String user_id) {
		dao.point_write(user_id);
	}
	@Override
	public List<PointVO> write_check(String user_id, String date) {
		return dao.write_check(user_id, date);
	}
	@Override //댓글작성
	public void point_reply(String user_id) {
		dao.point_reply(user_id);
	}
	@Override
	public List<PointVO> reply_check(String user_id, String date) {
		return dao.reply_check(user_id, date);
	}
	@Override // 포인트 획득내역
	public List<PointVO> getPoint_list(String user_id) {
		return dao.getPoint_list(user_id);
	}
	@Override
	public void insertPoint_list(PointVO pvo) {
		dao.insertPoint_list(pvo);
	}
	@Override
	public UserVO getPoint(String user_id) {
		return dao.getPoint(user_id);
	}
	// 마이페이지(포인트)	
	@Override
	public int getTotal(Criteria cri) { // 게시물 총갯수
		return dao.getTotal(cri);
	}
	
	@Override
	public List<PointVO> pointPaging(Criteria cri) {
		return dao.pointPaging(cri);
	}

}
