package project.tt.controller;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import project.tt.service.UserService;
import project.tt.vo.GroupVO;
import project.tt.vo.NewsVO;
import project.tt.vo.ScheduleVO;

@Controller
public class MainController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping("/")
	public String main(Model model)  {
	
		ArrayList<String> grouplist = new ArrayList<>(Arrays.asList("A조","B조","C조","D조","E조","F조","G조","H조"));
      
        LocalDate now = LocalDate.now();   // 현재 날짜 구하기
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM월d일");   // 포맷 정의
        String today = now.format(format);         // 포맷 적용

        model.addAttribute("g_list", grouplist);
        model.addAttribute("group", service.getGroup_main());
        model.addAttribute("schedule", service.getSchedule(today));
        model.addAttribute("s_date", service.getSchedule(today).get(0).getDate());
        model.addAttribute("news", service.getNews());
 
        return "main";
	}
	
	@RequestMapping("/group") //a조 화면 열기
	public String group(GroupVO gvo, Model model) {  

		ArrayList<String> grouplist = new ArrayList<>(Arrays.asList("A조","B조","C조","D조","E조","F조","G조","H조"));
		
        LocalDate now = LocalDate.now();   // 현재 날짜 구하기
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM월d일");   // 포맷 정의
        String today = now.format(format);         // 포맷 적용
		
        model.addAttribute("g_list", grouplist);
        model.addAttribute("group", service.getGroup(gvo.getR_group()));
        model.addAttribute("schedule", service.getSchedule(today));
        model.addAttribute("s_date", service.getSchedule(today).get(0).getDate());
        model.addAttribute("news", service.getNews());
        
		return "main";
}
	
//	@GetMapping("/schedule") //경기일정 날짜별 화면 열기 
//	public String b_class(ScheduleVO svo, Model model) {  
//			
////		List<GroupVO> userList = service.selectUserA(voo.getR_group());
////        List<NewsVO> userList1 = service.selectUsernews();
////	    List<ScheduleVO> userList2 = service.selectUserSchedule(month1, vo.getDate());
////	    List<ScheduleVO> userList3 = service.selectUserSchedule1(vo.getDate());
//	    
////	    for (ScheduleVO temp : userList2) {
////    		}
////	    for (ScheduleVO temp : userList3) {
////    		logger.info(temp.toString());
////    		}
////	    model.addAttribute("group", voo.getR_group());
////        model.addAttribute("date", vo.getDate());
////	    model.addAttribute("userrList", userList);
////        model.addAttribute("newsList", userList1);
////	    model.addAttribute("schedulelist", userList2);
////	    model.addAttribute("schedulelist1", userList3);
//		return "main";	
//	}
	@RequestMapping("/schedule") //a조 화면 열기
	public String schedule(ScheduleVO svo, Model model) { 
		
		model.addAttribute("schedule_date", service.getSchedule_date());
        model.addAttribute("schedule", service.getSchedule(svo.getDate()));
//        model.addAttribute(attributeValue)
		return "schedule";
	}
}
	
