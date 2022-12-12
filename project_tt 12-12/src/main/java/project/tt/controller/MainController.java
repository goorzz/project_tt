package project.tt.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import project.tt.service.BoardService;
import project.tt.service.ReplyService;
import project.tt.service.UserService;
import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.PointVO;
import project.tt.vo.ScheduleVO;
import project.tt.vo.UserVO;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	@NonNull
	private UserService service;
	
	String user_id;
	String group;
	
    LocalDate now = LocalDate.now();   // 현재 날짜 구하기
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM월d일");   // 포맷 정의
    String today = now.format(format);         // 포맷 적용
	
	@RequestMapping("/")
	public String main(GroupVO gvo, Model model,@RequestParam(value="user_id", required=false) String user_id,HttpSession session)  {
		
		ArrayList<String> grouplist = new ArrayList<>(Arrays.asList("A조","B조","C조","D조","E조","F조","G조","H조"));
		if(!(user_id==null)) {
			this.user_id=user_id;
		}else {
			this.user_id=this.user_id;
		}
		if(!(gvo.getR_group()==null)) {
			this.group=gvo.getR_group();	
		}else {
			this.group="A조";
		}
        LocalDate now = LocalDate.now();   // 현재 날짜 구하기
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM월d일");   // 포맷 정의
        String today = now.format(format);         // 포맷 적용

        model.addAttribute("g_list", grouplist);
        model.addAttribute("group", service.getGroup(group));
        model.addAttribute("schedule", service.getSchedule(today));
        model.addAttribute("s_date", today);
        model.addAttribute("news", service.getNews());
        model.addAttribute("point",service.getPoint(this.user_id));

        return "main";
	}
	
	@RequestMapping("/schedule") //더보기 화면
	public String schedule(ScheduleVO svo, Model model) { 
		
		model.addAttribute("schedule_date", service.getSchedule_date());
        model.addAttribute("schedule2",service.getSchedule_name(svo.getName_1()));
        model.addAttribute("schedule",service.getSchedule(svo.getDate()));
		return "schedule";
	}
}
	
