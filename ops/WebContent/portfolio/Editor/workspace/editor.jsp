<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="Content-Script-Type" content="text/javascript">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>OPS 에디터 </title>
<link href="../portfolio/Editor/workspace/css/ko_KR/smart_editor2.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="../portfolio/Editor/workspace/css/smartEditor.css">
<!-- 이미지 팝업 -->
    <script type="text/javascript">
      function getCurrentScrollPercentage(){
return (window.scrollY + window.innerHeight) / document.body.clientHeight * 100
}

document.addEventListener('scroll', () => {
const currentScrollPercentage = getCurrentScrollPercentage()
if(currentScrollPercentage > 90){
////업데이트
 console.log(window.scrollY);
 var scro=window.scrollY;
 var menu=document.getElementsByClassName('menu-wrapper')[0];
 var gnbcon=document.getElementsByClassName('gnb-con')[0];
 if(window.scrollY>=64){
    menu.classList.add('menuScroAnimation');
    gnbcon.classList.add('saveAnimation');
    gnbcon.classList.remove('saveAnimation2');
 }else if(window.scrollY<=63){
   gnbcon.classList.add('saveAnimation2');
   menu.classList.remove('menuScroAnimation');
   gnbcon.classList.remove('saveAnimation');
 }
}
});
    </script>
<script type="text/javascript">
//이미지 검색을 위해만듬
  window.onload = function(){ document.getElementById("loding").style.display = "none";document.getElementById("lodingBG").style.display = "none" }
</script>
<!-- //이미지 팝업 -->

<script type="text/javascript" src="../portfolio/Editor/workspace/js/lib/jindo2.all.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/lib/jindo_component.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/SE2M_Configuration.js" charset="utf-8"></script>	<!-- 설정 파일 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/SE2BasicCreator.js" charset="utf-8"></script>
<!--HuskyApp JS Start-->
<!-- 허스키 프레임웍 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/husky_framework/HuskyCore.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/husky_framework/HuskyRange.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/husky_framework/hp_CorePlugin.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/husky_framework/hp_HuskyRangeManager.js" charset="utf-8"></script>
<!-- 공통 : 기본 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/common/base/hp_SE2M_Toolbar.js" charset="utf-8"></script>
<!-- 편집 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_EditingAreaManager.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_EditingArea_WYSIWYG.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_EditingArea_HTMLSrc.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_EditingArea_TEXT.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_EditingAreaVerticalResizer.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_WYSIWYGEnterKey.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE2M_EditingModeChanger.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/editing/hp_SE_PasteHandler.js" charset="utf-8"></script>
<!-- 1단 툴바 : 기본 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_ExecCommand.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE_WYSIWYGStyler.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE_WYSIWYGStyleGetter.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_FontSizeWithLayerUI.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_LineStyler.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_LineHeightWithLayerUI.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_ColorPalette.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_FontColor.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_BGColor.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_Hyperlink.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_FontNameWithLayerUI.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/colorpicker.js" charset="utf-8"></script> 
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_Accessibility.js" charset="utf-8"></script>
<!-- 1단 툴바 : 확장 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_SCharacter.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_FindReplacePlugin.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_Quote.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_TableCreator.js" charset="utf-8"></script>		
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_TableBlockStyler.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_StyleRemover.js" charset="utf-8"></script>	
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_TableEditor.js" charset="utf-8"></script>
<!-- 퀵에디터 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/quick_editor/hp_SE2M_QuickEditor_Common.js" charset="utf-8"></script>
<!-- 단축키 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/shortcut/shortcut.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/shortcut/hp_Hotkey.js" charset="utf-8"></script>
<!-- Undo/Redo -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/undo_redo/hp_SE_UndoRedo.js" charset="utf-8"></script>
<!-- 유틸 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_Utils.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_DialogLayerManager.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_ActiveLayerManager.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_StringConverterManager.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_MessageManager.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_LazyLoader.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_PopupManager.js" charset="utf-8"></script>	 
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_SE2M_Utils.js"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_SE2B_CSSLoader.js" charset="utf-8"></script>		<!-- Basic 버전에서 사용하지 않는 메시지를 제거한 버전 -->
<!-- SE2.0 Open 전용 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/husky_SE2B_Lang_ko_KR.js" charset="utf-8"></script><!-- Basic 버전에서 사용하는 알림 메시지 -->
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/husky_SE2B_Lang_en_US.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/husky_SE2B_Lang_ja_JP.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/husky_SE2B_Lang_zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/husky_SE2B_Lang_zh_TW.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/hp_SE_OuterIFrameControl.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js/service/hp_SE_ToolbarToggler.js" charset="utf-8"></script>
<!--HuskyApp JS End-->
<!--Remove Start-->
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_FindReplacePlugin$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_Quote$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_SCharacter$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_TableCreator$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/hp_SE2M_TableEditor$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_BGColor$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_FontColor$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_Hyperlink$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/base/hp_SE2M_LineHeightWithLayerUI$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/quick_editor/hp_SE2M_QuickEditor_Common$Lazy.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/hp_DialogLayerManager$Lazy.js" charset="utf-8"></script>

<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/N_FindReplace.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/fundamental/advanced/SE2M_TableTemplate.js" charset="utf-8"></script>
<script type="text/javascript" src="../portfolio/Editor/workspace/js_src/util/N_DraggableLayer.js" charset="utf-8"></script>
<!--Remove End-->

</head>
<body>
<!-- SE2 Markup Start -->	
<div id="smart_editor2">
	<div id="smart_editor2_content"><a href="#se2_iframe" class="blind">글쓰기영역으로 바로가기</a>
	
	<header>
      <h1>OPS 스마트 에디터</h1>
      <div class="head-wrapper">
        <div class="head-con">
          <div class="logo-con">
            <a href="../ops/main"><img src="../../images/common/opsLogoBlack.svg" width="159px" alt=""></a>
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
            <div class="document-save"><a href="#" onclick="saveA()">저장</a></div>
            <div>
              <svg version="1.1" x="0px" y="0px" viewBox="0 0 50 50" style="width:20px; enable-background:new 0 0 50 50;" xml:space="preserve"> <g> <path style="fill:#5058F0;" d="M35,0H0v35C0,15.8,15.8,0,35,0z"/> <path style="fill:#FFFFFF;" d="M50,0H35C15.8,0,0,15.8,0,35v15h50V0z"/> </g> </svg>
            </div>
          </div>
          <span class="carte">
            카테고리 : 개발자
          </span>
        </div>
      </div>
      <nav class="menu-wrapper">
        <!-- 에디터툴바 시작 -->
		<div class="se2_tool" id="se2_tool">
			<div class="se2_text_tool husky_seditor_text_tool">
			<ul class="se2_font_type">
				<li class="husky_seditor_ui_fontName"><button type="button" class="se2_font_family" title="글꼴"><span class="husky_se2m_current_fontName">글꼴</span><div style="margin-top:3.5px; color:#737475;">▼</div></button>
					<!-- 글꼴 레이어 -->
					<div class="se2_layer husky_se_fontName_layer">
						<div class="se2_in_layer">
							<ul class="se2_l_font_fam">
						 	<li style="display:none"><button type="button"><span>@DisplayName@<span>(</span><em style="font-family:FontFamily;">@SampleText@</em><span>)</span></span></button></li>
							<li></li>
							<li><button type="button"><span>나눔고딕<span></span><em style="font-family:'나눔고딕',NanumGothic;"></em><span></span></span></button></li>
							<li><button type="button"><span>나눔명조<span></span><em style="font-family:'나눔명조',NanumMyeongjo;"></em><span></span></span></button></li>
							<li><button type="button"><span>나눔고딕코딩<span></span><em style="font-family:'나눔고딕코딩',NanumGothicCoding;"></em><span></span></span></button></li>
							<li><button type="button"><span>나눔바른고딕<span></span><em style="font-family:'나눔바른고딕',NanumBarunGothic,NanumBarunGothicOTF;"></em><span></span></span></button></li>
							<li><button type="button"><span>나눔바른펜<span></span><em style="font-family:'나눔바른펜',NanumBarunpen;"></em><span></span></span></button></li>
							</ul>
						</div>
					</div>
					<!-- //글꼴 레이어 -->
				</li>
				<li><div class="colHr"></div></li>
				<li class="husky_seditor_ui_fontSize"><button type="button" class="se2_font_size" title="글자크기"><span class="husky_se2m_current_fontSize" style="width:38px;">크기</span><div style="margin-top:3.5px; color:#737475;">▼</div></button>
					<!-- 폰트 사이즈 레이어 -->
					<div class="se2_layer husky_se_fontSize_layer">
						<div class="se2_in_layer">
							<ul class="se2_l_font_size">
							<li><button type="button"><span style="margin-top:4px; margin-bottom:3px; font-size:7pt;"><span style=" font-size:11pt;">7pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:2px; font-size:8pt;"><span style="font-size:11pt;">8pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:1px; font-size:9pt;"><span style="font-size:11pt;">9pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:1px; font-size:10pt;"><span style="font-size:11pt;">10pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:2px; font-size:11pt;"><span style="font-size:11pt;">11pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:1px; font-size:12pt;"><span style="font-size:11pt;">12pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:2px; font-size:14pt;"><span style="font-size:11pt;">14pt</span></span></button></li>
							<li><button type="button"><span style="margin-bottom:1px; font-size:18pt;"><span style="font-size:11pt;">18pt</span></span></button></li>
							<li><button type="button"><span style="margin-left:3px; font-size:24pt;"><span style="font-size:11pt;">24pt</span></span></button></li>
							<li><button type="button"><span style="margin-top:-1px; margin-left:3px; font-size:36pt;"> <span style="font-size:11pt;">36pt</span></span></button></li>
							</ul>
						</div>
					</div>
					<!-- //폰트 사이즈 레이어 -->
				</li>
