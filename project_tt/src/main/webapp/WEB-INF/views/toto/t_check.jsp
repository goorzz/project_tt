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
<h1>승부예측 확인</h1>
	${user.user_nickname }님의 승부예측 확인 <br>
	*******확정시 취소 할수 없습니다******* <br>
	경기날짜 : ${date} <br>
	<c:forEach items="${match16}" var="match16">	
	경기내용 : ${match16.name_1} vs ${match16.name_2}<br>
	</c:forEach>
	승자예측 : ${predict_w}<br>
	소모포인트 : -500p<br>
	<form action="/toto/t_bat" method ="get">
		<c:forEach items="${match16}" var="match16">	
		<input type ="hidden" name ="name_1" value="${match16.name_1}">
		<input type ="hidden" name ="name_2" value="${match16.name_2}">
		</c:forEach>
		<input type ="hidden" name ="date" value="${date}">
		<input type ="hidden" name ="user_id" value="${user.user_id}">
		<input type ="hidden" name ="predict_w" value="${predict_w}">
		<input type ="hidden" name ="point_no" value="3">
		<input type ="submit" value ="확정">
	</form>
	
</body>
</html>