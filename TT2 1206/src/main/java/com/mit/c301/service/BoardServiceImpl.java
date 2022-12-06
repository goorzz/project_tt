package com.mit.c301.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import com.mit.c301.domain.Criteria;
import com.mit.c301.domain.PageDTO;
import com.mit.c301.mapper.BoardMapper;
import com.mit.c301.vo.BoardVO;
import com.mit.c301.vo.CountVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
@Service
@Log4j
@AllArgsConstructor //생성자주입
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper1;

	@Override
	public List<BoardVO> getList() {
		log.info("리스트요청....");
		return mapper1.getList();	 
	}

	

	@Override
	public void register(BoardVO boardVO) {
		mapper1.InsertSelectKey(boardVO);
	}

	@Override
	public  boolean remove(int bno) {
		return mapper1.delete(bno)==1;
	}

	@Override
	public boolean modify(BoardVO boardVO) {
		log.info("글수정");
		return mapper1.update(boardVO)==1;
	}
	@Override
	public int bad(int bno) {//싫어요
		return mapper1.bad(bno);
	}

	@Override
	public int good(int bno) {// 좋아요
		return mapper1.good(bno);
	}
	//상세보기
	@Override
	public BoardVO get(int bno) {//상세보기
		
		return mapper1.read(bno);
	}
	
	//조회수
	@Override
	public int view_count(int bno) { // 조회수 
		log.info("조회수 증가");
		return mapper1.view_count(bno);
	}

	@Override
	public int getTotal(Criteria cri) { // 게시물 총갯수
		return mapper1.getTotal(cri);
	}

	@Override
	public List<BoardVO> boardPaging(Criteria cri) {
		return mapper1.boardPaging(cri);
	}

	//마이페이지 리스트
	@Override
	public List<BoardVO> mypage_board(String user_nickname) {
		return mapper1.mypage_board(user_nickname);
	}




	



}
