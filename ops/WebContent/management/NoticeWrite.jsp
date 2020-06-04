<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <title>공고 작성</title>
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
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <style>
    	.fileup-file{width:100%; width:-webkit-fill-available; width: 95%; margin: 5px auto; max-width:none !important; background:#fff; border-radius:0;}
   		.career-wrap .car-content{margin:0 auto; float:none;}   
   		.sb:hover{background-color:#1c69f5;}
   		.ui-datepicker-trigger{display:none;}
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
	            <a href="LOGIN/login?loginCk?=0" class="login">${userID}</a>
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
      <div style="width:55%; margin:0 auto;"><h2 style="margin-left:20px;font-size:24px;">공고작성</h2></div>
      <form id="go" action="noticeWrite.no" method="post" enctype="multipart/form-data" class="car-content">
         <div id="car-title" class="car-title">
          <input id="title" type="text" name="title" value="" placeholder="제목">
       	</div>
        <div class="car-con">
          <textarea id="content" class="car-textCon" name="content" rows="8" cols="80" placeholder="자기소개" onkeyup="cartextCon()"></textarea>
        </div>
                                                 
          <div class="">
          <input id="img" name="img" placeholder="이미지파일" type="file" id="img" />
          </div>
        <div class="car-satis">
          <input id="comName" type="text" name="comName" value="" placeholder="기업명">
        </div> 
        <div class="car-satis">
          <input id="ceoName" name="ceoName" placeholder="대표이름" type="text" />
        </div>
        <div class="car-satis">
          <input  id="address" name="address" placeholder="회사주소" type="text"/>
        </div>
        <div class="car-satis">
          <input  id="job"name="job" placeholder="직종" type="text" id="job"  />
        </div>
        <div class="car-satis">
          <input id="reCruit" name="reCruit" placeholder="모집인원" type="text" value=""/>
        </div>
        <div class="car-satis">
          <input id="field"  name="field" placeholder="모집분야" type="text"/>
        </div>
        <div class="car-satis">
          <input   id="gender" name="gender" placeholder="성별" type="text"/>
        </div>
        <div class="car-satis">
          <input  id="age" name="age" placeholder="연령" type="text"/>
        </div>
        <div class="car-satis">
          <input id="acadamiBg" name="acadamiBg" placeholder="학력" type="text"/>
        </div>
        <div class="car-satis">
          <input id="sal" name="sal" placeholder="급여" type="text" id="sal"  />  
        </div>
        <div class="car-satis">
          <input id="endDate" name="endDate" placeholder="공고 종료일" type="text" />
        </div>
        <div class="car-satis">
          <input id="workTerm" name="workTerm" placeholder="근무기간" type="text"/>
        </div>
        <div class="car-satis">
          <input id="workDay" name="workDay" placeholder="근무요일" type="text"/>
        </div>
        <div class="car-satis">
          <input id="workTime" name="workTime" placeholder="근무시간" type="text"/>
   		</div>
   		<div class="car-satis">
          <input id="workForm" name="workForm" placeholder="근무형태" type="text"/>
        </div>
        <div class="car-satis">
          <input id="name" name="name" placeholder="담당자" type="text"/>
       	</div>
       	<div class="car-satis">
          <input id="email" name="email" placeholder="이메일" type="text"/>
        </div>
        <div class="car-satis">
          <input id="phone" name="phone" placeholder="연락처" type="text"/>
        </div> 
        <div class="car-satis">
          <input id="supportForm" name="supportForm" placeholder="지원방식" type="text"/>
        </div>
        <div class="car-satis">
          <input id="bigo" name="bigo" placeholder="비고" type="text"/>
        </div>
          <input class="sb" style="border-radius:50px;width:200px;margin:0 auto;display:block;margin-top:20px;background-color: #fff;" type="button" value="등록" onclick="gonow()">
      </form>
   </div>
</body>
<script>
	function gonow(form){
		var title=document.getElementById('title').value;
		var content=document.getElementById('content').value;
		var img=document.getElementById('img').value;
		var comName=document.getElementById('comName').value;
		var ceoName=document.getElementById('ceoName').value;
		var address=document.getElementById('address').value;
		var job=document.getElementById('job').value;
		var recruit=document.getElementById('recruit');
		var field=document.getElementById('field').value;
		var gender=document.getElementById('gender').value;
		var age=document.getElementById('age').value;
		var acadamiBg=document.getElementById('acadamiBg').value;
		var sal=document.getElementById('sal').value;
		var endDate=document.getElementById('endDate').value;
		var workTerm=document.getElementById('workTerm').value;
		var workDay=document.getElementById('workDay').value;
		var workTime=document.getElementById('workTime').value;
		var workForm=document.getElementById('workForm').value;
		var name=document.getElementById('name').value;
		var email=document.getElementById('email').value;
		var phone=document.getElementById('phone').value;
		var supportForm=document.getElementById('supportForm').value;
		
		go = document.getElementById('go');
		var isCheck=1;
		//go.submit();
		if(title==""){
			alert("제목을 입력하세요");
			isCheck=0;
		}else if(content==""){
			alert("내용을 입력하세요");
			isCheck=0;
		}
		else if(img==""){
			alert("이미지를 등록하세요");
			isCheck=0;
		}
		else if(comName==""){
			alert("회사명을 입력하세요");
			isCheck=0;
		}
		else if(ceoName==""){
			alert("대표명을 입력하세요");
			isCheck=0;
		}
		else if(address==""){
			alert("주소를 입력하세요");
			isCheck=0;
		}
		else if(job==""){
			alert("직종을 입력하세요");
			isCheck=0;
		}
		else if(recruit==""){
			alert("모집인원을 입력하세요");
			isCheck=0;
		}
		else if(field==""){
			alert("모집분야를 입력하세요");
			isCheck=0;
		}
		else if(gender==""){
			alert("성별을 입력하세요");
			isCheck=0;
		}
		else if(age==""){
			alert("연령을 입력하세요");
			isCheck=0;
		}else if(acadamiBg==""){
			alert("학력을 입력하세요");
			isCheck=0;
		}else if(sal==""){
			alert("연봉을 입력하세요");
			isCheck=0;
		}
		else if(endDate==""){
			alert("공고종료일을 입력하세요");
			isCheck=0;
		}
		else if(workTerm==""){
			alert("근무기간을 입력하세요");
			isCheck=0;
		}
		else if(workDay==""){
			alert("근무요일을 입력하세요");
			isCheck=0;
		}
		else if(workTime==""){
			alert("근무시간을 입력하세요");
			isCheck=0;
		}
		else if(workForm==""){
			alert("근무형태을 입력하세요");
			isCheck=0;
		}
		else if(name==""){
			alert("담당자를 입력하세요");
			isCheck=0;
		}
		else if(email==""){
			alert("이메일을 입력하세요");
			isCheck=0;
		}
		else if(phone==""){
			alert("연락처을 입력하세요");
			isCheck=0;
		}
		else if(supportForm==""){
			alert("지원방식을 입력하세요");
			isCheck=0;
		}
		
		if(isCheck==1){
			go.submit();
		}
		
		
	}
</script>


 <script>
        $(function() {
            //모든 datepicker에 대한 공통 옵션 설정
            $.datepicker.setDefaults({
                dateFormat: 'yy-mm-dd' //Input Display Format 변경
                ,showOtherMonths: true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
                ,showMonthAfterYear:true //년도 먼저 나오고, 뒤에 월 표시
                ,changeYear: true //콤보박스에서 년 선택 가능
                ,changeMonth: true //콤보박스에서 월 선택 가능                
                ,showOn: "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
                ,buttonImage: "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
                ,buttonImageOnly: true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
                ,buttonText: "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
                ,yearSuffix: "년" //달력의 년도 부분 뒤에 붙는 텍스트
                ,monthNamesShort: ['1','2','3','4','5','6','7','8','9','10','11','12'] //달력의 월 부분 텍스트
                ,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip 텍스트
                ,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 부분 텍스트
                ,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 부분 Tooltip 텍스트
                ,minDate: "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
                ,maxDate: "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                    
            });
 
            //input을 datepicker로 선언
            $("#endDate").datepicker();                    
            
            //From의 초기값을 오늘 날짜로 설정
            $('#endDate').datepicker('setDate', 'today'); //(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)
            //To의 초기값을 내일로 설정
        });
    </script>
</html>