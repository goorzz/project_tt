package project.tt.dao;

import java.util.List;

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
}
