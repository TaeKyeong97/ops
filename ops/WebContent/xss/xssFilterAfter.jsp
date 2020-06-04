<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>필터링</title>
	<style>
	body{background:#2d303a;}
	h2{color:#fff; font-weight:400;}
	textarea,input{width:97%; max-width:1900px; margin:0 auto; background:rgb(44, 47, 53); color:#fff; border:1px solid; display:block;}
	#contents{color:#fff}
	#content{color:#00ff0a;}
	.Title,.subTitle{color:#00ff0a;}
	.info-filter{margin:5px 40px 0 0; float:right;}
	.info-filter>div{float:left; color:#fff; font-size:13px;}
	.info-filter>div>span{display:block; float:left;}
	.info-filter>div>span::before{width:20px; height:20px; margin:0 5px 0 15px; content:''; background:#2d303a; border:1px solid #00ff0a; display:block; float:left;}
	.info-filter>div>span:nth-child(1)::before{border-color:#fff;}
	.Error-con{padding:19px; top:50%; left:50%; transform:translate(-50%,-50%); position:absolute; color:#fff; border:1px solid #fff; background-color:#292b33;}
	</style>
</head>
<body>	
	<c:choose>
		<c:when test="${FilterMode=='Developer'}">
			<div style="color:#fff;">${FilterMode}</div>
			<div class="info-filter">
				<div style="line-height:23px;"><b>표시</b></div>
				<div><span></span><div style="line-height:23px; float:left;">필터링 안됨</div><span></span><div style="line-height:22px; float:left;">필터링됨</div></div>
			</div>
			<h2>넘겨 받은 내용</h2>
			<textarea id='contents' style='height:70px;'>${content}</textarea><br>	
			<h2>필터링 내용</h2>
			<textarea id='content' style='height:170px;'>${contentFilter}</textarea><br>
			<h2>필터링 제목</h2>
			<input class='Title' type='text' value="${Title}" style='height:70px;'><br>
			<h2>필터링 서브제목</h2>
			<input class='subTitle' type='text' value="${subTitle}" style='height:70px;'><br>
			<c:if test="${ASCIINumber=='1'}">
				<div style='margin-top: 15px;color: white;position: fixed;top: 0;transform: translate(-50%,0);left: 50%;padding: 6px 10px;background: #f00;border-radius: 21px;font-size: 13px;'>ASCII CODE가 감지되었습니다.</div>
			</c:if>
		</c:when>
		<c:when test="${FilterMode=='General'}">
			<div class="Error-con" style="border:0; border-top:1px solid #41b7da;">
				<div class="ErrorInfo" style="margin-bottom:12px; padding-bottom:5px; border-bottom:1px solid #ffffff14">처리중...</div>
				<div class="ErrorInfo">위협 검사 중입니다.</div>
				<div class="ErrorInfo">본 화면이 장시간 유지된다면 관리자에게 문의하십시오</div>
			</div>
		</c:when>
	</c:choose>
</body>
</html>