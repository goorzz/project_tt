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
	승부예측을 통해 Point를 벌어보세요.<br>
	승부예측시 500p가 소모됩니다.<br>
	승부예측에 성공할시 1000p가 지급됩니다.
	<!-- 날짜 선택 -->
	<form action="/toto/t_batting" method="get">
		날짜 선택 <select name ="date">
		<c:if test="${date == null}">
			<option>날짜를 선택해주세요</option>
		</c:if>
		<c:if test="${date != null}">
			<option>${date}</option>
		</c:if>
		<c:forEach items="${schedule_date16}" var="schedule_date16">	
			<option>${schedule_date16.date}</option>
		</c:forEach>
		</select>
		<input type="submit" value ="완료">		
	</form>
	<!-- 경기 선택 -->
	<form action="/toto/t_batting" method="get" >
		경기 선택 <select name="name_1" >
		<c:if test="${name_1 == null}">
			<option>경기를 선택해주세요</option>
		</c:if>
		<c:if test="${name_1 != null}">
			<c:forEach items="${match16}" var="match16">	
				<option>${match16.name_1} vs ${match16.name_2}</option>
			</c:forEach>	
		</c:if>

		<c:forEach items="${schedule_predict16}" var="schedule16">
	    	<option value="${schedule16.name_1}" >${schedule16.name_1} vs ${schedule16.name_2}</option>
	    </c:forEach>
		</select>
		<input type="hidden" name="date" value ="${date}" >	
		<input type="submit" value ="완료">
	</form>
		<c:forEach items="${match16}" var="match16">	
			재명이의 예측 : ${match16.predict} 승리!
		</c:forEach>
	<!-- 승리팀 선택 -->
	<form action="/toto/t_check" method="get" >
		승리팀 선택 <select name="predict_w" >
		<c:if test="${predict_w == null}">
			<option>승리팀을 선택해주세요</option>
		</c:if>
		<c:if test="${predict_w != null}">
				<option>${predict_w}</option>
		</c:if>

		<c:forEach items="${match16}" var="match16">
	    	<option>${match16.name_1}</option>
	    	<option>${match16.name_2}</option>
	    </c:forEach>
		</select>
		<input type="hidden" name ="name_1" value="${name_1}">
		<input type="hidden" name="date" value ="${date}" >	
		<input type="submit" value ="확정">
	</form>
	<input type="button" value="메인으로" onclick="location.href='/'">	

</body>
</html>