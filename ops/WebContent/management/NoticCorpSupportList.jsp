<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공고 지원 리스트 (기업)</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="management/css/common.css">
<link rel="stylesheet" href="management/css/apc_manage.css">
<style>
	html,body{height:100%;}
	.apc_manage{overflow:hidden;}
	.content_wrap{min-height:100%;}
</style>
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
                    <a href="portfolio.html">포트폴리오 작성</a>
                </div>
                <div class="header_login">
	                <c:choose>
	          			<c:when test="${userID==null&&emID==null}">
		                    <a href="LOGIN/login?loginCk?=0">로그인</a>
		                    <a href="JOIN/joinV1">회원가입</a>
	                  	</c:when>
		          		<c:when test="${userID!=null}">
		          			<a href="LOGIN/login?loginCk?=0">${userID}</a>
		                    <a href="LOGIN/logout" class="join">로그아웃</a>
		          		</c:when>
		          		<c:when test="${emID!=null}">
		          			<a href="myInfo/myPage">${emID} 기업 회원 님</a>
		                    <a href="LOGIN/logout" class="join">로그아웃</a>
		          		</c:when>
	          		</c:choose>
                </div>
                <img src="management/img/logo_icon.png" class="logo_icon_big" alt="bigLogo">
            </div>
        </div>
        <div class="header_bottom">
            <div class="header_gnb">
                <ul class="gnb_main">
                    <li class="menu"><a href="">기업 서비스</a>
                        <ul class="gnb_sub">
                            <li><a href="#"><img src="img/icon8.png" alt="">공고 작성</a></li>
                            <li><a href="#"><img src="img/icon3.png" alt="">지원자 관리</a></li>
                            <li><a href="#"><img src="img/icon5.png" alt="">채용 현황</a></li>
                            <li><a href="#"><img src="img/icon7.png" alt="">인재 정보</a></li>
                        </ul>
                    </li>
                    <li class="menu"><a href="">개인 서비스</a>
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
    <div class="outtext">
        <h3 class="apc_h3">지원자 관리</h3>
        <p class="apc_count">총 <span>${ntbSize }</span>명 지원</p>
    </div>
    <div class="apc_manage">
    <jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="yyyy" var="today" />
    <c:forEach var="ntb" items="${ntb}" varStatus="status">
    	<c:choose>
    		<c:when test="${(status.index+1)%2!=0}">
    			<fmt:parseNumber var="ind" integerOnly="true" value="${ntbSize/(status.index+1)}"/>
    			<fmt:parseNumber var="namogi" integerOnly="true" value="${ntbSize%(status.index+1)}"/>      	
	    		<c:if test="${status.index+1==1&&ind==1&&namogi==0}">
    			<div class="apc_listbox">
    				<div class="apc_list">
    					<div style="overflow:hidden; width:90px; height:90px; margin:7px 0 0 6px; border-radius:50px; background:#fff; position:relative; float:left;">
    						<img class="apc_img" src="MyImage/${ntb.m_id}/profile/${ntb.profile}" alt="원형썸네일" style="width:initial; border-radius:0; height:100%; margin:0; top:50%; left:50%; position:absolute; transform:translate(-50%,-50%)">
    					</div>		                
		                <p class="apc_list_p1"><span>${ntb.name}</span><span>&nbsp;(${fn:substring(ntb.birthday,0,4)}년생 ${(today-fn:substring(ntb.birthday,0,4))+1}세)</span></p>
		                <p class="apc_list_p2">최선을 다하겠습니다.</p>
		                <p class="apc_list_p3">자격증 <span>0</span>개</p> 
		                <p class="apc_list_p4">포트폴리오 <span>${portSize[status.index]}</span>개</p>
		                <p class="apc_list_p5">첨부 파일 <span>5</span>개</p>
		                <c:if test="${ntb.hi_confirmNum=='N'}">
			            	<input type="hidden" id="careerLinkA" value="noticCareerSuccess.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLinkB" value="noticCareerRefusal.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerNameA" value="채용하기">
							<input type="hidden" id="careerNameB" value="거절">
						</c:if>
						<c:if test="${ntb.hi_confirmNum=='Y'}">
							<input type="hidden" id="careerLinkA" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLinkB" value="#"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 취소">
							<input type="hidden" id="careerNameB" value="상세보기">		
						</c:if>		
						<c:if test="${ntb.hi_confirmNum=='R'}">
							<input type="hidden" id="careerLinkA" value=""/>
							<input type="hidden" id="careerLinkB" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 거절함">
							<input type="hidden" id="careerNameB" value="거절 취소">		
						</c:if>	
		            </div>
		         </div>
	    		</c:if>
	    		<c:if test="${ind!=1&&namogi==0}">
    			<div class="apc_listbox">
    				<div class="apc_list">
    					<div style="overflow:hidden; width:90px; height:90px; margin:7px 0 0 6px; border-radius:50px; background:#fff; position:relative; float:left;">
    						<img class="apc_img" src="MyImage/${ntb.m_id}/profile/${ntb.profile}" alt="원형썸네일" style="width:initial; border-radius:0; height:100%; margin:0; top:50%; left:50%; position:absolute; transform:translate(-50%,-50%)">
    					</div>		                
		                <p class="apc_list_p1"><span>${ntb.name}</span><span>&nbsp;(${fn:substring(ntb.birthday,0,4)}년생 ${(today-fn:substring(ntb.birthday,0,4))+1}세)</span></p>
		                <p class="apc_list_p2">최선을 다하겠습니다.</p>
		                <p class="apc_list_p3">자격증 <span>0</span>개</p> 
		                <p class="apc_list_p4">포트폴리오 <span>${portSize[status.index]}</span>개</p>
		                <p class="apc_list_p5">첨부 파일 <span>5</span>개</p>
		                ${ntb.hi_confirmNum}
		                <c:if test="${ntb.hi_confirmNum=='N'}">
			            	<input type="hidden" id="careerLinkA" value="noticCareerSuccess.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLinkB" value="noticCareerRefusal.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerNameA" value="채용하기">
							<input type="hidden" id="careerNameB" value="거절">
						</c:if>
						<c:if test="${ntb.hi_confirmNum=='Y'}">
							<input type="hidden" id="careerLinkA" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLinkB" value="#"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 취소">
							<input type="hidden" id="careerNameB" value="상세보기">		
						</c:if>	
						<c:if test="${ntb.hi_confirmNum=='R'}">
							<input type="hidden" id="careerLinkA" value=""/>
							<input type="hidden" id="careerLinkB" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 거절함">
							<input type="hidden" id="careerNameB" value="거절 취소">		
						</c:if>	
		            </div>
		            
	    		</c:if>
	    		<c:if test="${ind==1&&namogi!=0}">
    			<div class="apc_listbox">
    				<div class="apc_list">
    					<div style="overflow:hidden; width:90px; height:90px; margin:7px 0 0 6px; border-radius:50px; background:#fff; position:relative; float:left;">
    						<img class="apc_img" src="MyImage/${ntb.m_id}/profile/${ntb.profile}" alt="원형썸네일" style="width:initial; border-radius:0; height:100%; margin:0; top:50%; left:50%; position:absolute; transform:translate(-50%,-50%)">
    					</div>		                
		                <p class="apc_list_p1"><span>${ntb.name}</span><span>&nbsp;(${fn:substring(ntb.birthday,0,4)}년생 ${(today-fn:substring(ntb.birthday,0,4))+1}세)</span></p>
		                <p class="apc_list_p2">최선을 다하겠습니다.</p>
		                <p class="apc_list_p3">자격증 <span>0</span>개</p> 
		                <p class="apc_list_p4">포트폴리오 <span>${portSize[status.index]}</span>개</p>
		                <p class="apc_list_p5">첨부 파일 <span>5</span>개</p>
		                <c:if test="${ntb.hi_confirmNum=='N'}">
			            	<input type="hidden" id="careerLinkA" value="noticCareerSuccess.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLinkB" value="noticCareerRefusal.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerNameA" value="채용하기">
							<input type="hidden" id="careerNameB" value="거절">
						</c:if>
						<c:if test="${ntb.hi_confirmNum=='Y'}">
							<input type="hidden" id="careerLinkA" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLinkB" value="#"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 취소">
							<input type="hidden" id="careerNameB" value="상세보기">		
						</c:if>	
						<c:if test="${ntb.hi_confirmNum=='R'}">
							<input type="hidden" id="careerLinkA" value=""/>
							<input type="hidden" id="careerLinkB" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 거절함">
							<input type="hidden" id="careerNameB" value="거절 취소">		
						</c:if>	
		            </div>
		            
	    		</c:if>
	    		<c:if test="${status.index+1!=1&&ind==1&&namogi==0}">
    			<div class="apc_listbox">
    				<div class="apc_list">
    					<div style="overflow:hidden; width:90px; height:90px; margin:7px 0 0 6px; border-radius:50px; background:#fff; position:relative; float:left;">
    						<img class="apc_img" src="MyImage/${ntb.m_id}/profile/${ntb.profile}" alt="원형썸네일" style="width:initial; border-radius:0; height:100%; margin:0; top:50%; left:50%; position:absolute; transform:translate(-50%,-50%)">
    					</div>		                
		                <p class="apc_list_p1"><span>${ntb.name}</span><span>&nbsp;(${fn:substring(ntb.birthday,0,4)}년생 ${(today-fn:substring(ntb.birthday,0,4))+1}세)</span></p>
		                <p class="apc_list_p2">최선을 다하겠습니다.</p>
		                <p class="apc_list_p3">자격증 <span>0</span>개</p> 
		                <p class="apc_list_p4">포트폴리오 <span>${portSize[status.index]}</span>개</p>
		                <p class="apc_list_p5">첨부 파일 <span>5</span>개</p>
		                <c:if test="${ntb.hi_confirmNum=='N'}">
			            	<input type="hidden" id="careerLinkA" value="noticCareerSuccess.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLinkB" value="noticCareerRefusal.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerNameA" value="채용하기">
							<input type="hidden" id="careerNameB" value="거절">
						</c:if>
						<c:if test="${ntb.hi_confirmNum=='Y'}">
							<input type="hidden" id="careerLinkA" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLinkB" value="#"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 취소">
							<input type="hidden" id="careerNameB" value="상세보기">		
						</c:if>	
						<c:if test="${ntb.hi_confirmNum=='R'}">
							<input type="hidden" id="careerLinkA" value=""/>
							<input type="hidden" id="careerLinkB" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 거절함">
							<input type="hidden" id="careerNameB" value="거절 취소">		
						</c:if>	
		            </div>
	            </div>
	    		</c:if>
    		</c:when>
    		<c:when test="${(status.index+1)%2==0}">
    		   		
    		<fmt:parseNumber var="ind" integerOnly="true" value="${ntbSize/(status.index+1)}"/>
    				<div class="apc_list">
		                <div style="overflow:hidden; width:90px; height:90px; margin:7px 0 0 6px; border-radius:50px; background:#fff; position:relative; float:left;">
    						<img class="apc_img" src="MyImage/${ntb.m_id}/profile/${ntb.profile}" alt="원형썸네일" style="width:initial; border-radius:0; height:100%; margin:0; top:50%; left:50%; position:absolute; transform:translate(-50%,-50%)">
    					</div>
		                <p class="apc_list_p1"><span>${ntb.name}</span><span>&nbsp;(${fn:substring(ntb.birthday,0,4)}년생 ${(today-fn:substring(ntb.birthday,0,4))+1}세)</span></p>
		                <p class="apc_list_p2">최선을 다하겠습니다.</p>
		                <p class="apc_list_p3">자격증 <span>0</span>개</p> 
		                <p class="apc_list_p4">포트폴리오 <span>${portSize[status.index]}</span>개</p>
		                <p class="apc_list_p5">첨부 파일 <span>5</span>개</p>
		                <c:if test="${ntb.hi_confirmNum=='N'}">
			            	<input type="hidden" id="careerLinkA" value="noticCareerSuccess.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLinkB" value="noticCareerRefusal.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
			            	<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>			            	
			            	<input type="hidden" id="careerNameA" value="채용하기">
							<input type="hidden" id="careerNameB" value="거절">
						</c:if>
						<c:if test="${ntb.hi_confirmNum=='Y'}">
							<input type="hidden" id="careerLinkA" value="NoticCareerCance.no?hi_no=${ntb.hi_no}&&n_no=${param.n_no}"/>
							<input type="hidden" id="careerLinkB" value="#"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 취소">
							<input type="hidden" id="careerNameB" value="상세보기">		
						</c:if>	
						<c:if test="${ntb.hi_confirmNum=='R'}">
							<input type="hidden" id="careerLinkA" value=""/>
							<input type="hidden" id="careerLinkB" value="#"/>
							<input type="hidden" id="careerLink" value="careerDetail.ops2?ca_no=${ntb.ca_no }"/>
			            	<input type="hidden" id="careerNameA" value="채용 거절함">
							<input type="hidden" id="careerNameB" value="거절취소">		
						</c:if>	
		            </div>
	            </div>
    		</c:when>
    	</c:choose>
	</c:forEach>
        <div class="viewbox">
            <div class="apc_list">
            	<div style="overflow:hidden; width:90px; height:90px; margin:7px 0 0 6px; border-radius:50px; background:#fff; position:relative; float:left;">
					<img class="apc_imgView" src="" alt="원형썸네일" style="width:initial; border-radius:0; height:100%; margin:0; top:50%; left:50%; position:absolute; transform:translate(-50%,-50%)">
				</div>
                <p class="apc_list_p1"><span>김태경</span><span>&nbsp;(1997년생 23세)</span></p>
                <p class="apc_list_p2">최선을 다하겠습니다.</p>
                <p class="apc_list_p3">자격증 <span>5</span>개</p> 
                <p class="apc_list_p4">포트폴리오 <span>5</span>개</p>
                <p class="apc_list_p5">첨부 파일 <span>5</span>개</p>
                <div class="view_a">
                    <a class="view_a1" href="#">채용하기</a>
                    <a class="view_a2" href="#">거절하기</a>
                </div>
            </div>
            <div style="margin-top:260px;">
                <p class="p6">현재 VIEW 화면에서만 적용됩니다.</p>
                <a class="view_a3" href="#" >VIEW 이동하기</a>
            </div>
        </div>
    </div><!--apc_manage-->
    </div>
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
	        //
	        $('.apc_list',this).click(function(){
	            if($(this).hasClass('on')){
	                $('.viewbox').slideUp(100);
	                $(this).removeClass('on')
	                $(this).css({'border-bottom':'1px solid #e3e3e3'});                
	            }else{
	                $(this).addClass('on');
	                $('.viewbox .apc_imgView').attr('src',$('.apc_img',this).attr('src'));
	                $('.viewbox .apc_list_p1 span:nth-child(1)').text($('.apc_list_p1 span:nth-child(1)',this).text());
	                $('.viewbox .apc_list_p1 span:nth-child(2)').text($('.apc_list_p1 span:nth-child(2)',this).text());
	                $('.viewbox .apc_list_p2').text($('.apc_list_p2',this).text());
	                $('.viewbox .apc_list_p3 span').text($('.apc_list_p3 span',this).text());
	                $('.viewbox .apc_list_p4 span').text($('.apc_list_p4 span',this).text());
	                $('.viewbox .apc_list_p5 span').text($('.apc_list_p5 span',this).text());
					$('.view_a1').text($('#careerNameA',this).val());
					$('.view_a2').text($('#careerNameB',this).val());					
					$('.view_a3').attr('href',$('#careerLink',this).val());
					$('.view_a1').attr('href',$('#careerLinkA',this).val());
					$('.view_a2').attr('href',$('#careerLinkB',this).val());
	                $('.viewbox').css({
	                        'top':$(".apc_list",this).height()+30+'px', 
	                        'float':'left'
	                    });
	                $('.viewbox').slideDown(100) 
	                $('.apc_list').not($(this)).removeClass('on')  
	                $(this).css({'border-bottom':'1px solid #1c69f5'})
	                $('.apc_list').not($(this)).css({'border-bottom':'1px solid #e3e3e3'})
	            }
	        })
	    })
	</script>
	<%@ include file="../footerNoParent.jsp" %>
</body>
</html>