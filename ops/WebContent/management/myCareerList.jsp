<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 이력서 조회</title>
<style>
	@import url(https://fonts.googleapis.com/css?family=Nanum+Gothic);
	*{margin:0; padding:0;}
	html,body{width:100%; height:100%;}
	a{text-decoration:none; color:#000}
	a:hover{color:#000;}
	
	.myCareerList-wrap .myCareer-head{width:100%; height:100%; background:#0b62ff; }
	.myCareerList-wrap .myCareer-head h2{padding:16px 0; color:#fff; font-size:20px; font-weight:500; text-align:center; font-family: 'Nanum Gothic', sans-serif;}
	.careerOption{padding:18px 20px; border-bottom:1px solid #e7e8ec;}
	.portfolio-submit{width:100%; position:fixed; bottom:0;}
	.portfolio-submit>input[type="submit"]{width:100%; min-width:200px; max-width:400px; margin:0 auto; left:50%; bottom:20px; position:absolute; text-align:center; transform:translate(-50%,0); padding:18px 0; border:0; background:#0b62ff; color:#fff; font-size:16px;}
</style>
</head>
<body>
	
	
	<div class="myCareerList-wrap">
		<div class="myCareer-head">
			<h2>My이력서 선택</h2>	
		</div>
		<form action="noticSupport.no?n_no=${param.n_no}" method="post">
			<div class="myCareer-body">
				<c:forEach var="myCareerList" items="${myCareerList }" varStatus="status">
					<c:choose>
						<c:when test="${status.index==0}">
							<div class="careerOption">
							<input id="portfolio-${myCareerList.ca_no}" type="radio" name="portfolioList" value="${myCareerList.ca_no}" checked><label for="portfolio-${myCareerList.ca_no}">${myCareerList.ca_title}</label>
						</div>
						</c:when>
						<c:otherwise>
							<div class="careerOption">
							<input id="portfolio-${myCareerList.ca_no}" type="radio" name="portfolioList" value="${myCareerList.ca_no}"><label for="portfolio-${myCareerList.ca_no}">${myCareerList.ca_title}</label>
						</div>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<div class="portfolio-submit">
					<input type="submit" value="지원하기">
				</div>
			</div>
		</form>
	</div>
</body>
</html>