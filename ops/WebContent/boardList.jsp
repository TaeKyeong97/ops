<%@ page import="ops.Notice.Beans.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>질문 답변</title>
<link rel="stylesheet" href="css/qna.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<style>
*{margin:0;padding:0;}
ul,ol,li{list-style:none;}
a{text-decoration:none;color:#333;}
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700&subset=korean');*{font-family:'Nanum Gothic',sans-serif;font-weight:400;font-style:normal;}.wrap{width:100%;}.header{width:100%;border-bottom:1px solid#ccc;box-sizing:border-box;position:relative;z-index:10;}.header a{display:inline-block;}.header_top{width:100%;background-color:#1c69f5;}.header_bottom{width:100%;background-color:#fff;}
@media(max-width:1100px){.header_content{min-width:100%;height:10vh;margin:0 auto;border:1px solid red;box-sizing:border-box;}.input_search{width:200px;}}
@media(max-width:1920px){.header_content{width:80%;height:100px;position:relative;margin:0 auto;overflow:hidden;}.header_gnb{width:80%;height:40px;position:relative;margin:0 auto;background-color:#fff;}.header_logo{width:180px;height:50px;margin-top:25px;float:left;}.header_logo::after{clear:both;display:block;content:'';}.header_logo img{width:180px;height:50px;}.header_search{display:inline-block;position:absolute;top:35px;left:20%;}.input_search{width:350px;height:2rem;padding:2px 15px;border-radius:1.2rem;border:none;}.header_portfolio{display:inline-block;border:1px solid#fff;padding-right:12px;position:absolute;top:32px;transform:translate(-50%);left:63%;}.header_portfolio img{width:40px;height:30px;padding-top:3px;float:left;}.header_portfolio a{font-size:0.8rem;line-height:2.3rem;color:#fff;}.header_login{display:inline-block;position:absolute;top:40px;transform:translate(-50%);left:80%;}.header_login a{display:inline-block;color:#fff;font-size:0.8rem;}.header_login a:nth-child(1){margin-right:15px;}.header_login a:nth-child(2){margin-right:15px;}.logo_icon_big{width:180px;height:170px;position:absolute;top:22px;right:-20px;}.header_gnb a{font-size:0.8rem;}.header_gnb{height:40px;}.gnb_main{width:80%;margin:0 auto;}.gnb_main>li{float:left;position:relative;}.gnb_main li a{width:150px;display:block;line-height:40px;text-align:center;}.gnb_main>li>a{background-color:#fff;color:#333;}.gnb_sub{position:absolute;left:0;top:50px;z-index:100;display:none;}.gnb_sub li{}.gnb_sub li a{background-color:#fff;}.gnb_bg{position:absolute;width:100%;height:200px;background-color:#fff;left:0;top:40px;z-index:99;display:none;box-sizing:border-box;}.visual{width:100%;height:200px;background-color:#fff;display:none;position:absolute;z-index:98;border-top:1px solid#ccc;box-sizing:border-box;}.gnb_sub img{width:30px;}.qna_li{border-bottom:0;}.qna_ul>.qna_li:first-child{border:0;border-bottom:1px;border-style:solid;border-color:#dedeef;}.qna_ul:last-child>.qna_li:last-child{border-top:0;border-bottom:1px!important;border-style:solid;}}

body{background-color:#eeeff3}@media (max-width:1920px){.content_wrap{width:100%;position:relative;left:0}.question_wrap{width:60%;height:auto;position:relative;margin:0 auto;margin-bottom:100px;box-sizing:border-box}.outtext{width:60%;height:1.5em;margin:0 auto;position:relative;font-size:1em;margin-top:50px;margin-bottom:30px}.title_txt{font-size:22px;margin-left:15px}.tablink_box{width:60%;height:auto;background-color:#fff;margin:0 auto;margin-top:20px}.tablink_box p{display:inline-block;margin:0 10px 0 10px}.tablink_box p:nth-child(1){margin-left:50px}.tablink_box p a{font-size:16px;padding:10px 3px 10px 3px;display:inline-block;box-sizing:border-box;line-height:40px}.tabcontent{display:none}.tabcontent_box{width:100%;margin-top:25px}.tabcontent_ul{width:100%;box-sizing:border-box;float:left}.tbul{border-bottom:1px solid #dedede}.tabcontent_ul li{box-sizing:border-box;text-align:center;float:left;height:60px;background-color:#fff;line-height:60px}.tabcontent_ul li:nth-child(1){width:10%}.tabcontent_ul li:nth-child(2){width:50%}.tabcontent_ul li:nth-child(3){width:20%}.tabcontent_ul li:nth-child(4){width:20%}.active{border-bottom:1px solid #1c69f5;box-sizing:border-box}}
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
              <li><a href="#"><span class="opsLogo i_con i_conF"></span><span class="text">BEST 포트폴리오</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conG"></span><span class="text">관심 기업정보</span></a></li>
              <li><a href="#"><span class="opsLogo i_con i_conH"></span><span class="text">MY 포트폴리오</span></a></li>
              <li><a href="../write/careerWriteForm.ops2"><span class="opsLogo i_con i_conH"></span><span class="text">이력서 작성</span></a></li>
              <li class="reaction_type"><a href="#"><span class="opsLogo i_con i_conH"></span><span class="text">MY 이력서</span></a></li>
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
	<div class="tablink_box">
          <p><a href="#" class="tablinks defaultOpen" onclick="tabQuestion(event,'all_q')">전체 문의게시판</a></p>
          <p><a href="#" class="tablinks" onclick="tabQuestion(event,'my_q')">나의 문의게시판</a></p>
      </div>
	<div class="content_wrap">
	    <div class="outtext">
	    	<c:if test="${userId!=null}"><span><a href="boardWriteForm.no" style="float:right;">질문 작성하기</a></span></c:if>
	        <h3 class="title_txt">질문 답변</h3>
	    </div>
	    <div class="qna_wrap">
	    <c:forEach var = "boardList" items="${boardList}">
	        <ul class="qna_ul" >
	            <li class="qna_li"><span>Q</span>${boardList.board_title}<span style="line-height:30px; float:right; font-size:14px;">${boardList.board_date}</span></li>
	            <li class="qna_li" style="overflow:hidden;">
	            	<div style="float:right;">
	            		<span style="font-size:12px">질문작성자:</span><span style="font-size:12px">${boardList.board_id}</span>
	            	</div>
	            	<div>
	            		<c:if test="${boardList.board_img!=null}"><img src="images/${boardList.board_img}"/><br></c:if> 
	            		질문 내용 : ${boardList.board_content}
	            	</div>
	            	<p style="margin:10px 0; border-bottom:1px solid #e3e4e6;"></p>
	            	<div>
	            		답변 내용 : ${boardList.board_reply}
	            	</div>
	            	<div style="float:right; overflow:hidden;">
		            	<input type="button" value="수정" onclick="location.href='boardModify.no?board_no=${boardList.board_no}'" style="background:#1c69f5; color:#fff;border:0; padding:5px 15px;">
		            	<input type="button" value="삭제" onclick="location.href='boardDelete.no?board_no=${boardList.board_no}'" style="background:#f26666; color:#fff; border:0; padding:5px 15px;">
	            	</div>
	            </li>
	        </ul>
				<td><a href="boardDetail.no?board_no=${boardList.board_no}"></a></td>
				<td></td>
				<td></td>
				<td></td>
        </c:forEach>
	    </div>
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
        $('.qna_ul .qna_li:nth-child(1)').click(function(){
            if($(this).next().css('display')=='block'){
                $(this).next().css('display','none')
            }else{
                $(this).next().css('display','block')
            }
        })
    })
</script>
</body>
</html>