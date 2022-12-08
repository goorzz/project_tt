package project.tt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import project.tt.service.UserService;
import project.tt.vo.PointVO;
import project.tt.vo.UserVO;


@Controller
public class MembershipController {
	
	@Autowired
	private UserService service;
	
    LocalDate now = LocalDate.now();   // 현재 날짜 구하기
    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");   // 포맷 정의
    String today = now.format(format); // 포맷 적용 
	
	@RequestMapping("/membership")
	public void main(UserVO vo, Model model) {
		model.addAttribute("list",service.getUser());						
	}
	@RequestMapping("/register")
	public String membership(UserVO vo, PointVO pvo, Model model) throws IOException {
		if(vo.getUser_id() == "") {
			model.addAttribute("text","아이디를 입력해주세요.");
			return "membership";
		}else if(vo.getUser_pw() == "") {
			model.addAttribute("text","비밀번호를 입력해주세요.");
			return "membership";	
		}else if(vo.getUser_name() == "") {
			model.addAttribute("text","이름을 입력해주세요.");
			return "membership";
		}else if(vo.getUser_nickname() == "") {
			model.addAttribute("text","닉네임을 입력해주세요.");
			return "membership";
		}else if(vo.getUser_tel() == "") {
			model.addAttribute("text","전화번호를 입력해주세요.");
			return "membership";		
		}else if(service.idCheck(vo) != null) { //중복이면
			model.addAttribute("text","아이디 중복확인 주세요.");
			return "membership"; 
		}else if(service.nicknameCheck(vo) != null) {
			model.addAttribute("text","닉네임 중복확인해주세요.");
			return "membership";
		}else if(!vo.getPw_check2().equals("check")) {
			model.addAttribute("text","비밀번호를 확인해주세요.");
			return "membership";			
		}else {
			service.register(vo);
			service.point_join(pvo.getUser_id());
			service.insertPoint_list(pvo);	
			return "register";
		}		
	}	
	@RequestMapping("/idCheck")
	public String idCheck(UserVO vo, Model model) {
		if(service.idCheck(vo) == null) {
			model.addAttribute("id",vo.getUser_id());
			model.addAttribute("nN",vo.getUser_nickname());
			model.addAttribute("pw",vo.getUser_pw());
			model.addAttribute("pw2",vo.getUser_pw2());
			model.addAttribute("name",vo.getUser_name());
			model.addAttribute("tel",vo.getUser_tel());		
			model.addAttribute("pw_check2",vo.getPw_check2());			
			model.addAttribute("check","사용가능한 아이디입니다.");
		}else { 
			model.addAttribute("id","");
			model.addAttribute("nN",vo.getUser_nickname());	
			model.addAttribute("pw",vo.getUser_pw());
			model.addAttribute("pw2",vo.getUser_pw2());			
			model.addAttribute("name",vo.getUser_name());
			model.addAttribute("tel",vo.getUser_tel());	
			model.addAttribute("pw_check2",vo.getPw_check2());				
			model.addAttribute("check","이미 사용중인 아이디입니다.");
		}
		return "/membership";
	}		
	@RequestMapping("/nicknameCheck")
	public String nucknameCheck(UserVO vo, Model model) {
		if(service.nicknameCheck(vo) == null) { //중복X 
			model.addAttribute("id",vo.getUser_id());
			model.addAttribute("nN",vo.getUser_nickname());
			model.addAttribute("pw",vo.getUser_pw());
			model.addAttribute("pw2",vo.getUser_pw2());
			model.addAttribute("name",vo.getUser_name());
			model.addAttribute("tel",vo.getUser_tel());	
			model.addAttribute("pw_check2",vo.getPw_check2());				
			model.addAttribute("check2","사용가능한 닉네임입니다.");
			}else {
			model.addAttribute("nN","");
			model.addAttribute("pw",vo.getUser_pw());
			model.addAttribute("pw2",vo.getUser_pw2());			
			model.addAttribute("name",vo.getUser_name());	
			model.addAttribute("id",vo.getUser_id());
			model.addAttribute("tel",vo.getUser_tel());		
			model.addAttribute("pw_check2",vo.getPw_check2());				
			model.addAttribute("check2","이미 사용중인 닉네임입니다.");
		}		
		return "membership";
	}	
	@RequestMapping("/test")
	public String test(Model model, UserVO vo) {		
		model.addAttribute("pw_check","비밀번호확인 완료");
		model.addAttribute("pw_check2","check");
		model.addAttribute("id",vo.getUser_id());
		model.addAttribute("nN",vo.getUser_nickname());
		model.addAttribute("pw",vo.getUser_pw());
		model.addAttribute("pw2",vo.getUser_pw2());
		model.addAttribute("name",vo.getUser_name());	
		model.addAttribute("tel",vo.getUser_tel());		
		return "membership";
	}
	@RequestMapping("/test2")
	public String test2(Model model, UserVO vo) {		
		model.addAttribute("id",vo.getUser_id());
		model.addAttribute("nN",vo.getUser_nickname());
		model.addAttribute("name",vo.getUser_name());	
		model.addAttribute("tel",vo.getUser_tel());			
		return "membership";
	}
    
	@RequestMapping("/login") // 관우씨
	public String loginsueecess(PointVO pvo,UserVO vo,HttpSession session,Model model, RedirectAttributes re) {	
		re.addAttribute("user_id",vo.getUser_id());	
		UserVO user = service.loginidpw(vo);	
		if(user!=null) {
			session.setAttribute("user", user);	
			if(service.login_check(vo.getUser_id(), today).size()==0) {
				service.point_login(vo.getUser_id());
				service.insertPoint_list(pvo);
				return "redirect:/";
			}else {
				return "redirect:/";	
			}				
		}else {		
			return "redirect:/";
	    }
	}
	
	@GetMapping("/logout")
    public String logout(UserVO vo,HttpSession session) {
    	session.removeAttribute("user");
    	return"redirect:/";
    }
	

}	
	
