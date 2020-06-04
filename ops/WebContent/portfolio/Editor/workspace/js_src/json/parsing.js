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
