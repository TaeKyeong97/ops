<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../portfolio/view/css/common.css">
    <link rel="stylesheet" href="../portfolio/view/css/sub2.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <title>Document</title>
    <style>
    	.thum_title>div{float:left;}
    	.thum_title font{color:#000 !important;}
    </style>
    
    <script>
    		if(typeof(history.pushState) == 'function')
    		{
    		var renewURL = location.href;
    		renewURL = renewURL.replace(/\&page=([0-9]+)/ig,'');
    		function Portfolio(state){
    			if(state=="Myportfolio"){
        			renewURL = 'portfolioList?page='+"Myportfolio";
    			}else if(state=="bestPortfolio"){
        			renewURL = 'portfolioList?page='+"bestPortfolio";
    			}else{
    				renewURL = 'portfolioList?page='+"newPortfolio";
    			}
        		history.pushState(null, null, renewURL);
    		}
    		
    		}
   </script>
</head>
<body>
<div class="wrap">
    <div class="header">
        <div class="header_top">
            <div class="header_content">
                <a href="../ops/main" class="header_logo"><img src="../portfolio/view/img/logo_line2.png" alt="logo"></a>
                <div class="header_search">
                    <!--<img src="img/icon8.png" class="input_icon8" alt="search_icon"> 검색창 돋보기-->
                    <input type="text" class="input_search" name="search" placeholder="search">
                </div>
                <div class="header_portfolio">
                    <img src="../portfolio/view/img/icon1.png" alt="icon1">
                    <a href="../PORTFOLIO/portfolioWriter">포트폴리오 작성</a>
                </div>
                <div class="header_login">
                <c:choose>
          			<c:when test="${userID==null&&emID==null}">
	                    <a href="../LOGIN/login?loginCk?=0">로그인</a>
	                    <a href="../JOIN/joinV1">회원가입</a>
                  	</c:when>
	          		<c:when test="${userID!=null}">
	          			<a href="../LOGIN/login?loginCk?=0">${userID}</a>
	                    <a href="../LOGIN/logout" class="join">로그아웃</a>
	          		</c:when>
	          		<c:when test="${emID!=null}">
	          			<a href="../LOGIN/login?loginCk?=0">${emID} 기업회원 님</a>
	                    <a href="../LOGIN/logout" class="join">로그아웃</a>
	          		</c:when>
          		</c:choose>
                </div>
                <img src="../portfolio/view/img/logo_icon.png" class="logo_icon_big" alt="bigLogo">
            </div>
        </div>
        <div class="header_bottom">
            <div class="header_gnb">
                <ul class="gnb_main">
                    <li><a href="">기업 서비스</a>
                        <ul class="gnb_sub">
                            <li><a href="#"><img src="../portfolio/view/img/icon8.png" alt="">공고 작성</a></li>
                            <li><a href="#"><img src="../portfolio/view/img/icon3.png" alt="">지원자 관리</a></li>
                            <li><a href="#"><img src="../portfolio/view/img/icon5.png" alt="">채용 현황</a></li>
                            <li><a href="#"><img src="../portfolio/view/img/icon7.png" alt="">인재 정보</a></li>
                        </ul>
                    </li>
                    <li><a href="">개인 서비스</a>
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
</div>

<div class="content_wrap">
    <!--광고-->
    <div class="ad">광고영역</div>
    <!--광고-->
    <div class="tabbutton">
        <c:if test="${param.page=='bestPortfolio'}">
	        <button class="tablinks defaultOpen" onclick="tabPortfolio(event, 'bestPf');Portfolio('bestPortfolio')">BEST 포트폴리오</button>
	        <button class="tablinks" onclick="tabPortfolio(event, 'newPf');Portfolio('newPortfolio')">NEW 포트폴리오</button>
	        <button id="myPortfolio" class="tablinks" onclick="tabPortfolio(event, 'myPf');Portfolio('Myportfolio')">MY 포트폴리오</button>
        </c:if>
        <c:if test="${param.page=='Myportfolio'}">
	        <button class="tablinks" onclick="tabPortfolio(event, 'bestPf');Portfolio('bestPortfolio')">BEST 포트폴리오</button>
	        <button class="tablinks" onclick="tabPortfolio(event, 'newPf');Portfolio('newPortfolio')">NEW 포트폴리오</button>
	        <button id="myPortfolio" class="tablinks defaultOpen active" onclick="tabPortfolio(event, 'myPf');Portfolio('Myportfolio')">MY 포트폴리오</button>
        </c:if>
    </div>
    <div class="tabbox">

    		<c:if test="${param.page=='bestPortfolio'}">
		        <div class="tabcontent" id="bestPf" style="display:block;">
		            <div class="tabcontent_boxs"> <!--BEST포트폴리오의 박스3개씩(= 1줄) 추가-->
		                <div class="tabbox_3">
		                    <p class="thum_name">김태경</p> <!--포트폴리오 작성자명-->
		                    <img class="thum_heart" src="../portfolio/view/img/thum_heart.png" alt="찜">
		                    <img class="thum_star" src="../portfolio/view/img/icon_star1.png" alt="큰 별 이미지">
		                    <img class="thum_img" src="../portfolio/view/img/thum_img.png" alt="썸네일이미지">
		                    <div class="thum_desc"> <!--썸네일아래 흰색 박스-->
		                        <p class="thum_title">1일차 여행기</p>
		                        <p class="thum_subtitle">러시아 눈 덮인 산에 등산 - 사진</p>
		                        <ul class="thum_starscore">
		                            <li><img src="../portfolio/view/img/icon_smallstar10.png" alt="별점10"></li>
		                            <li><img src="../portfolio/view/img/icon_smallstar10.png" alt="별점10"></li>
		                            <li><img src="../portfolio/view/img/icon_smallstar10.png" alt="별점10"></li>
		                            <li><img src="../portfolio/view/img/icon_smallstar5.png" alt="별점5"></li>
		                            <li><img src="../portfolio/view/img/icon_smallstar0.png" alt="별점0"></li>
		                        </ul>
		                        <p class="thum_categorytxt">카테고리 <span class="thum_category">요리</span></p>
		                    </div>
		                </div>
		                <div class="tabbox_3">
		    
		                </div>
		                <div class="tabbox_3">
		    
		                </div>
		            </div>
		        </div>
        </c:if>
        <c:if test="${param.page!='bestPortfolio'}">
        	<div class="tabcontent"id="bestPf" style="display:none;">		        
	        </div>
        </c:if>
        <c:if test="${param.page=='newPortfolio'}">
        <div class="tabcontent" id="newPf" style="display:block;">
            <div class="tabbox_3">

            </div>
            <div class="tabbox_3">

            </div>
            <div class="tabbox_3">

            </div>
        </div>
        </c:if>
        <c:if test="${param.page!='newPortfolio'}">
        <div class="tabcontent" id="newPf" style="display:none;">
        </div>
        </c:if>
        
        	<c:if test="${param.page=='Myportfolio'}">
		       	<div class="tabcontent"id="myPf" style="display:block;">
		        
		        	<script>
		        	$(document).ready(function(){
		        		$.fn.myPortfolioLoad();
		        	});
		        	</script>
		        
		        </div>
        	</c:if>
        	<c:if test="${param.page!='Myportfolio'}">
		       	<div class="tabcontent"id="myPf" style="display:none;">		        
		        </div>
        	</c:if>
    </div>
    <div class="text_center"><button class="tab_btn_more"><img src="../portfolio/view/img/icon_more2.png" alt="더보기"> 더보기</button></div>
</div>

</body>
<script>   //임시방편
    $(function(){
        $('.gnb_main').mouseenter(function(){
            $('.gnb_sub').show()
            $('.gnb_bg').show()
            $('.visual').show()
        })
        $('.header_gnb').mouseleave(function(){
            $('.gnb_sub').hide()
            $('.gnb_bg').hide()
            $('.visual').hide()
        })
    })
    document.getElementsByClassName("defaultOpen")[0].click();

    function tabPortfolio(evt, btnName) {
        // Declare all variables
        var i, tabcontent, tablinks;

        // Get all elements with class="tabcontent" and hide them
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }

        // Get all elements with class="tablinks" and remove the class "active"
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }

        // Show the current tab, and add an "active" class to the button that opened the tab
        document.getElementById(btnName).style.display = "block";
            evt.currentTarget.className += " active";
     }
    	
</script>
<script src="../portfolio/js/portfolio.js"></script>
</html>