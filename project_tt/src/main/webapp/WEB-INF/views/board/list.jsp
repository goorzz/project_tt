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
<button onclick="location.href = 'register'">글작성</button>
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
                                            <td><a href="get?bno=${board.bno}"><c:out value="${board.title}"></c:out></a></td>
                                            <td><c:out value="${board.user_nickname}"></c:out></td>
                    						<td><fmt:formatDate pattern="yyyy/MM/dd hh:mm:ss" value="${board.date}"/></td> 
                                          	<td><c:out value="${board.good}"></c:out></td>
                                          	<td><form action ="good" method ="get">
												<input type="hidden" name="bno" value="${board.bno} "> 
												<button type ="submit">좋아요</button>
										  	</form></td>
										  	<td><c:out value="${board.bad}"></c:out></td>
                                         	<td><form action ="bad" method ="get">
												<input type="hidden" name="bno" value="${board.bno} ">
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
					<%-- <c:if test="${pagebar.prev}">
					<li class="paginate_button previous">
						<a href="${pagebar.startPage -1}">previous</a>
					</li>

					</c:if>
					
					<c:forEach var="num" begin="${pagebar.startPage}" end="${pagebar.endPage}">
						<li class="paginate_button ${pagebar.cri.pageNum == num ?"active":""} ">
							<a href="${num}">${num}</a>
						</li>
					</c:forEach>
					
					<c:if test="${pagebar.next}">
					<li class="paginate_button previous">
						<a href="${pagebar.endPage +1}">Next</a>
					</li>
					</c:if>
					
					<form id= 'actionForm' action="/board/list" mthod='get'>
					<input type = "hidden" name="pageNum" value="${pagebar.cri.pageNum}">
					<input type = "hidden" name="amount" value="${pagebar.cri.amount}">
					</form>  --%>
					

	
</body>
</html>