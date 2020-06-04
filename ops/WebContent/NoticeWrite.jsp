<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공고작성</title>
<style type="text/css">
h2 {
   text-align: center;
}

 input:not([type="radio"]), textarea {
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
      <h2>공고작성</h2>
      <form action="noticeWrite.no" method="post" enctype="multipart/form-data">
               
          <p align="center">
          <input name="title" placeholder="제목" type="text" id="title"  />
                                                                        
          <p align="center">
          <textarea id="content" placeholder="내용" name="content" cols="68" rows="20"></textarea>
          
          <p align="center">
          <input name="img" placeholder="이미지파일" type="file" id="img" />
          
          <p align="center">
          <input name="comName" placeholder="기업명" type="text" id="comName"  />
          
          <p align="center">
          <input name="ceoName" placeholder="대표이름" type="text" id="ceoName"  />
          
          <p align="center">
          <input name="address" placeholder="회사주소" type="text" id="address"  />
          
          <p align="center">
          <input name="job" placeholder="직종" type="text" id="job"  />
          
          <p align="center">
          <input name="reCruit" placeholder="모집인원" type="text" id="reCruit"  />
          
          <p align="center">
          <input name="field" placeholder="모집분야" type="text" id="field"  />
                         
          <p align="center">
          <input name="gender" placeholder="성별" type="text" id="gender"  />
          
          <p align="center">
          <input name="age" placeholder="연령" type="text" id="age"  />
          
          <p align="center">
          <input name="acadamiBg" placeholder="학력" type="text" id="acadamiBg"  />
            
          <p align="center">
          <input name="sal" placeholder="급여" type="text" id="sal"  />  
          
          <p align="center">
          <input name="endDate" placeholder="공고 종료일" type="text" id="endDate" />
            
          <p align="center">
          <input name="workTerm" placeholder="근무기간" type="text" id="workTerm" />
               
          <p align="center">
          <input name="workDay" placeholder="근무요일" type="text" id="workDay" />
            
          <p align="center">
          <input name="workTime" placeholder="근무시간" type="text" id="workTime" />
   
          <p align="center">
          <input name="workForm" placeholder="근무형태" type="text" id="workForm" />
          
          <p align="center">
          <input name="name" placeholder="담당자" type="text" id="name" />
          
          <p align="center">
          <input name="email" placeholder="이메일" type="text" id="email" />
          
          <p align="center">
          <input name="phone" placeholder="연락처" type="text" id="phone" />
          
          <p align="center">
          <input name="supportForm" placeholder="지원방식" type="text" id="supportForm" />
          
          <p align="center">
          <input name="bigo" placeholder="비고" type="text" id="bigo" />
          
          <input type="submit" value="등록">
      </form>
   
</body>
</html>