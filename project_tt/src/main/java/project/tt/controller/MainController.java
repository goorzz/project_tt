package project.tt.controller;


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
	public String main(Model model) throws Exception {
		
		String month1="없어";
		String day1="없어";

        List<GroupVO> userList = service.selectUser();
        List<NewsVO> userList1 = service.selectUsernews();
        List<ScheduleVO> userList2 = service.selectUserSchedule(month1,day1);
        
  
        for (ScheduleVO temp : userList2) {
        		}
        model.addAttribute("userrList", userList);
        model.addAttribute("newsList", userList1);
        model.addAttribute("schedulelist", userList2);
        
        return "main";

	}
	@GetMapping("/a") //a조 화면 열기
	public String a_class(String month1, ScheduleVO vo,GroupVO voo,  Model model) throws Exception {  
		
	
		List<GroupVO> userList = service.selectUserA(voo.getR_group());
        List<NewsVO> userList1 = service.selectUsernews();
        List<ScheduleVO> userList2 = service.selectUserSchedule(month1, vo.getDate());
        

        for (NewsVO temp : userList1) {
        	
        		}
	    model.addAttribute("group", voo.getR_group());
        model.addAttribute("date", vo.getDate());
        model.addAttribute("userrList", userList);
        model.addAttribute("newsList", userList1);
        model.addAttribute("schedulelist", userList2);
        model.addAttribute("month1", month1);
		return "main";
}
 
	@GetMapping("/gametime") //경기일정 날짜별 화면 열기 
	public String b_class(String month1, ScheduleVO vo, GroupVO voo,  Model model) throws Exception {  
		
		
		List<GroupVO> userList = service.selectUserA(voo.getR_group());
        List<NewsVO> userList1 = service.selectUsernews();
	    List<ScheduleVO> userList2 = service.selectUserSchedule(month1, vo.getDate());
//	    List<ScheduleVO> userList3 = service.selectUserSchedule1(vo.getDate());
	    
	    for (ScheduleVO temp : userList2) {
    		}
//	    for (ScheduleVO temp : userList3) {
//    		logger.info(temp.toString());
//    		}
	    model.addAttribute("group", voo.getR_group());
        model.addAttribute("date", vo.getDate());
	    model.addAttribute("userrList", userList);
        model.addAttribute("newsList", userList1);
	    model.addAttribute("schedulelist", userList2);
//	    model.addAttribute("schedulelist1", userList3);
		return "main";
		
}
	@RequestMapping("/main")
	public void main2(Model model) {

	}
}
