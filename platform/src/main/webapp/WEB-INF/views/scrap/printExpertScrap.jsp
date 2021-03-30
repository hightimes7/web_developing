<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="expertScrapAllList" value="${expMap.expertScrapAllList}" />
<c:set var="expertImage" value="${expMap.expertImage}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>printExpertScrap.do</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/animate.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/magnific-popup.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath }/resources/css/style.css">
  </head>
  <body>
 
		
		<section class="ftco-section">
			<div class="container">
				
				
				
				
			

				<div class="mt-5">
					<h2>전문가</h2>
				</div>
				<hr/>
				<div class="row">
				<!-- 전문가 -->
					<c:forEach var="expertScrap" items="${expertScrapAllList }">
					<!-- for -->
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">						
							<div class="img-wrap d-flex align-items-stretch">
								<c:forEach var="expImg" items="${expertImage}">
									<c:if test="${expertScrap.expid==expImg.id}">
										<div class="img align-self-stretch" style="background-image: url(${contextPath}/download.do?id=${expertScrap.expid}&imageFileName=${expImg.imageFileName})"></div>
									</c:if>
								</c:forEach>
								
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>${expertScrap.expName }</h3>
								<div class="faded">
									<p>${expertScrap.expBizField }<br>${expertScrap.expTel }</p>
									<a href="${contextPath }/expSearch/viewExpert.do?id=${expertScrap.expid }" class="btn btn-primary">상세페이지</a>
									<a href="${contextPath }/scrap/deleteExpertScrap.do?no=${expertScrap.no}&compId=${member.id}" class="btn btn-primary">삭제</a>
	<!-- sns 코드
									<ul class="ftco-social text-center">
	  	                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-google"></span></a></li>
		                <li class="ftco-animate"><a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"></span></a></li>
		             				</ul>
		             				-->
	             				</div>
							</div>														
						</div>
					</div>
					</c:forEach>
				</div><!-- row end -->
				
				
			
				
				
				
				
				
            </div><!-- container end -->
      </section>
      
    
  

  <!-- loader 
    <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
  <script src="js/main.js"></script>
  -->
    
    	
    	<!-- 페이지네이션 -->		
    		<div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
              	<c:if test="${pageVO.startPage != 1}">
                	<li><a href="${contextPath}/scrap/selectAllScrap.do?nowPage=${pageVO.startPage -1}&cntPerPage=${pageVO.cntPerPage}">&lt;</a></li>
                </c:if>
                <c:forEach begin = "${pageVO.startPage}" end = "${pageVO.endPage}" var="idx">
                	<c:choose>
                		<c:when test="${idx == pageVO.nowPage }">
                   			<li class="active"><span> ${idx} </span></li>
                  		</c:when>
                   		<c:when test="${idx != pageVO.nowPage}">
                   		<!-- compId 나중에 session에서 받도록 변경 -->
                   			<li><a href="${contextPath}/scrap/printExpertScrap.do?compId=compId&nowPage=${idx}&cntPerPage=${pageVO.cntPerPage}"> ${idx} </a></li>
                   		</c:when>
                     </c:choose>
                </c:forEach>
                 
                   <li><a href="#">&gt;</a></li>
              	
              </ul>
            </div>
          </div>
        </div>
  
  
  






 <!-- javascript -->
  <script src="${contextPath }/resources/js/jquery.min.js"></script>
  <script src="${contextPath }/resources/js/jquery-migrate-3.0.1.min.js"></script>
  <script src="${contextPath }/resources/js/popper.min.js"></script>
  <script src="${contextPath }/resources/js/bootstrap.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.easing.1.3.js"></script>
  <script src="${contextPath }/resources/js/jquery.waypoints.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.stellar.min.js"></script>
  <script src="${contextPath }/resources/js/owl.carousel.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.magnific-popup.min.js"></script>
  <script src="${contextPath }/resources/js/jquery.animateNumber.min.js"></script>
  <script src="${contextPath }/resources/js/scrollax.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
  <script src="${contextPath }/resources/js/main.js"></script>
  <script>
        var serchArray = document.querySelectorAll("button");
        var changeHtml ="";
        console.log(serchArray)
        var scrapArray = document.querySelectorAll(".scrapClass")
        
        for(var i = 0 ; i<scrapArray.length; i++){
			
			scrapArray[i].addEventListener("click",function(e){
				var expertId = e.target.id
				$.ajax({
	            	url:"${contextPath}/scrap/scrapExpert.do",
	            	type:"GET",
	            	data:{"id":expertId},
	            	dataType:"json",
	            	success:function(data){
	            		console.log("success")
	            	}
	            });
			})
		}
        
        
        
       
        
        for(var i = 0 ; i<serchArray.length; i++){
            serchArray[i].addEventListener("click",function(e){
                var target = e.target.id
                var select = "";
                
                if(target === "serchByTypebtn"){
                    select = document.querySelector("#expertBizType").value
                    console.log(select)
                    changeHtml ="";
                    if(select != "box"){
	                    typeAjax(select);
                    }else{
                    	window.location.reload(true);
                    }
                }else if(target === "serchByName"){
                    select = document.querySelector("#expertName").value
                    console.log(select)
                    changeHtml ="";
                    nameAjax(select);
                }
            })
        }
		function typeAjax(select){
			$.ajax({
            	url:"${contextPath}/serchByExpertType",
            	type:"GET",
            	data:{"type":select},
            	dataType:"json",
            	success:function(data){
            		for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
           			}
            	}
            });
		}
		
		function nameAjax(select){
			$.ajax({
                url:"${contextPath}/serchByExpertName",
                type:"GET",
                data:{"name":select},
                success:function(data){
                	for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manuFac = data[i];
                		console.log(manuFac);
          				fixHtml(manuFac);
           			}
                }
            });
		}
		
		function fixHtml(expert){
				changeHtml += '<div class="col-md-4 d-flex">'        				
				changeHtml += 	'<div class="book-wrap">'
				changeHtml +=		'<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath }/resources/images/book-1.jpg);">'
				changeHtml +=			'<div class="in-text">'
				changeHtml +=				'<a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Add to Wishlist">'
				changeHtml +=						'<span class="flaticon-heart-1"></span>'
				changeHtml +=				'</a>'
				changeHtml +=				'<a href="#" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">'
				changeHtml +=					'<span class="flaticon-search"></span>'
				changeHtml +=				'</a>'
				changeHtml +=			'</div>'
				changeHtml +=		'</div>'
				changeHtml +=		'<div class="text px-4 py-3 w-100">'
				changeHtml +=			'<h2><a href="#"> '+expert.name+' </a></h2>'
				changeHtml +=			'<p> ' + expert.type + '</p>'
				changeHtml +=		'</div>'
				changeHtml +=	'</div>'
				changeHtml +='</div>'
			
  				console.log(changeHtml);
				$(".con").html(changeHtml);
		}
  </script>
    
  </body>
</html>