<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/board/register" method="post">
		<fieldset>
			<legend> <h1>자유게시판글 등록하기 </h1></legend>
			제목 :<input type ="text" name ="title" placeholder="제목을 입력해주세요."style="width:500px;font-size:10px;"><br>
			작성자:<input type ="text" name="user_nickname" placeholder="작성자를 입력해주세요."style="width:500px;font-size:10px;"><br>
			<label>내용:<textarea name="content" class="form-control form-control-user" rows ="30" cols="100" >${board.content}</textarea></label> <br><hr>
		<%-- 	<input type="hidden" name="bno" value="${board.bno}"> 
			<input type="hidden" name="good" value="${board.good}">
			<input type="hidden" name="bad" value="${board.bad}">
			<input type="hidden" name="date" value="${board.date}">
			<input type="hidden" name="view_count" value="${board.view_count}">    --%>   
			<input type ="submit" value="작성">
			<input type ="reset" value="취소">
			
		
			
		}
		
		</fieldset>
	</form>
</body>
</html>