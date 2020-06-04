<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" type="text/css" href="css/p-main.css">
    <link rel="stylesheet" href="css/create.css">
    <link rel="stylesheet" href="css/amimation.css">
    <meta charset="utf-8">
    <title></title>
    <style media="screen">
      .x-logo{width:150px; float:left;}
      .x-pwrap{min-width:967px;}
      #audio{display:none;}

    </style>
    <script src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU=" crossorigin="anonymous"></script>
    <script>
    $(document).ready(function() {
        var audioElement = document.createElement('audio');
        audioElement.setAttribute('src', 'audio/audio.mp3');

        audioElement.addEventListener('ended', function() {
            this.play();
        }, false);

        audioElement.addEventListener("canplay",function(){
            $("#length").text("Duration:" + audioElement.duration + " seconds");
            $("#source").text("Source:" + audioElement.src);
            $("#status").text("Status: Ready to play").css("color","green");
        });

        audioElement.addEventListener("timeupdate",function(){
            $("#currentTime").text("Current second:" + audioElement.currentTime);
        });

        $('#play').click(function() {
            audioElement.play();
            $("#status").text("Status: Playing");
        });

        $('#pause').click(function() {
            audioElement.pause();
            $("#status").text("Status: Paused");
        });

        $('#restart').click(function() {
            audioElement.currentTime = 0;
        });
    });
    </script>
  </head>
  <body>
    <!--<audio autoplay loop id="audio">
      <source src="audio/audio.ogg" type="audio/ogg">
      <source src="audio/audio.mp3" type="audio/mpeg">
    </audio>-->
