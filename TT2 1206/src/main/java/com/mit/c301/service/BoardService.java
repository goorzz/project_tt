package com.mit.c301.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mit.c301.domain.Criteria;
import com.mit.c301.domain.PageDTO;
import com.mit.c301.vo.BoardVO;
import com.mit.c301.vo.CountVO;

public interface BoardService {
		// 글목록보기 
		List<BoardVO> getList();
		// 글 상세보기
		BoardVO  get(int bno);
		// 글 등록
		void register(BoardVO boardVO);
		// 글 삭제
		boolean remove(int bno);
		// 글 수정
		boolean modify(BoardVO boardVO); //맵퍼만 요청하며된다
		//좋아요
		public int bad(int bno);
		//싫어요
		public int good(int bno);
		// 조회수 
		public int view_count(int bno);
		// 게시판 총 갯수
		public int getTotal(Criteria cri);
		// 게시판 페이징처리
		List<BoardVO> boardPaging(Criteria cri);
	
		//  마이페이지 게시판 
		List<BoardVO> mypage_board(String user_nickname);
		
		

		

}