</ul><ul>
				<li><div class="colHr"></div></li>
				
				<li class="husky_seditor_ui_justifyleft first_child AlignmentCon"><button type="button" title="왼쪽정렬" class="se2_left"><span class="_buttonRound tool_bg">왼쪽</span></button></li>

				<li class="husky_seditor_ui_justifycenter AlignmentCon"><button type="button" title="가운데정렬" class="se2_center"><span class="_buttonRound">중간</span></button></li>

				<li class="husky_seditor_ui_justifyright AlignmentCon"><button type="button" title="오른쪽정렬" class="se2_right"><span class="_buttonRound">우쪽</span></button></li>
				
				<li><div class="colHr"></div></li>
				
				<li class="husky_seditor_ui_italic"><button type="button" title="기울임꼴[Ctrl+I]" class="se2_italic"><span class="_buttonRound">기울임꼴</span></button></li>
				
				<li class="husky_seditor_ui_lineThrough"><button type="button" title="취소선[Ctrl+D]" class="se2_tdel"><span class="_buttonRound">취소선</span></button></li>
				
				<li class="husky_seditor_ui_underline"><button type="button" title="밑줄[Ctrl+U]" class="se2_underline"><span class="_buttonRound">밑줄</span></button></li>
				
				<li class="husky_seditor_ui_bold first_child"><button type="button" title="굵게[Ctrl+B]" class="se2_bold"><span class="_buttonRound tool_bg">굵게</span></button></li>

				
				
				<li><div class="colHr"></div></li>
				<li class="se2_pair husky_seditor_ui_fontColor"><span class="selected_color husky_se2m_fontColor_lastUsed" style="background-color:#4477f9"></span><span class="husky_seditor_ui_fontColorA"><button type="button" title="글자색" class="se2_fcolor"><span>글자색</span></button></span><span class="husky_seditor_ui_fontColorB"><button type="button" title="더보기" class="se2_fcolor_more"><span class="_buttonRound">더보기</span></button></span>				
					<!-- 글자색 -->
					<div class="se2_layer husky_se2m_fontcolor_layer" style="display:none">
						<div class="se2_in_layer husky_se2m_fontcolor_paletteHolder">
							<div class="se2_palette husky_se2m_color_palette">
								<ul class="se2_pick_color">
								<li><button type="button" title="#ff0000" style="background:#ff0000"><span><span>#ff0000</span></span></button></li>
								<li><button type="button" title="#ff6c00" style="background:#ff6c00"><span><span>#ff6c00</span></span></button></li>
								<li><button type="button" title="#ffaa00" style="background:#ffaa00"><span><span>#ffaa00</span></span></button></li>
								<li><button type="button" title="#ffef00" style="background:#ffef00"><span><span>#ffef00</span></span></button></li>
								<li><button type="button" title="#a6cf00" style="background:#a6cf00"><span><span>#a6cf00</span></span></button></li>
								<li><button type="button" title="#009e25" style="background:#009e25"><span><span>#009e25</span></span></button></li>
								<li><button type="button" title="#00b0a2" style="background:#00b0a2"><span><span>#00b0a2</span></span></button></li>
								<li><button type="button" title="#0075c8" style="background:#0075c8"><span><span>#0075c8</span></span></button></li>
								<li><button type="button" title="#3a32c3" style="background:#3a32c3"><span><span>#3a32c3</span></span></button></li>
								<li><button type="button" title="#7820b9" style="background:#7820b9"><span><span>#7820b9</span></span></button></li>
								<li><button type="button" title="#ef007c" style="background:#ef007c"><span><span>#ef007c</span></span></button></li>
								<li><button type="button" title="#000000" style="background:#000000"><span><span>#000000</span></span></button></li>
								<li><button type="button" title="#252525" style="background:#252525"><span><span>#252525</span></span></button></li>
								<li><button type="button" title="#464646" style="background:#464646"><span><span>#464646</span></span></button></li>
								<li><button type="button" title="#636363" style="background:#636363"><span><span>#636363</span></span></button></li>
								<li><button type="button" title="#7d7d7d" style="background:#7d7d7d"><span><span>#7d7d7d</span></span></button></li>
								<li><button type="button" title="#9a9a9a" style="background:#9a9a9a"><span><span>#9a9a9a</span></span></button></li>
								<li><button type="button" title="#ffe8e8" style="background:#ffe8e8"><span><span>#9a9a9a</span></span></button></li>
								<li><button type="button" title="#f7e2d2" style="background:#f7e2d2"><span><span>#f7e2d2</span></span></button></li>
								<li><button type="button" title="#f5eddc" style="background:#f5eddc"><span><span>#f5eddc</span></span></button></li>
								<li><button type="button" title="#f5f4e0" style="background:#f5f4e0"><span><span>#f5f4e0</span></span></button></li>
								<li><button type="button" title="#edf2c2" style="background:#edf2c2"><span><span>#edf2c2</span></span></button></li>
								<li><button type="button" title="#def7e5" style="background:#def7e5"><span><span>#def7e5</span></span></button></li>
								<li><button type="button" title="#d9eeec" style="background:#d9eeec"><span><span>#d9eeec</span></span></button></li>
								<li><button type="button" title="#c9e0f0" style="background:#c9e0f0"><span><span>#c9e0f0</span></span></button></li>
								<li><button type="button" title="#d6d4eb" style="background:#d6d4eb"><span><span>#d6d4eb</span></span></button></li>
								<li><button type="button" title="#e7dbed" style="background:#e7dbed"><span><span>#e7dbed</span></span></button></li>
								<li><button type="button" title="#f1e2ea" style="background:#f1e2ea"><span><span>#f1e2ea</span></span></button></li>
								<li><button type="button" title="#acacac" style="background:#acacac"><span><span>#acacac</span></span></button></li>
								<li><button type="button" title="#c2c2c2" style="background:#c2c2c2"><span><span>#c2c2c2</span></span></button></li>
								<li><button type="button" title="#cccccc" style="background:#cccccc"><span><span>#cccccc</span></span></button></li>
								<li><button type="button" title="#e1e1e1" style="background:#e1e1e1"><span><span>#e1e1e1</span></span></button></li>
								<li><button type="button" title="#ebebeb" style="background:#ebebeb"><span><span>#ebebeb</span></span></button></li>
								<li><button type="button" title="#ffffff" style="background:#ffffff"><span><span>#ffffff</span></span></button></li>
								</ul>
								<ul class="se2_pick_color" style="width:156px;">
								<li><button type="button" title="#e97d81" style="background:#e97d81"><span><span>#e97d81</span></span></button></li>
								<li><button type="button" title="#e19b73" style="background:#e19b73"><span><span>#e19b73</span></span></button></li>
								<li><button type="button" title="#d1b274" style="background:#d1b274"><span><span>#d1b274</span></span></button></li>
								<li><button type="button" title="#cfcca2" style="background:#cfcca2"><span><span>#cfcca2</span></span></button></li>
								<li><button type="button" title="#cfcca2" style="background:#cfcca2"><span><span>#cfcca2</span></span></button></li>
								<li><button type="button" title="#61b977" style="background:#61b977"><span><span>#61b977</span></span></button></li>
								<li><button type="button" title="#53aea8" style="background:#53aea8"><span><span>#53aea8</span></span></button></li>
								<li><button type="button" title="#518fbb" style="background:#518fbb"><span><span>#518fbb</span></span></button></li>
								<li><button type="button" title="#6a65bb" style="background:#6a65bb"><span><span>#6a65bb</span></span></button></li>
								<li><button type="button" title="#9a54ce" style="background:#9a54ce"><span><span>#9a54ce</span></span></button></li>
								<li><button type="button" title="#e573ae" style="background:#e573ae"><span><span>#e573ae</span></span></button></li>
								<li><button type="button" title="#5a504b" style="background:#5a504b"><span><span>#5a504b</span></span></button></li>
								<li><button type="button" title="#767b86" style="background:#767b86"><span><span>#767b86</span></span></button></li>
								<li><button type="button" title="#951015" style="background:#951015"><span><span>#951015</span></span></button></li>
								<li><button type="button" title="#6e391a" style="background:#6e391a"><span><span>#6e391a</span></span></button></li>
								<li><button type="button" title="#785c25" style="background:#785c25"><span><span>#785c25</span></span></button></li>
								<li><button type="button" title="#5f5b25" style="background:#5f5b25"><span><span>#5f5b25</span></span></button></li>
								<li><button type="button" title="#4c511f" style="background:#4c511f"><span><span>#4c511f</span></span></button></li>
								<li><button type="button" title="#1c4827" style="background:#1c4827"><span><span>#1c4827</span></span></button></li>
								<li><button type="button" title="#0d514c" style="background:#0d514c"><span><span>#0d514c</span></span></button></li>
								<li><button type="button" title="#1b496a" style="background:#1b496a"><span><span>#1b496a</span></span></button></li>
								<li><button type="button" title="#2b285f" style="background:#2b285f"><span><span>#2b285f</span></span></button></li>
								<li><button type="button" title="#45245b" style="background:#45245b"><span><span>#45245b</span></span></button></li>
								<li><button type="button" title="#721947" style="background:#721947"><span><span>#721947</span></span></button></li>
								<li><button type="button" title="#352e2c" style="background:#352e2c"><span><span>#352e2c</span></span></button></li>
								<li><button type="button" title="#3c3f45" style="background:#3c3f45"><span><span>#3c3f45</span></span></button></li>
								</ul>
								<button type="button" title="더보기" class="se2_view_more husky_se2m_color_palette_more_btn" style="background:linear-gradient(to right, #ff0000, #081010);"><span>더보기</span></button>
								<div class="husky_se2m_color_palette_recent" style="display:none">
									<h4>최근 사용한 색</h4>
									<ul class="se2_pick_color">
									<li></li>
									<!-- 최근 사용한 색 템플릿 -->
									<!-- <li><button type="button" title="#e97d81" style="background:#e97d81"><span><span>#e97d81</span></span></button></li> -->
									<!-- //최근 사용한 색 템플릿 -->
									</ul>
								</div>								
								<div class="se2_palette2 husky_se2m_color_palette_colorpicker">
									<!--form action="http://test.emoticon.naver.com/colortable/TextAdd.nhn" method="post"-->
										<div class="se2_color_set">
											<span class="se2_selected_color"><span class="husky_se2m_cp_preview" style="background:#e97d81"></span></span><input type="text" name="" class="input_ty1 husky_se2m_cp_colorcode" value="#e97d81"><button type="button" class="se2_btn_insert husky_se2m_color_palette_ok_btn" style="background:#fff;" title="입력"><span style="color:#000;">입력</span></button></div>
										<!--input type="hidden" name="callback" value="http://test.emoticon.naver.com/colortable/result.jsp" />
										<input type="hidden" name="callback_func" value="1" />
										<input type="hidden" name="text_key" value="" />
										<input type="hidden" name="text_data" value="" />
									</form-->
									<div class="se2_gradation1 husky_se2m_cp_colpanel"></div>
									<div class="se2_gradation2 husky_se2m_cp_huepanel"></div>
								</div>
							</div>
                        </div>
					</div>
                    <!-- //글자색 -->
				</li>

				<li class="se2_pair husky_seditor_ui_BGColor"><span class="selected_color husky_se2m_BGColor_lastUsed" style="background-color: rgb(255, 0, 0); border-radius: 5px; padding: 3px; margin-top: -3px; margin-left: -2px;"></span><span class="husky_seditor_ui_BGColorA" style="position: absolute;"><button type="button" title="배경색" class="se2_bgcolor"><span>배경색</span></button></span><span class="husky_seditor_ui_BGColorB"><button type="button" title="더보기" class="se2_bgcolor_more"><span class="_buttonRound" style="color: #fff; z-index: 5; position: relative; font-size: 14px;">가</span></button></span>
					<!-- 배경색 -->
					<div class="se2_layer se2_layer husky_se2m_BGColor_layer" style="display:none">
						<div class="se2_in_layer">
							<div class="se2_palette_bgcolor">
								<ul class="se2_background husky_se2m_bgcolor_list">
								<li><button type="button" title="배경색#ff0000 글자색#ffffff" style="background:#ff0000; color:#ffffff"><span><span>가나다</span></span></button></li>								
								<li><button type="button" title="배경색#6d30cf 글자색#ffffff" style="background:#6d30cf; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#000000 글자색#ffffff" style="background:#000000; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#ff6600 글자색#ffffff" style="background:#ff6600; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#3333cc 글자색#ffffff" style="background:#3333cc; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#333333 글자색#ffff00" style="background:#333333; color:#ffff00"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#ffa700 글자색#ffffff" style="background:#ffa700; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#009999 글자색#ffffff" style="background:#009999; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#8e8e8e 글자색#ffffff" style="background:#8e8e8e; color:#ffffff"><span><span>가나다</span></span></button></li>								
								<li><button type="button" title="배경색#cc9900 글자색#ffffff" style="background:#cc9900; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#77b02b 글자색#ffffff" style="background:#77b02b; color:#ffffff"><span><span>가나다</span></span></button></li>
								<li><button type="button" title="배경색#ffffff 글자색#000000" style="background:#ffffff; color:#000000"><span><span>가나다</span></span></button></li>
								</ul>
							</div>
							<div class="husky_se2m_BGColor_paletteHolder"></div>
                        </div>
					</div>
                    <!-- //배경색 -->
				</li>

				<!--<li class="husky_seditor_ui_superscript"><button type="button" title="윗첨자" class="se2_sup"><span class="_buttonRound">윗첨자</span></button></li>-->

				<!--<li class="husky_seditor_ui_subscript last_child"><button type="button" title="아래첨자" class="se2_sub"><span class="_buttonRound tool_bg">아래첨자</span></button></li>-->
