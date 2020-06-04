<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="career/css/common.css">
<link rel="stylesheet" href="career/css/resume1.css">
<title>이력서</title>
</head>
<body>
	
	<div class="wrap">
    <div class="header">
        <div class="header_top">
            <div class="header_content">
                <a href="ops/main" class="header_logo"><img src="career/img/logo_line2.png" alt="logo"></a>
                <div class="header_search">
                    <!--<img src="img/icon8.png" class="input_icon8" alt="search_icon"> 검색창 돋보기-->
                    <input type="text" class="input_search" name="search" placeholder="search">
                </div>
                <div class="header_portfolio">
                    <img src="career/img/icon1.png" alt="icon1">
                    <a href="portfolio.html">포트폴리오 작성</a>
                </div>
                <div class="header_login">
                    <a href="login.html">로그인</a>
                    <a href="register.html">회원가입</a>
                    <a href="insertUnique.jsp">기업인증</a>
                </div>
                <img src="career/img/logo_icon.png" class="logo_icon_big" alt="bigLogo">
            </div>
        </div>
        <div class="header_bottom">
            <div class="header_gnb">
                <ul class="gnb_main">
                    <li class="menu"><a href="">기업 서비스</a>
                        <ul class="gnb_sub">
                            <li><a href="#"><img src="career/img/icon8.png" alt="">공고 작성</a></li>
                            <li><a href="#"><img src="career/img/icon3.png" alt="">지원자 관리</a></li>
                            <li><a href="#"><img src="career/img/icon5.png" alt="">채용 현황</a></li>
                            <li><a href="#"><img src="career/img/icon7.png" alt="">인재 정보</a></li>
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
                    <li class="menu">
			            <a href="questionList.no">고객센터</a>
			            <ul class="gnb_sub">
			              <li><a href="questionList.no"><span class="opsLogo i_con i_conE"></span><span class="text">자주묻는 질문</span></a></li>
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
	<div>
		<a href="careerDeletePro.ops2?ca_no=${param.ca_no}">수정</a>
		<a href="careerDeletePro.ops2?ca_no=${param.ca_no}">삭제</a>
	</div>
    <div class="resumepage">
        <div class="resume_title" style="font-size: 22px; font-weight: 500;">" ${view.ca_title} "</div>
        <div class="work_type">--</div>
        <div class="resume_thum"><img src="MyImage/${mName.id}/profile/${mName.profile}" alt="이력서 본인사진"></div>
        <ul class="resume_profile_1">
            <li><span>${mName.name}&nbsp;</span>${mName.sex} 23세 / 1997년생</li>
            <li><span>휴대폰&nbsp;&nbsp;</span>${mName.phone}</li>
            <li><span>이메일&nbsp;&nbsp;</span>${mName.email}</li>
            <li><span>주소&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>${view.roadAddr}</li>
        </ul>
        <p class="oneline">최선을 다하겠습니다. (한마디)</p>
        <h3>희망근무조건</h3>
        <div class="resume_profile_2">
            <ul>
                <li>근무지</li>
                <li>${fn:split(view.roadAddr,' ')[1]}</li>
            </ul>
            <ul>
                <li>근무기간</li>
                <li>--</li>
            </ul>
            <ul>
                <li>근무형태</li>
                <li>정규직</li>
            </ul>
            <ul>
                <li>급여</li>
                <li>${view.ca_sal}</li>
            </ul>
        </div><!--/.resume_profile_2-->
        <h3>근무가능 요일</h3>
        <div class="abledate">
            <ul>
                <li class="abd_blue">월</li>
                <li class="abd_blue">화</li>
                <li class="abd_blue">수</li>
                <li class="abd_blue">목</li>
                <li class="abd_blue">금</li>
                <li class="">토</li>
                <li class="">일</li>
                <li class="abd_txt abd_blue">주 5일</li>
                <li class="abd_txt">주 7일</li>
                <li class="abd_txt">회사내규에 따름</li>
            </ul>
        </div>
        <h3>학력<span class="h3_minitxt">최종학력</span></h3>
        <div class="profile pr3"> 
            <ul>
                <li>재학기간</li>
                <li>구분</li>
                <li>학교명</li>
                <li>전공</li>
                <li>학점</li>
            </ul>
            <ul>
                <li>-</li>
                <li>${view.ca_acadamiBg}</li>
                <li>${view.ca_schoolName}</li>
                <li>컴퓨터공학</li>
                <li>3.0</li>
            </ul>
             
        </div><!--/.profile pr3-->
        <h3>자격증</h3>
        <div class="profile pr4"> 
            <ul>
                <li>종류</li>
                <li>등급</li>
                <li>취득일</li>
                <li>발행처</li>
            </ul>
            <ul>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>  
        </div><!--/.profile pr4-->
        <h3>외국어</h3>
        <div class="profile pr5"> 
            <ul>
                <li>구분</li>
                <li>점수</li>
            </ul>  
            <ul>
                <li></li>
                <li></li>
            </ul>
        </div><!--/.profile pr5-->
        <h3>포트폴리오</h3>
        <c:set var="sta" value="0" />
        <c:forEach var="pbl" items="${pbl}" varStatus="status">
        <c:set var="sta" value="${status.index+1}" />
        <div class="resume_list rsl">
            <p><c:out value="${sta}" /></p>
            <p><span><a href="PORTFOLIO/PortfolioView?no=${pbl.no}&&layout=${pbl.layout}" target="_blank">${pbl.title}</a></span></p>
            <p><span>레이아웃  : </span><span>${pbl.layout}</span></p>
        </div>
        </c:forEach>
        <c:forEach var="sfile" items="${sfile}" varStatus="status">
        <c:set var="sta" value="${sta+1}" />
        <div class="resume_list rsl">
            <p>${sta}</p>
            <p><span><a href="">${sfile.fileName}</a></span></p>
            <p><span>형식  : </span><span>파일</span></p>
        </div>
        </c:forEach>
        
        <!--<div class="resume_link rsl">
            <img src="career/img/icon_link.png" alt="링크아이콘">
            <p><a href="#">http://korea.ho.kr/test</a> <span class="rsl_tip">링크</span></p>
        </div>-->
    </div><!--/.resumepage-->

</div><!--/.content_wrap-->
<%@ include file="../footerNoParent.jsp" %>
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

</body>
</html>