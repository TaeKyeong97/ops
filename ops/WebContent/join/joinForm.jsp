<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>OPS : 일반 회원가입</title>
<link rel="stylesheet" href="../join/css/join.css" type="text/css">
<link rel="stylesheet" href="../css/common.css" type="text/css">
<script type="text/javascript" src="https://address.ops.or.kr:8983/app/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
	/**
	 * 주소 검색 화면 호출(Basic)
	 */
	function fn_openUrlJusoSearchBasic() {
		var pop = window.open("https://address.ops.or.kr:8983/app/open/search/JusoSearchBasic.jsp",	"pop_basic",
				"width=450,height=550,scrollbars=yes,resizable=yes");
	}
	function fn_setJuso(data) {
		$("#roadFullAddr").val(data["roadFullAddr"]);
		$("#roadAddrPart1").val(data["roadAddrPart1"]);
		$("#roadAddrPart2").val(data["roadAddrPart2"]);
		$("#jibunAddr").val(data["jibunAddr"]);
		$("#engAddr").val(data["engAddr"]);
		$("#zipNo").val(data["zipNo"]);
		$("#admCd").val(data["admCd"]);
		$("#rnMgtSn").val(data["rnMgtSn"]);
		$("#bdMgtSn").val(data["bdMgtSn"]);

		$("#bdNm").val(data["bdNm"]);
		$("#bdKdcd").val(data["bdKdcd"]);
		$("#siNm").val(data["siNm"]);
		$("#sggNm").val(data["sggNm"]);
		$("#emdNm").val(data["emdNm"]);
		$("#liNm").val(data["liNm"]);
		$("#rn").val(data["rn"]);
		$("#udrtYn").val(data["udrtYn"]);
		$("#buldMnnm").val(data["buldMnnm"]);
		$("#buldSlno").val(data["buldSlno"]);
		$("#mtYn").val(data["mtYn"]);
		$("#lnbrMnnm").val(data["lnbrMnnm"]);
		$("#lnbrSlno").val(data["lnbrSlno"]);
	}
</script>
</head>
<body>
<form method="post" id="form1" name="writeform" enctype="multipart/form-data">
<div id="join-wrap">
	<div class="join-header">
		<h1 class="logo"><a href="../ops/main"></a></h1>
	</div>
	<div class="join-content">
		<div class="consent-con">
      <div class="join-check checkID"></div>
			<div class="left join-input-con">
        <input type="text" name="id" class="EM_id" placeholder="아이디">
        <button type="button" name="button" onclick="joinIdCk()">중복확인</button>
      </div>
      <div class="join-check checkPW"></div>
      <div class="left join-input-con">
        <input type="password" name="pw" class="EM_pw" value="" placeholder="비밀번호">
      </div>
      <div class="left join-input-con">
        <input type="text" name="name" value="" placeholder="이름">
      </div>
      <div class="left join-input-con">
        <input type="text" name="sex" value="" placeholder="남자 여자">
      </div>
      <div class="left join-input-con join-temple">
        <input type="number" name="year" value="" placeholder="년도">
        <input type="number" name="month" value="" placeholder="월">
        <input type="number" name="day" value="" placeholder="일">
      </div>
      <div class="join-check checkPHONE"></div>
      <div class="left join-input-con">
        <input type="text" name="phone" placeholder="휴대폰번호">
      </div>
      <div class="left join-input-con">
        <input type="text" name="email" placeholder="이메일">
      </div>
      <div class="left join-input-con">
        <input type="text" name="zipNo" id="zipNo" placeholder="우편번호" onClick="javascript:fn_openUrlJusoSearchBasic()">
        <button type="button" name="button" onClick="javascript:fn_openUrlJusoSearchBasic()">주소검색</button>
      </div>
      <div class="left join-input-con">
        <input type="text" name="roadAddr" id="roadAddrPart1" placeholder="도로명주소">
      </div>
      <div class="left join-input-con">
        <input type="hidden" name="jibunAddr" id="jibunAddr" placeholder="지번">
        <input type="text" name="realAddr" id="realAddrPart1" placeholder="상세 주소">
      </div>
	  <div class="left join-input-con" style="height:188px;">
        <div style="padding:9px 0; font-size:15px; font-weight:bold;">프로필</div>
        <input id="document-file" type="file" name="profile" style="padding:63px 19px;">
      </div>
		</div>
	</div>
	<div style="min-height:68px;"><input type="button" class="submit" value="가입하기" onclick="submits(this.form)"></div>
	<input type="hidden" class="cks" name="cks" value="0">
