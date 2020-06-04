<%@page import="ops.Notice.Beans.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Q&amp;A 조회</title>
<style type="text/css">
h2 {
   text-align: center;
}

input{
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;

 }
.sec{
	width:120px;
	margin:0 auto;
}
.bluetop {
  border-collapse: collapse;
  border-top: 3px solid gray;
}  
.bluetop th {
  color: black;
  background: #f2f2f2;
}
.bluetop th, .bluetop td {
  padding: 10px;
  border: 1px solid #ddd;
}

.bluetop th:first-child, .bluetop td:first-child {
  border-left: 0;
}
.bluetop th:last-child, .bluetop td:last-child {
  border-right: 0;
}
</style>
</head>

<body>
	<table class="bluetop" width="75%" align="center">
   		
        <colgroup>
            <col width="15%">
            <col width="35%">
            <col width="15%">
            <col width="*">
        </colgroup>
         
        <tbody>
            <tr>
                <th>번호</th>
                <td>${detail.q_no}</td>
                <th>제목</th>
                <td>${detail.q_title}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td>${detail.q_content}</td>
                <th>작성일</th>
                <td>${detail.q_date}</td>
            </tr>
        </tbody>
   </table>
   <div class="sec">
   <input type = "button" value="수정" onclick="location.href='questionModify.no?q_no=${detail.q_no}'">
   <input type = "button" value="삭제" onclick="location.href='questionDelete.no?q_no=${detail.q_no}'">
   </div>
</body>
</html>