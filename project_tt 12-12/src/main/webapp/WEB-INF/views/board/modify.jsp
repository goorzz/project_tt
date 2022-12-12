<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<form action ="modify" method ="post">
	<input type="hidden" name="bno" value="${board.bno}"> 
		제목 :<input type ="text" name="title" class="form-control form-control-user" value ="${board.title}" /><br>
		작성자:${board.user_nickname}<br>
		내용:<input type ="text" name="content" class="form-control form-control-user" value ="${board.content}"/><br><hr>
		
		<input type="hidden" name="user_nickname" value="${user.user_nickname}"> 
		<input type="submit"value="수정"onclick="modify()" >
	<button type="button" onclick="location.href='list'">취소</button>
</form>

<script>
function modify(){
	alert('수정되었습니다.');
}
</script>

</body>
</html>