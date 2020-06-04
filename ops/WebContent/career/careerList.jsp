<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 리스트 페이지</title>
<meta name="theme-color" content="#1c69f5"/>
<link rel="stylesheet" href="css/common.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" href="css/main-Media.css">
<link rel="stylesheet" href="write/css/career.css">
<meta content="images/main/ops_standard_color_128dp.png" itemprop="image">
<link rel="icon" href="images/main/favicon_32-vflOogEID.png" sizes="32x32">
<link rel="icon" href="images/main/favicon_144-vfliLAfaB.png" sizes="144x144">
<style>
	.wrap{width:100%; max-width:1160px; margin:60px auto;}
	.careerList{width:46%; margin:20px 1%; background:#fff; border:1px solid #dedfe6; float:left;}
	.profile{width:131px; height:167px; border-right:1px solid #dedfe6; overflow:hidden; float:left;}
	.cont{float:left;}
	html,body{height:100%;}
	.apc_manage{overflow:hidden;}
	.wrap{min-height:100%;}
</style>
</head>
<body>
	<header id="header5">
      <div class="header_con">
        <div class="header_wrap">
          <h2 class="logo_con"><a href="ops/main"><span class="opsLogo">OPS</span></a></h2>
          <div class="sech_wrap">
            <form action="search/search?locals=&indu=&req=null&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=" method="get">
	           	<div style="display:none;">
        			<input type="text" name="locals">
        			<input type="text" name="indu">
        			<input type="text" name="req">
        			<input type="text" name="detailSett">
        			<input type="text" name="locDedetailSett" value="all">
        			<input type="text" name="induDeDedetailSett">
        			<input type="text" name="reqsSett">
        			<input type="text" name="reqsSettAB">
	           	</div>
	            <input class="sech_con" type="text" name="query" title="검색어 입력" value="${param.query}" autocomplete="off">
	            <input class="sech_butt" type="submit">
            </form>
          </div>
        </div>
        <aside id="gnb">
          <a href="#" class="pp_wr"><span></span>포트폴리오 작성</a>
          <c:choose>
          	<c:when test="${userID==null&&$emID==null}">
	          <div class="login_wrap">
	            <a href="../LOGIN/login?loginCk?=0" class="login">로그인</a>
	            <a href="../JOIN/joinV1" class="join">회원가입</a>
	          </div>
          	</c:when>
          	<c:when test="${userID!=null}">
	          <div class="login_wrap">
	            <a href="../LOGIN/login?loginCk?=0" class="login">${userID}</a>
	            <a href="../LOGIN/logout" class="join">로그아웃</a>
	          </div>
          	</c:when>
          	<c:when test="${emID!=null}">
	          <div class="login_wrap">
	            <a href="../LOGIN/login?loginCk?=0" class="login">${userID}</a>
	            <a href="../LOGIN/logout" class="join">로그아웃</a>
	          </div>
          	</c:when>
          </c:choose>
        </aside>
        <div class="cqu_icon"></div>
      </div>
      <nav class="sub_nav_wrap">
        <h3 class="acc">메뉴서비스</h3>
        <ul style="position:absolute;">
          <li>
            <h4><a href="#">기업서비스</a></h4>
            <ul class="sub_menu">
              <li><a href="noticeWriteForm.no"><span class="opsLogo i_con i_con_PublWrit"></span><span class="text">공고작성</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_Rec"></span><span class="text">채용현황</span></a></li>
              <li><a href="noticCareerLists.no"><span class="opsLogo i_con i_con_VolOffi"></span><span class="text">지원자 관리</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_userInf"></span><span class="text">인재 정보</span></a></li>
            </ul>
          </li>
          <li>
            <h4><a href="#">개인서비스</a></h4>
            <ul class="sub_menu">
              <li><a href="#"><span class="opsLogo i_con i_conE"></span><span class="text">포트폴리오</span></a></li>
              <li><a href="PORTFOLIO/portfolioList?page=bestPortfolio"><span class="opsLogo i_con i_conF"></span><span class="text">BEST 포트폴리오</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conG"></span><span class="text">관심 기업정보</span></a></li>
              <li><a href="PORTFOLIO/portfolioList?page=Myportfolio"><span class="opsLogo i_con i_conH"></span><span class="text">MY 포트폴리오</span></a></li>
              <li><a href="careerWriteForm.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">이력서 작성</span></a></li>
              <li class="reaction_type"><a href="careerList.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
            </ul>
          </li>
          <li>
            <h4><a href="questionList.no">고객센터</a></h4>
            <ul class="sub_menu">
              <li><a href="questionList.no"><span class="opsLogo i_con i_conE"></span><span class="text">자주묻는 질문</span></a></li>
            </ul>
          </li>
        </ul>
      </nav>
    </header>
    <div class="wrap">    	
   		<c:forEach var="careerList" items="${careerList}" varStatus="status">
    		<div class="careerList">
	    		<div class="profile"><img src="MyImage/${myId}/profile/${myProfile}" style="height:100%;"></div>
	    		<div class="cont">
	    			<div class="title"><a href="careerDetail.ops2?ca_no=${careerList.ca_no}" style="font-size: 18px; padding: 25px; display: block;">${careerList.ca_title}</a></div>
	    		</div>
    		</div>
   		</c:forEach>    	
    </div>
	<%@ include file="../footerNoParent.jsp" %>
</body>
</html>