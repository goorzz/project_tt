package com.mit.c301.mapper;

import java.util.List;

import com.mit.c301.domain.Criteria;
import com.mit.c301.domain.PageDTO;
import com.mit.c301.vo.BoardVO;
import com.mit.c301.vo.CountVO;



public interface BoardMapper {	
	//목록가져오기
	public List<BoardVO> getList();
	//게시판 타이틀 등록
	public BoardVO getTitle(BoardVO boardVO); 
	
	//글등록
	public void insert(BoardVO boardVO);//등록,수정,삭제는 int 리턴 타입시 처리된 행의 갯수
	
	//글 등록2- 등록글의 글번호를 알아온다.
	public void InsertSelectKey(BoardVO boardVO);
	
	//글 수정
	public int update(BoardVO boardVO);
	
	//글 삭제
	public int delete(int bno);
	
	//글 상세보기
	public BoardVO read(int bno);
	
	//좋아요 수
	public int good(int bno);
	
	//싫어요 수
	public int bad (int bno);
	
	// 조회수
	public int view_count(int bno);
	
	//페이지처리 
	public List<PageDTO> Criteria(Criteria cri);
	// 게시판 총갯수 
	public int getTotal(Criteria cri);
	
	//게시판 목록을 페이지 적용
	public List<BoardVO> boardPaging(Criteria cri);
	
	//마이페이지 내가쓴글 확인
	public List<BoardVO> mypage_board(String user_nickname);
	
}
