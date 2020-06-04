<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<title>Xss 공격 방어 구현</title>
<style>
	html{height:100%;}
	html,body,form,h2,input,div,textarea{margin:0; padding:0;}
	body{height:100%; min-height:616px; overflow:hidden; margin:0; background:#2d303a;  color:#fff; box-sizing: border-box; display: inline-block; /*border-style: solid;*/ 
	/*border-image: linear-gradient(90deg, #01c9ca 0%, #3886FF 100%);*/
	border-image-slice: 3; width: 100%;}
	body:before{width:99%; height:99%; padding:0 0.2%; top:50%;left:50%; transform:translate(-50%,-50%); position:absolute; z-index:-1; background:#2d303a; content:'';}
	body:after{width:170%; height:616px; top:0; left:0; position:absolute;content:''; z-index:-2;background:
		linear-gradient(#7cffdb, transparent),
		linear-gradient(-45deg, magenta, transparent),
		linear-gradient(45deg, #01c9ca, transparent);
		background-blend-mode: multiply;
		animation:HEHE 12s linear infinite;		
		
	}
	@keyframes HEHE{
	0%{transform:rotate(0deg);}
	100%{transform:rotate(360deg);}
	}
	
	input[type="text"],input[type="submit"],textarea{width:92%; margin:0 auto; padding:15px 15px; background:rgba(24, 26, 31, 0.38); font-size:14px; border:0; display:block; color:#fff;}
	input:nth-child(1){margin-top:30px;}
	form{width:100%; max-width:1200px; margin:0 auto;}
	.XSSTITLE{margin-top:15px; text-align:center; font-size:23px; font-weight:100;}
	input[type="submit"]{width:97%; margin-top:20px; padding:19px 0;  z-index:50; position:absolute;background:none;}
	#submit{width:97%; height:70px; margin:auto; position:relative; overflow:hidden; }
	#submit::after{width:250%; height:70px; content:''; top:20px; animation: HO 3s linear infinite alternate-reverse;
		/*background: -webkit-linear-gradient(left, #b927e5 2%,#7cc2ff 26%,#7c9eff 56%,#7325da 99%);*/
		background: -webkit-linear-gradient(left, #b927e5 0%,#7cffdb 37%,#7cc2ff 62%,#7c9eff 78%,#7325da 100%);
		position:absolute;
		 }
	@keyframes HO{
		0%{left:0}
		50%{left:-100px;}
		100%{left:-500px;}
	}
	
</style>
</head>
<body>
	<h2 class="XSSTITLE">XSS 방어 구현 테스트 입력창</h2>
	<form action="filtering" method="post">
		<input type="text" name="Title" placeholder="제목"><br>
		<input type="text" name="SubTitle" placeholder="서브 제목"><br>
		<textarea name="contents" style="height:300px;"></textarea>
		<div id="submit"><input type="submit"></div>
	</form>
</body>
</html>
