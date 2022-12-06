package project.tt.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String main(Model model) {
		return "/main";
	}
	@RequestMapping("/main")
	public void main2(Model model) {

	}
}
