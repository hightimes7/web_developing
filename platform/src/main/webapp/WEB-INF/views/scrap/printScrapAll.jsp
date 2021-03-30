<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="expertScrapList" value="${expMap.expertScrapList}" />
<c:set var="expertImage" value="${expMap.expertImage}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>printScrapAll.do</title>
    <meta charset="utf-8">
  </head>
  <body>
		<section class="ftco-section">
			<div class="container">



				<div class="subtitle">
					<h2>제조업체</h2>
				</div>
				<hr/>
				<div class="row">
				<!-- 제조업체 -->
					<c:forEach var="allScrap" items="${manuScrapList}">
					<!-- for -->
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">						
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(${contextPath}/download.do?id=${allScrap.manuid}&imageFileName=${allScrap.manuImg});"></div>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>${allScrap.manuName }</h3>
								<div class="faded">
									<p>${allScrap.manuBizType}<br>${allScrap.productPrice }</p>
									<a href="${contextPath}/manufacSearch/viewManufac.do?id=${allScrap.manuid}" class="btn btn-primary">상세페이지</a>
	             				</div>
							</div>														
						</div>
					</div>
					</c:forEach>
				</div><!-- row end -->
				<div style="float:right;">
					<a href="${contextPath}/scrap/printManuScrap.do?compId=${member.id}" class="btn btn-primary">더보기</a>
					<!-- 합친 후 compId 는 세션의 값을 가져와 사용자를 식별할 수 있도록 수정 -->
				</div>
				<div class="mt-5">
					<h2>전문가</h2>
				</div>
				<hr/>
				<div class="row">
				<!-- 전문가 -->
					<c:forEach var="allScrap" items="${expertScrapList }">
					<!-- for -->
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">						
							<div class="img-wrap d-flex align-items-stretch">
								<c:forEach var="expImg" items="${expertImage}">
									<c:if test="${allScrap.expid==expImg.id}">
										<div class="img align-self-stretch" style="background-image: url(${contextPath}/download.do?id=${allScrap.expid}&imageFileName=${expImg.imageFileName})"></div>
									</c:if>
								</c:forEach>
								
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>${allScrap.expName }</h3>
								<div class="faded">
									<p>${allScrap.expBizField }<br>${allScrap.expTel }</p>
									<a href="${contextPath}/expSearch/viewExpert.do?id=${allScrap.expid}" class="btn btn-primary">상세페이지</a>
	             				</div>
							</div>														
						</div>
					</div>
					</c:forEach>
				</div><!-- row end -->
				<div style="float:right;">
					<a href="${contextPath}/scrap/printExpertScrap.do?compId=${member.id}" class="btn btn-primary">더보기</a>
					<!-- 합친 후 compId 는 세션의 값을 가져와 사용자를 식별할 수 있도록 수정 -->
				</div>
            </div><!-- container end -->
      </section>
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