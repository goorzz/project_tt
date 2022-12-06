package com.mit.c301.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mit.c301.domain.Criteria;
import com.mit.c301.domain.PageDTO;
import com.mit.c301.service.BoardService;
import com.mit.c301.service.ReplyService;
import com.mit.c301.vo.BoardVO;
import com.mit.c301.vo.CountVO;
import com.mit.c301.vo.ReplyVO;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j; 

@RequestMapping("/board")
@Controller
@AllArgsConstructor
@Log4j
public class BoardController {
	

	private BoardService service;
	private ReplyService reply_service;	
	@GetMapping("/list") //게시글 목록보기 /list.jsp
	public void List(Model model ,Criteria cri) {
		if(cri.getPageNum()==0) {
			cri.setPageNum(1);
		}
	
		cri.set_skip();
		model.addAttribute("list",service.boardPaging(cri));
		int total = service.getTotal(cri);
		PageDTO  pagebar1 = new PageDTO(cri, total);
		model.addAttribute("pagebar", pagebar1);
	
		if(cri.getPageNum()>pagebar1.getEndPage()) {
			cri.setPageNum(pagebar1.getEndPage());
		}
	
	}
	
	
	@GetMapping("/register")//글등록 화면열기
	public void register() {
	
	}
	//좋아요
	@GetMapping("/good")
	public String good(int bno) {	
	service.good(bno);
	return"redirect:/board/list";
	
	}
	//싫어요
	@GetMapping("/bad")
	public String bad(int bno) {
	service.bad(bno);
	return"redirect:/board/list"; 
	}
	
	@PostMapping("/register") //등록 처리후 자동으로 목록보기 보여주기
	public String register(BoardVO boardVO, RedirectAttributes rttr) {
	service.register(boardVO);
	rttr.addFlashAttribute("bno",boardVO.getBno());
	return"redirect:/board/list"; 
	}
	
	@PostMapping("/remove")
	public String remove(int bno ,RedirectAttributes rttr) {
	
	service.remove(bno);
	rttr.addFlashAttribute("removeis", service.remove(bno));
	return"redirect:/board/list";
	
	}
	// 수정화면 요청(수정버튼을 누르면)
	@GetMapping("/modify")
		public void modify(int bno, Model model) {
		model.addAttribute("board", service.get(bno));
	}
	//글 수정
	@PostMapping("/modify")
	public String modify(BoardVO boardVO,RedirectAttributes rttr) {
		rttr.addFlashAttribute("modifyis", service.modify(boardVO));
		return"redirect:/board/list";
	}
	
	@GetMapping("/get") //글 상세보기 -> /board/get.jsp 
	public void get(int bno,Model model ,ReplyVO replyVO) {
		
		service.view_count(bno);
		model.addAttribute("board",service.get(bno));
		model.addAttribute("replylist",reply_service.Reply_List(bno));
	
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
	    String nowTime1 = format.format(now);
		model.addAttribute("datenow",nowTime1);
		System.out.println(nowTime1);
	}
	
	
	//댓글 등록하기
	@PostMapping("/get")
	public String reply_register(ReplyVO replyVO ,RedirectAttributes rttr) {
		
		reply_service.reply_register(replyVO);
		rttr.addFlashAttribute("reply",replyVO.getBno());
		return"redirect:/board/get?bno="+replyVO.getBno();
					
	}
	//댓글 삭제
	@PostMapping("/reply_delete")
	public String reply_delete(ReplyVO replyVO) {
		reply_service.reply_delete(replyVO.getRno());
		return"redirect:/board/get?bno="+replyVO.getBno();
	}
	//댓글 수정
	@PostMapping("/reply_modify")
	public String reply_modify(ReplyVO replyVO) {
		reply_service.reply_modify(replyVO);
		return"redirect:/board/get?bno="+replyVO.getBno();
	}
	@GetMapping("/test")
	public String test1(BoardVO boardVO ,Model model) {
		
		boardVO.setRno(boardVO.getRno());
		boardVO.setTitle(boardVO.getTitle());
		boardVO.setUser_nickname(boardVO.getUser_nickname());
		boardVO.setView_count(boardVO.getView_count());

		model.addAttribute("Mypage_board_list",service.mypage_board(boardVO.getUser_nickname()));
		return"board/test";
	}
	@PostMapping("/test")
	public String test2(BoardVO boardVO ,Model model) {
		System.out.println(service.mypage_board(boardVO.getUser_nickname()));
		model.addAttribute("Mypage_board_list",service.mypage_board(boardVO.getUser_nickname()));
		model.addAttribute("test","1");
		return"board/test1";
	}
	
}
