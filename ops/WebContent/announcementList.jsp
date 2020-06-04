<%@ page import="ops.Notice.Beans.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>공지리스트</title>
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
<div style="overflow-x:hidden">
<table border="1">	
	<c:forEach var = "announcementList" items="${announcementList}">
	<tr>
		<th>번호</th>	
		<th>아이디</th>
		<th>제목</th>		
		<th>내용</th>
		<th>등록일</th>
		<th>이미지</th>
	</tr>
	<tr>
		<td>${announcementList.a_no}</td>
		<td>${announcementList.a_id}</td>
		<td><a href="announcementDetail.no?a_no=${announcementList.a_no}">${announcementList.a_title}</a></td>
		<td>${announcementList.a_content}</td>
		<td>${announcementList.a_date}</td>
		<td>${announcementList.a_img}</td>
	</c:forEach>
</table>   
</div>
</body>
</html>