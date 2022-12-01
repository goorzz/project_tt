<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table>
        <tbody>
            <c:forEach items="${userrList}" var="user">
                <tr>
          			<!--<td>${user.no}</td>-->  
                    <td>${user.r_group}</td>
                    <td>${user.r_rank}</td>
                    <td>${user.r_name}</td>
                    <td><center>${user.r_count}</center></td>
                    <td>${user.r_win}</td>
                    <td>${user.r_draw}</td>
                    <td>${user.r_lose}</td>
                    <td><center>${user.r_gain}</center></td>
                    <td>${user.r_wincount}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
  
  
</body>
</html>