</ul><ul>

				<!--<li class="husky_seditor_ui_justifyfull"><button type="button" title="양쪽정렬" class="se2_justify"><span class="_buttonRound">양쪽정렬</span></button></li>

				<li class="husky_seditor_ui_orderedlist"><button type="button" title="번호매기기" class="se2_ol"><span class="_buttonRound">번호매기기</span></button></li>

				<li class="husky_seditor_ui_unorderedlist"><button type="button" title="글머리기호" class="se2_ul"><span class="_buttonRound">글머리기호</span></button></li>

				<li class="husky_seditor_ui_outdent"><button type="button" title="내어쓰기[Shift+Tab]" class="se2_outdent"><span class="_buttonRound">내어쓰기[Shift+Tab]</span></button></li>

				<li class="husky_seditor_ui_indent"><button type="button" title="들여쓰기[Tab]" class="se2_indent"><span class="_buttonRound">들여쓰기[Tab]</span></button></li>			-->
<li><div class="colHr"></div></li>
				<li class="husky_seditor_ui_lineHeight last_child" style="display:none;"><button type="button" title="줄간격" class="se2_lineheight" ><span class="_buttonRound tool_bg">줄간격</span></button>
					<!-- 줄간격 레이어 -->
					<div class="se2_layer husky_se2m_lineHeight_layer">
						<div class="se2_in_layer">
							<ul class="se2_l_line_height">
							<li><button type="button"><span>50%</span></button></li>
							<li><button type="button"><span>80%</span></button></li>
							<li><button type="button"><span>100%</span></button></li>
							<li><button type="button"><span>120%</span></button></li>
							<li><button type="button"><span>150%</span></button></li>
							<li><button type="button"><span>180%</span></button></li>
							<li><button type="button"><span>200%</span></button></li>
							</ul>
							<div class="se2_l_line_height_user husky_se2m_lineHeight_direct_input">
								<h3>직접 입력</h3>
								<span class="bx_input">
								<input type="text" class="input_ty1" maxlength="3" style="width:75px">
								<button type="button" title="1% 더하기" class="btn_up"><span>1% 더하기</span></button>
								<button type="button" title="1% 빼기" class="btn_down"><span>1% 빼기</span></button>
								</span>		
								<div class="btn_area">
									<button type="button" class="se2_btn_apply3"><span>적용</span></button><button type="button" class="se2_btn_cancel3"><span>취소</span></button>
								</div>
							</div>
						</div>
					</div>
					<!-- //줄간격 레이어 -->
				</li>
