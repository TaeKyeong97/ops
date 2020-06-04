<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&amp;A작성</title>
<style type="text/css">
h2 {
   text-align: center;
}

 input, textarea {
  width: 50%;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
 }

</style>
</head>
<body>
<h2>Q&amp;A작성</h2>
	<form action="questionWrite.no" method="post">
		<p align="center">
		<input name="title" placeholder="제목" type="text" id="title"  />
		                                                                        
		<p align="center">
		<textarea id="content" placeholder="내용" name="content" cols="68" rows="20"></textarea>
		          
		<input type="submit" value="등록">
	</form>  
</body>
</html>