<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="../admin/css/datacenter.css">
    <style>
    	a:link{color:#000;}
    </style>
  </head>
  <body>
    <div class="datacenter-wrap">
      <div class="ops-head">
        <a class="#">
          <div class="cqu_icon"></div>
          <h1>OPS Data Center</h1>
          <div>Open portfolio Service</div>
        </a>
        <a href="#" class="logout-btn">로그아웃</a>
      </div>
    </div>
    <div class="datacenter-body">
      <!--맞춤형 서비스-->
      <h2>맞춤형 서비스</h2>
      <div class="datacenter-table">
        <div class="table-attr-wrap">
          <div class="attr-con">관심분야</div>
          <div class="attr-con">레이아웃</div>
          <div class="attr-con">이벤트 정보</div>
          <div class="attr-con">수정 빈도</div>
        </div>
        <div class="table-tuple">
        <c:forEach var="applb" items="${applb}" varStatus="status">
        	<c:if test="${applb.sett_no!=0}">
        		<div class="table-row">
			        <div class="">${applb.sett_in_interest}</div>
			        <div class="">${applb.sett_boardForm}</div>
			        <div class="">${applb.sett_click}</div>
			        <div class="">--</div>
		        </div>
        	</c:if>
        	<c:if test="${applb.appc_no!=0}">
        		<div class="table-row">
			        <div class="">${applb.appc_in_interest}</div>
			        <div class="">${applb.appc_boardForm}</div>
			        <div class="">${applb.appc_click}</div>
			        <div class="">--</div>
		        </div>
        	</c:if>
        </c:forEach>
          
        </div>
      </div>
      <div class="datacenter-double">
        <div class="datacenter-info datacenter-table-write">
          <h2>수집정보</h2>
          <div class="pluse"><a href="#d">더보기></a></div>
          <div class="datacenter-table">
            <div class="table-attr-wrap">
              <div class="attr-con">수집일</div>
              <div class="attr-con">관심분야</div>
              <div class="attr-con">클릭수</div>
              <div class="attr-con">레이아웃</div>
            </div>
            <div class="table-tuple">
            <c:forEach var="clsb" items="${clsb}" varStatus="status">
              <div class="table-row">
                <div>${fn:substring(clsb.col_date,0,16)}</div>
                <div>${clsb.in_interest}</div>
                <div>${clsb.col_click}</div>
                <div>${clsb.col_boardForm}</div>
              </div>
            </c:forEach>
            </div>
          </div>
        </div>
        <div class="datacenter-num datacenter-table-write">
          <h2>수집통계</h2>
          <div class="pluse"><a href="#d">더보기></a></div>
          <div class="datacenter-table">
            <div class="table-attr-wrap">
              <div class="attr-con" style="width:20%;">수집달</div>
              <div class="attr-con" style="width:20%;">관심분야</div>
              <div class="attr-con" style="width:20%;">레이아웃</div>
              <div class="attr-con" style="width:20%;">이벤트</div>
              <div class="attr-con" style="width:20%;">여부</div>
            </div>
            <div class="table-tuple">
            <c:forEach var="monthl" items="${monthl}" varStatus="status">
              <div class="table-row">
                <div style="width:20%;">${monthl.month_date}</div>
                <div style="width:20%;">${monthl.in_interest}</div>
                <div style="width:20%;">${monthl.col_boardForm}</div>
                <div style="width:20%;">${monthl.col_click}</div>
                <fmt:parseDate value="${fn:replace(monthl.month_date,'-','')}" pattern="yyyyMM" var="startDate" />
				<fmt:parseDate value="${fn:replace(date,'-','')}" pattern="yyyyMM" var="nowDate" />
              	<c:choose>
              		<c:when test="${nowDate<=startDate}">
              			<div style="width:20%;"><a href="#c" style="padding:5px 7px; color:#000; background:#dad2d275;">수집 중</a></div>
              		</c:when>
              		<c:when test="${nowDate>startDate}">
              			<div style="width:20%;"><a href="saveCollection?interest=${monthl.in_interest}&&boardForm=${monthl.col_boardForm}&&startDate=${monthl.month_date}&&click=${monthl.col_click}" style="padding:5px 5px; background:#1c6bf5; color:#fff;">승인하기</a></div>
              		</c:when>
              	</c:choose>
              </div>
            </c:forEach>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>