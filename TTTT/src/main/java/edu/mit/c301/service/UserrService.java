package edu.mit.c301.service;

import java.util.List;

import edu.mit.c301.vo.NewsVO;
import edu.mit.c301.vo.ScheduleVO;
import edu.mit.c301.vo.UserrVO;

public interface UserrService {
	
	//조별리그 쿼리 list
    public List<UserrVO> selectUser() throws Exception;
    public List<UserrVO> selectUserA(String alpha) throws Exception;

	
	
	//news 쿼리 list
	public List<NewsVO> selectUsernews() throws Exception;
	
	
	//Schedule 쿼리 list
	public List<ScheduleVO> selectUserSchedule(String month1, String alpha1) throws Exception;


}