</ul><ul>
				<!--<li class="husky_seditor_ui_quote single_child"><button type="button" title="인용구" class="se2_blockquote"><span class="_buttonRound tool_bg">인용구</span></button> -->
					<!-- 인용구 -->
					<!-- <div class="se2_layer husky_seditor_blockquote_layer" style="margin-left:-407px; display:none;">
						<div class="se2_in_layer">
							<div class="se2_quote">
								<ul>
								<li class="q1"><button type="button" class="se2_quote1"><span><span>인용구 스타일1</span></span></button></li>
								<li class="q2"><button type="button" class="se2_quote2"><span><span>인용구 스타일2</span></span></button></li>
								<li class="q3"><button type="button" class="se2_quote3"><span><span>인용구 스타일3</span></span></button></li>
								<li class="q4"><button type="button" class="se2_quote4"><span><span>인용구 스타일4</span></span></button></li>
								<li class="q5"><button type="button" class="se2_quote5"><span><span>인용구 스타일5</span></span></button></li>
								<li class="q6"><button type="button" class="se2_quote6"><span><span>인용구 스타일6</span></span></button></li>
								<li class="q7"><button type="button" class="se2_quote7"><span><span>인용구 스타일7</span></span></button></li>
								<li class="q8"><button type="button" class="se2_quote8"><span><span>인용구 스타일8</span></span></button></li>
								<li class="q9"><button type="button" class="se2_quote9"><span><span>인용구 스타일9</span></span></button></li>
								<li class="q10"><button type="button" class="se2_quote10"><span><span>인용구 스타일10</span></span></button></li>
								</ul>
								<button type="button" class="se2_cancel2"><span>적용취소</span></button>
							</div>
						</div>
					</div> -->
					<!-- //인용구 -->
				<!--</li> -->
</ul><ul>
				<li class="husky_seditor_ui_hyperlink first_child"><button type="button" title="링크" class="se2_url"><span class="_buttonRound tool_bg">링크</span></button>
					<!-- 링크 -->
					<div class="se2_layer" style="margin-left:-285px">
						<div class="se2_in_layer">
							<div class="se2_url2">
								<input type="text" class="input_ty1" value="http://">
								<button type="button" class="se2_apply"><span>적용</span></button><button type="button" class="se2_cancel"><span>취소</span></button>
							</div>
						</div>
					</div>
					<!-- //링크 -->
				</li>
				<li class="ImgPopcon" onclick="ImgPopOn()">
				<!-- 이미지 -->
				<button type="button" title="이미지" class="ImgPop"><span class="_buttonRound tool_bg">이미지</span></button>
				<!-- //이미지 -->
				</li>
			

				<li class="husky_seditor_ui_table"><button type="button" title="표" class="se2_table" style="background:#fff;"><span class="_buttonRound" style="color:#000;">표</span></button>
					<!--@lazyload_html create_table-->
					<!-- 표 -->
					<div class="se2_layer husky_se2m_table_layer" style="margin-left:-171px">
						<div class="se2_in_layer">
							<div class="se2_table_set">
								<fieldset>
								<legend>칸수 지정</legend>
									<dl class="se2_cell_num">
									<dt><label for="row">행</label></dt>
									<dd><input id="row" name="" type="text" maxlength="2" value="4" class="input_ty2">
										<button type="button" class="se2_add"><span>1행추가</span></button>
										<button type="button" class="se2_del"><span>1행삭제</span></button>
									</dd>
									<dt><label for="col">열</label></dt>
									<dd><input id="col" name="" type="text" maxlength="2" value="4" class="input_ty2">
										<button type="button" class="se2_add"><span>1열추가</span></button>
										<button type="button" class="se2_del"><span>1열삭제</span></button>
									</dd>
									</dl>
									<table border="0" cellspacing="1" class="se2_pre_table husky_se2m_table_preview">
									<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									</tr>
									<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									</tr>
									<tr>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									<td>&nbsp;</td>
									</tr>
									</table>
								</fieldset>
								<fieldset>
									<legend>속성직접입력</legend>
									<dl class="se2_t_proper1">
									<dt><input type="radio" id="se2_tbp1" name="se2_tbp" checked><label for="se2_tbp1">속성직접입력</label></dt>
									<dd>
										<dl class="se2_t_proper1_1">
										<dt><label>표스타일</label></dt>
										<dd><div class="se2_select_ty1"><span class="se2_b_style3 husky_se2m_table_border_style_preview"></span><button type="button" title="더보기" class="se2_view_more"><span>더보기</span></button></div>
											<!-- 레이어 : 테두리스타일 -->
											<div class="se2_layer_b_style husky_se2m_table_border_style_layer" style="display:none">
												<ul>
												<li><button type="button" class="se2_b_style1"><span class="se2m_no_border">테두리없음</span></button></li>
												<li><button type="button" class="se2_b_style2"><span><span>테두리스타일2</span></span></button></li>
												<li><button type="button" class="se2_b_style3"><span><span>테두리스타일3</span></span></button></li>
												<li><button type="button" class="se2_b_style4"><span><span>테두리스타일4</span></span></button></li>
												<li><button type="button" class="se2_b_style5"><span><span>테두리스타일5</span></span></button></li>
												<li><button type="button" class="se2_b_style6"><span><span>테두리스타일6</span></span></button></li>
												<li><button type="button" class="se2_b_style7"><span><span>테두리스타일7</span></span></button></li>
												</ul>
											</div>
											<!-- //레이어 : 테두리스타일 -->
										</dd>
										</dl>
										<dl class="se2_t_proper1_1 se2_t_proper1_2">
										<dt><label for="se2_b_width">테두리두께</label></dt>
										<dd><input id="se2_b_width" name="" type="text" maxlength="2" value="1" class="input_ty1">
											<button type="button" title="1px 더하기" class="se2_add se2m_incBorder"><span>1px 더하기</span></button>
											<button type="button" title="1px 빼기" class="se2_del se2m_decBorder"><span>1px 빼기</span></button>
										</dd>
										</dl>
										<dl class="se2_t_proper1_1 se2_t_proper1_3">
										<dt><label for="se2_b_color">테두리색</label></dt>
										<dd><input id="se2_b_color" name="" type="text" maxlength="7" value="#cccccc" class="input_ty3"><span class="se2_pre_color"><button type="button" style="background:#cccccc;"><span>색찾기</span></button></span>	
										<!-- 레이어 : 테두리색 -->
											<div class="se2_layer se2_b_t_b1" style="clear:both;display:none;position:absolute;top:20px;left:-147px;">
												<div class="se2_in_layer husky_se2m_table_border_color_pallet">
												</div>
											</div>
										<!-- //레이어 : 테두리색-->
										</dd>
										</dl>
										<div class="se2_t_dim0"></div><!-- 테두리 없음일때 딤드레이어 -->
										<dl class="se2_t_proper1_1 se2_t_proper1_4">
										<dt><label for="se2_cellbg">셀 배경색</label></dt>
										<dd><input id="se2_cellbg" name="" type="text" maxlength="7" value="#ffffff" class="input_ty3"><span class="se2_pre_color"><button type="button" style="background:#ffffff;"><span>색찾기</span></button></span>
										<!-- 레이어 : 셀배경색 -->
										<div class="se2_layer se2_b_t_b1" style="clear:both;display:none;position:absolute;top:20px;left:-147px;">
											<div class="se2_in_layer husky_se2m_table_bgcolor_pallet">
											</div>
										</div>
										<!-- //레이어 : 셀배경색-->
										</dd>
										</dl>
									</dd>
									</dl>
								</fieldset>
								<fieldset>
									<legend>표스타일</legend>
									<dl class="se2_t_proper2">
									<dt><input type="radio" id="se2_tbp2" name="se2_tbp"><label for="se2_tbp2">스타일 선택</label></dt>
									<dd><div class="se2_select_ty2"><span class="se2_t_style1 husky_se2m_table_style_preview"></span><button type="button" title="더보기" class="se2_view_more"><span>더보기</span></button></div>
										<!-- 레이어 : 표템플릿선택 -->
										<div class="se2_layer_t_style husky_se2m_table_style_layer" style="display:none">
											<ul class="se2_scroll">
											<li><button type="button" class="se2_t_style1"><span>표스타일1</span></button></li>
											<li><button type="button" class="se2_t_style2"><span>표스타일2</span></button></li>
											<li><button type="button" class="se2_t_style3"><span>표스타일3</span></button></li>
											<li><button type="button" class="se2_t_style4"><span>표스타일4</span></button></li>
											<li><button type="button" class="se2_t_style5"><span>표스타일5</span></button></li>
											<li><button type="button" class="se2_t_style6"><span>표스타일6</span></button></li>
											<li><button type="button" class="se2_t_style7"><span>표스타일7</span></button></li>
											<li><button type="button" class="se2_t_style8"><span>표스타일8</span></button></li>
											<li><button type="button" class="se2_t_style9"><span>표스타일9</span></button></li>
											<li><button type="button" class="se2_t_style10"><span>표스타일10</span></button></li>
											<li><button type="button" class="se2_t_style11"><span>표스타일11</span></button></li>
											<li><button type="button" class="se2_t_style12"><span>표스타일12</span></button></li>
											<li><button type="button" class="se2_t_style13"><span>표스타일13</span></button></li>
											<li><button type="button" class="se2_t_style14"><span>표스타일14</span></button></li>
											<li><button type="button" class="se2_t_style15"><span>표스타일15</span></button></li>
											<li><button type="button" class="se2_t_style16"><span>표스타일16</span></button></li>
											</ul>
										</div>
										<!-- //레이어 : 표템플릿선택 -->
									</dd>
									</dl>
								</fieldset>
								<p class="se2_btn_area">
									<button type="button" class="se2_apply"><span>적용</span></button><button type="button" class="se2_cancel"><span>취소</span></button>
								</p>
								<!-- 딤드레이어 -->
								<div class="se2_t_dim3"></div>
								<!-- //딤드레이어 -->
							</div>
						</div>
					</div>
					<!-- //표 -->
					<!--//@lazyload_html-->
				</li>

				<li class="husky_seditor_ui_findAndReplace last_child" style="display:none;"><button type="button" title="찾기/바꾸기" class="se2_find"><span class="_buttonRound tool_bg">찾기/바꾸기</span></button>
					<!--@lazyload_html find_and_replace-->
					<!-- 찾기/바꾸기 -->
					<div class="se2_layer husky_se2m_findAndReplace_layer" style="margin-left:-238px;">
						<div class="se2_in_layer">
							<div class="se2_bx_find_revise">
								<button type="button" title="닫기" class="se2_close husky_se2m_cancel"><span>닫기</span></button>
								<h3>찾기/바꾸기</h3>
								<ul>
								<li class="active"><button type="button" class="se2_tabfind"><span>찾기</span></button></li>
								<li><button type="button" class="se2_tabrevise"><span>바꾸기</span></button></li>
								</ul>
								<div class="se2_in_bx_find husky_se2m_find_ui" style="display:block">
									<dl>
									<dt><label for="find_word">찾을 단어</label></dt><dd><input type="text" id="find_word" value="스마트에디터" class="input_ty1"></dd>
									</dl>
									<p class="se2_find_btns">
										<button type="button" class="se2_find_next husky_se2m_find_next"><span>다음 찾기</span></button><button type="button" class="se2_cancel husky_se2m_cancel"><span>취소</span></button>
									</p>
								</div>
								<div class="se2_in_bx_revise husky_se2m_replace_ui" style="display:none">
									<dl>
									<dt><label for="find_word2">찾을 단어</label></dt><dd><input type="text" id="find_word2" value="스마트에디터" class="input_ty1"></dd>
									<dt><label for="revise_word">바꿀 단어</label></dt><dd><input type="text" id="revise_word" value="스마트에디터" class="input_ty1"></dd>
									</dl>
									<p class="se2_find_btns">
										<button type="button" class="se2_find_next2 husky_se2m_replace_find_next"><span>다음 찾기</span></button><button type="button" class="se2_revise1 husky_se2m_replace"><span>바꾸기</span></button><button type="button" class="se2_revise2 husky_se2m_replace_all"><span>모두 바꾸기</span></button><button type="button" class="se2_cancel husky_se2m_cancel"><span>취소</span></button>
									</p>
								</div>
								<button type="button" title="닫기" class="se2_close husky_se2m_cancel"><span>닫기</span></button>
							</div>
						</div>
					</div>
					<!-- //찾기/바꾸기 -->
					<!--//@lazyload_html-->
				</li>
