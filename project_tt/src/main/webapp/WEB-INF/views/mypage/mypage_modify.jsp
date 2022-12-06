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
	function test(){
		var nick1 = document.getElementById("user_nickname1").value;
   		var tel1 = document.getElementById("user_tel1").value;
    	var p1 = document.getElementById("user_pw1").value;
    	var p2 = document.getElementById('user_pw2').value;
    	var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
   		var pw = $("#user_pw1").val();
    
   		if( p1 != p2 ) {
        	alert("비밀번호가 일치 하지 않습니다");    
       		return false;
    	}
    	else if(nick1==""&&tel1==""&&p1==""){
  	  		alert("수정 내용이 없습니다");
  	  		return false;
    	}
    	else if(false === reg.test(pw)){
  	  	alert("비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다."); 	  
    	}
    	else{
        	alert("수정 완료 다시 로그인 해주세요");
        	$("#form1").submit();
        	return true;
    	}
}
</script>

<script type="text/javascript">
	function test1(){
    var p1 = document.getElementById("user_pw1").value;
    var p2 = document.getElementById('user_pw2').value;
    if( p1 != p2 ) {
        alert("비밀번호가 일치 하지 않습니다");    
        return false;
	}else{
		(confirm("회원 탈퇴시 모든 정보가 삭제됩니다.\n정말 회원을 탈퇴하시겠습니까?")) 
		window.location.href = "/main"
		$("#form2").submit();
	}
}
</script>
<!-- 내용 -->
<h1>내 정보 수정</h1>
<form id="form1" action="mypage" method="post">
이름:<input type="text" name="user_name" value="${user.user_name}" readonly  style="border: none;">
ID:<input type="text" name="user_id" value="${user.user_id}" readonly  style="border: none;"><br>
닉네임:<input type="text" name="user_nickname"id="user_nickname1" value="${user.user_nickname}">
 전화번호:<input type="text" name="user_tel"id="user_tel1" value="${user.user_tel}" ><br>
비밀번호:<input type="password" name="user_pw" id="user_pw1"value="${user.user_pw}">
비밀번호 확인 :<input type="password" id="user_pw2"><br>
<label>*비밀번호는 영문 대소문자,숫자,특수문자 포함한 8자리 이상만 가능합니다*</label><br>
<input type="button" onclick="test()" value="내 정보 수정하기">
<input type="button" value="뒤로 가기" onclick="location.href='/mypage/mypage'"/>
</form>

<form id="form2" action="deletem" method="post">
	<input type="hidden" name="user_id" value="${user.user_id}">
	<input type="hidden" name="user_name" value="${user.user_name}">
	<input type="button" onclick="test1()" value="회원탈퇴">
</form>

</body>
</html>