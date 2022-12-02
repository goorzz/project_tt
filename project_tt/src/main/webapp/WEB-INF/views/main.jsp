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
 <h1>메인화면 (test중)</h1>
 	<form action="/main" method="post">
		<input type="text" id ="user_id1"name="user_id" placeholder="아이디"><br>
		<input type="password" id ="user_pw1"name="user_pw" placeholder="비밀번호"><br>
		<input type="submit" onclick="test()" value="로그인">
	</form>
 	<input type="button" value="회원가입" onclick="location.href='/membership'" style="width: 125px; height: 56px">
 	<input type="button" value="ID/PW찾기" onclick="location.href='/searchID'" style="width: 125px; height: 56px"> <br>
 	<input type="button" value="게시판" onclick="location.href='/board/list'" style="width: 125px; height: 56px">
 	
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script type="text/javascript">
  function test() {
	  var userId = document.getElementById("user_id1").value;
      var userPwd = document.getElementById("user_pw1").value;
      if(userId == "") {
          alert("아이디를 입력해주세요.");
          return false;
      }
      else if(userPwd == "") {
          alert("비밀번호를 입력해주세요.");
          return false;
      }

  }
  </script>
 	<div class="table.type07"></div>
	<table>
    <h1>조별 순위 보기</h1>
		<!-- 월드컵 조별 보여주기 -->
    	<c:forEach items="${g_list}" var="g_list">
    		    	<button class="a" type="button" onclick="location.href='/group?r_group=${g_list}'">${g_list}</button>&nbsp;
   		</c:forEach>

        <thead>
			<tr>
				<td><center>그룹</center></td>
				<td><center>순위</center></td>
				<td><center>나라이름</center></td>
				<td><center>경기수</center></td>
				<td><center>승</center></td>
				<td><center>무</center></td>
				<td><center>패</center></td>
				<td><center>골득실</center></td>
				<td><center>승점</center></td>
			</tr>
        </thead>
        <tbody>
            <c:forEach items="${group}" var="group">
                <tr>
                    <td><center>${group.r_group}</center></td>
                    <td><center>${group.r_rank}</center></td>
                    <td><center>${group.r_name}</center></td>
                    <td><center>${group.r_count}</center></td>
                    <td><center>${group.r_win}</center></td>
                    <td><center>${group.r_draw}</center></td>
                    <td><center>${group.r_lose}</center></td>
                    <td><center>${group.r_gain}</center></td>
                    <td><center>${group.r_wincount}</center></td>
                </tr>
            </c:forEach>
        </tbody>
        </table>
        <br>
        <!-- new기사 -->
   		<table>
   			   <tbody>
				<tr>
				<h2>날짜 별 뉴스 TOP 5</h2>
	            	<td><center>날짜</center></td>
	            	<td><center>뉴스 기사</center></td>
	            	<td><center>순위</center></td>
				</tr>
            <c:forEach items="${news}" var="news">
                <tr>
                    <td><center>${news.n_date}</center></td>
                    <td><center><a href="http://${news.n_url}">${news.n_title}</a></center></td>
                    <td><center>${news.n_no}</center></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    	<br>
    <table>
    	<!--                      경기일정						 -->
    		<h2>오늘 경기일정</h2>
    			<button class="day1" type="button" onclick="location.href='/gametime?month1=11&date=21&r_group=${group}'">11월21일(수)</button>&nbsp;
    			<button class="day2" type="button" onclick="location.href='/gametime?month1=11&date=22&r_group=${group}'">11월22일(수)</button>&nbsp;
		    	<button class="day3" type="button" onclick="location.href='/gametime?month1=11&date=23&r_group=${group}'">11월23일(수)</button>&nbsp;
		    	<button class="day4" type="button" onclick="location.href='/gametime?month1=11&date=24&r_group=${group}'">11월24일(목)</button>&nbsp;
		    	<button class="day5" type="button" onclick="location.href='/gametime?month1=11&date=25&r_group=${group}'">11월25일(금)</button>&nbsp;
		    	<button class="day6" type="button" onclick="location.href='/gametime?month1=11&date=26&r_group=${group}'">11월26일(토)</button>&nbsp;
		    	<button class="day7" type="button" onclick="location.href='/gametime?month1=11&date=27&r_group=${group}'">11월27일(일)</button>&nbsp;
		    	<button class="day8" type="button" onclick="location.href='/gametime?month1=11&date=28&r_group=${group}'">11월28일(월)</button>&nbsp;
		    	<button class="day9" type="button" onclick="location.href='/gametime?month1=11&date=29&r_group=${group}'">11월29일(화)</button>&nbsp;
		    	<button class="day10" type="button" onclick="location.href='/gametime?month1=11&date=30&r_group=${group}'">11월30일(수)</button>&nbsp;
		    	<button class="day11" type="button" onclick="location.href='/gametime?month1=12&date=1&r_group=${group}'">12월1일(목)</button>&nbsp;
		    	<button class="day12" type="button" onclick="location.href='/gametime?month1=12&date=2&r_group=${group}'">12월2일(금)</button>&nbsp;
		    	<button class="day13" type="button" onclick="location.href='/gametime?month1=12&date=3&r_group=${group}'">12월3일(토)</button>&nbsp;
		    	<button class="day14" type="button" onclick="location.href='/gametime?month1=12&date=4&r_group=${group}'">12월4일(일)</button>&nbsp;
		    	<button class="day15" type="button" onclick="location.href='/gametime?month1=12&date=5&r_group=${group}'">12월5일(월)</button>&nbsp;<br>
		    	<button class="day16" type="button" onclick="location.href='/gametime?month1=12&date=6&r_group=${group}'">12월6일(화)</button>&nbsp;
		    	<button class="day17" type="button" onclick="location.href='/gametime?month1=12&date=7&r_group=${group}'">12월7일(수)</button>&nbsp;
		    	<button class="day18" type="button" onclick="location.href='/gametime?month1=12&date=8&r_group=${group}'">12월8일(목)</button>&nbsp;
		    	<button class="day19" type="button" onclick="location.href='/gametime?month1=12&date=9&r_group=${group}'">12월9일(금)</button>&nbsp;
		    	<button class="day20" type="button" onclick="location.href='/gametime?month1=12&date=10&r_group=${group}'">12월10일(토)</button>&nbsp;
		    	<button class="day21" type="button" onclick="location.href='/gametime?month1=12&date=11&r_group=${group}'">12월11일(일)</button>&nbsp;
		    	<button class="day22" type="button" onclick="location.href='/gametime?month1=12&date=12&r_group=${group}'">12월12일(월)</button>&nbsp;
		    	<button class="day23" type="button" onclick="location.href='/gametime?month1=12&date=13&r_group=${group}'">12월13일(화)</button>&nbsp;
		    	<button class="day24" type="button" onclick="location.href='/gametime?month1=12&date=14&r_group=${group}'">12월14일(수)</button>&nbsp;
		    	<button class="day25" type="button" onclick="location.href='/gametime?month1=12&date=15&r_group=${group}'">12월15일(목)</button>&nbsp;
		    	<button class="day26" type="button" onclick="location.href='/gametime?month1=12&date=16&r_group=${group}'">12월16일(금)</button>&nbsp;
		    	<button class="day27" type="button" onclick="location.href='/gametime?month1=12&date=17&r_group=${group}'">12월17일(토)</button>&nbsp;
		    	<button class="day28" type="button" onclick="location.href='/gametime?month1=12&date=18&r_group=${group}'">12월18일(일)</button>&nbsp;
		    	<button class="day29" type="button" onclick="location.href='/gametime?month1=12&date=19&r_group=${group}'">12월19일(월)</button>&nbsp;
		    	
					
         <thead>
            <tr>
					<td><center>순위</center></td>
					<td><center>경기날짜</center></td>
					<td><center>조</center></td>
					<td><center>경기시간</center></td>
					<td><center>홈</center></td>
					<td><center>어웨이</center></td>
					<td><center>홈 스코어</center></td>
					<td><center>어웨이 스코어</center></td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${schedule}" var="schedule">
                <tr>
                    <td><center>${schedule.p_no}</center></td>
                    <td><center>${schedule.date}</center></td>
                    <td><center>${schedule.w_group}</center></td>
                    <td><center>${schedule.time}</center></td>
                    <td><center>${schedule.name_1}</center></td>
                    <td><center>${schedule.name_2}</center></td>
                    <td><center>${schedule.score_1}</center></td>
                    <td><center>${schedule.score_2}</center></td>
                </tr>
            </c:forEach>
           	 <c:forEach items="${schedulelist1}" var="user1">
                <tr>
                    <td>${user1.p_no}</td>
                    <td>${user1.date}</td>
                    <td>${user1.w_group}</td>
                    <td>${user1.time}</td>
                    <td>${user1.name_1}</td>
                    <td>${user1.name_2}</td>
                    <td>${user1.score_1}</td>
                    <td>${user1.score_2}</td>
                </tr>
            </c:forEach>
            
            
        </tbody>
        </table>
        <br>   		 
  
</body>
</html>