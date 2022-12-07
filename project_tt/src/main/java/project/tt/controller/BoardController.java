package project.tt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import project.tt.dao.BoardDAO;
import project.tt.dao.Criteria;
import project.tt.dao.PageDTO;
import project.tt.service.BoardService;
import project.tt.service.ReplyService;
import project.tt.vo.BoardVO;
import project.tt.vo.ReplyVO;
import project.tt.vo.UserVO;

@RequestMapping("/board")
@Controller
@AllArgsConstructor
public class BoardController {
	
//	@Autowired
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
	public String register(BoardVO boardVO, RedirectAttributes rttr,UserVO uvo ,Model model) {
	service.register(boardVO);
	rttr.addFlashAttribute("bno",boardVO.getBno());
	model.addAttribute("Mypage",service.mypage_board(uvo.getUser_nickname()));
	System.out.println(uvo.getUser_nickname());
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
	public String reply_register(ReplyVO replyVO ,RedirectAttributes rttr,UserVO uvo ,Model model) {
		model.addAttribute("Mypage",service.mypage_board(uvo.getUser_nickname()));
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
		
		
}

