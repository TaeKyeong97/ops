<%@ page import="ops.Notice.Beans.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
	<title>공고 수정</title>
	<script type="text/javascript">
		function modifyboard(){
			modifyform.submit();
		}
	</script>
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
<h2>공고수정</h2><br>
<div class="career-wrap">
<form action="noticeModifyPro.no" method="post" name = "modifyform">
<input type = "hidden" name = "n_no" value = "${n.n_no}"/>
	      <div id="car-title" class="car-title">
          	<input name="title" placeholder="제목" type="text" id="title" value = "${n.n_title}"/>
          </div>
          <div class="car-con">
          	<textarea id="content" placeholder="내용" name="content" cols="68" rows="20">${n.n_content}</textarea>
          </div>
          <div class="">
          	<input name="img" placeholder="이미지파일" type="file" id="img" value = "${n.n_img}" />
          </div>
          <div class="car-satis">
          	<input name="comName" placeholder="기업명" type="text" id="comName" value = "${n.n_comName}" />
          </div>
          
          <div class="car-satis">
          	<input name="ceoName" placeholder="대표이름" type="text" id="ceoName" value = "${n.n_ceoName}" />
          </div>
          
          <div class="car-satis">
          	<input name="address" placeholder="회사주소" type="text" id="address" value = "${n.n_address}" />
          </div>
          
		  <div class="car-satis">
          	<input name="job" placeholder="직종" type="text" id="job" value = "${n.n_job}" />
		  </div>
			
		  <div class="car-satis">
          	<input name="reCruit" placeholder="모집인원" type="text" id="reCruit" value = "${n.n_reCruit}" />
          </div>
          <div class="car-satis">
          	<input name="field" placeholder="모집분야" type="text" id="field" value = "${n.n_field}" />
          </div>
          <div class="car-satis">
          	<input name="gender" placeholder="성별" type="text" id="gender" value = "${n.n_gender}"  />
          </div>
          <div class="car-satis">
          	<input name="age" placeholder="연령" type="text" id="age" value = "${n.n_age}" />
          </div>
          <div class="car-satis">
          	<input name="acadamiBg" placeholder="학력" type="text" id="acadamiBg" value = "${n.n_acadamiBg }"  />
          </div>
          <div class="car-satis">
          	<input name="sal" placeholder="급여" type="text" id="sal" value = "${n.n_sal }" />  
          </div>
          <div class="car-satis">
          	<input name="endDate" placeholder="공고 종료일" type="text" id="endDate" value = "${n.n_endDate}"/>
          </div>
          <div class="car-satis">
          	<input name="workTerm" placeholder="근무기간" type="text" id="workTerm" value = "${n.n_workTerm}"/>  
          </div>
          <div class="car-satis">
          	<input name="workDay" placeholder="근무요일" type="text" id="workDay" value = "${n.n_workDay}"/>     
   		  </div>
          <div class="car-satis">
          	<input name="workTime" placeholder="근무시간" type="text" id="workTime" value = "${n.n_workTime}"/>  
          </div>
          <div class="car-satis">
          	<input name="workForm" placeholder="근무형태" type="text" id="workForm" value = "${n.n_workForm}"/>
		  </div>
		  <div class="car-satis">
          	<input name="name" placeholder="담당자" type="text" id="name" value = "${n.n_name}"/>
		  </div>
		  <div class="car-satis">
          	<input name="email" placeholder="이메일" type="text" id="email" value = "${n.n_email}"/>
		  </div>
		  <div class="car-satis">
          	<input name="phone" placeholder="연락처" type="text" id="phone"  value = "${n.n_phone}"/>
		  </div>
		  <div class="car-satis">
          	<input name="supportForm" placeholder="지원방식" type="text" id="supportForm" value = "${n.n_supportForm}"/>
		  </div>
		  <div class="car-satis">
          	<input name="bigo" placeholder="비고" type="text" id="bigo" value = "${n.n_bigo}"/>
		  </div>
			<input type="submit" value="수정">
            <input type="button" value="뒤로" class="suc" onclick="javascript:window.history.back();">
	
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