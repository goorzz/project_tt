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

<form action="/board/test" method="get">
<c:forEach items="${mypage_board_list}" var="mypage_list" >
	 <input type="text" name ="rno" value="${mypage_list.rno}">
	 <input type="hidden" name ="title" value="${mypage_list.title}">
	 <input type="hidden" name ="nickname" value="${mypage_list.user_nickname}">
	 <input type="hidden" name ="view_count" value="${mypage_list.view_count}">
	 <fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${mypage_list.date}"/>
	 <input type="hidden" name ="bno" value="${mypage_list.bno}">
</c:forEach>
 <input type="submit" value="마이페이지">
 </form>

 <script> 
  function submit2(frm) { 
    frm.action='/board/test1'; 
    frm.submit(); 
    return true; 
  } 
  
</script> 		
</body>
</html>