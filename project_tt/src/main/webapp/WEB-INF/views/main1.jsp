<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>메인화면 (login 후)</h1>
 ${user.user_nickname}님
 <a href="logout">로그아웃</a><br>
 <a href="mypagentry">마이페이지</a>
 	

 	<div class="table.type07"></div>
	<table>
    <h1>조별 순위 보기</h1>
		<!-- 월드컵 조별 보여주기 -->
		
    	<c:forEach items="${g_list}" var="g_list" >
    		<button type="button" onclick="location.href='/group?r_group=${g_list}'">${g_list}</button>&nbsp; 	
		</c:forEach>
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
            <c:forEach items="${group}" var="group">
                <tr>
                    <td><center>${group.r_group}</center></td>
                    <td><center>${group.r_rank}</center></td>
                    <td><center>${group.r_name}</center></td>
                    <td><center>${group.r_count}</center></td>
                    <td><center>${group.r_win}</center></td>
                    <td><center>${group.r_draw}</center></td>
                    <td><center>${group.r_lose}</center></td>
                    <td><center>${group.r_gain}</center></td>
                    <td><center>${group.r_wincount}</center></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
        <br>
        <!-- new기사 -->
   		<table>
   			   <tbody>
				<tr>
				<h2>오늘의 뉴스 TOP 5</h2>
	            	<td><center>날짜</center></td>
	            	<td><center>뉴스 기사</center></td>
	            	<td><center>순위</center></td>
				</tr>
            <c:forEach items="${news}" var="news">
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
    <!-- 경기일정 -->
	<h2>오늘 경기일정 <button type="button" onclick="location.href='/schedule?date=${s_date}'">더보기</button> </h2>
		<tr>
			<th><center>경기날짜</center></th>
			<th><center>조</center></th>
			<th><center>경기시간</center></th>
			<th><center>홈</center></th>
			<th><center>어웨이</center></th>
			<th><center>홈 스코어</center></th>
			<th><center>어웨이 스코어</center></th>
		</tr>
		<c:forEach items="${schedule}" var="schedule">
		<tr>
			<td><center>${schedule.date}</center></td>
			<td><center>${schedule.w_group}</center></td>
			<td><center>${schedule.time}</center></td>
			<td><center>${schedule.name_1}</center></td>
			<td><center>${schedule.name_2}</center></td>
			<td><center>${schedule.score_1}</center></td>
			<td><center>${schedule.score_2}</center></td>
		</tr>
		</c:forEach>
	</table>
        <br>   		 
  
</body>
</html>