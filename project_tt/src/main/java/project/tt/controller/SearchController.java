package project.tt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import project.tt.service.UserService;
import project.tt.vo.UserVO;

@Controller
public class SearchController {

	@Autowired
	private UserService service;
	
	@RequestMapping("/searchID")
	public void searchID(Model model) {
		
	}	
	@RequestMapping("/searchPW")
	public void searchPW(Model model) {
		
	}	
	@RequestMapping("/showID")
	public String showID(Model model, UserVO vo, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if(vo.getUser_name()=="") {
			writer.println("<script>alert('이름을 입력해주세요.'); </script>");
			writer.flush();
			return "searchID";
		}else if(vo.getUser_tel()=="") {
			writer.println("<script>alert('전화번호를 입력해주세요.'); </script>");
			writer.flush();
			return "searchID";
		}else if(service.idSearch(vo)==null) {

			return "searchID";
		}else {	
			model.addAttribute("id",service.idSearch(vo).getUser_id());
			return "/showID";
		}
	}	
	@RequestMapping("/showPW")
	public String showPW(Model model, UserVO vo, HttpServletResponse response) throws IOException {
		PrintWriter writer = response.getWriter();
		if(vo.getUser_id()=="") {
			writer.println("<script>alert('ID를 입력해주세요.'); </script>");
			writer.flush();
			return "searchPW";
		}else if(vo.getUser_tel()=="") {
			writer.println("<script>alert('전화번호를 입력해주세요.'); </script>");
			writer.flush();
			return "searchPW";
		}else if(service.pwSearch(vo)==null) {
			
			return "searchPW";
		}else {	
			model.addAttribute("pw",service.pwSearch(vo).getUser_pw());
			return "showPW";
		}	
	}	
}
