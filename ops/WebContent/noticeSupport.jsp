<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고 지원</title>
</head>
<body>
<table border="1">
	<c:forEach var = "managementList" items="${managementList}">
		<tr>
			<th>번호</th>
		</tr>
		<tr>
			<td>${managementList.m_no}</td>	
		</tr>
	</c:forEach>
</table>	
</body>
</html>