<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/register?user_id=${user.user_id}&point_no=4" method="post">
		<fieldset>
			<legend> <h1>자유게시판글 등록하기 </h1></legend>
			제목 :<input type ="text" name ="title" placeholder="제목을 입력해주세요."style="width:500px;font-size:10px;"><br>
			닉네임:${user.user_nickname}<br>
			<input type="hidden" name="user_nickname" value="${user.user_nickname}">
			<label>내용:<textarea name="content" class="form-control form-control-user" rows ="30" cols="100" >${board.content}</textarea></label> <br><hr>
			<input type ="submit" value="작성" onclick="register()" >
			<input type ="reset" value="취소">
			<input type="button" value="게시판으로" onclick="location.href='/board/list'"/>
		</fieldset>
	</form>

<script>
function register(){
	alert('글등록되었습니다.');
}
</script>
	
</body>
</html>

