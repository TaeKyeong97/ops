<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../member/css/common.css">
    <link rel="stylesheet" href="../member/css/useredit.css">
    <title>회원정보</title>
</head>
<body>	
<div class="wrap">
    <div class="header">
        <div class="header_top">
            <div class="header_content">
                <a href="../ops/main" class="header_logo"><img src="../member/img/logo_line2.png" alt="logo"></a>
                <div class="header_search">
                    <!--<img src="img/icon8.png" class="input_icon8" alt="search_icon"> 검색창 돋보기-->
                    <input type="text" class="input_search" name="search" placeholder="search">
                </div>
                <div class="header_portfolio">
                    <img src="../member/img/icon1.png" alt="icon1">
                    <a href="portfolio.html">포트폴리오 작성</a>
                </div>
                <div class="header_login">
                	<c:choose>
          				<c:when test="${userID==null&&emID==null}">
                    <a href="login.html">로그인</a>
                    <a href="register.html">회원가입</a>
					</c:when>
		          	<c:when test="${userID!=null}">
			            <a href="../myInfo/myPage" class="login">${userID}</a>
			            <a href="../LOGIN/logout" class="join">로그아웃</a>
		          	</c:when>
		          	<c:when test="${emID!=null}">
			            <a href="../myInfo/myPage" class="login">${emID} 기업회원 님</a>
			            <a href="../LOGIN/logout" class="join">로그아웃</a>
		          	</c:when>
		          </c:choose>
                </div>
                <img src="../member/img/logo_icon.png" class="logo_icon_big" alt="bigLogo">
            </div>
        </div>
        <div class="header_bottom">
            <div class="header_gnb">
                <ul class="gnb_main">
                    <li class="menu"><a href="">기업 서비스</a>
                        <ul class="gnb_sub">
                            <li><a href="#"><img src="../member/img/icon8.png" alt="">공고 작성</a></li>
                            <li><a href="#"><img src="../member/img/icon3.png" alt="">지원자 관리</a></li>
                            <li><a href="#"><img src="../member/img/icon5.png" alt="">채용 현황</a></li>
                            <li><a href="#"><img src="../member/img/icon7.png" alt="">인재 정보</a></li>
                        </ul>
                    </li>
                    <li class="menu"><a href="">개인 서비스</a>
                        <ul class="gnb_sub">
                            <li><a href="#"><img src="" alt="">가</a></li>
                            <li><a href="#"><img src="" alt="">나</a></li>
                            <li><a href="#"><img src="" alt="">다</a></li>
                            <li><a href="#"><img src="" alt="">라</a></li>
                        </ul>
                    </li>
                    <li><a href="">스터디 그룹</a>
                        <ul class="gnb_sub">
                            <li><a href=""><img src="" alt="">가</a></li>
                        </ul>
                    </li>
                </ul>
                <div class="gnb_bg"></div>
            </div>
            <div class="visual"></div>
        </div>
    </div> <!-- /.header-->
</div> <!-- /.wrap-->

<div class="content_wrap">

    <div class="useredit ud_box1">
        <div class="ud1_img">
            <a href="#"><img src="../member/img/personimg.jpg" alt="프로필이미지"></a>
        </div>
        <p class="ud1_name">${userID==mb.id}</p>
        <p class="ud1_id">@${mb.id}</p>
    </div><!--/.useredit ud_box1-->
    <form class="useredit ud_box3" method="post" action="myInfoChangePro">
        <input type="text" name="id" ${myInfo.id} placeholder="아이디" disabled style="display:none;">
		<input class="ud3_pw2" type="password" name="pw" value="" placeholder="새로운 비밀번호">
		<input class="ud3_pw2" type="password" placeholder="비밀번호 확인">
		<input class="ud3_phone" type="text" name="phone" value="${myInfo.phone}" placeholder="휴대폰번호">
        <input class="ud3_email" type="text" name="email" value="${myInfo.email}" placeholder="이메일">
        <input class="ud3_submit" type="submit" value="정보 수정">
    </form><!--/.useredit ud_box3-->
</div>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script>   //임시방편
    $(function(){
        $('.gnb_main').on('focusin mouseenter', function(){
            $('.gnb_sub').show()
            $('.gnb_bg').show()
            $('.visual').show()
            $(this).next().css('display','block');
        })
        $('.header_gnb').mouseleave(function(){
            $('.gnb_sub').hide()
            $('.gnb_bg').hide()
            $('.visual').hide()
        })
        $('.header_login').focus(function(){
            $('.gnb_sub').hide()
            $('.gnb_bg').hide()
            $('.visual').hide()
        })
    })
</script>
</html>