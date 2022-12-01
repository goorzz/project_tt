package edu.mit.c301.db.ctr;
 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
 
import javax.annotation.Resource;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mit.c301.dao.UserrDAO;
import edu.mit.c301.service.UserrService;
import edu.mit.c301.vo.NewsVO;
import edu.mit.c301.vo.ScheduleVO;
import edu.mit.c301.vo.UserrVO;
 

@Controller
public class UserrController{
     
private static final Logger logger =  LoggerFactory.getLogger(UserrController.class);
    	

    @Resource(name="userrService")
    private UserrService service;
    
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) throws Exception{
    	
    		String month1="없어";
    		String day1="없어";
			
  
	        logger.info("main");
	        List<UserrVO> userList = service.selectUser();
	        List<NewsVO> userList1 = service.selectUsernews();
	        List<ScheduleVO> userList2 = service.selectUserSchedule(month1,day1);
	        
	  
	        for (ScheduleVO temp : userList2) {
	        		logger.info(temp.toString());
	        		}
	        model.addAttribute("userrList", userList);
	        model.addAttribute("newsList", userList1);
	        model.addAttribute("schedulelist", userList2);
	        
	        return "main";
    }
    
    

    
	@GetMapping("/a") //a조 화면 열기
	public String a_class(String month1, ScheduleVO vo,UserrVO voo,  Model model) throws Exception {  
		
		logger.info(voo.getR_group());
		List<UserrVO> userList = service.selectUserA(voo.getR_group());
        List<NewsVO> userList1 = service.selectUsernews();
        List<ScheduleVO> userList2 = service.selectUserSchedule(month1, vo.getDate());
        

        for (NewsVO temp : userList1) {
        		logger.info(temp.toString());
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
	public String b_class(String month1, ScheduleVO vo, UserrVO voo,  Model model) throws Exception {  
		
		
		List<UserrVO> userList = service.selectUserA(voo.getR_group());
        List<NewsVO> userList1 = service.selectUsernews();
	    List<ScheduleVO> userList2 = service.selectUserSchedule(month1, vo.getDate());
//	    List<ScheduleVO> userList3 = service.selectUserSchedule1(vo.getDate());
	    
	    for (ScheduleVO temp : userList2) {
    		logger.info(temp.toString());
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

	
	
}
 