</div>
</form>
<div class="footer">
<a href="#">© OPS Corp.</a>
</div>
<script>
  function submits(form1){
    var EM_id=form1.id.value;
    var EM_pw=form1.pw.value;
    var EM_phon=form1.phone.value;
    var cks1=form1.cks.value;
    
    if(EM_id==""&&EM_pw==""&&EM_phon==""){
      document.getElementsByClassName("checkID")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPW")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="필수정보입니다.";
      form1.id.focus();
      return false;
    }
    if(EM_id==""&&EM_pw==""){
      document.getElementsByClassName("checkID")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPW")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="";
      form1.id.focus();
      return false;
    }
    if(EM_pw==""&&EM_phon==""){
      document.getElementsByClassName("checkID")[0].innerHTML="";
      document.getElementsByClassName("checkPW")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="필수정보입니다.";
      form1.pw.focus();
      return false;
    }
    if(EM_id==""&&EM_phon==""){
      document.getElementsByClassName("checkID")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPW")[0].innerHTML="";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="필수정보입니다.";
      form1.id.focus();
      return false;
    }

    if(EM_id==""){
      document.getElementsByClassName("checkID")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPW")[0].innerHTML="";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="";
      form1.id.focus();
      return false;
    }

    if(EM_pw==""){
      document.getElementsByClassName("checkID")[0].innerHTML="";
      document.getElementsByClassName("checkPW")[0].innerHTML="필수정보입니다.";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="";
      form1.pw.focus();
      return false;
    }
    if(EM_phon==""){
      document.getElementsByClassName("checkID")[0].innerHTML="";
      document.getElementsByClassName("checkPW")[0].innerHTML="";
      document.getElementsByClassName("checkPHONE")[0].innerHTML="필수정보입니다.";
      form1.phone.focus();
      return false;
    }
    if(cks1!="1"){
    	document.getElementsByClassName("checkID")[0].innerHTML="중복 체크 해주세요";
    	return false;
    }
    var myId=document.getElementsByClassName("EM_id")[0].value;
    writeform.action="joinPro?myId="+myId;
    form1.submit();
  }
</script>

<script>
	function joinIdCk(writeform){
		 var id=document.getElementsByClassName('EM_id')[0];
		 var ids=id.value;
		 window.open("overCK?EM_id="+ids, "네이버새창", "width=370, height=300, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	
	}
	
	function okes(ok){
		var id=document.getElementsByClassName("EM_id")[0];
		var cks=document.getElementsByClassName("cks")[0];
		id.value=ok;
		cks.value='1';
	}
	function reCk(){
		var ok=document.getElementsByClassName("ok")[0];
		location.href="overCK?EM_id="+ok.value;
	}
</script>
<script>
function receiveMessage(event){
	var oncomplete = function(a) {};
	oncomplete(event.data);
	var obj=event.data;
	var keys = Object.keys(obj);
	var objI;
	for(var i in keys) {
		if(keys[i]!=0&&keys[i]!=1&&keys[i]!=2&&keys[i]!=3&&keys[i]!=4&&keys[i]!=5&&keys[i]!=6&&keys[i]!=7&&keys[i]!=6&&keys[i]!=8&&keys[i]!=9){
			eval("var "+keys[i]+"=\""+obj[keys[i]]+"\"");
		}
	}
	$("#zipNo").val(zipNo);
	$("#roadAddrPart1").val(roadAddrPart1);
	$("#jibunAddr").val(jibunAddr);
}
window.addEventListener("message", receiveMessage, false);
</script>
</body>
</html>

