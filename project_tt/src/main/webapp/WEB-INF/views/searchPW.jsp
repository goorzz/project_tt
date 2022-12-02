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
<h1>아이디/비밀번호 찾기</h1> <br>

	<input type="button" value="아이디찾기" onclick="location.href='/searchID'" style="WIDTH: 80pt; HEIGHT: 50pt"/>
	<input type="button" value="비밀번호찾기" onclick="location.href='/searchPW'" style="WIDTH: 80pt; HEIGHT: 50pt"/> <br>
	<form action="/showPW" method="get" style="height: 182px; ">
		<input type="text" placeholder="ID" name="user_id" style="WIDTH: 160pt; HEIGHT: 40pt"> <br>
		<input type="text" placeholder="전화번호" name="user_tel" style="WIDTH: 160pt; HEIGHT: 40pt"> <br><br>
		<input type="submit" value ="비밀번호 찾기" style="WIDTH: 160pt; HEIGHT: 30pt"> ${text}
	</form>
		<input type="button" value="메인 이동" onclick="location.href='/'" style="WIDTH: 160pt; HEIGHT: 30pt"/>	
</body>
</html>