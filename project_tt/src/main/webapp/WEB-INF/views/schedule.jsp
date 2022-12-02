<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> 경기일정 상세페이지</h1><br>
	<form action="/schedule" method="get">
		날짜별 검색 <select name ="date">
			<c:forEach items="${schedule_date}" var="schedule_date">	
				<option>${schedule_date.date}</option>
			</c:forEach>
		</select>
		<input type="submit" value ="이동">		
	</form>
	<form action="/schedule" method="get">
		국가별 검색 <input type="text" name="name_1">
		<input type="submit" value ="이동">
	</form>
	<table>
		<tr>
			<th><center>경기날짜</center></th>
			<th><center>조</center></th>
			<th><center>경기시간</center></th>
			<th><center>홈</center></th>
			<th><center>어웨이</center></th>
			<th><center>홈 스코어</center></th>
			<th><center>어웨이 스코어</center></th>
		</tr>
		<!--날짜별 -->
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
		<!--국가별 -->
		<c:forEach items="${schedule2}" var="schedule2">
        <tr>
			<td><center>${schedule2.date}</center></td>
			<td><center>${schedule2.w_group}</center></td>
			<td><center>${schedule2.time}</center></td>
			<td><center>${schedule2.name_1}</center></td>
			<td><center>${schedule2.name_2}</center></td>
			<td><center>${schedule2.score_1}</center></td>
			<td><center>${schedule2.score_2}</center></td>
		</tr>
		</c:forEach>		
	</table> <br>		
	<input type="button" value="메인으로" onclick="location.href='/'"/>



</body>
</html>