</ul>
			</div>
			<!-- //704이상 -->
		</div>

         </nav>
 </header>		
<!-- 에디터 툴바 끝 -->
		
				<!-- 접근성 도움말 레이어 -->
		<div class="se2_layer se2_accessibility" style="display:none;">
			<div class="se2_in_layer">
				<button type="button" title="닫기" class="se2_close"><span>닫기</span></button>
				<h3><strong>접근성 도움말</strong></h3>
				<div class="box_help">
					<div>
						<strong>툴바</strong>
						<p>ALT+F10 을 누르면 툴바로 이동합니다. 다음 버튼은 TAB 으로 이전 버튼은 SHIFT+TAB 으로 이동 가능합니다. ENTER 를 누르면 해당 버튼의 기능이 동작하고 글쓰기 영역으로 포커스가 이동합니다. ESC 를 누르면 아무런 기능을 실행하지 않고 글쓰기 영역으로 포커스가 이동합니다.</p>
						<strong>빠져 나가기</strong>
						<p>ALT+. 를 누르면 스마트 에디터 다음 요소로 ALT+, 를 누르면 스마트에디터 이전 요소로 빠져나갈 수 있습니다.</p>
						<strong>명령어 단축키</strong>
						<ul>
						<li>CTRL+B <span>굵게</span></li>
						<li>SHIFT+TAB <span>내어쓰기</span></li>
						<li>CTRL+U <span>밑줄</span></li>
						<li>CTRL+F <span>찾기</span></li>
						<li>CTRL+I <span>기울임 글꼴</span></li>
						<li>CTRL+H <span>바꾸기</span></li>
						<li>CTRL+D <span>취소선</span></li>
						<li>CTRL+K <span>링크걸기</span></li>
						<li>TAB <span>들여쓰기</span></li>
						</ul>
					</div>
				</div>
				<div class="se2_btns">
					<button type="button" class="se2_close2"><span>닫기</span></button>
				</div>
			</div>
		</div>		
		<!-- //접근성 도움말 레이어 -->

		<hr>
		<!-- 제목 영역 -->
		<article id="head" style="width:950px; margin:0 auto;margin-top:20px;">
        <input class="title" id="titleName" type="text" value="" placeholder="제목" autocomplete="off" onkeyup="keyTitle()">
      	</article>
		<!-- //제목 영역 -->
		<!-- 입력 -->
		<div class="se2_input_area husky_seditor_editing_area_container">
			<div class="se2_converter" style="float:right; position:relative;">
				<div><button type="button" class="se2_to_html" style="width:auto; height:auto; float: right; border: 1px solid #e1e4e8; padding: 12px 14px; margin: 23px 27px 0 0; color: #5d6a7b; background:none;">HTML</button>
				</div>
				<div><button type="button" class="se2_to_editor" style="width:auto; height:auto; float: right; border: 1px solid #e1e4e8; padding: 12px 14px; margin: 23px 27px 0 0; color: #5d6a7b; background:none;">편집모드</button>
				</div>
			</div>
			<script>
				function keyTitle(){
					$("#title").val($("#titleName").val());
				}
				function saveA(){
					$("#contexts").val(oEditor.getIR());
					document.getElementById("saveForm").submit();
				};
			</script>
			<form id="saveForm" action="PortfolioWriterPro?layout=post" method="post" enctype="multipart/form-data">
				<input type="radio" name="range" id="public" value="Y">
				<label for="public">공개</label>
				<input type="radio" name="range" id="private" value="N" checked>
				<label for="private">비공개</label>
				<input type="file" name="uploadFile" style="display:none;">				
				<input type="hidden" id="title" name="title">
				<iframe src="about:blank" id="se2_iframe" name="se2_iframe" class="se2_input_wysiwyg" width="950px" height="300" title="글쓰기 영역 : 도구 모음은 ALT+F10을, 도움말은 ALT+0을 누르세요." frameborder="0" style="display:block;" onkeyup="cc()"></iframe>
				<textarea id="contexts" name="context" rows="10" cols="100" title="HTML 편집 모드" class="se2_input_syntax se2_input_htmlsrc" style="display:none;outline-style:none;resize:none; top:68px;"> </textarea>
				<textarea name="" rows="10" cols="100" title="TEXT 편집 모드" class="se2_input_syntax se2_input_text" style="display:none;outline-style:none;resize:none;"> </textarea>
			</form>
			<!-- 입력창 조절 안내 레이어 -->
			<div class="ly_controller husky_seditor_resize_notice" style="z-index:20;display:none;">
				<p>아래 영역을 드래그하여 입력창 크기를 조절할 수 있습니다.</p>
				<button type="button" title="닫기" class="bt_clse"><span>닫기</span></button>
				<span class="ic_arr"></span>
			</div>
			<!-- //입력창 조절 안내 레이어 -->
						<div class="quick_wrap">
				<!-- 표/글양식 간단편집기 -->
				<!--@lazyload_html qe_table-->
				<div class="q_table_wrap" style="z-index: 150;">
				<button class="_fold se2_qmax q_open_table_full" style="position:absolute; display:none;top:340px;left:210px;z-index:30;" title="최대화" type="button"><span>퀵에디터최대화</span></button>
				<div class="_full se2_qeditor se2_table_set" style="position:absolute;display:none;top:135px;left:661px;z-index:30;">
					<div class="se2_qbar q_dragable"><span class="se2_qmini"><button title="최소화" class="q_open_table_fold"><span>퀵에디터최소화</span></button></span></div>
					<div class="se2_qbody0">
						<div class="se2_qbody">
							<dl class="se2_qe1">
							<dt>삽입</dt><dd><button class="se2_addrow" title="행삽입" type="button"><span>행삽입</span></button><button class="se2_addcol" title="열삽입" type="button"><span>열삽입</span></button></dd>
							<dt>분할</dt><dd><button class="se2_seprow" title="행분할" type="button"><span>행분할</span></button><button class="se2_sepcol" title="열분할" type="button"><span>열분할</span></button></dd>

							<dt>삭제</dt><dd><button class="se2_delrow" title="행삭제" type="button"><span>행삭제</span></button><button class="se2_delcol" title="열삭제" type="button"><span>열삭제</span></button></dd>
							<dt>병합</dt><dd><button class="se2_merrow" title="행병합" type="button"><span>행병합</span></button></dd>
							</dl>
							<div class="se2_qe2 se2_qe2_3"> <!-- 테이블 퀵에디터의 경우만,  se2_qe2_3제거 -->
								<!-- 샐배경색 -->
								<dl class="se2_qe2_1">

								<dt><input type="radio" checked="checked" name="se2_tbp3" id="se2_cellbg2" class="husky_se2m_radio_bgc"><label for="se2_cellbg2">셀 배경색</label></dt>
								<dd><span class="se2_pre_color"><button style="background: none repeat scroll 0% 0% rgb(255, 255, 255);" type="button" class="husky_se2m_table_qe_bgcolor_btn"><span>색찾기</span></button></span>		
									<!-- layer:셀배경색 -->
									<div style="display:none;position:absolute;top:20px;left:0px;" class="se2_layer se2_b_t_b1">
										<div class="se2_in_layer husky_se2m_tbl_qe_bg_paletteHolder">
										</div>
									</div>
									<!-- //layer:셀배경색-->

								</dd>
								</dl>
								<!-- //샐배경색 -->
								<!-- 배경이미지선택 -->
								<dl style="display: none;" class="se2_qe2_2 husky_se2m_tbl_qe_review_bg">
								<dt><input type="radio" name="se2_tbp3" id="se2_cellbg3" class="husky_se2m_radio_bgimg"><label for="se2_cellbg3">이미지</label></dt>
								<dd><span class="se2_pre_bgimg"><button class="husky_se2m_table_qe_bgimage_btn se2_cellimg0" type="button"><span>배경이미지선택</span></button></span>
									<!-- layer:배경이미지선택 -->
									<div style="display:none;position:absolute;top:20px;left:-155px;" class="se2_layer se2_b_t_b1">
										<div class="se2_in_layer husky_se2m_tbl_qe_bg_img_paletteHolder">
											<ul class="se2_cellimg_set">
											<li><button class="se2_cellimg0" type="button"><span>배경없음</span></button></li>
											<li><button class="se2_cellimg1" type="button"><span>배경1</span></button></li>
											<li><button class="se2_cellimg2" type="button"><span>배경2</span></button></li>
											<li><button class="se2_cellimg3" type="button"><span>배경3</span></button></li>
											<li><button class="se2_cellimg4" type="button"><span>배경4</span></button></li>
											<li><button class="se2_cellimg5" type="button"><span>배경5</span></button></li>
											<li><button class="se2_cellimg6" type="button"><span>배경6</span></button></li>
											<li><button class="se2_cellimg7" type="button"><span>배경7</span></button></li>
											<li><button class="se2_cellimg8" type="button"><span>배경8</span></button></li>
											<li><button class="se2_cellimg9" type="button"><span>배경9</span></button></li>
											<li><button class="se2_cellimg10" type="button"><span>배경10</span></button></li>
											<li><button class="se2_cellimg11" type="button"><span>배경11</span></button></li>
											<li><button class="se2_cellimg12" type="button"><span>배경12</span></button></li>
											<li><button class="se2_cellimg13" type="button"><span>배경13</span></button></li>
											<li><button class="se2_cellimg14" type="button"><span>배경14</span></button></li>
											<li><button class="se2_cellimg15" type="button"><span>배경15</span></button></li>
											<li><button class="se2_cellimg16" type="button"><span>배경16</span></button></li>
											<li><button class="se2_cellimg17" type="button"><span>배경17</span></button></li>
											<li><button class="se2_cellimg18" type="button"><span>배경18</span></button></li>
											<li><button class="se2_cellimg19" type="button"><span>배경19</span></button></li>
											<li><button class="se2_cellimg20" type="button"><span>배경20</span></button></li>
											<li><button class="se2_cellimg21" type="button"><span>배경21</span></button></li>
											<li><button class="se2_cellimg22" type="button"><span>배경22</span></button></li>
											<li><button class="se2_cellimg23" type="button"><span>배경23</span></button></li>
											<li><button class="se2_cellimg24" type="button"><span>배경24</span></button></li>
											<li><button class="se2_cellimg25" type="button"><span>배경25</span></button></li>
											<li><button class="se2_cellimg26" type="button"><span>배경26</span></button></li>
											<li><button class="se2_cellimg27" type="button"><span>배경27</span></button></li>
											<li><button class="se2_cellimg28" type="button"><span>배경28</span></button></li>
											<li><button class="se2_cellimg29" type="button"><span>배경29</span></button></li>
											<li><button class="se2_cellimg30" type="button"><span>배경30</span></button></li>
											<li><button class="se2_cellimg31" type="button"><span>배경31</span></button></li>
											</ul>
										</div>
									</div>
									<!-- //layer:배경이미지선택-->
								</dd>
								</dl>
								<!-- //배경이미지선택 -->
							</div>
							<dl style="display: block;" class="se2_qe3 se2_t_proper2">
							<dt><input type="radio" name="se2_tbp3" id="se2_tbp4" class="husky_se2m_radio_template"><label for="se2_tbp4">표 스타일</label></dt>
							<dd>
								<div class="se2_qe3_table">
								<div class="se2_select_ty2"><span class="se2_t_style1"></span><button class="se2_view_more husky_se2m_template_more" title="더보기" type="button"><span>더보기</span></button></div>
								<!-- layer:표스타일 -->
								<div style="display:none;top:33px;left:0;margin:0;" class="se2_layer_t_style">
									<ul>
									<li><button class="se2_t_style1" type="button"><span>표 스타일1</span></button></li>
									<li><button class="se2_t_style2" type="button"><span>표 스타일2</span></button></li>
									<li><button class="se2_t_style3" type="button"><span>표 스타일3</span></button></li>
									<li><button class="se2_t_style4" type="button"><span>표 스타일4</span></button></li>
									<li><button class="se2_t_style5" type="button"><span>표 스타일5</span></button></li>
									<li><button class="se2_t_style6" type="button"><span>표 스타일6</span></button></li>
									<li><button class="se2_t_style7" type="button"><span>표 스타일7</span></button></li>
									<li><button class="se2_t_style8" type="button"><span>표 스타일8</span></button></li>
									<li><button class="se2_t_style9" type="button"><span>표 스타일9</span></button></li>
									<li><button class="se2_t_style10" type="button"><span>표 스타일10</span></button></li>
									<li><button class="se2_t_style11" type="button"><span>표 스타일11</span></button></li>
									<li><button class="se2_t_style12" type="button"><span>표 스타일12</span></button></li>
									<li><button class="se2_t_style13" type="button"><span>표 스타일13</span></button></li>
									<li><button class="se2_t_style14" type="button"><span>표 스타일14</span></button></li>
									<li><button class="se2_t_style15" type="button"><span>표 스타일15</span></button></li>
									<li><button class="se2_t_style16" type="button"><span>표 스타일16</span></button></li>
									</ul>
								</div>
								<!-- //layer:표스타일 -->
								</div>
							</dd>
							</dl>
							<div style="display:none" class="se2_btn_area">
								<button class="se2_btn_save" type="button"><span>My 리뷰저장</span></button>
							</div>
							<div class="se2_qdim0 husky_se2m_tbl_qe_dim1"></div>
							<div class="se2_qdim4 husky_se2m_tbl_qe_dim2"></div>
							<div class="se2_qdim6c husky_se2m_tbl_qe_dim_del_col"></div>
							<div class="se2_qdim6r husky_se2m_tbl_qe_dim_del_row"></div>
						</div>
					</div>
				</div>
				</div>
				<!--//@lazyload_html-->
				<!-- //표/글양식 간단편집기 -->
				<!-- 이미지 간단편집기 -->
				<!--@lazyload_html qe_image-->
				<div class="q_img_wrap">
					<button class="_fold se2_qmax q_open_img_full" style="position:absolute;display:none;top:240px;left:210px;z-index:30;" title="최대화" type="button"><span>퀵에디터최대화</span></button>
					<div class="_full se2_qeditor se2_table_set" style="position:absolute;display:none;top:140px;left:450px;z-index:30;">
						<div class="se2_qbar  q_dragable"><span class="se2_qmini"><button title="최소화" class="q_open_img_fold"><span>퀵에디터최소화</span></button></span></div>
						<div class="se2_qbody0">
							<div class="se2_qbody">
								<div class="se2_qe10">
									<label for="se2_swidth">가로</label><input type="text" class="input_ty1 widthimg" name="" id="se2_swidth" value="1024"><label class="se2_sheight" for="se2_sheight">세로</label><input type="text" class="input_ty1 heightimg" name="" id="se2_sheight" value="768"><button class="se2_sreset" type="button"><span>초기화</span></button>
									<div class="se2_qe10_1"><input type="checkbox" name="" class="se2_srate" id="se2_srate"><label for="se2_srate">가로 세로 비율 유지</label></div>
								</div>
								<div class="se2_qe11">
									<dl class="se2_qe11_1">
									<dt><label for="se2_b_width2">테두리두께</label></dt>
										<dd class="se2_numberStepper"><input type="text" class="input_ty1 input bordersize" value="1" maxlength="2" name="" id="se2_b_width2" readonly="readonly">
										<button class="se2_add plus" type="button"><span>1px 더하기</span></button>
										<button class="se2_del minus" type="button"><span>1px 빼기</span></button>
									</dd>
									</dl>

									<dl class="se2_qe11_2">
									<dt>테두리 색</dt>
									<dd><span class="se2_pre_color"><button style="background:#000000;" type="button" class="husky_se2m_img_qe_bgcolor_btn"><span>색찾기</span></button></span>
										<!-- layer:테두리 색 -->
										<div style="display:none;position:absolute;top:20px;left:-209px;" class="se2_layer se2_b_t_b1">
											<div class="se2_in_layer husky_se2m_img_qe_bg_paletteHolder">
											</div>
										</div>
										<!-- //layer:테두리 색 -->
									</dd>
									</dl>
								</div>
								<dl class="se2_qe12">
								<dt>정렬</dt>
								<dd><button title="정렬없음" class="se2_align0" type="button"><span>정렬없음</span></button><button title="좌측정렬" class="se2_align1 left" type="button"><span>좌측정렬</span></button><button title="우측정렬" class="se2_align2 right" type="button"><span>우측정렬</span></button>
								</dd>
								</dl>
								<button class="se2_highedit" type="button"><span>고급편집</span></button>
								<div class="se2_qdim0"></div>
							</div>
						</div>
					</div>
				</div>
				<!--//@lazyload_html-->
				<!-- 이미지 간단편집기 -->
			</div>
		</div>
		<!-- //입력 -->
		<!-- 입력창조절/ 모드전환 -->
		<div class="se2_conversion_mode" style="display:none;">
			<!--<button type="button" class="se2_inputarea_controller husky_seditor_editingArea_verticalResizer" title="입력창 크기 조절"><span>입력창 크기 조절</span></button> -->
			<ul class="se2_converter">
			<li class="active"><button type="button" class="se2_to_editor"><span>Editor</span></button></li>
			<li><button type="button" class="se2_to_html"><span>HTML</span></button></li>
			<li><button type="button" class="se2_to_text"><span>TEXT</span></button></li>
			</ul>
		</div>
		<!-- //입력창조절/ 모드전환 -->
		<hr>
		<!-- 얼럿 메세지 공통 -->
		<div class="se2_alert_wrap" style="display:none">
			<div class="se2_alert_content">
				<div class="se2_alert_txts"></div>
				<p class="se2_alert_btns">
					<button type="button" class="se2_confirm"><span>확인</span></button><button type="button" class="se2_cancel"><span>취소</span></button>
				</p>
				<a href="#" class="btn_close">닫기</a>
			</div>
			<!-- 레이어 중앙정렬 -->
			<span class="va_line"></span>
			<div class="ie_cover"></div>
		</div>
		<!-- //얼럿 메세지 공통 -->
	</div>
	
