<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> 아이디/비밀번호 찾기</h1><br>
		회원님의 ID는 아래와 같습니다 <br>
	<input type="text" value= "ID : ${id }" style="height: 50px; width: 195px"/> <br><br>
	<input type="button" value="메인 이동" onclick="location.href='/'" style="height: 51px; width: 93px"/>
	<input type="button" value="뒤로 가기" onclick="location.href='/searchID'"style="height: 51px; width: 93px"/>
</body>
</html>
