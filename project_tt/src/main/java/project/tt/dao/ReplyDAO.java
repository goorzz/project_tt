package project.tt.dao;

import java.util.List;

import project.tt.vo.ReplyVO;


public interface ReplyDAO {
	
	// 댓글 조회 리스트
	public List<ReplyVO> reply_List(int bno);
	
	// 댓글 등록하기
	public void reply_register(ReplyVO replyVO);
	// 댓글 수정
	public void reply_modify(ReplyVO replyVO);
	
	//댓글 삭제
	public void reply_delete(int rno);
}