</div>
<!-- SE2 Markup End -->



<!--Example Start-->
<div id="se2_sample" style="margin:10px 0;">
	<input type="button" onclick="pasteHTML();" value="본문에 내용 넣기" />
	<input type="button" onclick="showHTML();" value="본문 내용 가져오기" />
	<input type="button" onclick="submitContents();" value="서버로 내용 전송" />
	<input type="button" onclick="setDefaultFont();" value="기본 폰트 지정하기 (궁서_24)" />
	<form action="../../Xss방어 하기.jsp" method="post">
		<textarea name="contents" id="ir1" rows="10" cols="100" style="width:950px; height:1300px; display:none;">
			<p style="font-size:13pt">내용을 입력하세요.</p>
		</textarea>
	</form>
</div>

<!--이미지 popup 시작-->
<div class="comm-pop" style="display:none;">
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
    <!--
    <input type="checkbox" id="IMGee3db6" name="" value="">
    <div class="items IMGee3db6"><label for="IMGee3db6"><img style="width:100%;" src="https://pixabay.com/get/ee3db60a2af61c22d2524518b74d4792e771e1d61aac104491f9c178a0e5b7bf_1280.jpg"></label></div>
    <input type="checkbox" id="IMGe133b2" name="" value="">
    <div class="items IMGe133b2"><label for="IMGe133b2"><img style="width:100%;" src="https://pixabay.com/get/e133b2092ff11c22d2524518b74d4792e771e1d61aac104491f9c178a0e5b7bf_1280.jpg"></label></div>
    <input type="checkbox" id="IMGe83db3" name="" value="">
    <div class="items IMGe83db3"><label for="IMGe83db3"><img style="width:100%;" src="https://pixabay.com/get/e83db30d2df6013ed1584d05fb1d4797e773e4d61ab20c4090f4c879a6eabdbadf_1280.jpg"></label></div>
    <input type="checkbox" id="IMGe83db32" name="" value="">
    <div class="items IMGe83db32"><label for="IMGe83db32"><img style="width:100%;" src="https://pixabay.com/get/e83db30d2df6013ed1584d05fb1d4797e773e4d61ab20c4090f4c879a6eabdbadf_1280.jpg"></label></div>
    <input type="checkbox" id="IMGe83db30" name="" value="">
    <div class="items IMGe83db30"><label for="IMGe83db30"><img style="width:100%;" src="https://pixabay.com/get/e83db30d2df6013ed1584d05fb1d4797e773e4d61ab20c4090f4c879a6eabdbadf_1280.jpg"></label></div>
    <input type="checkbox" id="IMGe83db31" name="" value="">
    <div class="items IMGe83db31"><label for="IMGe83db31"><img style="width:100%;" src="https://pixabay.com/get/e83db30d2df6013ed1584d05fb1d4797e773e4d61ab20c4090f4c879a6eabdbadf_1280.jpg"></label></div>
  -->
