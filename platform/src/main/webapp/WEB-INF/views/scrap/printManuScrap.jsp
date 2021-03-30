<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>printManuScrap.do</title>
    <meta charset="utf-8">
  </head>
  <body>
		<section class="ftco-section">
			<div class="container">
				<div class="mt-5">
					<h2>제조업체</h2>
				</div>
				<hr/>
				<div class="row">
				<!-- 전문가 -->
					<c:forEach var="manuScrap" items="${manuScrapAllList }">
					<!-- for -->
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">						
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(${contextPath}/download.do?id=${manuScrap.manuid}&imageFileName=${manuScrap.manuImg});"></div>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>${manuScrap.manuName }</h3>
								<div class="faded">
									<p>${manuScrap.manuBizType }<br>${manuScrap.productPrice }</p>
									<a href="${contextPath }/manufacSearch/viewManufac.do?id=${manuScrap.manuid }" class="btn btn-primary">상세페이지</a>
									<a href="${contextPath }/scrap/deleteManuScrap.do?no=${manuScrap.no}&compId=${member.id}" class="btn btn-primary">삭제</a>
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
    	<!-- 페이지네이션 -->		
    		<div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
                <c:if test="${pageVO.startPage != 1}">
                	<li><a href="${contextPath}/scrap/printManuScrap.do?nowPage=${pageVO.startPage -1}&cntPerPage=${pageVO.cntPerPage}">&lt;</a></li>
                </c:if>
                <c:forEach begin = "${pageVO.startPage}" end = "${pageVO.endPage}" var="idx">
                	<c:choose>
                		<c:when test="${idx == pageVO.nowPage}">
                   			<li class="active"><span> ${idx} </span></li>
                  		</c:when>
                   		<c:when test="${idx != pageVO.nowPage}">
                   		<!-- compId 나중에 session에서 받도록 변경 -->
                   			<li><a href="${contextPath}/scrap/printManuScrap.do?compId=compId&nowPage=${idx}&cntPerPage=${pageVO.cntPerPage}"> ${idx} </a></li>
                   		</c:when>
                     </c:choose>
                </c:forEach>
                 
                   <li><a href="#">&gt;</a></li>
              </ul>
            </div>
          </div>
        </div>

 <!-- javascript -->
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