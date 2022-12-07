package project.tt.service;

import java.util.List;

import project.tt.vo.ReplyVO;


public interface ReplyService {
	
	//댓글 조회리스트
	List<ReplyVO>Reply_List(int bno);
	//댓글 등록하기
	void reply_register(ReplyVO replyVO);
	//댓글 삭제
	void reply_delete(int rno);
	//댓글 수정
	void reply_modify(ReplyVO replyVO);
}
