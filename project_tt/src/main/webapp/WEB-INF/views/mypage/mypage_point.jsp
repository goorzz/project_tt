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
<h1>내 포인트 현황</h1>
총 포인트 : ${point.user_point }<br>
	<table>
        <thead>
			<tr>
				<th><center>획득 내역</center></th>
				<th><center>획득 포인트</center></th>
				<th><center>획득 날짜</center></th>
			</tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="point_list">
                <tr>
                    <td><center>${point_list.point_content}</center></td>
                    <td><center>${point_list.point_point }</center></td>
                    <td><center><fmt:formatDate pattern="yyyy/MM/dd" value="${point_list.date}"/></center></td>
                </tr>
            </c:forEach>
        </tbody>
	</table>
	 <%-- 페이지바 만드는 부분  --%>
	
<ul class="pagination"> 
	<c:choose>
         <c:when test="${pagebar.cri.pageNum == 1}">
         	<li >
				<a href="mypage_point?user_id=${name}&pageNum=${pagebar.cri.pageNum}&amount=${pagebar.cri.amount}" class="page-link">Previous</a>
			</li>
         </c:when>

         <c:otherwise>
            <li >
				<a href="mypage_point?user_id=${name}&pageNum=${pagebar.cri.pageNum-1}&amount=${pagebar.cri.amount}" class="page-link">Previous</a>
			</li>
         </c:otherwise>
    </c:choose>
			
	<c:forEach begin="${pagebar.startPage}" end="${pagebar.endPage}" var="num">
		<li ><a href="mypage_point?user_id=${name}&pageNum=${num}&amount=${pagebar.cri.amount}" class="page-link">${num}</a></li>
	</c:forEach>
	
	<c:choose>
         <c:when test="${pagebar.cri.pageNum == pagebar.endPage}">
         	<li >
				<a href="mypage_point?user_id=${name}&pageNum=${pagebar.cri.pageNum}&amount=${pagebar.cri.amount}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">
				Next</a>
			</li>
         </c:when>

         <c:otherwise>
            <li >
				<a href="mypage_point?user_id=${name}&pageNum=${pagebar.cri.pageNum+1}&amount=${pagebar.cri.amount}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">
				Next</a>
			</li>
         </c:otherwise>
    </c:choose>
	
</ul>	
</body>
</html>