package edu.mit.c301.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.mit.c301.vo.NewsVO;
import edu.mit.c301.vo.ScheduleVO;
import edu.mit.c301.vo.UserrVO;


public interface UserrDAO {
	List<UserrVO> userrVO();
	
	

	List<UserrVO> a(String alpha);

	
	List<NewsVO> allnews();
	
	List<ScheduleVO> allSchedule(@Param("month1") String month1,@Param("alpha1") String alpha1);
	List<ScheduleVO> allSchedule1(String alpha2);

}