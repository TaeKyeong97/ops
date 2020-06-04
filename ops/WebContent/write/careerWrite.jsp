<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>이력서 작성페이지</title>
    <meta name="theme-color" content="#1c69f5"/>
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" href="css/main-Media.css">
    <link rel="stylesheet" href="write/css/career.css">
    <meta content="images/main/ops_standard_color_128dp.png" itemprop="image">
    <link rel="icon" href="images/main/favicon_32-vflOogEID.png" sizes="32x32">
    <link rel="icon" href="images/main/favicon_144-vfliLAfaB.png" sizes="144x144">
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <link href="write/fileup.min.css" rel="stylesheet">
    <script src="write/fileup.min.js"></script>
    <style>
    	.fileup-file{width:100%; width:-webkit-fill-available; width: 95%; margin: 5px auto; max-width:none !important; background:#fff; border-radius:0;}
    </style>
  </head>
  <body>
  <c:if test="${userID!=null}">
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
              <li><a href="boardList.no"><span class="opsLogo i_con i_conE"></span><span class="text">질문 답변</span></a></li>
            </ul>
          </li>
        </ul>
      </nav>
    </header>
    <div id="header" class="sub-head" style="display:none;">
      <div class="header_con">
        <div class="header_wrap">
          <h2 class="logo_con" style="padding-top:0;"><a href="ops/main"><span class="opsLogo">OPS</span></a></h2>
          <ul class="side-menu">
            <li><a href="#">지역별 공고</a></li>
            <li><a href="#">직업별 공고</a></li>
            <li><a href="#">포트폴리오</a></li>
            <li><a href="search/search?locals=&indu=&req=&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=&query=">인재검색</a></li>
          </ul>
          <div class="sech_wrap">
            <form class="search" action="search/search?locals=&indu=&req=null&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=" method="get">
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
              <input class="sech_con" type="text" name="query" title="검색어 입력" value="${param.query}" autocomplete="off" >
              <input class="sech_butt" type="submit" name="button" value="검색 하기">
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
    </div>
    <div class="career-wrap">
      <form action="careerWritePro.ops2" method="post" name="carContent" class="car-content">
        <div id="car-title" class="car-title">
          <input type="text" name="title" value="" placeholder="제목">
        </div>
        <div class="car-con">
          <textarea class="car-textCon" name="ca_selfText" rows="8" cols="80" placeholder="자기소개" onkeyup="cartextCon()"></textarea>
          <div class="con-size">
            <span class="cartextlen">0</span> / <span style="color:#1c69f5">500</span>
          </div>
        </div>
        <div class="car-satis">
          <input type="text" name="talk" value="" placeholder="한마디">
        </div>
        <!--학력-->
        <h2 class="hr-title">학력 <span>(필수)</span> </h2>
        <div class="car-ab-wrap">
          <div class="car-sal acb">
            <button type="button" name="button" class="selection" >학교</button>
            <ul class="selection-con">
              <li class="sal-con"><a href="#c" onclick="salType('nes')">학교</a></li>
              <li class="sal-con"><a href="#c" onclick="salType('es')">초등학교</a></li>
              <li class="sal-con"><a href="#c" onclick="salType('mh')">중학교</a></li>
              <li class="sal-con"><a href="#c" onclick="salType('mh')">고등학교</a></li>
              <li class="sal-con"><a href="#c" onclick="salType('tug')">대학(2,3년제)</a></li>
              <li class="sal-con"><a href="#c" onclick="salType('tug')">대학(4년제)</a></li>
              <li class="sal-con"><a href="#c" onclick="salType('tug')">대학원</a></li>
            </ul>
            <input type="hidden" name="school" class="selectionVal" value="">
          </div>
          <div class="car-sal nes">
            <button type="button" name="button" class="selection" >선택</button>
            <ul class="selection-con">
              <li class="sal-con"><a href="#c">선택</a></li>
            </ul>
            <input type="hidden" name="schoolState" class="selectionVal" value="">
          </div>
          <div class="car-sal es" style="display:none;">
            <button type="button" name="button" class="selection" >선택</button>
            <ul class="selection-con">
              <li class="sal-con"><a href="#c">졸업</a></li>
            </ul>
            <input type="hidden" name="eschool" class="selectionVal" value="">
          </div>
          <div class="car-sal mh" style="display:none;">
            <button type="button" name="button" class="selection" >선택</button>
            <ul class="selection-con">
              <li class="sal-con"><a href="#c">졸업</a></li>
              <li class="sal-con"><a href="#c">재학</a></li>
              <li class="sal-con"><a href="#c">중퇴</a></li>
            </ul>
            <input type="hidden" name="mhschool" class="selectionVal" value="">
          </div>
          <div class="car-sal tug" style="display:none;">
            <button type="button" name="button" class="selection" >선택</button>
            <ul class="selection-con">
              <li class="sal-con"><a href="#c">졸업</a></li>
              <li class="sal-con"><a href="#c">재학</a></li>
              <li class="sal-con"><a href="#c">휴학</a></li>
              <li class="sal-con"><a href="#c">중퇴</a></li>
              <li class="sal-con"><a href="#c">수료</a></li>
            </ul>
            <input type="hidden" name="tcungs" class="selectionVal" value="">
          </div>
          <input type="text" name="ca_schoolName" value="" placeholder="학교명" style="width:-webkit-fill-available">
        </div>
        <h2 class="hr-title">재학기간 <span>(필수)</span> </h2>
	  	<div class="car-Date" style="width:100%;">
		   <div><input type="text" name="attendTerm" value="" placeholder="입학 일" style="width:-webkit-fill-available"></div>
		   <div><input type="text" name="attendTerm" value="" placeholder="졸업 일" style="width:-webkit-fill-available"></div>
	   	</div>
        <!--희망근무조건-->
        <h2 class="hr-title">희망근무조건 <span>(필수)</span></h2>
        <div class="car-sal formService">
          <button type="button" name="button" class="selection" >근무형태 선택</button>
          <ul class="selection-con">
            <li class="sal-con"><a href="#c">알바</a></li>
            <li class="sal-con"><a href="#c">정규직</a></li>
            <li class="sal-con"><a href="#c">교육생</a></li>
            <li class="sal-con"><a href="#c">프리랜서</a></li>
          </ul>
          <input type="hidden" name="emploName" class="selectionVal" value="" >
        </div>
        <div class="car-car">
          <input type="radio" id="newC2-btn" class="newC-btn" name="workForm" value="2">
          <label for="newC2-btn" class="career-bg">경력</label>
          <input type="radio" id="newC-btn" class="newC-btn" name="workForm" value="1" checked>
          <label for="newC-btn" class="career-bg">신입</label>
        </div>
        <div class="car-business">
          <input type="text" name="job" value="" placeholder="업직종">
          <button type="button" name="button">업직종 선택</button>
        </div>
        <div class="car-Date">
          <div><input type="text" name="" value="" placeholder="근무 시작일"></div>
          <div><input type="text" name="" value="" placeholder="근무 종료일"></div>
        </div>
        <h3>근무요일 (미선택시 무관)</h3>
        <div class="week">
          <input type="checkbox" name="workDays" value="월" id="mon">
          <label class="mon" for="mon" onclick="weekCk(1,this.previousSibling,0)" tabindex="0">월</a> </label>
          <input type="checkbox" name="workDays" value="화" id="tue">
          <label class="tue" for="tue" onclick="weekCk(5,this.previousSibling,0)" tabindex="0">화</label>
          <input type="checkbox" name="workDays" value="수" id="wed">
          <label class="wed" for="wed" onclick="weekCk(9,this.previousSibling,0)" tabindex="0">수</label>
          <input type="checkbox" name="workDays" value="목" id="thur">
          <label class="thur" for="thur" onclick="weekCk(13,this.previousSibling,0)" tabindex="0">목</label>
          <input type="checkbox" name="workDays" value="금" id="fri">
          <label class="fri" for="fri" onclick="weekCk(17,this.previousSibling,0)" tabindex="0">금</label>
          <input type="checkbox" name="workDays" value="토" id="sat">
          <label class="sat" for="sat" onclick="weekCk(21,this.previousSibling,0)" tabindex="0">토</label>
          <input type="checkbox" name="workDays" value="일" id="sun">
          <label class="sun" for="sun" onclick="weekCk(25,this.previousSibling,0)" tabindex="0">일</label>
          <input type="radio" id="5w" name="weeks" value="5w">
          <label for="5w" onclick="weekCk(45,null,5)">주 5일</label>
          <input type="radio" id="7w" name="weeks" value="7w">
          <label for="7w" onclick="weekCk(45,null,7)">주 7일</label>
          <input type="radio" id="ds" name="weeks" value="ds">
          <label for="ds">직접 선택</label>
        </div>
        <div class="car-sal">
          <button type="button" name="button" class="selection" >급여선택</button>
          <ul class="selection-con">
            <li class="sal-con"><a href="#c" onclick="salType('nsal')">급여선택</a></li>
            <li class="sal-con"><a href="#c" onclick="salType('h')">시급</a></li>
            <li class="sal-con"><a href="#c" onclick="salType('m')">월급</a></li>
            <li class="sal-con"><a href="#c" onclick="salType('y')">연봉</a></li>
          </ul>
          <input type="hidden" name="selectionVal" class="selectionVal" value="">
        </div>
        <div class="car-sal nsal">
          <button type="button" name="button" class="selection" >급여방식 선택</button>
          <ul class="selection-con">
            <li class="sal-con"><a href="#c">급여방식을 선택하여주세요</a></li>
          </ul>
          <input type="hidden" name="" class="selectionVal" value="">
        </div>
        <div class="car-sal hsal" style="display:none;">
          <input type="text" name="hourly" value="" placeholder="시급" style="font-size:15px;">
        </div>
        <div class="car-sal msal" style="display:none;">
          <input type="text" name="monthly" value="" placeholder="월급" style="font-size:15px;">
        </div>
        <div class="car-sal ysal" style="display:none;">
          <button type="button" class="selection" >회사내규에 따름</button>
          <ul class="selection-con">
            <li class="sal-con"><a href="#c">회사내규에 따름</a></li>
            <li class="sal-con"><a href="#c">1,400만원 이하</a></li>
            <li class="sal-con"><a href="#c">1,400~1,600만원</a></li>
            <li class="sal-con"><a href="#c">1,600~1,800만원</a></li>
            <li class="sal-con"><a href="#c">1,800~2,000만원</a></li>
            <li class="sal-con"><a href="#c">2,000~2,200만원</a></li>
            <li class="sal-con"><a href="#c">2,200~2,400만원</a></li>
            <li class="sal-con"><a href="#c">2,400~2,600만원</a></li>
          </ul>
          <input type="hidden" name="annual" class="selectionVal" value="">
        </div>
		<!--포트폴리오추가-->
        <h3 style="width:100%; float:left;">포트폴리오 추가</h3>
        <div class="portfolio-add-wrap">
          <div class="portf-add-head">
            <ul class="portf-h-con">
              <li><a href="#c" class="portf-bar-ck">OPS</a></li>
              <li><a href="#c">첨부파일</a></li>
              <li><a href="#c">링크</a></li>
            </ul>
          </div>
          <div class="portf-add-body">
            <div class="ops-con opsPortfolioAdd" style="display:block;"><a href="#c">추가</a></div>
            <div class="file-con" style="display:none;">
				<div id="multiple">
			        <div class="btn btn-success fileup-btn" style="background:#1271ff; color:#fff; border:0; padding:7px 12px;top:50%;left:50%;font-size:15px;transform:translate(-50%,-50%);border-radius:25px;position:absolute;">
		            	파일 선택
			            <input type="file" id="upload-2" name="test" multiple style="border:0;">
			        </div>
			        <!-- <button onclick="$.fileup('upload-2', 'remove', '*')"
			                class="btn btn-link" type="button" style="display: none">
			            Remove all
			        </button> -->
			        <div id="upload-2-queue"></div>
			    </div>
			</div>
            <div class="link-con" style="display:none;">
              <a href="#c">추가</a>
            </div>
          </div>
        </div>
        <div class="openWrap">
          <div class="openCon">
            <div class="ope-title">
              본이력서를 인재 정보에 등록합니다.
            </div>
            <ul class="ope-content">
              <li><a href="#c">- 입사제의 및 면접제의를 받으시려면, 기업 인사담당자가 내 이력서를 확인 할 수 있게 이력서를 공개 해야합니다.</a></li>
              <li><a href="#c">- 공개한 이력서는 직접 비공개 하기 전까지 기업 인사담당자가 열람할 수 있습니다.</a></li>
              <li><a href="#c">- 재직중인 직장 또는 특정 기업이 내 이력서를 열람하는 것이 꺼려진다면 열람제한 설정을 하실 수 있습니다.</a></li>
            </ul>
          </div>
          <div class="agr-con">
            <span class="agr-title">이력서 공개 설정</span>
            <span><input id="agrOpen" type="radio" name="agrOpen" value="1" checked> <label for="agrOpen">추천인재 공개 (인재정보 검색 비공개)</label> </span>
            <span><input id="agrPriv" type="radio" name="agrOpen" value="0"> <label for="agrPriv">비공개</label> </span>
          </div>
        </div><!-- writeCk(this.form); -->
        <input id="submit-btn" type="button" value="등록" style="width:100%; max-width:200px; margin:40px auto;" onclick="$.fileup('upload-2', 'upload', '*')">
        <input type="hidden" name="phone" value="${mb.phone}">
        <input type="hidden" name="email" value="${mb.email}">
        <input type="hidden" name="roadAddr" value="${mb.jibunAddr}">
      </form>
      <div class="car-aside">
        <div class="profile-wrap">
          <div class="prof-img-con">
            <div class="prof-img career-bg">
              <img src="MyImage/${mb.id}/profile/${mb.profile}" alt="프로필 사진" style="height:100%;">
            </div>
            <div class="prof-sett">
              <a href="#c" class="crr-btn">수정</a>
              <a href="#c" class="crr-btn">삭제</a>
            </div>
          </div>
          <div class="prfo-info career-bg">
             <ul>
               <li><a href="#" class="name">${mb.name}</a> <a href="#">남자 23세 / 1997년생</a><a href="#">Setting</a> </li>
               <li><a href="#c" class="inft">휴대폰</a> <a href="#">${mb.phone}</a> </li>
               <li><a href="#c" class="inft">이메일</a> <a href="#">${mb.email}</a> </li>
               <li><a href="#c" class="inft">주소</a> <a href="#">${mb.jibunAddr}</a> </li>
             </ul>
          </div>
        </div>
        <!--상태표시줄-->
        <div class="state-bar">
          <ul>
            <li><h2 class="hr-title">상태표시</h2></li>
            <li><a href="#car-title"><span class="state-icon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="50.533" cy="49.864" r="49.136" fill="#fff"/><path d="M78.219 31.894c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="157.308" cy="75.42" r="17.692" fill="#1C69F5"/><path d="M167.277 68.95c-.118-.118-.311-.118-.429 0l-12.3 12.3-6.779-6.779c-.118-.118-.311-.118-.429 0s-.118.311 0 .429l6.991 6.991c.059.059.137.089.214.089h.006c.078 0 .155-.03.214-.089l12.511-12.511c.118-.118.118-.311 0-.429z" fill="#fff"/></svg>
            <svg xmlns="http://www.w3.org/2000/svg" style="display:none;" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="152.533" cy="-4.136" r="49.136" fill="#fff"/><path d="M180.219-22.106c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="50.308" cy="50.42" r="49.136" fill="#1C69F5"/><path d="M77.993 32.45c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.164.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#fff"/></svg>
            </span>기본정보 <span>(필수)</span> </a></li>
            <li><a href="#c"><span class="state-icon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="50.533" cy="49.864" r="49.136" fill="#fff"/><path d="M78.219 31.894c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="157.308" cy="75.42" r="17.692" fill="#1C69F5"/><path d="M167.277 68.95c-.118-.118-.311-.118-.429 0l-12.3 12.3-6.779-6.779c-.118-.118-.311-.118-.429 0s-.118.311 0 .429l6.991 6.991c.059.059.137.089.214.089h.006c.078 0 .155-.03.214-.089l12.511-12.511c.118-.118.118-.311 0-.429z" fill="#fff"/></svg>
            <svg xmlns="http://www.w3.org/2000/svg" style="display:none;" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="152.533" cy="-4.136" r="49.136" fill="#fff"/><path d="M180.219-22.106c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="50.308" cy="50.42" r="49.136" fill="#1C69F5"/><path d="M77.993 32.45c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.164.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#fff"/></svg>
            </span>학력사항 <span>(필수)</span> </a></li>
            <li><a href="#c"><span class="state-icon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="50.533" cy="49.864" r="49.136" fill="#fff"/><path d="M78.219 31.894c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="157.308" cy="75.42" r="17.692" fill="#1C69F5"/><path d="M167.277 68.95c-.118-.118-.311-.118-.429 0l-12.3 12.3-6.779-6.779c-.118-.118-.311-.118-.429 0s-.118.311 0 .429l6.991 6.991c.059.059.137.089.214.089h.006c.078 0 .155-.03.214-.089l12.511-12.511c.118-.118.118-.311 0-.429z" fill="#fff"/></svg>
            <svg xmlns="http://www.w3.org/2000/svg" style="display:none;" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="152.533" cy="-4.136" r="49.136" fill="#fff"/><path d="M180.219-22.106c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="50.308" cy="50.42" r="49.136" fill="#1C69F5"/><path d="M77.993 32.45c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.164.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#fff"/></svg>
            </span>희망근무조건 <span>(필수)</span> </a></li>
            <li><a href="#c"><span class="state-icon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="50.533" cy="49.864" r="49.136" fill="#fff"/><path d="M78.219 31.894c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="157.308" cy="75.42" r="17.692" fill="#1C69F5"/><path d="M167.277 68.95c-.118-.118-.311-.118-.429 0l-12.3 12.3-6.779-6.779c-.118-.118-.311-.118-.429 0s-.118.311 0 .429l6.991 6.991c.059.059.137.089.214.089h.006c.078 0 .155-.03.214-.089l12.511-12.511c.118-.118.118-.311 0-.429z" fill="#fff"/></svg>
            <svg xmlns="http://www.w3.org/2000/svg" style="display:none;" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="152.533" cy="-4.136" r="49.136" fill="#fff"/><path d="M180.219-22.106c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="50.308" cy="50.42" r="49.136" fill="#1C69F5"/><path d="M77.993 32.45c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.164.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#fff"/></svg>
            </span>포트폴리오 <span class="career-bg cbtn">추가 +</span> </a></li>
            <li><a href="#c"><span class="state-icon"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="50.533" cy="49.864" r="49.136" fill="#fff"/><path d="M78.219 31.894c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="157.308" cy="75.42" r="17.692" fill="#1C69F5"/><path d="M167.277 68.95c-.118-.118-.311-.118-.429 0l-12.3 12.3-6.779-6.779c-.118-.118-.311-.118-.429 0s-.118.311 0 .429l6.991 6.991c.059.059.137.089.214.089h.006c.078 0 .155-.03.214-.089l12.511-12.511c.118-.118.118-.311 0-.429z" fill="#fff"/></svg>
            <svg xmlns="http://www.w3.org/2000/svg" style="display:none;" viewBox="0 0 100 100" enable-background="new 0 0 100 100"><circle cx="152.533" cy="-4.136" r="49.136" fill="#fff"/><path d="M180.219-22.106c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.165.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#231815"/><circle cx="50.308" cy="50.42" r="49.136" fill="#1C69F5"/><path d="M77.993 32.45c-.329-.329-.862-.329-1.191 0l-34.16 34.16-18.828-18.828c-.329-.329-.862-.329-1.191 0-.329.329-.329.862 0 1.191l19.417 19.417c.164.165.38.247.596.247l.007-.001.007.001c.216 0 .431-.082.596-.247l34.748-34.748c.329-.329.329-.862 0-1.191z" fill="#fff"/></svg>
            </span>자격증 <span class="career-bg cbtn">추가 +</span> </a></li>
          </ul>
        </div>
      </div>
    </div>
    <!--포트폴리오 사이드-->
    <div class="portf-side-wrap" style="right:-900px">
      <div class="portf-head">
        <div>MY 포트폴리오</div>
        <div>사용: 0건</div>
      </div>
      <div class="portf-body">
        <div class="portf-content">
          <div class="portf-img">
            <img src="" alt="">
          </div>
          <a href="#c" class="title">포트폴리오제목</a>
          <a href="#c" class="cate">작성 유형:card</a>
          <a href="#c" class="add">사용하기</a>
        </div>
      </div>
    </div>
    <div class="portf-side-bg"></div>
    <script type="text/javascript" src="js/write/resumeForm.js"></script>
    <script>
    	function writeCk(form){
    		form.submit();
    	}    	
    </script>
	<noscript style="top:50%; left:50%; padding:20px; position:fixed;transform: translate(-50%,-50%); background: #fff;font-size: 15px; border: 1px solid #dedfe6; z-index: 500; box-shadow: 0px 0px 5px 2px #eeeff3;">
		<span>이 사이트의 기능을 모두 활용하기 위해서는 자바스크립트를 활성화 시킬 필요가 있습니다.<br></span>
		<a href="http://www.enable-javascript.com/ko/" target="_blank" style="color: #d60000;">브라우저에서 자바스크립트를 활성화하는 방법</a><span>을 참고 하세요. </span>
	</noscript>
	</c:if>
	<c:if test="${userID==null&&emID!=null}">
		<script>
			alert("기업회원은 이용불가한 상품 입니다.");
			history.back();
		</script>
	</c:if>
	<c:if test="${userID==null&&emID==null}">
		<script>
			alert("로그인후 이용가능합니다.");
			location.href="LOGIN/login?loginCk?=0";
		</script>
		<noscript style="top:50%; left:50%; padding:20px; position:fixed;transform: translate(-50%,-50%); background: #fff;font-size: 15px; border: 1px solid #dedfe6; z-index: 500; box-shadow: 0px 0px 5px 2px #eeeff3;">
			<span>이 사이트의 기능을 모두 활용하기 위해서는 자바스크립트를 활성화 시킬 필요가 있습니다.<br></span>
			<a href="http://www.enable-javascript.com/ko/" target="_blank" style="color: #d60000;">브라우저에서 자바스크립트를 활성화하는 방법</a><span>을 참고 하세요. </span>
		</noscript>
	</c:if>	
	<script>
        $.fileup({
            url: '/upload.ops2',
            inputID: 'upload-2',
            dropzoneID: 'upload-2-dropzone',
            queueID: 'upload-2-queue',
            lang: 'ru',
            onSelect: function(file) {
                $('#multiple button').show();
                $(".fileup-btn").css({"top":"inherit","bottom":"0px","margin-top":"10px","transform":"translate(-50%, -25%)"});
            },
            onRemove: function(file, total) {
                if (file === '*' || total === 1) {
                    $('#multiple button').hide();
                }
            },
            onSuccess: function(response, file_number, file) {
                setTimeout(function() {
                	carContent.submit();
               	}, 1000);
                Snarl.addNotification({
                    title: 'Upload success',
                    text: file.name,
                    icon: '<i class="fa fa-check"></i>'
                });
            },
            onError: function(event, file, file_number) {
                Snarl.addNotification({
                    title: 'Upload error',
                    text: file.name,
                    icon: '<i class="fa fa-times"></i>'
                });
            }
        });
    </script>
  </body>
</html>