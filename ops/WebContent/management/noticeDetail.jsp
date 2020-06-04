<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ops.Notice.Beans.*"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="management/css/common.css">
    <link rel="stylesheet" href="management/css/lookup.css">
    <title>기업공고</title>
</head>
<body>
<div class="wrap">
    <div class="header">
        <div class="header_top">
            <div class="header_content">
                <a href="ops/main" class="header_logo"><img src="management/img/logo_line2.png" alt="logo"></a>
                <div class="header_search">
                    <!--<img src="img/icon8.png" class="input_icon8" alt="search_icon"> 검색창 돋보기-->
                    <input type="text" class="input_search" name="search" placeholder="search">
                </div>
                <div class="header_portfolio">
                    <img src="management/img/icon1.png" alt="icon1">
                    <a href="PORTFOLIO/portfolioWriter">포트폴리오 작성</a>
                </div>
                <div class="header_login">
                <c:choose>
          			<c:when test="${userID==null&&$emID==null}">
	                    <a href="login.html">로그인</a>
	                    <a href="register.html">회원가입</a>
                  	</c:when>
	          		<c:when test="${userID!=null}">
	          			<a href="login.html">로그아웃</a>
	                    <a href="../LOGIN/logout" class="join">로그아웃</a>
	          		</c:when>
	          		<c:when test="${emID!=null}">
	          			<a href="login.html">로그아웃</a>
	                    <a href="../LOGIN/logout" class="join">로그아웃</a>
	          		</c:when>
          		</c:choose>
                </div>
                <img src="management/img/logo_icon.png" class="logo_icon_big" alt="bigLogo">
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
</div> <!-- /.wrap-->
    
<div class="content_wrap">
    <div class="regtext">
        <p class="regdate">등록일&nbsp;<span>${detail.n_date}</span></p>
        <p class="compname">${detail.n_comName}</p>
    </div>
    <div class="lookup" style="height:auto; min-height:1500px;">
        <p class="titletxt">" <span>${detail.n_title}</span> "
        
        <span style="float:right;"><a href="noticeModifyForm.no?n_no=${detail.n_no}" style="font-size:12px;">삭제</a></span>
        <span style="float:right;"><a href="noticeModifyForm.no?n_no=${detail.n_no}" style="font-size:12px;">수정</a></span>
        </p>
        <img class="lookup_img1" src="images/${detail.n_img}" alt="">
        <div class="company_box">
            <p class="cb_compname">${detail.n_comName}</p>
            <p><span class="cb_span1">대표</span><span class="cb_span2">${detail.n_ceoName}</span></p>
            <p><span class="cb_span1">회사주소</span><span class="cb_span2">${detail.n_address}</span></p>
            <p><span class="cb_span1">업직종</span><span class="cb_span2">${detail.n_job}</span></p>
            <c:choose>
            	<c:when test="${ncsState==false}">
            		<a class="applybtn" href="javascript:cot_tl_bigPopup('noticCareerListSupport.no?n_no=${param.n_no}')">지원하기</a>
            	</c:when>
            	<c:otherwise>
            		<a class="applybtn" href="#" style="background:#e0e3ec; color:#000;">지원하기</a>
            	</c:otherwise>
            </c:choose>            
        </div>
        <h3 class="table_title">모집조건</h3>
        <div class="table_box tb1">
            <ul class="tb_ul1">
                <li>마감일</li>
                <li>모집인원</li>
                <li>모집분야</li>
                <li>성별</li>
                <li>연령</li>
                <li>학력</li>
            </ul>
            <ul class="tb_ul2">
                <li>${detail.n_endDate}</li>
                <li>${detail.n_reCruit}</li>
                <li>${detail.n_field}</li>
                <li>${detail.n_gender}</li>
                <li>${detail.n_age}</li>
                <li>${detail.n_acadamiBg}</li>
            </ul>
        </div><!-- /.tb1-->
        <h3 class="table_title">근무조건</h3>
        <div class="table_box tb2">
            <ul class="tb_ul1">
                <li>급여</li>
                <li>근무기간</li>
                <li>근무요일</li>
                <li>근무시간</li>
                <li>업직종</li>
                <li>근무형태</li>
            </ul>
            <ul class="tb_ul2">
                <li>${detail.n_sal}</li>
                <li>${detail.n_workTerm}</li>
                <li>${detail.n_workDay}</li>
                <li>${detail.n_workTime}</li>
                <li>${detail.n_job}</li>
                <li>${detail.n_workForm}</li>
            </ul>
        </div><!-- /.tb2-->
        <!--<p class="red_letters">※ 시급제, 중식 제공, 출입카드 지급</p>-->
        <h3 class="table_title">지원</h3>
        <div class="table_box tb3">
            <ul class="tb_ul1">
                <li>담당자</li>
                <li>이메일</li>
                <li>전화</li>
                <li>지원방식</li>
                <li>비고</li>
            </ul>
            <ul class="tb_ul2">
                <li>${detail.n_name}</li>
                <li>${detail.n_email}</li>
                <li>${detail.n_phone}</li>
                <li>${detail.n_supportForm}</li>
                <li>-</li>
            </ul>
        </div><!-- /.tb2-->
        <h3 class="table_title">근무지역</h3>
        <p>${detail.n_address}</p>
        <h3 class="table_title">상세모집요강</h3>
        <p>
        	${detail.n_content}
        </p>
        <h3 class="table_title">장소</h3>
        <div id="map" style="width:100%;height:350px;"></div>
    </div><!--/.lookup-->
</div>
</body>
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
    
    function cot_tl_bigPopup(url){
	     newwindow=window.open(url,'name','WIDTH=490,HEIGHT=690,FRAMEBORDER=0,MARGINWIDTH=0,MARGINHEIGHT=0,scrollbars=yes,SCROLLING=yes,allowtransparency=true');
	     if(window.focus){newwindow.focus()}
	 }
</script>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=cbd7bdce0a1a5c0f6d4774d9c0f54d78&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

//일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도 타입 컨트롤을 지도에 표시합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 주소로 좌표를 검색합니다
geocoder.addressSearch('${detail.n_address}', function(result, status) {

    // 정상적으로 검색이 완료됐으면
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">${detail.n_comName}</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    }
});
</script>
</html>