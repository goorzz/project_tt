package project.tt.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import project.tt.dao.Criteria;
import project.tt.dao.PageDTO;
import project.tt.service.BoardService;
import project.tt.service.ReplyService;
import project.tt.service.UserService;
import project.tt.vo.BoardVO;
import project.tt.vo.PointVO;
import project.tt.vo.ReplyVO;
import project.tt.vo.UserVO;

@RequestMapping("/board")
@Controller
@RequiredArgsConstructor
public class BoardController {
	
	@NonNull
	private BoardService service;
	@NonNull
	private ReplyService reply_service;
	@NonNull
	private UserService point_service; 	
	
    LocalDate now = LocalDate.now();   // 현재 날짜 구하기
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");   // 포맷 정의
    String today = now.format(format); // 포맷 적용 
	
	@GetMapping("/list") //게시글 목록보기 /list.jsp
	public void List(Model model ,Criteria cri) {
		if(cri.getPageNum()==0) {
			cri.setPageNum(1);
		}
		model.addAttribute("pageNum",cri.getPageNum());
		model.addAttribute("amount",cri.getAmount());
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
	public String good(int bno,Criteria cri, UserVO uvo ,Model model) {
		if(uvo.getUser_id()=="") {
			return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
		}else {
		service.good(bno);
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
		}
	}
	//싫어요
	@GetMapping("/bad")
		public String bad(int bno,Criteria cri,UserVO uvo) {
		if(uvo.getUser_id()=="") {
			return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
		}else{
		service.bad(bno);
		return "redirect:/board/list?pageNum="+cri.getPageNum()+"&amount="+cri.getAmount();
		}
	}
	
	@PostMapping("/register") //등록 처리후 자동으로 목록보기 보여주기
	public String register(BoardVO boardVO, RedirectAttributes rttr,UserVO uvo ,Model model, PointVO pvo) {
		if(point_service.write_check(pvo.getUser_id(), today).size()<3) {
			point_service.point_write(pvo.getUser_id());
			point_service.insertPoint_list(pvo);
			service.register(boardVO);
			rttr.addFlashAttribute("bno",boardVO.getBno());
			model.addAttribute("Mypage",service.mypage_board(uvo.getUser_nickname()));
			return"redirect:/board/list"; 
		}else {
			service.register(boardVO);
			rttr.addFlashAttribute("bno",boardVO.getBno());
			model.addAttribute("Mypage",service.mypage_board(uvo.getUser_nickname()));
			return"redirect:/board/list"; 			
		}
	}
	@PostMapping("/remove")
	public String remove(int bno ,RedirectAttributes rttr,BoardVO boardVO ) {
	
	service.remove(bno);
	
	rttr.addFlashAttribute("removeis", service.remove(bno));
	return "redirect:/board/list?bno="+boardVO.getBno();
	
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
		return "redirect:/board/list?bno="+boardVO.getBno();
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
	}
	
	
	//댓글 등록하기
	@PostMapping("/get")
	public String reply_register(ReplyVO replyVO ,RedirectAttributes rttr,UserVO uvo ,Model model, PointVO pvo) {
		if(point_service.reply_check(pvo.getUser_id(), today).size()<5) {
			point_service.point_reply(pvo.getUser_id());
			point_service.insertPoint_list(pvo);
			model.addAttribute("Mypage",service.mypage_board(uvo.getUser_nickname()));
			reply_service.reply_register(replyVO);
			rttr.addFlashAttribute("reply",replyVO.getBno());
			return"redirect:/board/get?bno="+replyVO.getBno();
		}else {
			model.addAttribute("Mypage",service.mypage_board(uvo.getUser_nickname()));
			reply_service.reply_register(replyVO);
			rttr.addFlashAttribute("reply",replyVO.getBno());
			return"redirect:/board/get?bno="+replyVO.getBno();			
		}				
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

