<%@ page import="ops.Notice.Beans.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 공고 리스트 -->
<title>공고리스트</title>
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: center;
  padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

a{text-decoration:none;
  color:black;
}
</style>
</head>
<body>
<form action="" method="post">
   <select name="searchOption" id="selectBox" style="width:100px;">   
         <option value="시도를입력하세요">서울특별시</option>  
         <option>경기도</option>
         <option>대전광역시</option>   
   </select>
   <input type="text" name = "keyword">
   <input type="submit" value="검색"><br><br>
<div style="overflow-x:hidden">
<table border="1">	
	<c:forEach var = "noticeList" items="${noticeList}">
	<tr>
		<th>번호</th>	
		<th>제목</th>
		<th>등록일</th>		
		<th>기업명</th>
		<th>대표이름</th>
		<th>회사주소</th>
		<th>직종</th>	
		<th>모집인원</th>
		<th>모집분야</th>
		<th>성별</th>
		<th>연령</th>	
		<th>학력</th>
		<th>공고종료일</th>
		<th>급여</th>
		<th>근무기간</th>
		<th>근무요일</th>
		<th>근무시간</th>
		<th>근무형태</th>
		<th>담당자</th>
		<th>이메일</th>
		<th>연락처</th>	
		<th>지원방식</th>
		<th>비고</th>
		<th>내용</th>
	</tr>
	<tr>
		<td>${noticeList.n_no}</td>
		<td><a href="noticeDetail.no?n_no=${noticeList.n_no}">${noticeList.n_title}</a></td>
		<td>${noticeList.n_date}</td>
		<td>${noticeList.n_comName}</td>
		<td>${noticeList.n_ceoName}</td>
		<td>${noticeList.n_address}</td>
		<td>${noticeList.n_job}</td>
		<td>${noticeList.n_reCruit}</td>
		<td>${noticeList.n_field}</td>
		<td>${noticeList.n_gender}</td>
		<td>${noticeList.n_age}</td>
		<td>${noticeList.n_acadamiBg}</td>
		<td>${noticeList.n_endDate}</td>
		<td>${noticeList.n_sal}</td>
		<td>${noticeList.n_workTerm}</td>
		<td>${noticeList.n_workDay}</td>
		<td>${noticeList.n_workTime}</td>
		<td>${noticeList.n_workForm}</td>
		<td>${noticeList.n_name}</td>
		<td>${noticeList.n_email}</td>
		<td>${noticeList.n_phone}</td>
		<td>${noticeList.n_supportForm}</td>
		<td>${noticeList.n_bigo}</td>
		<td>${noticeList.n_content}</td>
	</c:forEach>
</table>   
</form>
</div>
</body>
</html>