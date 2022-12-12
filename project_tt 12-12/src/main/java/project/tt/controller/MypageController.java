package project.tt.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import project.tt.dao.Criteria;
import project.tt.dao.PageDTO;
import project.tt.service.BoardService;
import project.tt.service.ReplyService;
import project.tt.service.UserService;
import project.tt.vo.BoardVO;
import project.tt.vo.UserVO;

@RequestMapping("/mypage")
@Controller
@AllArgsConstructor
public class MypageController {
	
	private UserService service;
	private BoardService service_b;
	
	@GetMapping("/mypagentry")//비밀번호 재인증
	void mypagentry() {  
		 
	}
	    
	@PostMapping("/mypagentry")//비밀번호 재인증
	public String pw(UserVO uservo) {
		UserVO user = service.pw(uservo);
		if(user!=null) {    		
			return "redirect:mypage";	    		
		}else {			
			return "redirect:mypagentry";
		}
    }
	
	@RequestMapping("/mypage")
	void mypage() {   
		 
	}
	
	@GetMapping("/mypage_modify")//수정
	void mypage_modify() {   
		 
	}
	 
	@PostMapping("/mypage_modify")//수정
	String mypage_modify1(UserVO uservo,HttpSession session) {
		service.modify(uservo);  
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping("/mypage_info")// 내 게시글 목록
	void mypage_info(UserVO uvo,Model model) {  

		model.addAttribute("Mypage_board_list",service_b.mypage_board(uvo.getUser_nickname()));
	}		 
	
	@RequestMapping("/mypage_point")// 포인트획득 현황
	void mypage_point(UserVO uvo,Model model,Criteria cri) { 
		cri.set_skip();
		System.out.println(cri.getUser_id());
		System.out.println(cri.getSkip());
		System.out.println(cri.getAmount());
		model.addAttribute("list",service.pointPaging(cri));
		int total = service.getTotal(cri);
		
		PageDTO  pagebar = new PageDTO(cri, total);
		model.addAttribute("pagebar", pagebar);
		model.addAttribute("name",cri.getUser_id());
		
		model.addAttribute("point",service.getPoint(cri.getUser_id()));
//		model.addAttribute("point",service.getPoint(uvo.getUser_id()));
//		model.addAttribute("point_list",service.getPoint_list(uvo.getUser_id()));
	} 
	  
	@RequestMapping("/deletem")//탈퇴
	String deletem1(UserVO uvo,HttpSession session) {
		service.delete(uvo);
		service.delete_point(uvo.getUser_id());
		session.removeAttribute("user");
		return "redirect:/";
	}

}
