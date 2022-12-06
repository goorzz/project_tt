package com.mit.c301;

import java.util.List;

import org.junit.Test;

import com.mit.c301.domain.Criteria;
import com.mit.c301.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;



@Log4j
public class BoardMapperTests {
	
	private BoardMapper mapper1;
	// 게시판 목록(페이징 적용하기) 테스트
	
	
	@Test
	public void testgetlistpaging() {
		
		Criteria cri =new Criteria();
		List list= mapper1.boardPaging(cri);
		list.forEach(board -> log.info(""+board));
		
	}

	
}
