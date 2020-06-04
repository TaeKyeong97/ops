<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정하기</title>
    <link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/portfolioCard.css">
    <link rel="stylesheet" type="text/css" href="../css/smartEditor.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <style>
  	/*.header_con{height:96px !important;}*/
  	.port-card-con{overflow:hidden; position:absolute;}
  	.editaer{width:598px; height:746px; padding:35px; float:left; font-size:25px;}
  	.editaer>div{padding:6px 0;}
    .portfolio-card-wrap{margin:55px auto !important;}
    #editable{width:668px !important; height:833px !important; position:absolute; z-index:0;}
  </style>
</head>
<body>
	<header id="header5">
		      <div class="header_con">
		        <div class="head-wrapper">
		          <div class="head-con">
		            <div class="logo-con">
		              <a href="../ops/main"><img src="../images/common/opsLogoBlack.svg" width="159px" alt=""></a>
		            </div>
		            <!--마춤형 라이브러리-->
		            <div class="service-wrapper">
		              <ul class="service-con">
		                <li>
		                  <a href="#">
		                    <div class="S-icon GitHub"></div>
		                    <div class="">깃허브</div>
		                  </a>
		                </li>
		                <li>
		                  <a href="#">
		                    <div class="S-icon Code"></div>
		                    <div class="">코드</div>
		                  </a>
		                </li>
		                <li>
		                  <a href="#">
		                    <div class="S-icon Food"></div>
		                    <div class="">요리</div>
		                  </a>
		                </li>
		              </ul>
		            </div>
		            <div class="gnb-con">
		              <div class="document-close"><a href="#" onclick="return false">취소</a></div>
		              <div>
		                <svg version="1.1" x="0px" y="0px" viewBox="0 0 50 50" style="width:20px; enable-background:new 0 0 50 50;" xml:space="preserve"> <g> <path style="fill:#5058F0;" d="M15,0l35,0v35C50,15.8,34.2,0,15,0z"/> <path style="fill:#FFFFFF;" d="M0,0l15,0c19.3,0,35,15.8,35,35v15H0L0,0z"/> </g> </svg>
		              </div>
		              <div class="document-save"><a href="#" onclick="return false" class="cardBoardSave">저장</a></div>
		              <div>
		                <svg version="1.1" x="0px" y="0px" viewBox="0 0 50 50" style="width:20px; enable-background:new 0 0 50 50;" xml:space="preserve"> <g> <path style="fill:#5058F0;" d="M35,0H0v35C0,15.8,15.8,0,35,0z"/> <path style="fill:#FFFFFF;" d="M50,0H35C15.8,0,0,15.8,0,35v15h50V0z"/> </g> </svg>
		              </div>
		            </div>
		            <span class="carte">
		              카테고리 : 개발자
		            </span>
		          </div>
		        </div>
		        <div class="cqu_icon"></div>
		      </div>
		      <nav class="sub_nav_wrap">
		        <h3 class="acc">메뉴서비스</h3>
		        <ul style="position:absolute;">
		          <li>
		            <h4><a href="#">기업서비스</a></h4>
		            <ul class="sub_menu">
		              <li><a href="#"><span class="i_con i_con_PublWrit"></span><span class="text">공고작성</span></a></li>
		              <li><a href="#"><span class="i_con i_con_Rec"></span><span class="text">채용현황</span></a></li>
		              <li><a href="#"><span class="i_con i_con_VolOffi"></span><span class="text">지원자 관리</span></a></li>
		              <li><a href="#"><span class="i_con i_con_userInf"></span><span class="text">인재 정보</span></a></li>
		            </ul>
		          </li>
		          <li>
		            <h4><a href="#">개인서비스</a></h4>
		            <ul class="sub_menu">
		              <li><a href="#"><span class="i_con i_conE"></span><span class="text">포트폴리오</span></a></li>
		              <li><a href="#"><span class="i_con i_conF"></span><span class="text">BEST 포트폴리오</span></a></li>
		              <li class="reaction_type"><a href="#"><span class="i_con i_conG"></span><span class="text">관심 기업정보</span></a></li>
		              <li><a href="#"><span class="i_con i_conH"></span><span class="text">MY 포트폴리오</span></a></li>
		              <li><a href="#"><span class="i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
		              <li class="reaction_type"><a href="#"><span class="i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
		            </ul>
		          </li>
		        </ul>
		      </nav>
		    </header>
    <form class="portfolio-card-wrap" action="PortfolioModifyPro?layout=card&&no=${param.no}" method="post"  name="cardBoardContent" enctype="multipart/form-data">
      <div class="portf-card-smartBar" style="display:none;">
          <div class="portfCard portfCard-main portMainAniStartEND portMainAniPrev">
            <ul style="width:332px;">
              <li class="portfCar-bg"><a href="#p">배경</a></li>
              <li><span></span></li>
              <li class="portfCar-edit"><a href="#p">편집</a></li>
              <li><span></span></li>
              <li><a href="#p">레이아웃</a></li>
            </ul>
          </div>
          <div class="portfCard portfCard-bgcon" style="display:none;">
            <ul class="opsCardIcon" style="width:332px;">
              <li><a href="#p" class="portfCar-prev prevIcon">이전</a></li>
              <li><span></span></li>
              <li><a href="#p" class="CardbgIcon" style="width:50px; padding:0;"><label for="imgAttach" style="padding:5px 18px; display:block;">배경</label></a></li>
              <li><span></span></li>
              <li><a href="#p" class="CardbgColorIcon">배경색상</a></li>
              <li><a href="#p" class="CardbgColor white bgColor">흰색</a></li>
              <li><a href="#p" class="CardbgColor black bgColor">검정</a></li>
              <li><a href="#p" class="CardbgColor yellow bgColor">노랑</a></li>
              <li><a href="#p" class="CardbgColor red bgColor">빨강</a></li>
              <li><a href="#p" class="CardbgColor blue bgColor">파랑</a></li>
            </ul>
          </div>
          <div class="portfCard portfCard-edit" style="display:none;">
            <ul class="opsCardIcon" style="width:332px;">
              <li ><a href="#p" class="portfCar-edit-prev prevIcon">이전</a></li>
              <li><span></span></li>
              <li><a href="#p" id="portCardLeft-Btn" class="CardLeftIcon">왼쪽</a></li>
              <li><span></span></li>
              <li><a href="#p" id="portCardCenter-Btn" class="CardCenterIcon">중앙</a></li>
              <li><a href="#p" id="portCardRight-Btn" class="CardRightIcon">오른쪽</a></li>
              <li><a href="#p" class="foreColor CardEditColor white" style="font-size:15px !important" data_color="#fff">A</a></li>
              <li><a href="#p" class="foreColor CardEditColor black" style="font-size:15px !important" data_color="#000">A</a></li>
            </ul>
          </div>
        </div>
        <div class="portf-card-addCon">
          <div class="port-card-con" style="width:${(668*cbb.size())+668}px; left:0;" data-width="2004">
            <div id="editable-1" class="editaer" style="position:relative; z-index:1;" data-content="editable" contenteditable="true">${view.title}<span style="display:none;">x</span></div>
            <c:forEach var="cbb" items="${cbb}" varStatus="status">
            	<div id="editable-${cbb.contentNo+1}" class="editaer" data-content="editable" style="background:#fff; float:left;" contenteditable="true">${cbb.content}</div>
            </c:forEach>
            <div id="editable" style="width:668px; height:833px; background:url('../portfolio/view/upload/${view.img}') no-repeat; background-size:cover; background-position:center;"> </div>
          </div>
          <input type="file" id="imgAttach" name="uploadFile" onchange="LoadImg(this);" value="${view.img}" style="display:none;">
        </div>
      <div class="portf-card-aside">
        <a href="#p" class="portf-check-1 portf-check-btn" data-width="0">1<span style="display:none;">x</sapn></a>
        <c:forEach var="cbb" items="${cbb}" varStatus="status">
        	<a href="#p" class="portf-check-${cbb.contentNo+1}" data-width="-${cbb.contentNo*668}">${cbb.contentNo+1}<span class="portfClose portfClose-2">x</span></a>
        </c:forEach>
        <a href="#p" class="portf-pluse">+</a>
      </div>
      <div class="contentInfo">
        <textarea id="title" name="title" rows="3" cols="80">${view.title}</textarea>
        <c:forEach var="cbb" items="${cbb}" varStatus="status">
        	<textarea id="content-${cbb.contentNo+1}" name="content">${cbb.content}</textarea>
        </c:forEach>
      </div>
      <c:choose>
			<c:when test="${view.po_public=='Y'}">
				<input type="radio" name="range" id="public" value="Y" checked>
				<label for="public">공개</label>
				<input type="radio" name="range" id="private" value="N">
				<label for="private">비공개</label>
			</c:when>
			<c:when test="${view.po_public=='N'}">
				<input type="radio" name="range" id="public" value="Y">
				<label for="public">공개</label>
				<input type="radio" name="range" id="private" value="N" checked>
				<label for="private">비공개</label>
			</c:when>
		</c:choose>
		
    </form>
    <script type="text/javascript">
     function LoadImg(value) {
          if(value.files && value.files[0]) {
               var reader = new FileReader();
               reader.onload = function (e) {
                    $('#editable').attr('style', 'background:url('+e.target.result+')no-repeat; background-size:cover; background-position:center;');
               }
               reader.readAsDataURL(value.files[0]);
          }
     }
    </script>
    <script src="../portfolio/js/cardModi.js" charset="utf-8"></script>
</body>
</html>