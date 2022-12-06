<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>메인화면 (test중)</h1>
 	<form action="/main" method="post">
		<input type="text" id ="user_id1"name="user_id" placeholder="아이디"><br>
		<input type="password" id ="user_pw1"name="user_pw" placeholder="비밀번호"><br>
		<input type="submit" onclick="test()" value="로그인">
	</form>
 	<input type="button" value="회원가입" onclick="location.href='/membership'" style="width: 125px; height: 56px">
 	<input type="button" value="ID/PW찾기" onclick="location.href='/searchID'" style="width: 125px; height: 56px">
 	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
  function test() {
	  var userId = document.getElementById("user_id1").value;
      var userPwd = document.getElementById("user_pw1").value;
      if(userId == "") {
          alert("아이디를 입력해주세요.");
          return false;
      }
      else if(userPwd == "") {
          alert("비밀번호를 입력해주세요.");
          return false;
      }

  }
  </script>
</body>
</html>