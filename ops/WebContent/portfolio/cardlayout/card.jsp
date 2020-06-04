<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>카드형 게시판</title>
<link rel="stylesheet" href="../css/common.css">
    <link rel="stylesheet" href="../css/main.css">
    <link rel="stylesheet" href="../css/portfolioCard.css">
    <link rel="stylesheet" type="text/css" href="../css/smartEditor.css">
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="../portfolio/js/json/parsing.js" charset="utf-8"></script>

<script type="text/javascript">
//이미지 검색을 위해만듬
  window.onload = function(){ document.getElementById("loding").style.display = "none";document.getElementById("lodingBG").style.display = "none" }
</script>
<!-- //이미지 팝업 -->
</head>
<body>
	<c:if test="${appr==false}">
		<div class="setting-pop-wrap" style="z-index:105;">
		  <form class="spop-content" action="../DataCenter/setting" name="spopc" method="post">
		    <h2 class="spop-title"><a href="#" tabindex="1">관심분야 선택</a></h2>
		    <div class="spop-con">
		      관심분야를 선택하여 주세요
		      <ul class="spop-carte">
		        <li><input type="radio" name="category" value="it" id="it"><label for="it" tabindex="2">I · T</label></li>
		        <li><input type="radio" name="category" value="photo" id="photo"><label for="photo" tabindex="2">사진작가</label></li>
		        <li><input type="radio" name="category" value="poem" id="poem"><label for="poem" tabindex="2">시인</label></li>
		        <li><input type="radio" name="category" value="formality" id="formality"><label for="formality" tabindex="2">요식업</label></li>
		        <li><input type="radio" name="category" value="Hobby" id="Hobby"><label for="Hobby" tabindex="2">취미</label></li>
		        <li><input type="radio" name="category" value="Guitar" id="Guitar"><label for="Guitar" tabindex="2">기타</label></li>
		      </ul>
		      <div class="spop-text-con">
		        관심 분야는 처음 한 번만 보이며 변경 사항 발생 시 개인 정보 수정 페이지에서 설정할 수 있습니다.
		      </div>
		      <a href="#c" class="spop-next" tabindex="3" onclick="spopSubmit()">
		        <div class="nextIcon"></div>
		        건너뛰기
		      </a>
		    </div>
		  </form>
		  <div class="spopbg"></div>
		</div>
		<script>
			function spopSubmit(form){
				var form=document.spopc;
				form.submit();
			}
		</script>
	</c:if>
	<c:if test="${appr==true&&param.layout==null}">
		<div class="setting-pop-wrap" style="z-index:500;">
		  <div class="spop-content">
		    <h2 class="spop-title"><a href="#" tabindex="1">탬플릿 선택</a></h2>
		    <div class="spop-con">
		      원하는 탬플릿을 선택하여 주세요
		      <ul class="spop-carte" style="max-width:820px; margin-top:87px; grid-template-columns:auto auto;">
		        <li><input type="radio" name="category" value="it" id="it"><label for="it" tabindex="2" style="max-width:100%; height:206px; background:url('../portfolio/img/layoutSelect.png') no-repeat; border:0;"  onclick="location.href='portfolioWriter?layout=card'"></label></li>
		        <li><input type="radio" name="category" value="photo" id="photo"><label for="photo" tabindex="2" style="max-width:100%; height:206px; background:url('../portfolio/img/layoutSelect.png') no-repeat; border:0; background-position:0 -233px;" onclick="location.href='portfolioBoardWriter?layout=board'"></label></li>
		      </ul>
		      <div class="spop-text-con" style="margin-top:86px;">
		        원하는 탬플릿을 선택하세요
		      </div>
		      <a href="#c" class="spop-next" tabindex="3" onclick="spopSubmit()" style="display:none;">
		        <div class="nextIcon"></div>
		        다음
		      </a>
		    </div>
		  </div>
		  <div class="spopbg"></div>
		</div>
	</c:if>
	<c:choose>
		<c:when test="${userID!=null}">
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
		                <li>
		                  <a href="#" onclick="ImgPopOn()">
		                    <div class="S-icon images"></div>
		                    <div class="">이미지</div>
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
		              <li><a href="#"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
		              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
		            </ul>
		          </li>
		        </ul>
		      </nav>
		    </header>
		    <form class="portfolio-card-wrap" action="PortfolioWriterPro?layout=card" method="post" name="cardBoardContent" enctype="multipart/form-data">
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
		        <div class="portf-card-con">
		          <div id="editable" class="editable" contenteditable="true" style="overflow-y:auto;">
		              <div></div>
		          </div>
		          <input type="file" id="imgAttach" name="uploadFile" onchange="LoadImg(this);" style="display:none;">
		        </div>
		        <div class="portf-card-addCon"></div>
		      <div class="portf-card-aside">
		        <a href="#p" class="portf-check-1 portf-check-btn">1</a>
		        <a href="#p" class="portf-pluse">+</a>
		      </div>
		      <div class="contentInfo">
		        <textarea id="title" name="title" rows="3" cols="80"></textarea>
		      </div>
		      <input type="radio" name="range" id="public" value="Y" checked>
				<label for="public">공개</label>
				<input type="radio" name="range" id="private" value="N">
				<label for="private">비공개</label>
		    </form>
		    
	    <!--이미지 popup 시작-->
