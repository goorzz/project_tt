package project.tt.service;

import java.util.List;

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
}