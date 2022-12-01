<p><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>경기 일정</title>
</head>
<body>
	<h1>경기 일정</h1>
	<a href ="/main">aaa</a><br>
	   <tbody>
            <c:forEach items="${schedulelist}" var="user">
                <tr>
                    <td>${user.n_no}</td>
                    <td>${user.date}</td>
                    <td>${user.w_group}</td>
                    <td>${user.time}</td>
                    <td>${user.name_1}</td>
                    <td>${user.name_1}</td>
                    <td>${user.score_1}</td>
                    <td>${user.score_2}</td>
                </tr>
            </c:forEach>
        </tbody>
</body>
</html>