<p><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
<title>월드컵 조별 순위</title>
<link rel="stylesheet" herf="src/main/webapp/resources/css/type07.css">
</head>
<body>
	<div class="table.type07"></div>
	<table>
    <h1>조별 순위 보기</h1>
    	<button class="a" type="button" onclick="location.href='/a?r_group=A&month1=${month1}&date=${date}'">A조</button>&nbsp;
    	<button class="b" type="button" onclick="location.href='/a?r_group=B&month1=${month1}&date=${date}'">B조</button>&nbsp;
    	<button class="c" type="button" onclick="location.href='/a?r_group=C&month1=${month1}&date=${date}'">C조</button>&nbsp;
    	<button class="d" type="button" onclick="location.href='/a?r_group=D&month1=${month1}&date=${date}'">D조</button>&nbsp;
    	<button class="e" type="button" onclick="location.href='/a?r_group=E&month1=${month1}&date=${date}'">E조</button>&nbsp;
    	<button class="f" type="button" onclick="location.href='/a?r_group=F&month1=${month1}&date=${date}'">F조</button>&nbsp;
    	<button class="g" type="button" onclick="location.href='/a?r_group=G&month1=${month1}&date=${date}'">G조</button>&nbsp;
    	<button class="h" type="button" onclick="location.href='/a?r_group=H&month1=${month1}&date=${date}'">H조</button>

        <thead>
            <tr>
					<td><center>그룹</center></td>
					<td><center>순위</center></td>
					<td><center>나라이름</center></td>
					<td><center>경기수</center></td>
					<td><center>승</center></td>
					<td><center>무</center></td>
					<td><center>패</center></td>
					<td><center>골득실</center></td>
					<td><center>승점</center></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userrList}" var="user">
                <tr>
           <!--     <td>${user.no}</td> --> 
                    <td><center>${user.r_group}</center></td>
                    <td><center>${user.r_rank}</center></td>
                    <td><center>${user.r_name}</center></td>
                    <td><center>${user.r_count}</center></td>
                    <td><center>${user.r_win}</center></td>
                    <td><center>${user.r_draw}</center></td>
                    <td><center>${user.r_lose}</center></td>
                    <td><center>${user.r_gain}</center></td>
                    <td><center>${user.r_wincount}</center></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
        <br>
        <!-- 					new기사 	                     -->
   		<table>
   			   <tbody>
				<tr>
				<h2>날짜 별 뉴스 TOP 5</h2>
	            	<td><center>날짜</center></td>
	            	<td><center>뉴스 기사</center></td>
	            	<td><center>순위</center></td>
				</tr>
            <c:forEach items="${newsList}" var="news">
                <tr>
                    <td><center>${news.n_date}</center></td>
                    <td><center><a href="http://${news.n_url}">${news.n_title}</a></center></td>
                    <td><center>${news.n_no}</center></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    	<br>
    <table>
    	<!--                      경기일정						 -->
    		<h2>경기일정</h2>
    			<button class="day1" type="button" onclick="location.href='/gametime?month1=11&date=21&r_group=${group}'">11월21일(수)</button>&nbsp;
    			<button class="day2" type="button" onclick="location.href='/gametime?month1=11&date=22&r_group=${group}'">11월22일(수)</button>&nbsp;
		    	<button class="day3" type="button" onclick="location.href='/gametime?month1=11&date=23&r_group=${group}'">11월23일(수)</button>&nbsp;
		    	<button class="day4" type="button" onclick="location.href='/gametime?month1=11&date=24&r_group=${group}'">11월24일(목)</button>&nbsp;
		    	<button class="day5" type="button" onclick="location.href='/gametime?month1=11&date=25&r_group=${group}'">11월25일(금)</button>&nbsp;
		    	<button class="day6" type="button" onclick="location.href='/gametime?month1=11&date=26&r_group=${group}'">11월26일(토)</button>&nbsp;
		    	<button class="day7" type="button" onclick="location.href='/gametime?month1=11&date=27&r_group=${group}'">11월27일(일)</button>&nbsp;
		    	<button class="day8" type="button" onclick="location.href='/gametime?month1=11&date=28&r_group=${group}'">11월28일(월)</button>&nbsp;
		    	<button class="day9" type="button" onclick="location.href='/gametime?month1=11&date=29&r_group=${group}'">11월29일(화)</button>&nbsp;
		    	<button class="day10" type="button" onclick="location.href='/gametime?month1=11&date=30&r_group=${group}'">11월30일(수)</button>&nbsp;
		    	<button class="day11" type="button" onclick="location.href='/gametime?month1=12&date=1&r_group=${group}'">12월1일(목)</button>&nbsp;
		    	<button class="day12" type="button" onclick="location.href='/gametime?month1=12&date=2&r_group=${group}'">12월2일(금)</button>&nbsp;
		    	<button class="day13" type="button" onclick="location.href='/gametime?month1=12&date=3&r_group=${group}'">12월3일(토)</button>&nbsp;
		    	<button class="day14" type="button" onclick="location.href='/gametime?month1=12&date=4&r_group=${group}'">12월4일(일)</button>&nbsp;
		    	<button class="day15" type="button" onclick="location.href='/gametime?month1=12&date=5&r_group=${group}'">12월5일(월)</button>&nbsp;<br>
		    	<button class="day16" type="button" onclick="location.href='/gametime?month1=12&date=6&r_group=${group}'">12월6일(화)</button>&nbsp;
		    	<button class="day17" type="button" onclick="location.href='/gametime?month1=12&date=7&r_group=${group}'">12월7일(수)</button>&nbsp;
		    	<button class="day18" type="button" onclick="location.href='/gametime?month1=12&date=8&r_group=${group}'">12월8일(목)</button>&nbsp;
		    	<button class="day19" type="button" onclick="location.href='/gametime?month1=12&date=9&r_group=${group}'">12월9일(금)</button>&nbsp;
		    	<button class="day20" type="button" onclick="location.href='/gametime?month1=12&date=10&r_group=${group}'">12월10일(토)</button>&nbsp;
		    	<button class="day21" type="button" onclick="location.href='/gametime?month1=12&date=11&r_group=${group}'">12월11일(일)</button>&nbsp;
		    	<button class="day22" type="button" onclick="location.href='/gametime?month1=12&date=12&r_group=${group}'">12월12일(월)</button>&nbsp;
		    	<button class="day23" type="button" onclick="location.href='/gametime?month1=12&date=13&r_group=${group}'">12월13일(화)</button>&nbsp;
		    	<button class="day24" type="button" onclick="location.href='/gametime?month1=12&date=14&r_group=${group}'">12월14일(수)</button>&nbsp;
		    	<button class="day25" type="button" onclick="location.href='/gametime?month1=12&date=15&r_group=${group}'">12월15일(목)</button>&nbsp;
		    	<button class="day26" type="button" onclick="location.href='/gametime?month1=12&date=16&r_group=${group}'">12월16일(금)</button>&nbsp;
		    	<button class="day27" type="button" onclick="location.href='/gametime?month1=12&date=17&r_group=${group}'">12월17일(토)</button>&nbsp;
		    	<button class="day28" type="button" onclick="location.href='/gametime?month1=12&date=18&r_group=${group}'">12월18일(일)</button>&nbsp;
		    	<button class="day29" type="button" onclick="location.href='/gametime?month1=12&date=19&r_group=${group}'">12월19일(월)</button>&nbsp;
		    	
					
         <thead>
            <tr>
					<td><center>순위</center></td>
					<td><center>경기날짜</center></td>
					<td><center>조</center></td>
					<td><center>게임여부</center></td>
					<td><center>홈</center></td>
					<td><center>어웨이</center></td>
					<td><center>홈 스코어</center></td>
					<td><center>어웨이 스코어</center></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${schedulelist}" var="user">
                <tr>
                    <td>${user.p_no}</td>
                    <td>${user.date}</td>
                    <td>${user.w_group}</td>
                    <td>${user.time}</td>
                    <td>${user.name_1}</td>
                    <td>${user.name_1}</td>
                    <td>${user.score_1}</td>
                    <td>${user.score_2}</td>
                </tr>
            </c:forEach>
           	 <c:forEach items="${schedulelist1}" var="user1">
                <tr>
                    <td>${user1.p_no}</td>
                    <td>${user1.date}</td>
                    <td>${user1.w_group}</td>
                    <td>${user1.time}</td>
                    <td>${user1.name_1}</td>
                    <td>${user1.name_1}</td>
                    <td>${user1.score_1}</td>
                    <td>${user1.score_2}</td>
                </tr>
            </c:forEach>
            
            
        </tbody>
        </table>
        <br>   		
</body>
</html>