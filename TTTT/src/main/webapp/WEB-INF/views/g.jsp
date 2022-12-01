<p><%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>월드컵 G조 순위</title>
</head>
<body>
    <h1>G조 순위 상세보기</h1>
    <a href ="/main">전체 순위 보기</a><br>
    <a href = "/a">A조</a>
    <a href = "/b">B조</a>
    <a href = "/c">C조</a>
    <a href = "/d">D조</a>
    <a href = "/e">E조</a>
    <a href = "/f">F조</a>
    <a href = "/g">G조</a>
    <a href = "/h">H조</a>
  
    <table>
        <thead>
            <tr>
        		<!--<td>No</td>-->  
            	<td>그룹</td>
            	<td>순위</td>
            	<td>나라이름</td>
            	<td>경기수</td>
            	<td>승</td>
            	<td>무</td>
            	<td>패</td>
            	<td>골득실</td>
            	<td>승점</td>
      
            </tr>
        </thead>
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