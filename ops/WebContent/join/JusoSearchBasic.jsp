<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta content="../../img/ops_standard_color_128dp.png" itemprop="image">
<link rel="icon" href="../../img/favicon_32-vflOogEID.png" sizes="32x32">
<link rel="icon" href="../../img/favicon_144-vfliLAfaB.png" sizes="144x144">
<script type="text/javascript" src="../../js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../../js/jquery-ui-1.12.1.min.js"></script>
<script type="text/javascript" src="../../js/rns.search-1.0.min.js"></script>
<style>
#ui-id-1{width:100% !important; left:0 !important;}
#ui-id-1>li{padding:5px 7px !important;}
</style>
<title>도로명 주소</title>

<script>
var searchTypes = ["ADDR"];
var rnsSearch = new rnsSearch({
	searchServerUrl : "https://address.ops.or.kr:8983",
	width : 500,
	height : 500,
	oncomplete : function(data) {
		$(opener.location).attr("href", "javascript:fn_setJuso(" + JSON.stringify(data) + ");");
	},
}).open({
	popupName : "ops 주소찾기",
	left : (window.screen.width / 2) - (width / 2),
	top : (window.screen.height / 2) - (height / 2),
	autoClose : false,
	farNmUseYn : "N",
	selectSigUseYn : "N",
	defaultSigCd : "00000",
	autocompleteUseYn : "Y",
	searchTypes : searchTypes
});
</script>
</head>
<body>
</body>
</html>
