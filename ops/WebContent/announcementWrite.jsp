<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항작성</title>
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
      <h2>공지사항작성</h2>
      <form action="announcementWrite.no" method="post" enctype="multipart/form-data">
           
          <p align="center">
          <input name="id" placeholder="아이디" type="text" id="id" value="rlwnd0000" />
               
          <p align="center">
          <input name="title" placeholder="제목" type="text" id="title"  />
                                                                        
          <p align="center">
          <textarea id="content" placeholder="내용" name="content" cols="68" rows="20"></textarea>
          
          <p align="center">
          <input name="img" placeholder="이미지파일" type="file" id="img" />
          
          <input type="submit" value="등록">
      </form>
   
</body>
</html>