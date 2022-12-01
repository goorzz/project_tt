package edu.mit.c301.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.mit.c301.dao.UserrDAO;
import edu.mit.c301.vo.NewsVO;
import edu.mit.c301.vo.ScheduleVO;
import edu.mit.c301.vo.UserrVO;


@Service("userrService")
public class UserrServiceImpl implements UserrService {
	
	@Resource(name="userrDAO")
    private UserrDAO userrDAO;
	
	
	@Override
	public List<UserrVO> selectUser() throws Exception {
		return userrDAO.userrVO();
	}

	@Override
	public List<UserrVO> selectUserA(String alpha) throws Exception {
		return userrDAO.a(alpha);
	}


	@Override
	public List<NewsVO> selectUsernews() throws Exception {
		return userrDAO.allnews();
	}

	@Override
	public List<ScheduleVO> selectUserSchedule(String month1, String alpha1) throws Exception {
		if(alpha1.equals("없어")) {
			SimpleDateFormat date = new SimpleDateFormat("d"); // 날짜 부분  dd=03일 04일   MM = 월 / mm = 분 
			Calendar c1 = Calendar.getInstance();
			String today=date.format(c1.getTime());
			alpha1=today;
		}
		if(month1.equals("없어")) {
			SimpleDateFormat date = new SimpleDateFormat("M"); // 날짜 부분  dd=03일 04일   MM = 월 / mm = 분 
			Calendar c1 = Calendar.getInstance();
			String today=date.format(c1.getTime());
			month1=today;
		}

		
		return userrDAO.allSchedule(month1,alpha1);
	}
	
}


