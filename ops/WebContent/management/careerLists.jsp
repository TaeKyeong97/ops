<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기업 공고 리스트</title>
<link rel="stylesheet" href="management/css/common.css">
<link rel="stylesheet" href="management/css/apc_manage.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<style media="screen">
html,body{height:100%;}
  .sub_nav_wrap{height:42px;}
  .sub_nav_wrap>ul>li>h4>a{height:42px;}
  .apc_list{width:100%; margin:5px 0;}
  .apc_list:nth-child(2){margin-left:0;}
  #gnb{padding:31px 0 0;}
  
.apc_manage{overflow:hidden;}
.content_wrap{min-height:100%;}
</style>
</head>
<body>
<div class="wrap">
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
          <a href="PORTFOLIO/portfolioWriter" class="pp_wr"><span></span>포트폴리오 작성</a>
          <c:choose>
          	<c:when test="${userID==null&&emID==null}">
	          <div class="login_wrap">
	            <a href="LOGIN/login?loginCk?=0" class="login">로그인</a>
	            <a href="JOIN/joinV1" class="join">회원가입</a>
	          </div>
          	</c:when>
          	<c:when test="${userID!=null}">
	          <div class="login_wrap">
	            <a href="LOGIN/login?loginCk?=0" class="login">${userID}</a>
	            <a href="LOGIN/logout" class="join">로그아웃</a>
	          </div>
          	</c:when>
          	<c:when test="${emID!=null}">
	          <div class="login_wrap">
	            <a href="LOGIN/login?loginCk?=0" class="login">${emID} 기업회원 님</a>
	            <a href="LOGIN/logout" class="join">로그아웃</a>
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
    
</div> <!-- /.wrap-->
<div class="content_wrap">
    <div class="outtext">
        <h3 class="apc_h3">작성공고 관리</h3>
        <p class="apc_count">총 <span>${fn:length(ntb)}</span>공고 작성</p>
    </div>
    <div class="apc_manage">
        <div class="apc_listbox"> <!--1줄(2박스) 이게 아래로 반복-->
        <c:forEach var="ntc" items="${ntc}" varStatus="status">
			<div class="apc_list">
	            <img class="apc_img" src="images/${ntc.n_img}" alt="원형썸네일">
	            <p class="apc_list_p1"><span><a href="noticCorpCareerList.no?n_no=${ntc.n_no}">${ntc.n_title}</a></span><span>&nbsp;(1997년생 23세)</span></p>
	            <p class="apc_list_p2">${ntc.n_date}</p>
	            <p class="apc_list_p3">지원자수 <span>${ntb[status.index]}</span>개</p>
	        </div>
		</c:forEach>
        </div>
    </div>
</div>
<%@ include file="../footerNoParent.jsp" %>
</body>
</html>