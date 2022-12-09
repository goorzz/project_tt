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
<table>
	<tr>
		<th>경기날짜</th>
		<th>경기내용</th>
		<th>내예측</th>
		<th>결과확인</th>
		
	</tr>
	<c:forEach items="${toto_list}" var="list">
	<tr>
    	<td>${list.date }</td>
		<td>${list.name_1 } vs ${list.name_2 }</td>
		<td>${list.predict_w }</td> 
		<td><input type="button" value="확인"></td> 
	</tr>
    </c:forEach>
	

	    
</table>	    
</body>
</html>