<div class="comm-pop" style="display:none; z-index:150;">
  <div class="comm-pop-h">
    <div class="close">
      <a href="#" onclick="ImgPopOff(); return false">취소</a>
    </div>
    <div class="menu">
      <svg version="1.1" x="0px" y="0px" viewBox="0 0 50 50" style="width:20px; float:left; enable-background:new 0 0 50 50;" xml:space="preserve"> <g> <path style="fill:#5058F0;" d="M15,0l35,0v35C50,15.8,34.2,0,15,0z"></path> <path style="fill:#f3f5f8;" d="M0,0l15,0c19.3,0,35,15.8,35,35v15H0L0,0z"></path> </g> </svg>
      <ul>
        <li><a href="#" class="checked">빅데이터검색</a></li>
        <li><a href="#">직접올리기</a></li>
        <li><a href="#">링크</a></li>
      </ul>
      <svg version="1.1" x="0px" y="0px" viewBox="0 0 50 50" style="width:20px; float:left; enable-background:new 0 0 50 50;" xml:space="preserve"> <g> <path style="fill:#e6e7fa;" d="M35,0H0v35C0,15.8,15.8,0,35,0z"></path> <path style="fill:#f3f5f8;" d="M50,0H35C15.8,0,0,15.8,0,35v15h50V0z"></path> </g> </svg>
    </div>
    <div class="post">
      <span class="postLen"></span><a href="#" onclick="insertIMG(); return false">올리기</a>
    </div>
  </div>
  <div class="search">
    <input id="searchInput" type="search" name="" value="" placeholder="한글 또는 영어로 검색" onkeydown="ImgSearchKEYBO()">
    <button type="button" name="button" onclick="ImgSearch()">검색</button>
  </div>
  <div class="pop-wrapper">
  </div>
  <div class="Provision">
    <img src="../portfolio/Editor/workspace/img/Provision.png" alt="빅데이터 이미지 제공 : 픽사베이">
  </div>
  <div id="loding">
    <div class="con"></div>
  </div>
  <div id="lodingBG"></div>
</div>
		</c:when>
		<c:when test="${emID!=null}">
			<script>
				alert("기업회원은 이용불가한 상품 입니다.");
				location.href="../LOGIN/login?loginCk=0";
			</script>
		</c:when>
		<c:otherwise>
			<script>
				alert("로그인후 이용가능합니다.");
				location.href="../LOGIN/login?loginCk=0";
			</script>
		</c:otherwise>
	</c:choose>
	
	<script src="../portfolio/js/card.js" charset="utf-8"></script>
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
    <!--Example End-->
<script>
  $(".spop-carte>li>label").on("click",function(){
    $(".spop-next").html("<div class=\"nextIcon nextIconCk\"></div><span style=\"color:#1c69f5;\">다음</span>");
  });
</script>
</body>
</html>