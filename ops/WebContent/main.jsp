<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta name="theme-color" content="#317EFB"/>
    <meta content="../images/main/ops_standard_color_128dp.png" itemprop="image">
    <link rel="icon" href="../images/main/favicon_32-vflOogEID.png" sizes="32x32">
    <link rel="icon" href="../images/main/favicon_144-vfliLAfaB.png" sizes="144x144">
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <link rel="stylesheet" href="../SEARCH/css/search.css">
    <link rel="stylesheet" href="../css/main-Media.css">
    <script src="../js/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <style>
    	.sub_menu li>a{overflow:hidden;}
    	.list_Portf span{color:#fff;}
    	.Portf_title{left:25px;}
    	.main_content{min-height:100%;}
    	.wrap_Portf .img_Port_bg>.bg{z-index:5;}
    	.eventBar{ width:100%; height: 69px; margin:0 auto; top:0;  position:absolute; overflow:hidden;z-index:500; background: #1c72f5; border-bottom: 1px solid #ffffff14;}
      	.eventBar>a>img{position:absolute; transform:translate(-50%,0); left:50%; top:0;}

		/**/
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
		.main_content{margin-top:400px;}
		.notic-wrap .notic-con{min-width:255px;}
		.wrap_Portf .img_Port_bg>img{width:auto !important; height:120%;}
	</style>
    <title>OPS</title>
  </head>
  <body>
  	<div class="eventBar">
      <a href="../event/event.jsp" style="width: 100%; height: 68px; display: block; border-bottom: 1px solid #2063de;"><img src="../images/main/eventBar1.png" alt="이벤트 바"></a>
    </div>
    <header id="header" style="margin-top: 69px;">
      <div class="header_con">
        <div class="header_wrap">
          <h2 class="logo_con"><a href="#"><span class="opsLogo">OPS</span></a></h2>
          <div class="sech_wrap">
            <form action="../search/search?locals=&indu=&req=&detailSett=&locDedetailSett=%25&induDeDedetailSett=&reqsSett=&reqsSettAB=&query=" method="get">
          	<div class="filt-body" style="display:none;">
            <div class="filter-con filt-con-1" data-left="0" data-type="1" data-width="0" style="width: 1224px; left: 0px;">
              <div class="filter-content">
                <h2>지역</h2>
                <ul>
                  <li><input type="radio" name="locals" id="loc-default" value="" checked=""><label for="loc-default">선택안함</label></li>
                  <li data-loc="seoul"><input type="radio" name="locals" id="seoul" value="서울"><label for="seoul">서울</label></li>
                  <li data-loc="gyeong-gi"><input type="radio" name="locals" id="gyeong-gi" value="경기"><label for="gyeong-gi">경기</label></li>
                  <li data-loc="busan"><input type="radio" name="locals" id="busan" value="부산"><label for="busan">부산</label></li>
                </ul>
              </div>

              <div class="filter-content">
                <h2>업종</h2>
                <ul>
                  <li><input type="radio" name="indu" id="indu-default" value="" checked=""><label for="indu-default">선택안함</label></li>
                  <li data-office="it"><input type="radio" name="indu" id="indu-it" value="it"><label for="indu-it">I·T 컴퓨터</label></li>
                  <li data-office="office"><input type="radio" name="indu" id="indu-office" value="office"><label for="indu-office">사무직</label></li>
                  <li data-office="service"><input type="radio" name="indu" id="indu-service" value="service"><label for="indu-service">서비스</label></li>
                </ul>
              </div>
              <div class="filter-content">
                <h2>요구사항</h2>
                <ul>
                  <li><input type="radio" name="req" id="req-default" value="" checked=""><label for="req-default">선택안함</label></li>
                  <li data-req="sex"><input type="radio" name="req" id="req-sex" value="sex"><label for="req-sex">성별</label></li>
                  <li data-req="ab"><input type="radio" name="req" id="req-ab" value="req-ab"><label for="req-ab">학력</label></li>
                  <li data-req="req-income"><input type="radio" name="req" id="req-income" value="req-income"><label for="req-income">연봉</label></li>
                  <li><input type="radio" name="req" id="req-Certificate" value="req-Certificate"><label for="req-Certificate">자격증</label></li>
                </ul>
              </div>
              <div class="filter-content">
                <h2>상세설정</h2>
                <ul>
                  <li><input type="radio" name="detailSett" id="detailSett-default" value="" checked=""><label for="detailSett-default">선택안함</label></li>
                  <li><input type="radio" name="detailSett" id="detailSett-searchException" value="detailSett-searchException"><label for="detailSett-searchException">검색제외 대상 설정</label></li>
                  <li><input type="radio" name="detailSett" id="detailSett-rd" value="detailSett-rd"><label for="detailSett-rd">등록일별</label></li>
                </ul>
              </div>
            </div>
            <div class="filter-con filt-con-2" data-type="2" data-width="1224" style="width: 1224px; left: 1224px;">
              <div class="filter-content">
                <h2>상세 지역</h2>
                <ul class="loc-con seoul-con">
                  <li><input type="radio" name="locDedetailSett" id="locDe-all" value="%" checked=""><label for="locDe-all">전체</label></li>
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
                
					<ul class="office-con">
                	</ul>
				                
                <ul class="office-con it-con">
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-default" value="" checked=""><label for="induDe-default">선택안함</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-html" value="HTML코딩"><label for="induDe-html">HTML코딩</label></li>
                  <li><input type="radio" name="induDeDedetailSett" id="induDe-progra" value="프로그래머"><label for="induDe-progra">프로그래머</label></li>
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
				<ul class="reqs-con" style="display:none;">
               		<li>요구사항 선택 후 이용 가능합니다.</li>
               	</ul>
                <ul class="reqs-con sex-con" style="display:none;">
                  <li><input type="radio" name="reqsSett" id="reqs-default" value="" checked=""><label for="reqs-default">선택안함</label></li>
                  <li><input type="radio" name="reqsSett" id="man" value="남자"><label for="man">남자</label></li>
                  <li><input type="radio" name="reqsSett" id="woman" value="여자"><label for="woman">여자</label></li>
                </ul>               
                <ul class="reqs-con ab-con" style="display:none;">
                  <li><input type="radio" name="reqsSettAB" id="ab-default" value="" checked=""><label for="ab-default">선택안함</label></li>
                  <li><input type="radio" name="reqsSettAB" id="ab-hs" value="고등학교"><label for="ab-hs">고등학교</label></li>
                  <li><input type="radio" name="reqsSettAB" id="ab-uv2" value="대학(2,3년제)"><label for="ab-uv2">대학(2,3년제)</label></li>
                  <li><input type="radio" name="reqsSettAB" id="ab-uv4" value="대학(4년제)"><label for="ab-uv4">대학교(4년제)</label></li>
                </ul>
                <ul class="reqs-con req-money" style="display:none;">
                  <li><input type="radio" name="money" id="reqinc-default" value=""><label for="ab-default">선택안함</label></li>
                  <li><input type="radio" name="money" id="reqinc-14" value="1,400만원 이하"><label for="reqinc-14">1,400만원 이하</label></li>
                  <li><input type="radio" name="money" id="reqinc-16" value="1,400~1,600만원"><label for="reqinc-16">1,400~1,600만원</label></li>
                  <li><input type="radio" name="money" id="reqinc-18" value="1,600~1,800만원"><label for="reqinc-18">1,600~1,800만원</label></li>
                  <li><input type="radio" name="money" id="reqinc-20" value="1,800~2,000만원"><label for="reqinc-20">1,800~2,000만원</label></li>
                  <li><input type="radio" name="money" id="reqinc-22" value="2,000~2,200만원"><label for="reqinc-22">2,000~2,200만원</label></li>
               	<li><input type="radio" name="money" id="reqinc-24" value="2,200~2,400만원"><label for="reqinc-24">2,200~2,400만원</label></li>
               	<li><input type="radio" name="money" id="reqinc-26" value="2,400~2,600만원"><label for="reqinc-26">2,400~2,600만원</label></li>
                </ul>
              </div>
            </div>
          </div>
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
	            <a href="../LOGIN/login?loginCk=0" class="login">로그인</a>
	            <a href="../JOIN/joinSelect" class="join">회원가입</a>
	          </div>
          	</c:when>
          	<c:when test="${userID!=null}">
	          <div class="login_wrap">
	            <a href="../myInfo/myPage" class="login">${userID}</a>
	            <a href="../LOGIN/logout" class="join">로그아웃</a>
	          </div>
          	</c:when>
          	<c:when test="${emID!=null}">
	          <div class="login_wrap">
	            <a href="../myInfo/myPage" class="login">${emID} 기업회원 님</a>
	            <a href="../LOGIN/logout" class="join">로그아웃</a>
	          </div>
          	</c:when>
          </c:choose>
        </aside>
        <div class="cqu_icon"></div>
      </div>
      <nav class="nav_wrap">
        <h3 class="acc">메뉴서비스</h3>
        <ul>
          <li>
            <h4><a href="#">기업서비스</a></h4>
            <ul class="sub_menu">
              <li><a href="../noticeWriteForm.no"><span class="opsLogo i_con i_con_PublWrit"></span><span class="text">공고작성</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_Rec"></span><span class="text">채용현황</span></a></li>
              <li><a href="../noticCareerLists.no"><span class="opsLogo i_con i_con_VolOffi"></span><span class="text">지원자 관리</span></a></li>
              <li><a href="../search/search?locals=&indu=&req=&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=&query="><span class="opsLogo i_con i_con_userInf"></span><span class="text">인재 정보</span></a></li>
            </ul>
          </li>
          <li>
            <h4><a href="#">개인서비스</a></h4>
            <ul class="sub_menu">
              <li><a href="../PORTFOLIO/portfolioList?page=Myportfolio"><span class="opsLogo i_con i_conH"></span><span class="text">MY 포트폴리오</span></a></li>
              <li><a href="../PORTFOLIO/portfolioList?page=bestPortfolio"><span class="opsLogo i_con i_conF"></span><span class="text">BEST 포트폴리오</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conG"></span><span class="text">관심 기업정보</span></a></li>
              <li><a href="../noticCareerList.no"><span class="opsLogo i_con i_con_VolOffi"></span><span class="text">MY 지원자 관리</span></a></li>
              <li><a href="../careerWriteForm.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">이력서 작성</span></a></li>
              <li class="reaction_type"><a href="../careerList.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
            </ul>
          </li>
        </ul>
        <div class="m_plus">
          <div class="m_plus_con">
            <a href="#">더보기</a>
          </div>
        </div>
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
            <form class="search" action="../search/search?locals=&indu=&req=null&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=" method="get">
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
    <section class="main_content">
      <h1 class="disNO">본문시작</h1>
      <article class="ad">
        <h2 class="disNO">광고</h2>
        <div class="ad_row">
          <a class="ad_con"></a>
          <a class="ad_con right"></a>
        </div>
      </article>
      <article class="wrap_list">
        <h2 class="list_title">NEW 포트폴리오</h2>
        <div class="list_Portf">
        <c:forEach var="bss" items="${bss}">
          <a href="../PORTFOLIO/PortfolioView?no=${bss.no}&&layout=${bss.layout}" class="wrap_Portf" style="display:block;">
            <span class="wrap_Port_info">
              <span href="" class="name">${bss.name}</span>
              <span href="#" class="like" title="좋아요중">좋아요</span>
            </span>
            <span class="Portf_title">
              <span href="../PORTFOLIO/PortfolioView?no=${bss.no}&&layout=${bss.layout}" class="title">${bss.title}</span>
              <span href="../PORTFOLIO/PortfolioView?no=${bss.no}&&layout=${bss.layout}" class="sub_Title">--</span>
            </span>
            <span class="Port_cate">
              <span href="#">여행</span>
            </span>
            <span class="img_Port_bg">
              <span class="bg"></span>
              <img src="../portfolio/view/upload/${bss.img}" style="width:100%;" alt="썸네일">
            </span>
          </a>
        </c:forEach>
        </div>
      </article>
      <article class="wrap_list">
        <h2 class="list_title">채용공고</h2>
        <div class="notic-wrap">
          <c:forEach var="nbl" items="${nbl}" varStatus="status">
          <div class="notic-con">
            <img src="../SEARCH/img/img1.png" alt="">
            <div class="notic-bg"></div>
            <div class="notic-info">
              <div class="notic-title"><a href="../noticeDetail.no?n_no=${nbl.n_no}">${nbl.n_title}</a></div>
              <div class="notic-title">${nbl.n_comName}</div>
            </div>
          </div>
          </c:forEach>
        </div>
      </article>
    </section>
    <div class="nextBrowser" style="width:100%; height:100%; display:none; padding:20px 0; position:fixed; z-index:500; top:0; left:0; text-align:center; background:#5984e4; font-family:'Nanum Gothic',sans-serif;">
    	<div style="width:50%; max-width:820px; min-width:600px; margin: 0 auto; background: #fff; padding: 20px 0px; box-shadow: 0px 0px 16px 5px #373a5847; }">
	    	<div style="font-size: 22px; padding: 12px 0; font-weight:bold; font-family:'Nanum Gothic',sans-serif;">2021년 익스플로러 지원 중단 선언</div>
	    	<div style="padding:5px 0;font-family:'Nanum Gothic',sans-serif;">현재 접속 중인 브라우저는 인터넷 익스플로러입니다.</div>
	    	<div style="padding:5px 0;font-family:'Nanum Gothic',sans-serif;">OPS에서는 보다 나은 서비스를 위해 익스플로러를 지원하지 않습니다.</div>
	    	<div style="padding:5px 0;font-family:'Nanum Gothic',sans-serif;">다른 브라우저를 이용해 주시기 바랍니다.</div>
	    	<div style="padding:5px 0;"><a href="https://whale.naver.com/ko/" target="_blank" style="font-family:'Nanum Gothic',sans-serif; font-size:14px; color:rgba(28, 105, 245, 1);">네이버 웨일 브라우저 다운</a></div>
    	</div>
    </div>
    <script type="text/javascript" src="../js/main/main2.js" ></script>
    <script>
	    $(window).scroll(function(){
	    	if ($(document).scrollTop() >= 300) {
	         	$(".sub-head").css("display","block");
	        }else{
	        	$(".sub-head").css("display","none");
	        }
	    });
	    
	    var agent = navigator.userAgent.toLowerCase();

	    if ( (navigator.appName == 'Netscape' && navigator.userAgent.search('Trident') != -1) || (agent.indexOf("msie") != -1) ) {
		  $("#header").css("display","none");
		  $(".main_content").css("display","none");
	      $(".nextBrowser").css("display","block");

	    }

    </script>
    <%@ include file="footer.jsp" %>
  </body>
</html>
