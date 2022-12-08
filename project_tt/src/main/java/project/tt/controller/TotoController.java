package project.tt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.tt.service.UserService;
import project.tt.vo.ScheduleVO;


@RequestMapping("/toto")
@Controller
public class TotoController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/tmain") //게시글 목록보기 /list.jsp
	public void tmain(ScheduleVO svo,Model model) {
		System.out.println(svo.getDate());
		System.out.println(service.getSchedule_predict3(svo.getDate()));
		model.addAttribute("schedule_date", service.getSchedule_date());
		model.addAttribute("schedule_predict2",service.getSchedule_predict2(svo.getName_1()));
		model.addAttribute("schedule_predict4",service.getSchedule_predict4(svo.getName_1()));
        model.addAttribute("schedule_predict",service.getSchedule_predict(svo.getDate()));
        model.addAttribute("schedule_predict3",service.getSchedule_predict3(svo.getDate()));
	}
}