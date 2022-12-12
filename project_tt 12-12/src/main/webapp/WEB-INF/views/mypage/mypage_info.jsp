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
<h1>내 게시글 목록</h1>
<table class="table table-bordered" border="1" >
<thead>
	<tr>
		<td>번호</td>
		<td>글제목</td>
		<td>조회수</td>
		<td>작성일</td>
	</tr>
</thead>
<tbody>
		<c:forEach items="${Mypage_board_list}" var="blist" >
		<tr>
			<td> ${blist.rno}</td>
			<td> <a href="/board/get?bno=${blist.bno}">${blist.title}</a></td>
			<td> ${blist.view_count}</td>
			<td ><fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${blist.date}"/></td>
		</tr>
		</c:forEach>
</tbody>
</table>
	<input type="button" value="메인 이동" onclick="location.href='/mypage/mypage'" style="WIDTH: 160pt; HEIGHT: 30pt"/>
</body>
</html>