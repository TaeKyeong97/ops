<%@ page import="ops.Notice.Beans.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
	<title>Q&amp;A 수정</title>
<style type="text/css">
input, textarea {
  width: 50%;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  
 }
 
   h2{
      text-align: center;
   }

</style>
</head>
<body>
<h2>Q&amp;A수정</h2><br>

<form action="questionModifyPro.no" method="post" name = "modifyform">
	<input type = "hidden" name = "q_no" value = "${q.q_no}"/>
	
	<p align="center">
	<input name ="title" placeholder="제목" type="text" id="title" value ="${q.q_title}"/>
           
	<p align="center">
	<textarea id="content" placeholder="내용" name="content" cols="68" rows="20">${q.q_content}</textarea>
			  
	<input type="submit" value="수정">
	<input type="button" value="뒤로" class="suc" onclick="javascript:window.history.back();">
	
</form>
</body>
</html>