</div>
  <div class="Provision">
    <img src="../portfolio/Editor/workspace/img/Provision.png" alt="빅데이터 이미지 제공 : 픽사베이">
  </div>
  <div id="loding">
    <div class="con"></div>
  </div>
  <div id="lodingBG"></div>
</div>
<!-- 이미지 popup 종료-->
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script>

<script type="text/javascript">
if(window.frameElement){
	jindo.$("se2_sample").style.display = "none";
}else{
	var oEditor = createSEditor2(jindo.$("ir1"), {
		bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
		bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
		//bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
		//aAdditionalFontList : [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]],	// 추가 글꼴 목록
		fOnBeforeUnload : function(){
			//예제 코드
			//return "내용이 변경되었습니다.";
		}
	});
	
	oEditor.run({
		fnOnAppReady: function(){
			//예제 코드
			//oEditor.exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		}
	});
	
	function pasteHTML() {
		var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
		oEditor.exec("PASTE_HTML", [sHTML]);
	}
	
	function showHTML() {
		var sHTML = oEditor.getIR();
		alert(sHTML);
	}
	
	function submitContents() {
		oEditor.exec("UPDATE_CONTENTS_FIELD");	// 에디터의 내용이 textarea에 적용됩니다.
	
		// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("ir1").value를 이용해서 처리하면 됩니다.
		jindo.$("ir1").form.submit();
	}
	
	function setDefaultFont() {
		var sDefaultFont = '궁서';
		var nFontSize = 24;
		oEditor.setDefaultFont(sDefaultFont, nFontSize);
	}
}
</script>
<!--Example End-->


<!-- 이미지 팝업 Start -->

<script defer type="text/javascript">
//이미지파업 온
function ImgPopOn(){
  $('.comm-pop').css("display","block");
  document.getElementsByTagName('body')[0].style.overflow = 'hidden';
}
//off
function ImgPopOff(){
  $('.comm-pop').css("display","none");
  document.getElementsByTagName('body')[0].style.overflow = 'scroll';
}


function ImgSearchKEYBO(){
  if (window.event.keyCode == 13) {
    ImgSearch();
  }
}
//이미지 검색을 위해 만듬
function ImgSearch(){
  $(document).ready(function() {
    document.getElementById("loding").style.display = "block";document.getElementById("lodingBG").style.display = "block"
    });
  Imgsrc=document.getElementById('searchInput').value;
  $('.pop-wrapper').html("");
  var code="";
  $.getJSON('https://pixabay.com/api/?key=11446333-bd811e8aa11e2a2852f803b7d&q=yellow+flowers&image_type=photo&lang=ko&q='+Imgsrc+'&per_page=6', function(data) {
    console.log(data);
    $.each(data.hits, function(index, value){
      console.log(value);
      var name = "";
      var bio = "";
      var imgeURL = value.largeImageURL;
      console.log(imgeURL);
      code=imgeURL.substring(24,80);
      //$('.wrapper').append('<div class="items IMG'+code+'"><img style="width:100%;" src="' + imgeURL + '"/></div>');
      $('.pop-wrapper').append('<input type="checkbox" id="IMG'+code+'" name="" value="">'+
      '<div class="items IMG'+code+'"><label for="IMG'+code+'"><img style="width:100%;" src="'+imgeURL+'"></label></div>');
    });
    if(code==""){
      $('.pop-wrapper').html('<div style=" text-align: right; margin-top: 100px; ">검색 결과가 없습니다.</div>');
    }
  });

  //2
  $.getJSON('https://api.unsplash.com/search/photos?page=1&query='+Imgsrc+'&client_id=9da242ad85084ad7ca951738b8e7d9478fd637ba6d41cf835be09e7e1628c9dc', function(data) {
    console.log(data);
    $.each(data.results, function(index, value){
      console.log(value);
      var name = value.user.name;
      var bio = value.user.bio;
      var imgeURL = value.urls.regular;
      code=imgeURL.substring(34,57);
      $('.pop-wrapper').append('<input type="checkbox" id="IMG'+code+'" name="" value="">'+
      '<div class="items IMG'+code+'"><label for="IMG'+code+'"><img style="width:100%;" src="'+imgeURL+'"></label></div>');
      });
        $('.pop-wrapper').append('<script>$(document).ready(function () {ArrayIMGURL=new Array(); $(".items").click(function(){ ce = $(this).find("label").attr("for"); cd=document.getElementsByClassName(ce)[0]; postLens=document.getElementsByClassName("postLen")[0]; ArrayIMGURL[ArrayIMGURL.length]=ce; if(ArrayIMGURL.length>1){ for(var i=0;i<ArrayIMGURL.length-1;i++){ if(ArrayIMGURL[i]==ArrayIMGURL[ArrayIMGURL.length-1]){ ArrayIMGURL.splice(ArrayIMGURL.indexOf(ArrayIMGURL[i]),1); ArrayIMGURL.splice(ArrayIMGURL.indexOf(ArrayIMGURL[ArrayIMGURL.length-1]),1); cd.classList.remove("pop-ck"); }else{ cd.classList.add("pop-ck"); } } }else{ postLens.classList.add("postLenA"); cd.classList.add("pop-ck"); } document.getElementsByClassName("postLen")[0].innerHTML=ArrayIMGURL.length; console.log(ArrayIMGURL); });});');
  });

  $(document).ajaxStop(function () {
  // 0 === $.active
  document.getElementById("loding").style.display = "none";document.getElementById("lodingBG").style.display = "none";
})
  //window.onload = function(){ document.getElementById("loding").style.display = "none";document.getElementById("lodingBG").style.display = "none" }


}
$(document).ready(function () {
  ArrayIMGURL=new Array();
  $('.items').click(function(){

    ce = $(this).find("label").attr("for");
    cd=document.getElementsByClassName(ce)[0];
    postLens=document.getElementsByClassName("postLen")[0];
    //cd.attr("class","pop-ck");
    //cd.classList.add("popck");
    ArrayIMGURL[ArrayIMGURL.length]=ce;

    if(ArrayIMGURL.length>1){
    for(var i=0;i<ArrayIMGURL.length-1;i++){

        if(ArrayIMGURL[i]==ArrayIMGURL[ArrayIMGURL.length-1]){
          ArrayIMGURL.splice(ArrayIMGURL.indexOf(ArrayIMGURL[i]),1);
          ArrayIMGURL.splice(ArrayIMGURL.indexOf(ArrayIMGURL[ArrayIMGURL.length-1]),1);
          cd.classList.remove("pop-ck");
        }else{
          cd.classList.add("pop-ck");
        }
    }
  }else{
      postLens.classList.add("postLenA");
      cd.classList.add("pop-ck");
  }
  document.getElementsByClassName('postLen')[0].innerHTML=ArrayIMGURL.length;
  console.log(ArrayIMGURL);
  });
});
</script>
<script>
 function insertIMG(){
  //스크롤 온
  document.getElementsByTagName('body')[0].style.overflow = 'scroll';
  //이미지 넣기위해만듬.
  //마춤형 이미지 추가
  //var cde=$('.ql-editor').last();
  for(var co=0;co<ArrayIMGURL.length;co++){
    //var dd=document.getElementsByClassName(ArrayIMGURL[co]).find("label").attr("for");
    ce = $('.'+ArrayIMGURL[co]).find("img").attr("src");
	var documenta="<img src='"+ce+"' style='max-width:100%'>";
    oEditor.exec("PASTE_HTML", [documenta]);
  }
  ArrayIMGURL=[];
  $('.items').removeClass("pop-ck");
  $('.comm-pop').css("display","none");
$('.postLenA').html("0");
  //var documenta =document.getElementsByClassName('ql-editor')[0].innerHTML;
  //var documentb = document.getElementById('contents');
  //documentb.innerHTML=documenta;
  
  }
 
 	

</script>
</body>
</html>