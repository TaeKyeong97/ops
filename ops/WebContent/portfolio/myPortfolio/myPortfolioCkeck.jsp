<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
	.remove>span:before{content:'사용 중'; color:#00ff08;}
	.remove:hover span:before{content:'사용 중지'; color:#f08d4e;}
</style>
<c:forEach var="mpfl" items="${mpfl}" varStatus="stauts">
	<div class="portf-content">
		<div class="portf-img">
			<img src="portfolio/view/upload/${mpfl.img}" alt="">
		</div>
		<a href="#c" class="title">${fn:substring(mpfl.title,0,7)}..</a>
		<a href="#c" class="cate">작성 유형 : ${mpfl.layout}</a>
		<a href="#c" id="add-${mpfl.no}" class="add" data-source="${mpfl.no}"><span>사용하기</span></a>
	</div>
</c:forEach>

<script>
//사용중인지 체크
var len=$(".ops-con>input").length;
$(document).on("click",".ops-add-con",function(){
	len=$(".ops-con>input").length;
	if(len>0){
		setTimeout(function() {
			for(var myLenI=1;myLenI<=len;myLenI++){
				$("#add-"+$(".ops-con>input:nth-child("+Number(myLenI*2)+")").attr("value")).html("<span></span>");
				$("#add-"+$(".ops-con>input:nth-child("+Number(myLenI*2)+")").attr("value")).addClass("remove");
			}
		}, 110);
	}
});
	
	//사용하기
	var portfIndexNumber=len;
	$(document).on("click",".add",function(){
		$(".ops-con>a").css({"top":"inherit","bottom":"0px","transform":"translate(-50%, -25%)"});
		if($(event.target).text()=="사용하기"){
			portfIndexNumber++;
			if($(event.target).attr("class")=="add"){
				$(event.target).html("<span></span>");
				$(event.target).addClass("remove");
				$(".ops-con").append("<input class=\"portfolioAddCon-"+$(event.target).attr("data-source")+"\" type=\"hidden\" name=\"portfolioList\" value=\""+$(event.target).attr("data-source")+"\">");
				$(".ops-con").append("<div class=\"ops-add-con portfolioAddCon-"+$(event.target).attr("data-source")+"\"> <div class=\"opsAdd-img\"><img src=\""+$(event.target).parent().children().first().children().first().attr("src")+"\" alt=\"\" style='width:100%;'> </div> <a href=\"#c\">"+$(event.target).prev().prev().text()+"</a> <a href=\"#c\">"+$(event.target).prev().text()+"</a></div>");
			}else{
				$(event.target).html("");
				$(event.target).parent().addClass("remove");
				$(".ops-con").append("<input class=\"portfolioAddCon-"+$(event.target).parent().attr("data-source")+"\" type=\"hidden\" name=\"portfolioList\" value=\""+$(event.target).parent().attr("data-source")+"\">");
				$(".ops-con").append("<div class=\"ops-add-con portfolioAddCon-"+$(event.target).parent().attr("data-source")+"\"> <div class=\"opsAdd-img\"><img src=\"\" alt=\"\"> </div> <a href=\"#c\" style='width:100%;'>"+$(event.target).parent().prev().prev().text()+"</a> <a href=\"#c\">"+$(event.target).parent().prev().text()+"</a></div>");
			}
			$(".portf-head>div:last-child").text("사용: "+portfIndexNumber+"건");
		}else{
			portfIndexNumber--;
			if($(event.target).attr("class")=="add remove"){
				$(event.target).html("<span>사용하기</span>");
				$(event.target).removeClass("remove");
				$(".portfolioAddCon-"+$(event.target).attr("data-source")).remove();
			}else{
				$(event.target).html("사용하기");
				$(event.target).parent().removeClass("remove");
				$(".portfolioAddCon-"+$(event.target).parent().attr("data-source")).remove();
				
			}
			$(".portf-head>div:last-child").text("사용: "+portfIndexNumber+"건");

		}
	});
	
</script>
