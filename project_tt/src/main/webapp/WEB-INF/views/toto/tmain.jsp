<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 승부예측 화면</h1>
	<form action="/toto/tmain" method="get">
		날짜별 검색 <select name ="date">
			<c:forEach items="${schedule_date}" var="schedule_date">	
				<option>${schedule_date.date}</option>
			</c:forEach>
		</select>
		<input type="submit" value ="이동">		
	</form>
	<form action="/toto/tmain" method="get">
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
			<th><center>승자 예측</center></th>
		</tr>
		<!--날짜별 -->
		<c:forEach items="${schedule_predict}" var="schedule">
        <tr>
			<td><center>${schedule.date}</center></td>
			<td><center>${schedule.w_group}</center></td>
			<td><center>${schedule.time}</center></td>
			<td><center>${schedule.name_1}</center></td>
			<td><center>${schedule.name_2}</center></td>
			<td><center>${schedule.score_1}</center></td>
			<td><center>${schedule.score_2}</center></td>
			<td><center>${schedule.predict}</center></td>
		</tr>
		</c:forEach> 
		<c:forEach items="${schedule_predict3}" var="schedule3">
        <tr>
			<td><center>${schedule3.date}</center></td>
			<td><center>${schedule3.w_group}</center></td>
			<td><center>${schedule3.time}</center></td>
			<td><center>${schedule3.name_1}</center></td>
			<td><center>${schedule3.name_2}</center></td>
			<td><center>${schedule3.score_1}</center></td>
			<td><center>${schedule3.score_2}</center></td>
			<td><center>${schedule3.predict}</center></td>
		</tr>
		</c:forEach>
		<!--국가별 -->
		<c:forEach items="${schedule_predict2}" var="schedule2">
        <tr>
			<td><center>${schedule2.date}</center></td>
			<td><center>${schedule2.w_group}</center></td>
			<td><center>${schedule2.time}</center></td>
			<td><center>${schedule2.name_1}</center></td>
			<td><center>${schedule2.name_2}</center></td>
			<td><center>${schedule2.score_1}</center></td>
			<td><center>${schedule2.score_2}</center></td>
			<td><center>${schedule2.predict}</center></td>
		</tr>
		</c:forEach>
		<c:forEach items="${schedule_predict4}" var="schedule4">
        <tr>
			<td><center>${schedule4.date}</center></td>
			<td><center>${schedule4.w_group}</center></td>
			<td><center>${schedule4.time}</center></td>
			<td><center>${schedule4.name_1}</center></td>
			<td><center>${schedule4.name_2}</center></td>
			<td><center>${schedule4.score_1}</center></td>
			<td><center>${schedule4.score_2}</center></td>
			<td><center>${schedule4.predict}</center></td>
		</tr>
		</c:forEach>				
	</table> <br>		
	<input type="button" value="메인으로" onclick="location.href='/'"/>	
toto test
</body>
</html>