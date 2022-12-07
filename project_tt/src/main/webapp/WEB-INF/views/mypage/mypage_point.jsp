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
<h1>내 포인트 현황</h1>
총 포인트 : ${point.user_point }<br>
	<table>
        <thead>
			<tr>
				<td><center>획득 내역</center></td>
				<td><center>획득 포인트</center></td>
				<td><center>획득 날짜</center></td>
			</tr>
        </thead>
        <tbody>
            <c:forEach items="${point_list}" var="point_list">
                <tr>
                    <td><center>${point_list.point_content}</center></td>
                    <td><center>${point_list.point_point }</center></td>
                    <td><center><fmt:formatDate pattern="yyyy/MM/dd" value="${point_list.date}"/></center></td>
                </tr>
            </c:forEach>
        </tbody>
	</table>
</body>
</html>