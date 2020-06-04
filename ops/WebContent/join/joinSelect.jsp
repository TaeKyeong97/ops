<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OPS : 회원가입</title>
<link rel="stylesheet" href="../join/css/join.css" type="text/css">
<link rel="stylesheet" href="../css/common.css" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic&display=swap&subset=korean" rel="stylesheet">
<style>
	.join-header{margin-top:190px;}
	.join-content{width:100%; padding:0; border-radius:0; border:1px solid #dedfe6;background:#fff;}
	.select>li{width:49%; padding:23px 0; float:left; list-style:none; text-align:center;}	
	.select>li>a{padding:28px 0; display:block; font-size:24px; font-weight:200; font-family: 'Nanum Gothic', sans-serif;}
	a{color:#000; text-decoration:none;}
</style>
</head>
<body>
<div id="join-wrap">
	<div class="join-header">
		<h1 class="logo"><a href="../ops/main"></a></h1>
	</div>
	<div class="join-content">
		<ul class="select">
			<li>
				<a href="../JOIN/joinV1" style="border-right:1px solid #dedfe6;">일반회원 가입</a>
			</li>
			<li>
				<a href="../JOIN/joinV2">기업회원 가입</a>
			</li>
		</ul>
	</div>
</div>
<div class="footer">
<a href="#">© OPS Corp.</a>
</div>
</body>
</html>
