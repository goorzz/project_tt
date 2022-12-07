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
<!-- 스크립트 -->
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
  function test() {	  
      var user1 = document.getElementById("user_pw1").value;
       
       if(user1 == "") {
          alert("비밀번호를 입력해주세요."); 
         
      }
  }
  </script>
  
<h1>비밀번호 확인</h1>
<h3>회원정보의 안전한 관리를 위해서 비밀번호 재 확인을 하고 있습니다.</h3>
<form action="mypagentry" method="post">
	<input type="hidden" id ="user_id1"name="user_id" value="${user.user_id}">
	<input type="password" id ="user_pw1" name="user_pw" placeholder="비밀번호" ><br>
	<input type="submit" onclick="test()" value="확인">
</form>

</body>
</html>