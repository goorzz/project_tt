<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<!-- 스크립트 -->
	<script>
		function locate1() {
			return true;
		}
		function locate2(locate) {
			locate.action="/idCheck";
			locate.submit();
			return true;
		}
		function locate3(locate) {
			locate.action="/nicknameCheck";
			locate.submit();
			return true;
		}		
	</script>
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
  	<script type="text/javascript" >
    function test(form) {      
      var p1 = document.getElementById('user_pw1').value;
      var p2 = document.getElementById('user_pw2').value;     
      var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
      var pw = $("#user_pw1").val();
 	 	
      if(p1 == ""){
		alert("비밀번호를 입력해주세요");
		form.action="/test2"; 	           
      }else if(p2 == ""){
        alert("비밀번호를 재입력해주세요"); 
		form.action="/test2";
      }else if(false === reg.test(pw)){
		alert("비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.");
		form.action="/test2";
      }else if( p1 != p2 ) {
		alert("비밀번호가 일치 하지 않습니다");    
		form.action="/test2";
      }else{
		form.action="/test";
// 		locate.submit();
		return true;
      }
    }
	</script>
<!-- 입력창 -->
	<form action="/register?point_no=1" method="post" onsubmit="return loacte1()">
		아이디 <br> <input name='user_id' id='user_id1'type='text' value="${id}"/>
			<input type="submit" value="중복확인" onclick="locate2(this.form)"> ${check} <br>
		비밀번호 (8자리 이상, 숫자/대문자/소문자/특수문자 모두 포함) <br><input name='user_pw' type='text' id='user_pw1' value="${pw}" /> <br>
		비밀번호재입력 <br> <input name='user_pw2' type='text' id='user_pw2' value="${pw2}"/>
			<input type="submit" value="비밀번호확인" onclick="test(this.form)"> ${pw_check} <br>
				<input type="hidden" name="pw_check2" value="${pw_check2}"/>	
		이름 <br> <input name='user_name' type='text' value="${name}"/><br>
		닉네임 <br> <input name='user_nickname' type='text' value="${nN}"/>
			<input type="submit" value="중복확인" onclick="locate3(this.form)"> ${check2} <br>		
		전화번호 <br> <input name='user_tel' type='text' value="${tel}"/><br><br>	
		
		<input type="submit" value="회원가입" style="WIDTH: 60pt; HEIGHT: 30pt"> ${text}
	</form>
	<input type="button" value="뒤로 가기" onclick="location.href='/searchID'"style="WIDTH: 60pt; HEIGHT: 30pt"/> <br>
	<c:forEach items="${list}" var="list">
		<td>${list.user_id}</td>
		<td>${list.user_pw}</td>
		
		<td>${list.user_name}</td>
		<td>${list.user_nickname}</td>
		<td>${list.user_tel}</td><br>
	</c:forEach>


</body>
</html>
