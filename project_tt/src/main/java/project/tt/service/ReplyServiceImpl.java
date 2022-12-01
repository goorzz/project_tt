package project.tt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import project.tt.dao.BoardDAO;
import project.tt.dao.ReplyDAO;
import project.tt.vo.ReplyVO;
@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
//	@Autowired
	private ReplyDAO mapper;
	
	//댓글 리스트
	@Override
	public List<ReplyVO> Reply_List(int bno) {
		return mapper.reply_List(bno);
	}
	
	//댓글 등록하기 
	@Override
	public void reply_register(ReplyVO replyVO) {
		log.info("등록하기");
		mapper.reply_register(replyVO);
	}
	
	//댓글 삭제
	@Override
	public void reply_delete(int rno) {
		log.info("댓글 삭제");
		mapper.reply_delete(rno);
	}

	@Override
	public void reply_modify(ReplyVO replyVO) {
		mapper.reply_modify(replyVO);
		
	}
	
	
	
	
	
	

}
