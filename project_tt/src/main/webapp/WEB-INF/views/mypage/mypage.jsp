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
	<h1> 반갑습니다 ${user.user_nickname}님</h1>
	<input type="button" value="내 정보 수정" onclick="location.href='/mypage/mypage_modify'" style="width: 125px; height: 56px">
	<input type="button" value="내 게시글 목록" onclick="location.href='/mypage/mypage_info?user_nickname=${user.user_nickname}'" style="width: 125px; height: 56px">
	<input type="button" value="내 포인트 현황" onclick="location.href='/mypage/mypage_point?user_id=${user.user_id}'" style="width: 125px; height: 56px"> <br><br>
	<input type="button" value="메인 이동" onclick="location.href='/'" style="WIDTH: 160pt; HEIGHT: 30pt"/>

</body>
</html>