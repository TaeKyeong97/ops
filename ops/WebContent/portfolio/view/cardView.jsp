<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>card View</title>
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/main.css">
<link rel="stylesheet" href="../css/portfolioCard.css">
<link rel="stylesheet" type="text/css" href="../css/smartEditor.css">
<script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
<style>
	.header_con{height:96px !important;}
	.port-card-con{width:${(cardList.size()+1)*668}px !important; overflow:hidden; position:absolute;}
	.edita{width:598px; height:746px; padding:35px; float:left; font-size:25px;}
	.edita>div{padding:6px 0;}
    .portfolio-card-wrap{margin:55px auto !important;}
    .portf-card-addCon,.portf-card-aside{top:78px !important;}
    .portfolio-card-wrap{z-index:1;}
</style>

</head>
<body>
	<header id="header5">
      <div class="header_con">
        <div class="header_wrap">
          <h2 class="logo_con"><a href="../ops/main"><span>OPS</span></a></h2>
          <div class="sech_wrap">
            <form action="../search/search?locals=&indu=&req=null&detailSett=&locDedetailSett=all&induDeDedetailSett=&reqsSett=&reqsSettAB=" method="get">
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
              <li><a href="#"><span class="opsLogo i_con i_con_PublWrit"></span><span class="text">공고작성</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_Rec"></span><span class="text">채용현황</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_VolOffi"></span><span class="text">지원자 관리</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_con_userInf"></span><span class="text">인재 정보</span></a></li>
            </ul>
          </li>
          <li>
            <h4><a href="#">개인서비스</a></h4>
            <ul class="sub_menu">
              <li><a href="#"><span class="opsLogo i_con i_conE"></span><span class="text">포트폴리오</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_conF"></span><span class="text">BEST 포트폴리오</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conG"></span><span class="text">관심 기업정보</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_conH"></span><span class="text">MY 포트폴리오</span></a></li>
              <li><a href="../write/careerWriteForm.ops"><span class="opsLogo i_con i_conH"></span><span class="text">이력서 작성</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
            </ul>
          </li>
        </ul>
      </nav>
    </header>
    <c:choose>
    	<c:when test="${param.layout=='post' }">
			<!-- 제목 영역 -->
			<article id="head" style="width:950px; margin:0 auto;margin-top:20px;">
	        <input class="title" id="titleName" style="margin-top:50px;"type="text" value="${view.title}" placeholder="제목" autocomplete="off" onkeyup="keyTitle()" readonly >
	      	</article>
      		<div class="se2_input_area husky_seditor_editing_area_container" style="width: 950px; height: 1300px; margin:20px auto; background: #fff;">${view.content}</div>
		</c:when>
		<c:when test="${param.layout=='card' }">
			<div class="portfolio-card-wrap">
		    	<div class="cardboard-userInfo-con">
		          <div class="userImg">
		            <img src="../MyImage/${view.id}/profile/${view.profile}" alt="사용자 프로필">
		          </div>
		          <div class="userInfo">
		            <a href="#">${userName}</a>
		            <a href="#">@${view.id}</a>
		          </div>
		          <a href="#p" class="opsLogo viewIcon">더보기</a>
		        </div>
		        <c:if test="${userID==view.id}">
			        <a href="PortfolioModify?no=${view.no}&&layout=${view.layout}">수정</a>
					<!-- <a href="PortfolioRemove?no=${view.no}&&layout=${view.layout}">삭제</a> -->
					<a href="#p" class="deletePortfolio">삭제</a>
		        </c:if>
		        <div class="portf-card-addCon">
			        <div class="port-card-con">
			        	<div id="editable-1" class="edita" style="background:url('../portfolio/view/upload/${view.img}') no-repeat; background-size:cover; background-position:center;">${view.title}</div>
				        <c:forEach var="cardList" items="${cardList}" varStatus="status">
				        	<div id="editable-${cardList.contentNo+1}" class="edita" data-content="editable" style="background:#fff; float:left;">${cardList.content}</div>
				        </c:forEach>
			        	</div>
			        </div>
		      <div class="portf-card-aside">
		      	
		      		<a href="#p" class="portf-check-1 portf-check-btn" data-width="0">1</a>
			        <c:forEach var="cardList" items="${cardList}" varStatus="status">
			        	<a href="#p" class="portf-check-${cardList.contentNo+1}" data-width="-${cardList.contentNo*668}">${cardList.contentNo+1}</a>
			        </c:forEach>
		
		      </div>
		      <div class="contentInfo">
		        <textarea id="title" name="title" rows="3" cols="80"></textarea>
		      </div>
		    </div>
		    <div id="windowsWarp" style="width:100%; height:100%; top:0; left:0; position:absolute; display:none;"></div>
		    <script src="../portfolio/js/card.js" charset="utf-8" async></script>
		    <script>
		    	$(".deletePortfolio").on("click",function(){
		    		$.ajax({
		    			url:'portfolioCareerLinkSize',
		    			type:'post',
		    			data:{no:${param.no},layout:'${param.layout}'}
		    		}).done(function(html){
		    			$("#windowsWarp").css("display","block");
		    			$("#windowsWarp").html(html);
		    		});
		    			
		    	});
		    	function closeP(){
		    		$("#windowsWarp").css("display","none");
		    	}
		    </script>
		</c:when>
    	
    </c:choose>
    
</body>
</html>