<button id="play" style="position:absolute;z-index:500;border: 0;background: #fff;padding: 11px 15px;border-radius: 50px;transform: translate(-50%, 0);left: 50%;top: 20px; font-size:11px;">Play</button>

    <!--<iframe id="audio" width="853" height="480" src="audio/audio.mp3" frameborder="0" mute="1" allowfullscreen></iframe>
    -->
    <div class="x-pwrap">
      <header class="x-head">
        <div class="x-logo">
          <a href="#">
            <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 900 150" style="enable-background:new 0 0 900 150;" xml:space="preserve">
            <style type="text/css">
            	.st0{fill:#1E1E1E;}
            	.st1{font-family:'NanumGothicBold'; font-weight:bold;}
            	.st2{font-size:72px;}
            </style>
            <g>
            	<path class="st0" d="M105.3,66.5h-7.7c-0.9-3.7-2.4-7.1-4.3-10.2l5.4-5.4c1.9-1.9,1.9-5.1,0-7l-5.4-5.4c-1.9-1.9-5.1-1.9-7,0
            		l-5.5,5.5c-3.1-1.9-6.5-3.3-10.2-4.2v-7.8c0-2.7-2.2-4.9-4.9-4.9h-7.6c-2.7,0-4.9,2.2-4.9,4.9v7.8c-3.6,0.9-7.1,2.3-10.2,4.2
            		l-5.5-5.5c-1.9-1.9-5.1-1.9-7,0l-5.4,5.4c-1.9,1.9-1.9,5.1,0,7l5.4,5.4c-1.9,3.1-3.4,6.6-4.3,10.2h-7.7c-2.7,0-4.9,2.2-4.9,4.9V79
            		c0,2.7,2.2,4.9,4.9,4.9h7.6c0.9,3.7,2.3,7.1,4.2,10.3l-5.4,5.4c-1.9,1.9-1.9,5.1,0,7l5.4,5.4c1.9,1.9,5.1,1.9,7,0l5.3-5.3
            		c3.2,1.9,6.6,3.4,10.3,4.3v7.5c0,2.7,2.2,4.9,4.9,4.9h7.6c2.7,0,4.9-2.2,4.9-4.9v-7.5c3.7-0.9,7.2-2.4,10.3-4.3l5.3,5.3
            		c1.9,1.9,5.1,1.9,7,0l5.4-5.4c1.9-1.9,1.9-5.1,0-7l-5.4-5.4c1.9-3.2,3.3-6.6,4.2-10.3h7.6c2.7,0,4.9-2.2,4.9-4.9v-7.6
            		C110.2,68.7,108,66.5,105.3,66.5z M62,90c-8.2,0-14.8-6.6-14.8-14.8S53.8,60.4,62,60.4c8.2,0,14.8,6.6,14.8,14.8S70.2,90,62,90z"/>
            </g>
            <text transform="matrix(1 0 0 1 128 101.549)" class="st1 st2">프로젝트 관리자 페이지</text>
            </svg>
          </a>
        </div>
        <div class="nav-con">
          <div class="menu-con">
            <ul class="menu-service">
              <li><a href="#">서비스</a></li>
            </ul>
          </div>
          <div class="login-con">
            <a href="#">로그인</a>
            <a href="#">회원가입</a>
          </div>
        </div>
      </header>
      <div class="article1">
        <!--배경1-->
        <div class="banner01">
          <h2 class="anim1">더스마트한 스케줄관리</h2>
          <h2 class="anim2">현재 진행 중인 프로젝트를 한눈에 관리해보세요</h2>
          <a href="../index.ops">시작하기</a>
          <div class="article-subbg"><div id="particles-js"></div></div>
        </div>
        <!--배경2-->
        <div class="banner02">
          <!--두번째 이미지-->
          <div class="anim3">
                      <svg version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
            	 y="0px" viewBox="0 0 300 300" style="enable-background:new 0 0 300 300;" xml:space="preserve">
            <style type="text/css">
            	.st00{fill:#FFFFFF;}
            	.st11{fill:none;stroke:#FFFFFF;stroke-width:2;stroke-linecap:round;stroke-miterlimit:10;}
            	.st22{fill:none;stroke:#FFFFFF;stroke-width:2;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
            	.st33{fill:#E6E6E6;}
            	.st44{fill:#e5e6e6;}
            	.st55{fill:#e5e6e6;}
            	.st66{fill:#e5e6e6;}
            	.st77{fill:#e5e6e6;}
            </style>
            <g>
            	<path class="st00" d="M282.5,151.1H92.1c-1.2,0-2.2-1-2.2-2.2V28.5c0-1.2,1-2.2,2.2-2.2h190.4c1.2,0,2.2,1,2.2,2.2v120.4
            		C284.7,150.1,283.7,151.1,282.5,151.1z"/>
            </g>
            <g>
            	<line class="st11" x1="186.2" y1="134.5" x2="186.2" y2="170.7"/>
            	<line class="st22" x1="237.7" y1="185.2" x2="186.2" y2="170.7"/>
            	<line class="st22" x1="186.2" y1="170.7" x2="134.8" y2="185.2"/>
            </g>
            <path class="st33" d="M283.2,151.1H91.5c-0.8,0-1.5-0.7-1.5-1.5V38.8c0-0.8,0.7-1.5,1.5-1.5h191.7c0.8,0,1.5,0.7,1.5,1.5v110.7
            	C284.7,150.4,284,151.1,283.2,151.1z"/>
            <g>
            	<path class="st44" d="M115.7,65.7h-1.2c-0.3,0-0.5-0.2-0.5-0.5V53.1c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C116.2,65.5,116,65.7,115.7,65.7z"/>
            	<path class="st44" d="M159.5,65.7h-1.2c-0.3,0-0.5-0.2-0.5-0.5V53.1c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C160,65.5,159.8,65.7,159.5,65.7z"/>
            	<path class="st44" d="M159.5,60.3h-45c-0.3,0-0.5-0.2-0.5-0.5v-1.2c0-0.3,0.2-0.5,0.5-0.5h45c0.3,0,0.5,0.2,0.5,0.5v1.2
            		C160,60,159.8,60.3,159.5,60.3z"/>
            </g>
            <g>
            	<path class="st55" d="M159.5,81h-1.2c-0.3,0-0.5-0.2-0.5-0.5V68.4c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C160,80.8,159.8,81,159.5,81z"/>
            	<path class="st55" d="M220.7,81h-1.2c-0.3,0-0.5-0.2-0.5-0.5V68.4c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C221.2,80.8,221,81,220.7,81z"/>
            	<path class="st55" d="M220.7,75.6h-62.5c-0.3,0-0.5-0.2-0.5-0.5v-1.2c0-0.3,0.2-0.5,0.5-0.5h62.5c0.3,0,0.5,0.2,0.5,0.5v1.2
            		C221.2,75.3,221,75.6,220.7,75.6z"/>
            </g>
            <g>
            	<path class="st66" d="M190.1,96.4h-1.2c-0.3,0-0.5-0.2-0.5-0.5V83.7c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C190.6,96.1,190.4,96.4,190.1,96.4z"/>
            	<path class="st66" d="M251.4,96.4h-1.2c-0.3,0-0.5-0.2-0.5-0.5V83.7c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C251.9,96.1,251.7,96.4,251.4,96.4z"/>
            	<path class="st66" d="M251.4,90.9h-62.5c-0.3,0-0.5-0.2-0.5-0.5v-1.2c0-0.3,0.2-0.5,0.5-0.5h62.5c0.3,0,0.5,0.2,0.5,0.5v1.2
            		C251.9,90.7,251.7,90.9,251.4,90.9z"/>
            </g>
            <g>
            	<path class="st77" d="M251.4,113.9h-1.2c-0.3,0-0.5-0.2-0.5-0.5v-12.1c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            		C251.9,113.6,251.7,113.9,251.4,113.9z"/>
            	<g>
            		<path class="st77" d="M220.7,113.9h-1.2c-0.3,0-0.5-0.2-0.5-0.5v-12.1c0-0.3,0.2-0.5,0.5-0.5h1.2c0.3,0,0.5,0.2,0.5,0.5v12.1
            			C221.2,113.6,221,113.9,220.7,113.9z"/>
            		<path class="st77" d="M250.3,108.4h-30.7c-0.3,0-0.5-0.2-0.5-0.5v-1.2c0-0.3,0.2-0.5,0.5-0.5h30.7c0.3,0,0.5,0.2,0.5,0.5v1.2
            			C250.8,108.2,250.6,108.4,250.3,108.4z"/>
            	</g>
            </g>
            <path class="st00 anim4" d="M232.6,273.7H56.7c-2,0-3.6-1.6-3.6-3.6v-58.3c0-2,1.6-3.6,3.6-3.6h175.9c2,0,3.6,1.6,3.6,3.6v58.3
            	C236.2,272.1,234.6,273.7,232.6,273.7z"/>
            <path class="st00 anim5" d="M286,270h-13.6c-6.6,0-12-5.4-12-12v-34.2c0-6.6,5.4-12,12-12H286c6.6,0,12,5.4,12,12V258
            	C298,264.6,292.6,270,286,270z"/>
            <g>
            	<path class="st00 anim6" d="M120.4,115.3L4.6,174.9c-0.5,0.3-3.1-1.4-3.4-2h0c-0.3-0.5,1.2-4.9,1.7-5.1l116.5-54.4c0.5-0.3,1.2,0,1.5,0.5
            		l0,0C121.2,114.4,120.9,115.1,120.4,115.3z"/>
            </g>
            </svg>
          </div>
          <div class="anim-text1">
            <h2>이제 개인 PC로 누구나 쉽고 간편하게</h2>
            <h2>스케줄을 관리할 수있습니다.</h2>
          </div>
        </div>
        <div class="banner03">
          <div class="anim7">
            <svg version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
	 y="0px" viewBox="0 0 1500 800" style="enable-background:new 0 0 1500 800;" xml:space="preserve">
            <path style="fill:#EAECEF;" d="M1431,797.4H87c-6.6,0-12-5.4-12-12V23c0-6.6,5.4-12,12-12h1344c6.6,0,12,5.4,12,12v762.4
            	C1443,792,1437.6,797.4,1431,797.4z"/>
            <path style="fill:#FFFFFF;" d="M358.5,797.4H87c-6.6,0-12-5.4-12-12V23c0-6.6,5.4-12,12-12h271.5c6.6,0,12,5.4,12,12v762.4
            	C370.5,792,365.1,797.4,358.5,797.4z"/>
            <path style="fill:#FFFFFF;" d="M1352.8,205.6H485.7c-6.6,0-12-5.4-12-12v-22.1c0-6.6,5.4-12,12-12h867.2c6.6,0,12,5.4,12,12v22.1
            	C1364.8,200.2,1359.4,205.6,1352.8,205.6z"/>
            <path style="fill:#FFFFFF;" d="M1352.8,264.3H485.7c-6.6,0-12-5.4-12-12v-22.1c0-6.6,5.4-12,12-12h867.2c6.6,0,12,5.4,12,12v22.1
            	C1364.8,258.9,1359.4,264.3,1352.8,264.3z"/>
            <path style="fill:#FFFFFF;" d="M1352.8,322.9H485.7c-6.6,0-12-5.4-12-12v-22.1c0-6.6,5.4-12,12-12h867.2c6.6,0,12,5.4,12,12v22.1
            	C1364.8,317.5,1359.4,322.9,1352.8,322.9z"/>
            <path style="fill:#FFFFFF;" d="M786.9,512.1H485.7c-6.6,0-12-5.4-12-12V386.5c0-6.6,5.4-12,12-12h301.2c6.6,0,12,5.4,12,12v113.6
            	C798.9,506.7,793.5,512.1,786.9,512.1z"/>
            <path style="fill:#FFFFFF;" d="M1151.1,512.1H850c-6.6,0-12-5.4-12-12V386.5c0-6.6,5.4-12,12-12h301.2c6.6,0,12,5.4,12,12v113.6
            	C1163.1,506.7,1157.7,512.1,1151.1,512.1z"/>
            <path style="fill:#FFFFFF;" d="M1352.8,512.1H1215c-6.6,0-12-5.4-12-12V386.5c0-6.6,5.4-12,12-12h137.8c6.6,0,12,5.4,12,12v113.6
            	C1364.8,506.7,1359.4,512.1,1352.8,512.1z"/>
            <path style="fill:#FFFFFF;" d="M786.9,685.6H485.7c-6.6,0-12-5.4-12-12V560c0-6.6,5.4-12,12-12h301.2c6.6,0,12,5.4,12,12v113.6
            	C798.9,680.2,793.5,685.6,786.9,685.6z"/>
            <path style="fill:#FFFFFF;" d="M1151.1,685.6H850c-6.6,0-12-5.4-12-12V560c0-6.6,5.4-12,12-12h301.2c6.6,0,12,5.4,12,12v113.6
            	C1163.1,680.2,1157.7,685.6,1151.1,685.6z"/>
            <path style="fill:#FFFFFF;" d="M1352.8,685.6H1215c-6.6,0-12-5.4-12-12V560c0-6.6,5.4-12,12-12h137.8c6.6,0,12,5.4,12,12v113.6
            	C1364.8,680.2,1359.4,685.6,1352.8,685.6z"/>
            </svg>
          </div>
          <div class="anim-text2">
            <h2>프로젝트를 체계적으로 계획하고 설계하세요</h2>
            <h2>이제 프로젝트를 손쉽게 관리 감독할 수 있습니다.</h2>
          </div>
        </div>
        <div class="banner04">
          <div class="ban4-anim-text1">
            <h2>실시간 파일공유와</h2>
          </div>
          <div class="ban4-anim1">
                  <svg version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
          	 y="0px" viewBox="0 0 1300 800" style="enable-background:new 0 0 1300 800;" xml:space="preserve">
            <path class="ban4-anim2" style="fill:#EAECEF;" d="M1229,384H70.5c-6.6,0-12-5.4-12-12V19.7c0-6.6,5.4-12,12-12H1229c6.6,0,12,5.4,12,12V372
            	C1241,378.6,1235.6,384,1229,384z"/>
            <path class="ban4-anim2" style="fill:#FFFFFF;" d="M1185.1,340.7h-1071c-8.3,0-15.1-6.8-15.1-15.1v0c0-8.3,6.8-15.1,15.1-15.1h1071
            	c8.3,0,15.1,6.8,15.1,15.1v0C1200.2,334,1193.4,340.7,1185.1,340.7z"/>
            <text class="ban4-anim2" transform="matrix(1 0 0 1 208.7598 105.8208)" style="font-family:'NanumGothic'; font-size:47.0366px;">문서.hwp</text>
            <path class="ban4-anim2" style="fill:#6081F6;" d="M118.8,340.7h-4.7c-8.3,0-15.1-6.8-15.1-15.1v0c0-8.3,6.8-15.1,15.1-15.1h4.7
            	c8.3,0,15.1,6.8,15.1,15.1v0C133.9,334,127.1,340.7,118.8,340.7z"/>
            <text class="ban4-anim2" transform="matrix(1 0 0 1 1001.5195 283.1318)" style="font-family:'NanumGothic'; font-size:33.8663px;">업로드중...</text>
            <g>

            		<line class="ban4-anim2" style="fill:none;stroke:#000000;stroke-width:5;stroke-linecap:round;stroke-miterlimit:10;" x1="1198.8" y1="42.1" x2="1150.8" y2="90"/>

            		<line class="ban4-anim2" style="fill:none;stroke:#000000;stroke-width:5;stroke-linecap:round;stroke-miterlimit:10;" x1="1150.8" y1="42.1" x2="1198.8" y2="90"/>
            </g>
            <path class="ban4-anim3" style="fill:#EAECEF;" d="M1229,792.3H70.5c-6.6,0-12-5.4-12-12V428c0-6.6,5.4-12,12-12H1229c6.6,0,12,5.4,12,12v352.3
            	C1241,786.9,1235.6,792.3,1229,792.3z"/>
            <path class="ban4-anim3" style="fill:#FFFFFF;" d="M1185.1,749h-1071c-8.3,0-15.1-6.8-15.1-15.1l0,0c0-8.3,6.8-15.1,15.1-15.1h1071
            	c8.3,0,15.1,6.8,15.1,15.1l0,0C1200.2,742.2,1193.4,749,1185.1,749z"/>
            <text class="ban4-anim3" transform="matrix(1 0 0 1 128.3271 512.6875)" style="font-family:'NanumGothic'; font-size:47.0366px;">양식.hwp</text>
            <path class="ban4-anim3" style="fill:#6081F6;" d="M114.1,749L114.1,749c-8.3,0-15.1-6.8-15.1-15.1v0c0-8.3,6.8-15.1,15.1-15.1h0
            	c8.3,0,15.1,6.8,15.1,15.1v0C129.2,742.2,122.4,749,114.1,749z"/>
            <text class="ban4-anim3" transform="matrix(1 0 0 1 1001.5195 691.4092)" style="font-family:'NanumGothic'; font-size:33.8663px;">업로드중...</text>
            <g class="ban4-anim3">

            		<line style="fill:none;stroke:#000000;stroke-width:5;stroke-linecap:round;stroke-miterlimit:10;" x1="1198.8" y1="450.3" x2="1150.8" y2="498.3"/>

            		<line style="fill:none;stroke:#000000;stroke-width:5;stroke-linecap:round;stroke-miterlimit:10;" x1="1150.8" y1="450.3" x2="1198.8" y2="498.3"/>
            </g>
            <g class="ban4-anim2">
            	<g>
            		<g>
            			<path style="fill:#FFFFFF;" d="M148.4,80.5l2.5,9c0,0,0,0,0,0l0,0c0.1,0.4,0.6,0.4,0.7,0l0,0l1.7-8.9c0-0.2,0.2-0.3,0.3-0.3h2.5
            				c0.2,0,0.4,0.2,0.3,0.4l-3.6,13.7c0,0.2-0.2,0.3-0.3,0.3h-2.4c-0.2,0-0.3-0.1-0.3-0.3l-2.5-8.8c0,0,0,0,0,0l-0.1-0.4
            				c-0.1-0.4-0.6-0.4-0.7,0l-0.1,0.4c0,0,0,0,0,0l-2.5,8.8c0,0.1-0.2,0.3-0.3,0.3h-2.4c-0.2,0-0.3-0.1-0.3-0.3l-3.5-13.7
            				c-0.1-0.2,0.1-0.4,0.3-0.4h2.5c0.2,0,0.3,0.1,0.3,0.3l1.7,8.9l0,0c0.1,0.4,0.6,0.4,0.7,0l0,0c0,0,0,0,0,0l2.5-9
            				c0-0.1,0.2-0.3,0.3-0.3h2.4C148.2,80.3,148.4,80.4,148.4,80.5z"/>
            			<path style="fill:#FFFFFF;" d="M152.6,95h-2.4c-0.3,0-0.6-0.2-0.6-0.5l-2.5-8.8c0,0,0,0,0,0l-0.1-0.4c0,0,0,0,0,0l0,0
            				c0,0,0,0,0,0l-0.1,0.4c0,0,0,0,0,0l-2.5,8.8c-0.1,0.3-0.3,0.5-0.6,0.5h-2.4c-0.3,0-0.6-0.2-0.6-0.5L137,80.8
            				c-0.1-0.2,0-0.4,0.1-0.6c0.1-0.2,0.3-0.3,0.5-0.3h2.5c0.3,0,0.6,0.2,0.7,0.5l1.7,8.9c0,0,0,0,0,0c0,0,0,0,0,0c0,0,0,0,0,0
            				c0,0,0,0,0-0.1l2.5-9c0.1-0.3,0.3-0.5,0.6-0.5h2.4c0.3,0,0.6,0.2,0.6,0.5l0,0l2.5,9c0,0,0,0,0,0c0,0,0,0,0,0c0,0,0,0,0,0
            				c0,0,0,0,0,0l1.7-8.9c0.1-0.3,0.3-0.5,0.7-0.5h2.5c0.2,0,0.4,0.1,0.5,0.3c0.1,0.2,0.2,0.4,0.1,0.6l-3.6,13.7
            				C153.2,94.8,152.9,95,152.6,95z M146.9,84.5C146.9,84.5,146.9,84.5,146.9,84.5c0.3,0,0.6,0.2,0.6,0.5l0.1,0.4l2.5,8.8
            				c0,0,0,0,0,0h2.4c0,0,0,0,0,0l3.6-13.7c0,0,0,0,0,0c0,0,0,0,0,0h-2.5c0,0,0,0,0,0l-1.7,8.9c0,0.3-0.3,0.6-0.6,0.6
            				c-0.3,0-0.6-0.2-0.7-0.5l-2.5-9c0,0,0,0,0,0h-2.4c0,0,0,0,0,0l-2.5,9c-0.1,0.3-0.3,0.6-0.7,0.5c-0.3,0-0.6-0.2-0.6-0.6l-1.7-8.9
            				c0,0,0,0,0,0h-2.5c0,0,0,0,0,0c0,0,0,0,0,0l3.5,13.7c0,0,0,0,0,0h2.4c0,0,0,0,0,0l2.5-8.8l0.1-0.4
            				C146.3,84.7,146.5,84.5,146.9,84.5z"/>
            		</g>
            	</g>
            	<g>
            		<path style="fill:#4E93F9;" d="M162.9,73V58h-34.7v67.1h52.7V76H166C164.3,76,162.9,74.7,162.9,73z"/>
            	</g>
            	<g>
            		<path style="fill:#4E93F9;" d="M165.6,58L165.6,58l0,12.7c0,1.4,1.2,2.6,2.6,2.6h12.7v0L165.6,58z"/>
            	</g>
            	<g>
            		<g>
            			<path style="fill:#FFFFFF;" d="M148.4,86.5l2.5,9c0,0,0,0,0,0l0,0c0.1,0.4,0.6,0.4,0.7,0l0,0l1.7-8.9c0-0.2,0.2-0.3,0.3-0.3h2.5
            				c0.2,0,0.4,0.2,0.3,0.4l-3.6,13.7c0,0.2-0.2,0.3-0.3,0.3h-2.4c-0.2,0-0.3-0.1-0.3-0.3l-2.5-8.8c0,0,0,0,0,0l-0.1-0.4
            				c-0.1-0.4-0.6-0.4-0.7,0l-0.1,0.4c0,0,0,0,0,0l-2.5,8.8c0,0.1-0.2,0.3-0.3,0.3h-2.4c-0.2,0-0.3-0.1-0.3-0.3l-3.5-13.7
            				c-0.1-0.2,0.1-0.4,0.3-0.4h2.5c0.2,0,0.3,0.1,0.3,0.3l1.7,8.9l0,0c0.1,0.4,0.6,0.4,0.7,0l0,0c0,0,0,0,0,0l2.5-9
            				c0-0.1,0.2-0.3,0.3-0.3h2.4C148.2,86.2,148.4,86.3,148.4,86.5z"/>
            			<path style="fill:#FFFFFF;" d="M152.6,100.9h-2.4c-0.3,0-0.6-0.2-0.6-0.5l-2.5-8.8c0,0,0,0,0,0l-0.1-0.4c0,0,0,0,0,0l0,0
            				c0,0,0,0,0,0l-0.1,0.4c0,0,0,0,0,0l-2.5,8.8c-0.1,0.3-0.3,0.5-0.6,0.5h-2.4c-0.3,0-0.6-0.2-0.6-0.5L137,86.7
            				c-0.1-0.2,0-0.4,0.1-0.6c0.1-0.2,0.3-0.3,0.5-0.3h2.5c0.3,0,0.6,0.2,0.7,0.5l1.7,8.9c0,0,0,0,0,0c0,0,0,0,0,0c0,0,0,0,0,0
            				c0,0,0,0,0-0.1l2.5-9c0.1-0.3,0.3-0.5,0.6-0.5h2.4c0.3,0,0.6,0.2,0.6,0.5l0,0l2.5,9c0,0,0,0,0,0c0,0,0,0,0,0c0,0,0,0,0,0
            				c0,0,0,0,0,0l1.7-8.9c0.1-0.3,0.3-0.5,0.7-0.5h2.5c0.2,0,0.4,0.1,0.5,0.3c0.1,0.2,0.2,0.4,0.1,0.6l-3.6,13.7
            				C153.2,100.7,152.9,100.9,152.6,100.9z M146.9,90.5C146.9,90.5,146.9,90.5,146.9,90.5c0.3,0,0.6,0.2,0.6,0.5l0.1,0.4l2.5,8.8
            				c0,0,0,0,0,0h2.4c0,0,0,0,0,0l3.6-13.7c0,0,0,0,0,0c0,0,0,0,0,0h-2.5c0,0,0,0,0,0l-1.7,8.9c0,0.3-0.3,0.6-0.6,0.6
            				c-0.3,0-0.6-0.2-0.7-0.5l-2.5-9c0,0,0,0,0,0h-2.4c0,0,0,0,0,0l-2.5,9c-0.1,0.3-0.3,0.6-0.7,0.5c-0.3,0-0.6-0.2-0.6-0.6l-1.7-8.9
            				c0,0,0,0,0,0h-2.5c0,0,0,0,0,0c0,0,0,0,0,0l3.5,13.7c0,0,0,0,0,0h2.4c0,0,0,0,0,0l2.5-8.8l0.1-0.4
            				C146.3,90.7,146.5,90.5,146.9,90.5z"/>
            		</g>
            	</g>
            	<g>
            		<path style="fill:#FFFFFF;" d="M173.9,111.3h-38.8c-0.9,0-1.6-0.7-1.6-1.6s0.7-1.6,1.6-1.6h38.8c0.9,0,1.6,0.7,1.6,1.6
            			S174.8,111.3,173.9,111.3z"/>
            	</g>
            	<g>
            		<path style="fill:#FFFFFF;" d="M173.9,118.7h-38.8c-0.9,0-1.6-0.7-1.6-1.6c0-0.9,0.7-1.6,1.6-1.6h38.8c0.9,0,1.6,0.7,1.6,1.6
            			C175.5,117.9,174.8,118.7,173.9,118.7z"/>
            	</g>
            </g>
          </svg>
        </div>
        </div>
        <!--채팅-->
        <div class="banner05">
          <div class="ban5-text1">
            <svg version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
            	 y="0px" viewBox="0 0 1200 1500" style="enable-background:new 0 0 1200 1500;" xml:space="preserve">
            <g class="ban5-anim4">
            	<path style="fill:#FFFFFF;" d="M431.8,512H324.4c-28,0-51-22.9-51-51v-12.6c0-28,22.9-51,51-51h107.4c28,0,51,22.9,51,51V461
            		C482.8,489,459.8,512,431.8,512z"/>
            	<text transform="matrix(1 0 0 1 339.2104 470.2954)" style="font-family:'NanumGothic'; font-size:39.4909px;">안녕</text>
            	<polygon style="fill:#FFFFFF;" points="325.2,438.2 250.2,398.8 250.2,398.8 325.2,398.8 	"/>
            </g>
            <g class="ban5-anim2">
            	<path style="fill:#FFFFFF;" d="M431.8,712H324.4c-28,0-51-22.9-51-51v-12.6c0-28,22.9-51,51-51h107.4c28,0,51,22.9,51,51v12.6
            		C482.8,689.1,459.8,712,431.8,712z"/>
            	<text transform="matrix(1 0 0 1 346.0591 670.3823)" style="font-family:'NanumGothic'; font-size:39.4909px;">Hi~</text>
            	<polygon style="fill:#FFFFFF;" points="325.2,638.3 250.2,598.8 250.2,598.8 325.2,598.8 	"/>
            </g>
            <circle class="ban5-anim4" style="fill:#E4E5EA;" cx="180.9" cy="403.1" r="51.8"/>
            <circle class="ban5-anim2" style="fill:#E4E5EA;" cx="180.9" cy="597.1" r="51.8"/>
            <g class="ban5-anim3">
            	<path style="fill:#2D90F5;" d="M822.4,1148.6H997c28,0,51-22.9,51-51v-12.6c0-28-22.9-51-51-51H822.4c-28,0-51,22.9-51,51v12.6
            		C771.5,1125.7,794.4,1148.6,822.4,1148.6z"/>
            	<polygon style="fill:#2D90F5;" points="996.1,1074.9 1071.2,1035.4 1071.2,1035.4 996.1,1035.4 	"/>
            	<text transform="matrix(1 0 0 1 816.8945 1106.5176)" style="fill:#FFFFFF; font-family:'NanumGothic'; font-size:39.4909px;">안녕하세요</text>
            </g>
            </svg>
          </div>
          <div class="ban5-text2">
            <h2>안녕하세요</h2>
          </div>
          <div class="ban5-text3">
            <h2>실시간 채팅서비스</h2>
          </div>
          <div class="ban5-anim1">
            <svg version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
              	 y="0px" viewBox="0 0 1200 1500" style="enable-background:new 0 0 1200 1500;" xml:space="preserve">
              <g>
              	<path style="fill:#FFFFFF;" d="M1129.8,144.8V59.4c0-27.8-15.2-50.6-33.8-50.6H86.8C68.2,8.8,53,31.6,53,59.4v85.4H1129.8z"/>
              </g>
              <g>
              	<rect x="53" y="144.8" style="fill:#EFF0F4;" width="1076.8" height="1346.2"/>
              </g>
              <text transform="matrix(1 0 0 1 131.98 92.145)" style="font-family:'NanumGothic'; font-size:39.4909px;">그룹 채팅</text>
              <text transform="matrix(1 0 0 1 958.6582 92.145)" style="font-family:'NanumGothic'; font-size:39.4909px;">50명</text>
              <rect x="72.7" y="1183" style="fill:#FFFFFF;" width="1037.3" height="285.7"/>
              <g>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="120.6" y1="1211.9" x2="144.7" y2="1211.9"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="120.6" y1="1225.2" x2="144.7" y2="1225.2"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="120.6" y1="1238.5" x2="144.7" y2="1238.5"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="120.6" y1="1218.6" x2="153" y2="1218.6"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="120.6" y1="1231.9" x2="153" y2="1231.9"/>
              </g>
              <g>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="298.9" y1="1211.9" x2="323" y2="1211.9"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="298.9" y1="1225.2" x2="323" y2="1225.2"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="298.9" y1="1238.5" x2="323" y2="1238.5"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="290.5" y1="1218.6" x2="323" y2="1218.6"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="290.5" y1="1231.9" x2="323" y2="1231.9"/>
              </g>
              <g>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="206.1" y1="1211.9" x2="230.1" y2="1211.9"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="206.1" y1="1225.2" x2="230.1" y2="1225.2"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="206.1" y1="1238.5" x2="230.1" y2="1238.5"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="201.9" y1="1218.6" x2="234.3" y2="1218.6"/>
              	<line style="fill:none;stroke:#1E1E1E;stroke-width:5;stroke-miterlimit:10;" x1="201.9" y1="1231.9" x2="234.3" y2="1231.9"/>
              </g>
              <g>
              	<path d="M395.3,1212.4l0.7-1.7H408l-0.7,1.7l-5.8,0.6h-0.9L395.3,1212.4z M391.5,1236.9l5.3,0.6l-0.7,1.7h-11.9l0.7-1.7l5.8-0.6
              		H391.5z M394.6,1223.9c1.8-4.4,3.7-8.8,5.4-13.2h4.1c-1.9,4.3-3.8,8.7-5.7,13.2l-0.9,2.1c-1.8,4.4-3.7,8.8-5.4,13.2H388
              		c1.9-4.3,3.8-8.7,5.7-13.2L394.6,1223.9z"/>
              </g>
              <g>
              	<g>
              		<path d="M446.3,1213l1.9-2.1l-1.3,7.4h-2.3l0.3-7.4h22.8l0.3,7.4h-2.3l-1.3-7.4l1.9,2.1H446.3z M456.7,1236.6l5.9,0.6v1.7H450
              			v-1.7l5.9-0.6H456.7z M454.4,1223.8c0-4.3,0-8.7-0.1-13h4c-0.1,4.2-0.1,8.6-0.1,13v2.1c0,4.3,0,8.7,0.1,13h-4
              			c0.1-4.2,0.1-8.6,0.1-13V1223.8z"/>
              	</g>
              	<line style="fill:none;stroke:#000000;stroke-width:2;stroke-miterlimit:10;" x1="444.4" y1="1225.7" x2="468.1" y2="1225.7"/>
              </g>
              <g>
              	<circle style="fill:none;stroke:#000000;stroke-width:3;stroke-miterlimit:10;" cx="189.9" cy="1426.5" r="18"/>
              	<g>

              			<line style="fill:none;stroke:#000000;stroke-width:3;stroke-linecap:round;stroke-miterlimit:10;" x1="188.5" y1="1414.4" x2="188.5" y2="1427.8"/>

              			<line style="fill:none;stroke:#000000;stroke-width:3;stroke-linecap:round;stroke-miterlimit:10;" x1="201.9" y1="1427.8" x2="188.5" y2="1427.8"/>
              	</g>
              </g>
              <g>
              	<g>
              		<circle style="fill:#F4E922;" cx="263.7" cy="1426.6" r="19.2"/>
              	</g>
              	<g>
              		<path style="fill:#EF7048;" d="M253.6,1431.6C253.6,1431.7,253.6,1431.7,253.6,1431.6c0,4.9,4.5,8.8,10.1,8.8s10.1-3.9,10.1-8.7
              			c0,0,0,0,0-0.1H253.6z"/>
              		<path d="M263.7,1440.6c-5.7,0-10.3-4-10.3-8.9c0,0,0,0,0,0l0-0.2H274l0,0.2c0,0,0,0,0,0C274,1436.6,269.4,1440.6,263.7,1440.6z
              			 M253.8,1431.8c0.1,4.6,4.5,8.4,9.9,8.4c5.4,0,9.9-3.8,9.9-8.4H253.8z"/>
              	</g>
              	<g>
              		<g>
              			<path d="M267.8,1422.2C267.7,1422.2,267.7,1422.2,267.8,1422.2c-0.2-0.1-0.3-0.2-0.3-0.4c0.4-1.4,2.2-2.4,4.4-2.4
              				c2.2,0,4,1,4.4,2.3c0,0.2-0.1,0.3-0.2,0.4c-0.2,0-0.3-0.1-0.4-0.2c-0.3-1.1-1.9-1.9-3.8-1.9c-1.9,0-3.5,0.8-3.8,1.9
              				C268,1422.1,267.9,1422.2,267.8,1422.2z"/>
              		</g>
              		<g>
              			<path d="M251.5,1422.2C251.5,1422.2,251.4,1422.2,251.5,1422.2c-0.2-0.1-0.3-0.2-0.3-0.4c0.4-1.4,2.2-2.4,4.4-2.4
              				c2.2,0,4,1,4.4,2.3c0,0.2-0.1,0.3-0.2,0.4c-0.2,0-0.3-0.1-0.4-0.2c-0.3-1.1-1.9-1.9-3.8-1.9c-1.9,0-3.5,0.8-3.8,1.9
              				C251.8,1422.1,251.6,1422.2,251.5,1422.2z"/>
              		</g>
              	</g>
              </g>
              <line style="fill:#2D90F5;" x1="120.8" y1="1260.4" x2="120.8" y2="1392.9"/>
              <path style="fill:#2D90F5;" d="M1037.6,1374.3H899.5c-23.2,0-42.2-19-42.2-42.2v-10.4c0-23.2,19-42.2,42.2-42.2h138.1
              	c23.2,0,42.2,19,42.2,42.2v10.4C1079.8,1355.3,1060.8,1374.3,1037.6,1374.3z"/>
              <text transform="matrix(1 0 0 1 925.5313 1339.6182)" style="fill:#FFFFFF; font-family:'NanumGothic'; font-size:31.5927px;">보내기</text>
              <g>
              	<polygon style="fill:#FFFFFF;" points="907.8,1331.7 881.5,1323.1 881.5,1323.1 900.7,1337.1 	"/>
              	<polygon style="fill:#FFFFFF;" points="908.9,1328.9 882.2,1321.8 882.2,1321.8 910.9,1319.4 	"/>
              	<polygon style="fill:#FFFFFF;" points="904.1,1336.5 907.3,1339.6 907.9,1333.7 904.1,1336.5 	"/>
              </g>
              </svg>

          </div>
        </div>
        <div class="sut-title-text1">
          <h1 class="sub-title-anim0">쉽고 간편한 파일공유</h1>
          <h1 class="sub-title-anim1">실시간 채팅 서비스</h1>
          <h1 class="sub-title-anim2">그룹별 프로젝트 관리</h1>
          <h1 class="sub-title-anim3">인재 채용 관리 </h1>
          <h1 class="sub-title-anim4">지금 바로 시작해볼까요?</h1>
        </div>
      </div>
      <div class="x-xbg-con">
        <svg version="1.1" id="레이어_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px"
        	 y="0px" viewBox="0 0 2200 300" style="enable-background:new 0 0 2200 300;" xml:space="preserve">
        <polygon style="fill:#ebedf0;" points="2200,300 2200,57.6 2196.4,37.7 1097.6,239.2 0,38 0,300 "/>
        </svg>
      </div>
    </div>
    <!-- particles.js lib (JavaScript CodePen settings): https://github.com/VincentGarreau/particles.js -->
    <script src='https://cdn.jsdelivr.net/particles.js/2.0.0/particles.min.js'></script>
    <script  src="../js/index.js"></script>
  </body>
</html>
