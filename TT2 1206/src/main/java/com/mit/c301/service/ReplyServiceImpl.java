package com.mit.c301.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mit.c301.mapper.ReplyMapper;
import com.mit.c301.vo.ReplyVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service
@AllArgsConstructor
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper mapper;
	
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
