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
	승부예측에 성공할시 1000p가 지급됩니다. <br>

	<input type="button" value="승부예측하러가기" onclick="location.href='/toto/t_batting'">	
	<input type="button" value="내 승부예측 확인" onclick="location.href='/toto/t_mytoto?user_id=${user.user_id}'">	

</body>
</html>