package project.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.tt.service.UserService;
import project.tt.vo.PointVO;
import project.tt.vo.ScheduleVO;
import project.tt.vo.TotoVO;


@RequestMapping("/toto")
@Controller
public class TotoController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/t_main") //게시글 목록보기 /list.jsp
	public String tmain(TotoVO tvo,Model model) {
		if(tvo.getUser_id()=="") {
			model.addAttribute("loginx","로그인이 필요한 서비스입니다.");
			model.addAttribute("url","/");
			return "/alert_login";
		}else {
			model.addAttribute("date",tvo.getDate());
			model.addAttribute("predict_w",tvo.getPredict_w());
			model.addAttribute("name_1",tvo.getName_1());
			model.addAttribute("schedule_date16", service.getSchedule_date16());
	        model.addAttribute("schedule_predict16",service.getSchedule_predict16(tvo.getDate()));
	        model.addAttribute("match16",service.getMatch16(tvo));
	        return "/toto/t_main";
		}
	}
	
	@RequestMapping("/t_batting") //게시글 목록보기 /list.jsp
	public String t_batting(TotoVO tvo,Model model) {
			model.addAttribute("date",tvo.getDate());
			model.addAttribute("predict_w",tvo.getPredict_w());
			model.addAttribute("name_1",tvo.getName_1());
			model.addAttribute("schedule_date16", service.getSchedule_date16());
	        model.addAttribute("schedule_predict16",service.getSchedule_predict16(tvo.getDate()));
	        model.addAttribute("match16",service.getMatch16(tvo));
	        return "/toto/t_batting";	
	}
	@RequestMapping("/t_check")
	public void t_check(TotoVO tvo,Model model) {
		model.addAttribute("date",tvo.getDate());
		model.addAttribute("predict_w",tvo.getPredict_w());
		model.addAttribute("name_1",tvo.getName_1());
		model.addAttribute("match16",service.getMatch16(tvo));
		
	}
	@RequestMapping("/t_bat")
	public String t_bat(TotoVO tvo,Model model) {
		if(service.getPoint(tvo.getUser_id())<500) {
			model.addAttribute("pointx","보유 포인트가 부족합니다.");
			model.addAttribute("url","/");
			return "/toto/t_alert";
		}else if(service.toto_check(tvo).size()>0) {
			model.addAttribute("overlap","이미 배팅하신 경기입니다.");
			model.addAttribute("url","/");
			return "/toto/t_alert2";
		}else {
			service.point_toto(tvo.getUser_id());
			service.insertPoint_list(tvo);
			service.insertToto_list(tvo);
			return "redirect:/";
		}
	}
	@RequestMapping("/t_mytoto")
	public void t_mytoto(TotoVO tvo,Model model) {
		model.addAttribute("toto_list",service.getToto_list(tvo.getUser_id()));
		
	}
}