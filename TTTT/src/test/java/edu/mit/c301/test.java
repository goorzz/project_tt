package edu.mit.c301;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class test {

	public static void main(String[] args) {
		
    	SimpleDateFormat date = new SimpleDateFormat("M"); // 날짜 부분  dd=03일 04일   MM = 월 mm = 분
		Calendar c1 = Calendar.getInstance();
		String today=date.format(c1.getTime());
		String sum=today;
		
		
		System.out.println(sum);
		

	}

}
