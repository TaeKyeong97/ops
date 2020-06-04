<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>통합검색</title>
<link rel="icon" href="../images/main/favicon_32-vflOogEID.png" sizes="32x32">
<link rel="icon" href="../images/main/favicon_144-vfliLAfaB.png" sizes="144x144">
<link rel="stylesheet" type="text/css" href="../css/main.css">
<link rel="stylesheet" href="../SEARCH/css/search.css">
<link rel="stylesheet" href="../portfolio/view/css/sub2.css">
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<style>
#header{height:133px;}
.sub-head {height:67px!important; position:fixed!important; z-index:50; }
.sub-head>.header_con { width: 100%!important; height:inherit!important;}
.sub-head>.header_con .header_wrap .logo_con, .sub-head>.header_con .header_wrap .sech_wrap { margin-top: 16px!important; }
.side-menu { width: 50%; float: left; }
.side-menu>li>a { line-height: 69px; padding: 0 10px; float: left; border-right: 1px solid rgba(255,255,255,.14); background: 0 0; color: #fff; }
.sub-head>.header_con>.header_wrap>.sech_wrap { width: 24%; max-width: 114px; float: right; }
.sub-head>.header_con .header_wrap .logo_con, .sub-head>.header_con .header_wrap .sech_wrap { margin-top: 16px!important; }
.sub-head>.header_con>.header_wrap>.sech_wrap>.search>.sech_con {width:87%; }
.sub-head>.header_con>#gnb { padding: 18px 0 0!important; }
.sub-head>.header_con .header_wrap { width: 64%!important; }
.search-content{min-height:50%;}
</style>
</head>
<body>
	<header id="header5">
      <div class="header_con">
        <div class="header_wrap">
          <h2 class="logo_con"><a href="../ops/main"><span class="opsLogo">OPS</span></a></h2>
          <div class="sech_wrap">
            <form action="search?locals=&indu=&req=null&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=" method="get">
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
          <a href="../PORTFOLIO/portfolioWriter" class="pp_wr"><span></span>포트폴리오 작성</a>
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
	            <a href="../LOGIN/login?loginCk?=0" class="login">${emID} 기업회원 님</a>
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
              <li><a href="../noticeWriteForm.no"><span class="opsLogo i_con i_con_PublWrit"></span><span class="text">공고작성</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_Rec"></span><span class="text">채용현황</span></a></li>
              <li><a href="../noticCareerLists.no"><span class="opsLogo i_con i_con_VolOffi"></span><span class="text">지원자 관리</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_userInf"></span><span class="text">인재 정보</span></a></li>
            </ul>
          </li>
          <li>
            <h4><a href="#">개인서비스</a></h4>
            <ul class="sub_menu">
              <li><a href="#"><span class="opsLogo i_con i_conE"></span><span class="text">포트폴리오</span></a></li>
              <li><a href="../PORTFOLIO/portfolioList?page=bestPortfolio"><span class="opsLogo i_con i_conF"></span><span class="text">BEST 포트폴리오</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conG"></span><span class="text">관심 기업정보</span></a></li>
              <li><a href="../PORTFOLIO/portfolioList?page=Myportfolio"><span class="opsLogo i_con i_conH"></span><span class="text">MY 포트폴리오</span></a></li>
              <li><a href="../careerWriteForm.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">이력서 작성</span></a></li>
              <li class="../reaction_type"><a href="careerList.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
            </ul>
          </li>
          <li>
            <h4><a href="../questionList.no">고객센터</a></h4>
            <ul class="sub_menu">
              <li><a href="../questionList.no"><span class="opsLogo i_con i_conE"></span><span class="text">자주묻는 질문</span></a></li>
              <li><a href="../boardList.no"><span class="opsLogo i_con i_conE"></span><span class="text">질문 답변</span></a></li>
            </ul>
          </li>
        </ul>
      </nav>
    </header>
	<div id="header" class="sub-head" style="display:none;">
      <div class="header_con">
        <div class="header_wrap">
          <h2 class="logo_con" style="padding-top:0;"><a href="../ops/main"><span class="opsLogo">OPS</span></a></h2>
          <ul class="side-menu">
            <li><a href="#">지역별 공고</a></li>
            <li><a href="#">직업별 공고</a></li>
            <li><a href="#">포트폴리오</a></li>
            <li><a href="#">인재검색</a></li>
          </ul>
          <div class="sech_wrap">
            <form class="search" action="search?locals=&indu=&req=null&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=" method="get">
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
          <a href="../PORTFOLIO/portfolioWriter" class="pp_wr"><span></span>포트폴리오 작성</a>
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
	필터링 구분
	
	<form action="search" method="get">
      <div class="filter-wrap">
        <h2 class="filter-title"></h2>
        <div class="filt-con">
          <div class="filt-head">
            <div class="filt-menu filt-menu-1" data-menu="1">
              <a href="#" class="filter-ck">기본설정</a>
            </div>
            <div class="filt-menu filt-menu-2" data-menu="2">
              <a href="#">상세설정</a>
            </div>
          </div>
          <div class="filt-body">
            <div class="filter-con filt-con-1" data-left="0" data-type="1">
              <div class="filter-content" >
                <h2>지역</h2>
                <ul>
                  <li><input type="radio" name="locals" id="loc-default" value="" <c:if test="${param.locals==''||param.locals==null}">checked</c:if>><label for="loc-default">선택안함</label></li>
                  <li data-loc="seoul"><input type="radio" name="locals" id="seoul" value="서울" <c:if test="${param.locals=='서울'}">checked</c:if>><label for="seoul">서울</label></li>
                  <li data-loc="gyeong-gi"><input type="radio" name="locals" id="gyeong-gi" value="경기" <c:if test="${param.locals=='경기'}">checked</c:if>><label for="gyeong-gi">경기</label></li>
                  <li data-loc="busan"><input type="radio" name="locals" id="busan" value="부산" <c:if test="${param.locals=='부산'}">checked</c:if>><label for="busan">부산</label></li>
                </ul>
              </div>

              <div class="filter-content">
                <h2>업종</h2>
                <ul>
                  <li><input type="radio" name="indu" id="indu-default" value="" <c:if test="${param.indu==''||param.indu==null}">checked</c:if>><label for="indu-default">선택안함</label></li>
                  <li data-office="it"><input type="radio" name="indu" id="indu-it" value="it" <c:if test="${param.indu=='it'}">checked</c:if>><label for="indu-it">I·T 컴퓨터</label></li>
                  <li data-office="office"><input type="radio" name="indu" id="indu-office" value="office" <c:if test="${param.indu=='office'}">checked</c:if>><label for="indu-office">사무직</label></li>
                  <li data-office="service"><input type="radio" name="indu" id="indu-service" value="service" <c:if test="${param.indu=='service'}">checked</c:if>><label for="indu-service">서비스</label></li>
                </ul>
              </div>
              <div class="filter-content">
                <h2>요구사항</h2>
                <ul>
                  <li><input type="radio" name="req" id="req-default" value="" <c:if test="${param.req==''||param.req==null}">checked</c:if>><label for="req-default">선택안함</label></li>
                  <li data-req="sex"><input type="radio" name="req" id="req-sex" value="sex" <c:if test="${param.req=='sex'}">checked</c:if>><label for="req-sex">성별</label></li>
                  <li data-req="ab"><input type="radio" name="req" id="req-ab" value="req-ab" <c:if test="${param.req=='req-ab'}">checked</c:if>><label for="req-ab">학력</label></li>
                  <li data-req="req-income"><input type="radio" name="req" id="req-income" value="req-income" <c:if test="${param.req=='req-income'}">checked</c:if>><label for="req-income">연봉</label></li>
                  <li><input type="radio" name="req" id="req-Certificate" value="req-Certificate" <c:if test="${param.req=='req-Certificate'}">checked</c:if>><label for="req-Certificate">자격증</label></li>
                </ul>
              </div>
              <div class="filter-content">
                <h2>상세설정</h2>
                <ul>
                  <li><input type="radio" name="detailSett" id="detailSett-default" value="" checked><label for="detailSett-default">선택안함</label></li>
                  <li><input type="radio" name="detailSett" id="detailSett-searchException" value="detailSett-searchException"><label for="detailSett-searchException">검색제외 대상 설정</label></li>
                  <li><input type="radio" name="detailSett" id="detailSett-rd" value="detailSett-rd"><label for="detailSett-rd">등록일별</label></li>
                </ul>
              </div>
            </div>
            <div class="filter-con filt-con-2" data-type="2">
              <div class="filter-content">
                <h2>상세 지역</h2>
                <ul class="loc-con seoul-con">
                  <li><input type="radio" name="locDedetailSett" id="locDe-all" value="%" checked><label for="locDe-all">전체</label></li>
                  <li><input type="radio" name="locDedetailSett" id="gang-namgu" value="강남구"><label for="gang-namgu">강남구</label></li>
                  <li><input type="radio" name="locDedetailSett" id="gang-donggu" value="강동구"><label for="gang-donggu">강동구</label></li>
                </ul>
                <ul class="loc-con busan-con" style="display:none;">
                  <li><input type="radio" name="locDedetailSett" id="locDe2-all" value="%"><label for="locDe2-all">전체</label></li>
                  <li><input type="radio" name="locDedetailSett" id="gang-seogu" value="강서구"><label for="gang-seogu">강서구</label></li>
                  <li><input type="radio" name="locDedetailSett" id="geum-jeonggu" value="금정구"><label for="geum-jeonggu">금정구</label></li>
                </ul>
                <ul class="loc-con gyeong-gi-con" style="display:none;">
                  <li><input type="radio" name="locDedetailSett" id="locDe3-all" value="%"><label for="locDe3-all">전체</label></li>
                  <li><input type="radio" name="locDedetailSett" id="Ga-Pyeonggu" value="가평군"><label for="Ga-Pyeonggu">가평군</label></li>
                  <li><input type="radio" name="locDedetailSett" id="Gun-Posi" value="광주시"><label for="Gun-Posi">광주시</label></li>
                  <li><input type="radio" name="locDedetailSett" id="anseong-si" value="안성시"><label for="anseong-si">안성시</label></li>
                  <li><input type="radio" name="locDedetailSett" id="pangyo" value="판교"><label for="pangyo">판교</label></li>
                </ul>
              </div>
              <div class="filter-content">
                <h2>상세 업종</h2>
                <c:if test="${param.induDeDedetailSett==''||param.induDeDedetailSett==null}">
					<ul class="office-con">
                	</ul>
				</c:if>                
                <ul class="office-con it-con">
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-default" value="" <c:if test="${param.induDeDedetailSett==''||param.induDeDedetailSett==null}">checked</c:if>><label for="induDe-default">선택안함</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-html" value="HTML코딩" <c:if test="${param.induDeDedetailSett=='HTML코딩'}">checked</c:if>><label for="induDe-html">HTML코딩</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-progra" value="프로그래머" <c:if test="${param.induDeDedetailSett=='프로그래머'}">checked</c:if>><label for="induDe-progra">프로그래머</label></li>
                </ul>
                <ul class="office-con offices-con" style="display:none;">
                  <li><input type="radio" name="induDeDedetailSett" id="office-default" value=""><label for="office-default">선택안함</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="office-assistant" value="사무보조"><label for="office-assistant">사무보조</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-progra" value="비서"><label for="induDe-progra">비서</label></li>
                </ul>
                <ul class="office-con service-con" style="display:none;">
                  <li><input type="radio" name="induDeDedetailSett" id="service-default" value=""><label for="service-default">선택안함</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="serving" value="서빙"><label for="serving">서빙</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="md" value="MD"><label for="md">MD</label></li>
                </ul>
              </div>
              <div class="filter-content">
                <h2>상세 요구사항</h2>
				<ul class="reqs-con" <c:if test="${param.reqsSett==''||param.reqsSett==null&&param.reqsSettAB==''||param.reqsSettAB==null}">style="display:none;"</c:if>>
               		<li>요구사항 선택 후 이용 가능합니다.</li>
               	</ul>
                <ul class="reqs-con sex-con" <c:if test="${param.req!='sex'}">style="display:none;"</c:if>>
                  <li><input type="radio" name="reqsSett" id="reqs-default" value="" <c:if test="${param.reqsSett==''||param.reqsSett==null}">checked</c:if>><label for="reqs-default">선택안함</label></li>
                  <li><input type="radio" name="reqsSett" id="man" value="남자" <c:if test="${param.reqsSett=='남자'}">checked</c:if>><label for="man">남자</label></li>
                  <li><input type="radio" name="reqsSett" id="woman" value="여자" <c:if test="${param.reqsSett=='여자'}">checked</c:if>><label for="woman">여자</label></li>
                </ul>               
                <ul class="reqs-con ab-con" <c:if test="${param.req!='req-ab'}"> style="display:none;" </c:if>>
                  <li><input type="radio" name="reqsSettAB" id="ab-default" value="" <c:if test="${param.reqsSettAB==''||param.reqsSettAB==null}">checked</c:if>><label for="ab-default">선택안함</label></li>
                  <li><input type="radio" name="reqsSettAB" id="ab-hs" value="고등학교" <c:if test="${param.reqsSettAB=='고등학교'}">checked</c:if>><label for="ab-hs">고등학교</label></li>
                  <li><input type="radio" name="reqsSettAB" id="ab-uv2" value="대학(2,3년제)" <c:if test="${param.reqsSettAB=='대학(2,3년제)'}">checked</c:if>><label for="ab-uv2">대학(2,3년제)</label></li>
                  <li><input type="radio" name="reqsSettAB" id="ab-uv4" value="대학(4년제)" <c:if test="${param.reqsSettAB=='대학교(4년제)'}">checked</c:if>><label for="ab-uv4">대학교(4년제)</label></li>
                </ul>
                <ul class="reqs-con req-money" <c:if test="${param.req!='req-income'}"> style="display:none;" </c:if>>
                  <li><input type="radio" name="money" id="reqinc-default" value="" <c:if test="${param.money==''||param.reqsSettAB==null}">checked</c:if>><label for="ab-default">선택안함</label></li>
                  <li><input type="radio" name="money" id="reqinc-14" value="1,400만원 이하" <c:if test="${param.money=='1,400만원 이하'}">checked</c:if>><label for="reqinc-14">1,400만원 이하</label></li>
                  <li><input type="radio" name="money" id="reqinc-16" value="1,400~1,600만원" <c:if test="${param.money=='1,400~1,600만원'}">checked</c:if>><label for="reqinc-16">1,400~1,600만원</label></li>
                  <li><input type="radio" name="money" id="reqinc-18" value="1,600~1,800만원" <c:if test="${param.money=='1,600~1,800만원'}">checked</c:if>><label for="reqinc-18">1,600~1,800만원</label></li>
                  <li><input type="radio" name="money" id="reqinc-20" value="1,800~2,000만원" <c:if test="${param.money=='1,800~2,000만원'}">checked</c:if>><label for="reqinc-20">1,800~2,000만원</label></li>
                  <li><input type="radio" name="money" id="reqinc-22" value="2,000~2,200만원" <c:if test="${param.money=='2,000~2,200만원'}">checked</c:if>><label for="reqinc-22">2,000~2,200만원</label></li>
               	<li><input type="radio" name="money" id="reqinc-24" value="2,200~2,400만원" <c:if test="${param.money=='2,200~2,400만원'}">checked</c:if>><label for="reqinc-24">2,200~2,400만원</label></li>
               	<li><input type="radio" name="money" id="reqinc-26" value="2,400~2,600만원" <c:if test="${param.money=='2,400~2,600만원'}">checked</c:if>><label for="reqinc-26">2,400~2,600만원</label></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="search-con">
        <input type="text" name="query" class="search" value="${param.query}" autocomplete=off>
        <input type="submit" class="search-btn" value="검색">
      </div>
    </form>
    <div class="search-content">
	    <div class="notic-list">
	        <h2>공고</h2>
	        <div class="notic-wrap">
	          <c:forEach var="searnotics" items="${searnotics}" varStatus="status">
	          <div class="notic-con">
	            <img src="../SEARCH/img/img1.png" alt="">
	            <div class="notic-bg"></div>
	            <div class="notic-info">
	              <div class="notic-title"><a href="../noticeDetail.no?n_no=${searnotics.n_no}">${searnotics.n_title}</a></div>
	              <div class="notic-title">2019년도 신입 채용</div>
	            </div>
	          </div>
	          </c:forEach>
	        </div>
	      </div>
	      <div class="career-list">
	        <h2>이력서</h2>
	        <div class="career-wrap">
	        <c:forEach var="searchcls" items="${searchcls}" varStatus="status">
	          <div class="career-con">
	            <div class="user-pf">
	              <img src="../MyImage/${searchcls.id}/profile/${searchcls.profile}" alt="">
	            </div>
	            <div class="career-info">
	              <ul>
	                <li>${searchcls.ca_name}(1997년생 23세)</li>
	                <li>${searchcls.ca_title}</li>
	                <li>자격증 <span style="color:#155bdc;">5개</span></li>
	              </ul>
	            </div>
	          </div>
	          </c:forEach>
	        </div>
		</div>
		<div class="portfolio-list">
        <h2>포트폴리오</h2>
        <div class="portf-wrap">
        <c:forEach var="searchpfls" items="${searchpfls}" varStatus="status">
       		<div class="tabbox_3">
				<p class="thum_name">${searchpfls.id }</p> <!--포트폴리오 작성자명-->
				<img class="thum_heart" src="../portfolio/view/img/thum_heart.png" alt="찜">
				<img class="thum_star" src="../portfolio/view/img/icon_star1.png" alt="큰 별 이미지">
				<img class="thum_img" src="../portfolio/view/upload/${searchpfls.img}" alt="썸네일이미지">
				<div class="thum_desc"> <!--썸네일아래 흰색 박스-->
					<a href="../PORTFOLIO/PortfolioView?no=${searchpfls.no}&&layout=${searchpfls.layout}" class="thum_title">${searchpfls.title}</a>
					<p class="thum_subtitle">--</p>
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
          <!-- <div class="portf-con">
            <div class="portf-c">
              <div class="portf-h">
                <a href="#">김태경</a>
                <a href="#">좋아요</a>
              </div>
              <div class="portf-b">
                <ul>
                  <li class="title"><a href="#">${searchpfls.title}</a> </li>
                  <li style="margin-top:10px;"><div class="start-icon star-2"></div></li>
                </ul>
              </div>
            </div>
            <div class="portf-bg"><img src="../SEARCH/img/img2.png" alt=""></div>
          </div>-->
        </c:forEach>
        </div>
      </div>
	<noscript style="top:50%; left:50%; padding:20px; position:fixed;transform: translate(-50%,-50%); background: #fff;font-size: 15px; border: 1px solid #dedfe6; z-index: 500; box-shadow: 0px 0px 5px 2px #eeeff3;">
		<span>이 사이트의 기능을 모두 활용하기 위해서는 자바스크립트를 활성화 시킬 필요가 있습니다.<br></span>
		<a href="http://www.enable-javascript.com/ko/" target="_blank" style="color: #d60000;">브라우저에서 자바스크립트를 활성화하는 방법</a><span>을 참고 하세요. </span>
	</noscript>
	</div>
	<script>
      //메뉴 타켓 위치 정보저장
      var menuTarget=null;  //현재 선택된 위치정보
      var conwidth=0;       //이동 거리
      $(".filt-menu").on("click",function(){
        if($(event.target).prop("tagName")=="A"){
          menuTarget=$(event.target).parent().attr("data-menu");
          $(".filt-menu>a").removeClass("filter-ck");
          $(event.target).attr("class","filter-ck");
          conwidth="-"+$(".filt-con-"+menuTarget).attr("data-width");

          //이동
          if(menuTarget!=1){
            $(".filt-con-"+Number(menuTarget-1)).animate({left:conwidth},500);
            $(".filt-con-"+Number(menuTarget)).animate({left:0},500);
            $(".filt-con-"+Number(menuTarget-1)).attr("data-left",conwidth);
            $(".filt-con-"+Number(menuTarget)).attr("data-left","0");
          }else{
            $(".filt-con-"+Number(menuTarget)).animate({left:0},500);
            $(".filt-con-"+Number(Number(menuTarget)+Number(1))).animate({left:$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width")},200);
            $(".filt-con-"+Number(menuTarget)).attr("data-left",$(".filt-con-"+Number(menuTarget)).attr("data-width"));
            $(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-left",$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width"));
            $(".filt-con-"+Number(menuTarget)).attr("data-left","0");
          }

        }else{
          menuTarget=$(event.target).attr("data-menu");
          $(".filt-menu>a").removeClass("filter-ck");
          $(event.target).children().attr("class","filter-ck");
          conwidth="-"+$(".filt-con-"+menuTarget).attr("data-width");

          //이동
          if(menuTarget!=1){
            $(".filt-con-"+Number(menuTarget-1)).animate({left:conwidth},500);
            $(".filt-con-"+Number(menuTarget)).animate({left:0},500);
            $(".filt-con-"+Number(menuTarget-1)).attr("data-left",conwidth);
            $(".filt-con-"+Number(menuTarget)).attr("data-left","0");
          }else{
            $(".filt-con-"+Number(menuTarget)).animate({left:0},500);
            $(".filt-con-"+Number(Number(menuTarget)+Number(1))).animate({left:$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width")},200);
            $(".filt-con-"+Number(menuTarget)).attr("data-left",$(".filt-con-"+Number(menuTarget)).attr("data-width"));
            $(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-left",$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width"));
          }

        }
      });

      var filterLef=0;
      for(var filterI=0;filterI<$(".filt-body").children().length;filterI++){
        filterLef=$(".filt-body").width()*Number(filterI);
        $(".filt-con-"+Number(filterI+1)).css({"width":$(".filt-body").width(),"left":filterLef });
        $(".filt-con-"+Number(filterI+1)).attr("data-width",filterLef);
      }
      $(".filt-body").css("width",$(".filt-body").width()*2);


      //스클롤 이벤트
      $(window).resize(function() {
        $(".filt-body").css("width",$(".filt-head").width());
        console.log($(".filt-con-1").attr("data-left"));
        for(var filterI=0;filterI<$(".filt-body").children().length;filterI++){
          if($(".filt-con-1").attr("data-left")!=0){
            $(".filt-con-"+Number(filterI+1)).css("width",$(".filt-head").width());
            $(".filt-con-"+Number(filterI+1)).attr("data-left",$(".filt-head").width());

            filterLef=$(".filt-con-"+Number(filterI+1)).attr("data-left");
            $(".filt-con-"+Number(filterI+1)).css({"width":$(".filt-body").width(),"left":-$(".filt-body").width() });
            $(".filt-con-2").css({"width":$(".filt-body").width(),"left":"0" });
            $(".filt-con-"+Number(filterI+1)).attr("data-width",filterLef);
          }else{
            filterLef=$(".filt-body").width()*Number(filterI);
            $(".filt-con-"+Number(filterI+1)).css({"width":$(".filt-body").width(),"left":filterLef });
            $(".filt-con-"+Number(filterI+1)).attr("data-width",filterLef);
          }

        }
      });

      //본문 이벤트
      $(".filter-content>ul>li").on("click",function(){
        if($(event.target).parent().parent().parent().parent().attr("data-type")==1){
          if($(event.target).text()!="선택안함"&&$(event.target).text()!=""){
            menuTarget=2;
            $(".filt-menu>a").removeClass("filter-ck");
            $(".filt-menu-"+menuTarget+">a").attr("class","filter-ck"); //메뉴 포커스 변경
            conwidth="-"+$(".filt-con-"+menuTarget).attr("data-width");

            if(menuTarget!=1){
              $(".filt-con-"+Number(menuTarget-1)).animate({left:conwidth},400);
              $(".filt-con-"+Number(menuTarget)).animate({left:0},400);
              $(".filt-con-"+Number(menuTarget-1)).attr("data-left",conwidth);
              $(".filt-con-"+Number(menuTarget)).attr("data-left","0");
            }else{
              $(".filt-con-"+Number(menuTarget)).animate({left:0},400);
              $(".filt-con-"+Number(Number(menuTarget)+Number(1))).animate({left:$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width")},200);
              $(".filt-con-"+Number(menuTarget)).attr("data-left",$(".filt-con-"+Number(menuTarget)).attr("data-width"));
              $(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-left",$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width"));
            }
          }
        }else{
          if($(event.target).text()!="선택안함"&&$(event.target).text()!=""){
            menuTarget=1;
            $(".filt-menu>a").removeClass("filter-ck");
            $(".filt-menu-"+menuTarget+">a").attr("class","filter-ck"); //메뉴 포커스 변경
            conwidth="-"+$(".filt-con-"+menuTarget).attr("data-width");

            if(menuTarget!=1){
              $(".filt-con-"+Number(menuTarget-1)).animate({left:conwidth},400);
              $(".filt-con-"+Number(menuTarget)).animate({left:0},400);
              $(".filt-con-"+Number(menuTarget-1)).attr("data-left",conwidth);
              $(".filt-con-"+Number(menuTarget)).attr("data-left","0");
            }else{
              $(".filt-con-"+Number(menuTarget)).animate({left:0},400);
              $(".filt-con-"+Number(Number(menuTarget)+Number(1))).animate({left:$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width")},200);
              $(".filt-con-"+Number(menuTarget)).attr("data-left",$(".filt-con-"+Number(menuTarget)).attr("data-width"));
              $(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-left",$(".filt-con-"+Number(Number(menuTarget)+Number(1))).attr("data-width"));
            }
          }
        }

      });

      //상세 설정 이벤트
      $(".filter-content>ul>li").on("click",function(){
        var local=$(event.target).parent().attr("data-loc");
        var office=$(event.target).parent().attr("data-office");
        var req=$(event.target).parent().attr("data-req");
        //지역
        switch(local){
          case "seoul":
          $(".loc-con").css("display","none");
          $(".seoul-con").css("display","block");
          break;
          case "busan":
          $(".loc-con").css("display","none");
          $(".busan-con").css("display","block");
          break;
          case "gyeong-gi":
          $(".loc-con").css("display","none");
          $(".gyeong-gi-con").css("display","block");
          break;
        }
        //업종
        switch(office){
          case "office":
          $(".office-con").css("display","none");
          $(".offices-con").css("display","block");
          break;
          case "service":
          $(".office-con").css("display","none");
          $(".service-con").css("display","block");
          break;
          case "it":
          $(".office-con").css("display","none");
          $(".it-con").css("display","block");
          break;
        }
        //요구사항
        switch(req){
          case "ab":
          $(".reqs-con").css("display","none");
          $(".ab-con").css("display","block");
          $(".req-money").css("display","none");
          break;
          case "sex":
          $(".reqs-con").css("display","none");
          $(".sex-con").css("display","block");
          $(".req-money").css("display","none");
          break;
          case "req-income":
       	  $(".reqs-con").css("display","none");
          $(".sex-con").css("display","none");
          $(".req-money").css("display","block");
          break;
        }
        

      });
    </script>
    <script type="text/javascript" src="../js/write/resumeForm.js"></script>
    <%@ include file="../footer.jsp" %>
</body>
</html>