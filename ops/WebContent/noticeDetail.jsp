<%@page import="ops.Notice.Beans.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 공고 조회 -->
<title>공고 조회</title>
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
                <th>제목</th>
                <td>${detail.n_title}</td>
                <th>작성일</th>
                <td>${detail.n_date}</td>
            </tr>
            <tr>
                <th>기업명</th>
                <td>${detail.n_comName}</td>
                <th>대표이름</th>
                <td>${detail.n_ceoName}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    ${detail.n_content}
                </td>
            </tr>
        </tbody>
   </table>
   <div class="sec">
   <input type = "button" value="수정" onclick="location.href='noticeModifyForm.no?n_no=${detail.n_no}'">
   <input type = "button" value="삭제" onclick="location.href='noticeDelete.no?n_no=${detail.n_no}'">
   </div>
   <center>
   <input type = "text" value = "rlwnd0000"/>
   <input type = "button" value="지원하기" onclick="location.href='noticeSupport.no?n_no=${detail.n_no}'"></center>
</body>
</html>