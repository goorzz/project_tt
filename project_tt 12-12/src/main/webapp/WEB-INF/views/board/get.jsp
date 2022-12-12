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
<h1> 월드컵 자유게시판  상세보기 </h1>
	<form action="modify" method='get'>
		<input type="hidden" name="bno" value="${board.bno}">
		<input type="hidden" name="pageNum" value="${pageNum}"> 
		<input type="hidden" name="amount" value="${amount} "> 
		<c:if test="${user.user_nickname == board.user_nickname}">
			<input type="submit" value="수정" >
		</c:if>
	</form>
	<form action ="remove" method='post'>
		<input type="hidden" name="bno" value="${board.bno}">
		<input type="hidden" name="pageNum" value="${pageNum}"> 
		<input type="hidden" name="amount" value="${amount} "> 
		<c:if test="${user.user_nickname == board.user_nickname}">
			<input type="submit" value="삭제" onclick="remove()">
		</c:if>
	</form>
<script>
function remove(){
	alert('삭제되었습니다.');
}
</script>

	
	
	
<a href="list"><button>목록보기</button></a>

<table class="table table-bordered" border="1">
     <thead>
         <tr>
             <th>글번호</th>
             <th>제목</th>
             <th>닉네임</th>
             <th>작성일</th>                                  
             <th>좋아요</th>
             <th>싫어요</th>                                           
         </tr>
         <tr>
         	
         </tr>
     </thead>
     
     <tbody>
         <tr>
             <td>${board.bno}</td>
             <td>${board.title}</td>
             <td>${board.user_nickname}</td>
             <td><fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${board.date}"/></td>
             <td>${board.good}</td>
             <td>${board.bad}</td>                                            
         </tr>
         <tr>
  
         </tr>
     </tbody>
    
 </table>
 <table class="table table-bordered" border="1">
 	<thead>
 	<tr>
 		<th>내용</th>
 	</tr>
 	</thead>
 	<tbody>
 		<tr>
 			<td><input type="text" value="${board.content}" style="width:300px;height:200px;font-size:30px;" readonly></td>
 			
 		</tr>
 	</tbody>
 </table>

 <fieldset>
 <legend>댓글창</legend>
<!-- 댓글 부분 -->		
<c:forEach items ="${replylist}" var="reply"><br>
	<form action="reply_modify" method="post">
		댓글번호 :${reply.no}<br>
		닉네임 :${reply.user_nickname}<br>
		<input type="hidden" name="user_nickname" value="${user.user_nickname}">
		댓글내용 :<input type="text" name= "reply_content" value="${reply.reply_content}">	<br>	
		입력날짜 :${reply.reply_date}<br>
				  <input type="hidden" name="rno" value="${reply.rno }">

		<input type="hidden" value="${reply.bno}" name="bno">
		<c:if test="${user.user_nickname == reply.user_nickname}">
 			<input type="submit" value="댓글수정">
 		</c:if>
		<c:if test="${user.user_nickname == reply.user_nickname}">
 			<input type="button" value="댓글삭제" onclick='return submit2(this.form)'>
 		</c:if>
	</form>	
</c:forEach>
<!-- 댓글 삭제 -->
<c:forEach items ="${replylist}" var="reply"><br>
<form action="reply_delete" method="post">
	<input type="hidden" value="${reply.rno}" name="rno">
	<input type="hidden" name="user_nickname" value="${reply.user_nickname}">
	<input type="hidden" value="${reply.reply_content}" name="reply_content">
	<input type="hidden" value="${reply.reply_date}" name="reply_date">
	<input type="hidden" value="${reply.bno}" name="bno">
</form>	
</c:forEach>	

 	
<!--댓글 등록 -->
<c:if test="${! empty user}">
<form action="get?user_id=${user.user_id}&point_no=5" method="post">
	<input type="hidden" name="bno"value="${board.bno} ">
	닉네임:${user.user_nickname}<br>
	<input type="hidden" name="user_nickname" value="${user.user_nickname}">
	댓글내용: <textarea name="reply_content" placeholder="댓글을 입력해주세요." class="form-control form-control-user" rows ="3" cols="30" ></textarea>
	<input type="hidden" name="reply_date" value="${datenow}">
	<input type="submit" value="댓글등록">
	<input type ="reset" value="취소">
</form>
</c:if> 
<c:if test="${empty user}">		
로그인 후 댓글작성이 가능합니다.
</c:if>		
</body>

<script> 
  function submit2(frm) { 
    frm.action='reply_delete'; 
    frm.submit(); 
    return true; 
  } 
</script> 
</fieldset>
</html>