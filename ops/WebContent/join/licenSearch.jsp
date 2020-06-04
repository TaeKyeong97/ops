<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사업자 등록 조회</title>
<link rel="stylesheet" href="../join/css/join.css" type="text/css">
</head>
<body style="background:#fff;">

<c:if test="${param.liceName!=null&&liceNum!=null||param.liceName!=''&&liceNum!=''}">
	<div class="lj-title-con" style="border-radius:0;">
		<h2 class="lj-title" style="margin-top:0; padding:12px 0; font-size:15px;">라이센스 조회</h2>
	</div>
	<c:choose>
		<c:when test="${lice['seq']==''||lice['seq']==null}">
			<h5 style="margin:15px 0 10px 0; text-align:center; color:red;">등록되지 않은 사업자 입니다.</h5>
			<div class="join-inp-con">
				<input type="text" value="${param.liceName}" class="ok j-inp-sty" style="width:83%;">
				<input type="text" value="${param.liceNum}" class="ok2 j-inp-sty" style="width:83%;">
				<input type="button" value="등록조회" value="0" onclick="reCk();" class="j-inp-btn">
			</div>
		</c:when>
		<c:otherwise>
			<h5 style="margin:15px 0 10px 0; text-align:center; color:blue;">인증 되었습니다.</h5>
			<div class="join-inp-con">
				<input type="text" value="${param.liceName}" class="ok j-inp-sty" style="width:83%;" readonly>
				<input type="button" value="사용하기" value="1" onclick="ok()" class="j-inp-btn" style="background:rgb(95, 121, 255);">
			</div>
		</c:otherwise>
	</c:choose>
<script>
	function ok(){
		var ok = document.getElementsByClassName("ok")[0];
		//회사명
		var company="${lice['wkplNm']}";
		//법인 개인
		<c:choose>
			<c:when test="${lice['wkplStylDvcd']=='1'}">
				var corpfom="법인";
			</c:when>
			<c:when test="${lice['wkplStylDvcd']=='2'}">
			var corpfom="개인";
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${lice['vldtVlKrnNm']!=null||lice['vldtVlKrnNm']!=''}">
				var vldtVlKrnNm="${lice['vldtVlKrnNm']}";
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${lice['jnngpCnt']!=null||lice['jnngpCnt']!=''}">
				var jnngpCnt="${lice['jnngpCnt']}";
			</c:when>
		</c:choose>
		window.opener.emokes(ok.value,company,corpfom,vldtVlKrnNm,jnngpCnt);
		window.close();
	}
	function reCk(){
		var ok=document.getElementsByClassName("ok")[0];
		var ok2=document.getElementsByClassName("ok2")[0];
		location.href="LicenceseSearch?liceName="+ok.value+"&&liceNum="+ok2.value;
	}
</script>
</c:if>
<c:if test="${param.liceName==null||liceNum==null&&param.liceName==''||liceNum==''}">
		<div class="lj-title-con" style="border-radius:0;">
		<h2 class="lj-title" style="margin-top:0; padding:12px 0; font-size:15px;">라이센스 조회</h2>
	</div>
	<c:choose>
		<c:when test="${lice==''}">
			<h5 style="margin:15px 0 10px 0; text-align:center; color:red;">등록되지 않은 사업자 입니다.</h5>
			<div class="join-inp-con">
				<input type="text" value="${param.liceName}" class="ok j-inp-sty" style="width:83%;">
				<input type="text" value="${param.liceNum}" class="ok2 j-inp-sty" style="width:83%;">
				<input type="button" value="등록조회" value="0" onclick="reCk();" class="j-inp-btn">
			</div>
		</c:when>
		<c:otherwise>
			<h5 style="margin:15px 0 10px 0; text-align:center; color:blue;">인증 되었습니다.</h5>
			<div class="join-inp-con">
				<input type="text" value="${param.liceName}" class="ok j-inp-sty" style="width:83%;" readonly>
				<input type="button" value="사용하기" value="1" onclick="ok()" class="j-inp-btn" style="background:rgb(95, 121, 255);">
			</div>
		</c:otherwise>
	</c:choose>
<script>
	function ok(){
		var ok = document.getElementsByClassName("ok")[0];
		window.opener.emokes(ok.value);
		window.close();
	}
	function reCk(){
		var ok=document.getElementsByClassName("ok")[0];
		var ok2=document.getElementsByClassName("ok2")[0];
		location.href="LicenceseSearch?liceName="+ok.value+"&&liceNum="+ok2.value;
	}
</script>
</c:if>
</body>
</html>