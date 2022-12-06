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
		작성자:<input type ="text" name="user_nickname" class="form-control form-control-user" value ="${board.user_nickname}"/><br>
		내용:<input type ="text" name="content" class="form-control form-control-user" value ="${board.content}"/><br><hr>
		<input type="submit"value="수정" >
	<button type="button" onclick="location.href='list'">취소</button>
</form>

</body>
</html>