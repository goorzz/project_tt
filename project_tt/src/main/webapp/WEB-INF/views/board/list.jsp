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
<h1> 월드컵 자유게시판  </h1>
<c:if test="${! empty user}">
<button onclick="location.href = 'register?user_nickname=${user.user_nickname}'">글작성</button>
</c:if>
<input type="button" value="메인으로" onclick="location.href='/'"/>
<form action="/board/list" method="get">
	<select name= 'type'>
		<option value="T">제목</option>
		<option value="C">내용 </option>
		<option value="U">닉네임 </option>
		<option value="TU">제목 or 닉네임</option>
		<option value="TC">제목 or 내용</option>
		<option value="TU">제목 or 닉네임 </option>
		<option value="TCU">제목 or 내용 or 닉네임 </option>
		</select>
		<input type="text" name='keyword'value="${pagebar.cri.keyword}" />
		<input type="hidden" name="pageNum" value="${pagebar.cri.pageNum}">
		<input type="hidden" name="amount" value="${pagebar.cri.amount}">

		<button class='btn-default'>검색</button>
</form>
<table class="table table-bordered" border="1">
<thead>
    <tr>
        <th>글번호</th>
        <th>제목</th>
        <th>닉네임</th>
        <th>작성일</th>
        <th>좋아요</th>
          <th>버튼</th>
        <th>싫어요</th>
        <th>버튼</th>
        <th>조회수</th>                                           
    </tr>
</thead>
<tbody>
<c:forEach items="${list}" var="board">
<tr>
	<td><c:out value="${board.bno}"></c:out></td>	
	<td><a href="get?bno=${board.bno} & user_nickname=${user.user_nickname}"><c:out value="${board.title}"></c:out></a></td>
	<td><c:out value="${board.user_nickname}"></c:out></td>
	<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${board.date}"/></td> 
	<td><c:out value="${board.good}"></c:out></td>
	<td><form action ="good" method ="get">
	<input type="hidden" name="bno" value="${board.bno} "> 
	<input type="hidden" name="pageNum" value="${pageNum}"> 
	<input type="hidden" name="amount" value="${amount} "> 
	<button type ="submit">좋아요</button>
	</form></td>
	<td><c:out value="${board.bad}"></c:out></td>
	<td><form action ="bad" method ="get">
	<input type="hidden" name="bno" value="${board.bno} ">
	<input type="hidden" name="pageNum" value="${pageNum}"> 
	<input type="hidden" name="amount" value="${amount} "> 
	<button type ="submit">싫어요</button>
	</form></td>
	<td><c:out value="${board.view_count}"></c:out></td> 
 </tr>                                  
</c:forEach>
</tbody>
</table>
                                
<%-- 페이지바 만드는 부분  --%>
<ul class="pagination"> 
	<li class="paginate_button page-item previous ${pagebar.prev ? '': 'disabled' }" id="dataTable_previous"><a href="list?pageNum=${pagebar.cri.pageNum-1}&amount=${pagebar.cri.amount}" class="page-link">Previous</a></li>
	<c:forEach begin="${pagebar.startPage}" end="${pagebar.endPage}" var="num">
	<li class="paginate_button page-item ${pagebar.cri.pageNum==num ? 'active': '' }"><a href="list?pageNum=${num}&amount=${pagebar.cri.amount}" class="page-link">${num}</a></li>
	</c:forEach>
<li class="paginate_button page-item next ${pagebar.next ? '': 'disabled'}" id="dataTable_next"><a href="list?pageNum=${pagebar.cri.pageNum+1}&amount=${pagebar.cri.amount}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a></li>
</ul>	
<!-- 스크립트  -->			
<script>
<%-- 모달창 만드는 부분  --%>
	//글 등록번호 알려주는 모달창
	var bno="${bno}"; 
	var removeis="${removeis}";  
	var modifyis="${modifyis}"; 

	console.log("작성된 글번호"+bno);
	if(!history.state){ 
	    //경고창 필요없다는 표시
		history.replaceState({},null,null);  //표시하기               
		
		if(bno){ //이것은 의미는 bno 값이 있다면
			alert(bno+"번 글이 등록되었습니다.")
		}else if(removeis){
			if(removeis==="true")
				alert("");
			else
				alert(" 삭제 되었습니다.");
		}else if(modifyis){
			if(modifyis==="true")
				alert("수정 되었습니다.");
			else
				alert("수정중 오류가 났습니다.")
		}
	}
</script>

	
</body>
</html>