<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="warningWin-wrap" style="z-index:500;">
  <div class="warning-info">
    현재 <span>${pfclsSize}건</span>의 이력서와 연결되어 있습니다.
  </div>
  <div class="warning-btn">
    <button type="button" name="button" onclick="closeP()">취소</button>
    <button type="button" name="button" onclick="deletePortfolio()">삭제</button>
  </div>
</div>

<script>
	function deletePortfolio(){
		location.href="PortfolioRemove?no=${param.no}&&layout=${param.layout}";
	}
</script>