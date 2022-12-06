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
<h5> 내게시글 보기</h5>
<form action="/board/test" method="post">
<table class="table table-bordered" border="1">
	<thead>
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>조회수</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
		
		<c:forEach items="${Mypage_board_list}" var="blist" >
			<td><c:out value="${blist.rno}"></c:out></td>
			<td><c:out value="${blist.title}"></c:out></td>
			<td><c:out value="${blist.view_count}"></c:out></td>
			<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${blist.date}"/></td>
	
<%-- 	<input type="hidden" name="user_nickname" value="${blist.user_nickname} "> --%>
		</c:forEach>
		</tr>
	</tbody>
	${test}
</table>
</form>
</body>
</html>