<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${userID!=null}">
		<c:forEach var="pfb" items="${pfb}" varStatus="3">
			<div class="tabbox_3">
				<p class="thum_name">${pfb.id }</p> <!--포트폴리오 작성자명-->
				<img class="thum_heart" src="../portfolio/view/img/thum_heart.png" alt="찜">
				<img class="thum_star" src="../portfolio/view/img/icon_star1.png" alt="큰 별 이미지">
				<img class="thum_img" src="../portfolio/view/upload/${pfb.img}" alt="썸네일이미지">
				<div class="thum_desc"> <!--썸네일아래 흰색 박스-->
					<a href="PortfolioView?no=${pfb.no}&&layout=${pfb.layout}" class="thum_title">${pfb.title}</a>
					<p class="thum_subtitle">--</p>
					<ul class="thum_starscore">
						<li><img src="../portfolio/view/img/icon_smallstar10.png" alt="별점10"></li>
						<li><img src="../portfolio/view/img/icon_smallstar10.png" alt="별점10"></li>
						<li><img src="../portfolio/view/img/icon_smallstar10.png" alt="별점10"></li>
						<li><img src="../portfolio/view/img/icon_smallstar5.png" alt="별점5"></li>
						<li><img src="../portfolio/view/img/icon_smallstar0.png" alt="별점0"></li>
					</ul>
					<p class="thum_categorytxt">카테고리 <span class="thum_category">요리</span></p>
				</div>
			</div>
		</c:forEach>
	</c:when>
	<c:when test="${emID!=null}">
		<script>
			alert("기업회원은 이용불가한 상품 입니다.");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("로그인후이용가능한 서비스 입니다.");
			window.location.href="../LOGIN/login?loginCk?=0";
		</script>
	</c:otherwise>
</c:choose>