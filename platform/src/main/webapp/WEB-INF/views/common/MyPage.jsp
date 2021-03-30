<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
        <meta charset="utf-8">
    <style>
    .sidebar{
    	position: absolute;
		top:20px;
		right:-150px;
		width:130px;
    }
    
	  .down{
	    position: fixed;
	    top: 0;
	  }
	  
    </style>
  </head>
  <body>
	<section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
           <!-- user정보 -->
           <c:if test="${user.type=='startup' }">
	           <!-- 소개 사진 한칸 -->
	          	<div class="col-lg-5 ftco-animate" style="height:500px">
		          	<p>
		              <img src="${contextPath}/download.do?id=${user.id}&imageFileName=${user.compImg}" alt="" class="img-fluid">
		            </p>
	           </div> <!-- .col-md-8 -->
	           <!-- 소개 사진 한칸 -->
	           <div class="col-lg-7 ftco-animate">
		          		<h3>${user.id }</h3>
		          		<h3>${user.compName }</h3>
		          		<h3>${user.compEmail }</h3>
		          		<h3>${user.compBizType }</h3>
		          		<h3>${user.compTel }</h3>
	           </div>
           </c:if>
           <c:if test="${user.type=='manufac'}">
	           <!-- 소개 사진 한칸 -->
	          	<div class="col-lg-5 ftco-animate" style="height:500px">
		          	<p>
		              <img src="${contextPath}/download.do?id=${user.id}&imageFileName=${user.manuImg}" alt="" class="img-fluid">
		            </p>
	           </div> <!-- .col-md-8 -->
	           <!-- 소개 사진 한칸 -->
           		<div class="col-lg-7 ftco-animate">
		          		<h3>${user.id }</h3>
		          		<h3>${user.manuName }</h3>
		          		<h3>${user.manuEmail }</h3>
		          		<h3>${user.manuBizType }</h3>
		          		<h3>${user.manuTel }</h3>
	           </div>
           </c:if>
           <c:if test="${user.type=='expert'}">
	           		<!-- 소개 사진 한칸 -->
	          	<div class="col-lg-5 ftco-animate" style="height:500px">
		          	<p>
		              <img src="${contextPath}/download.do?id=${user.id}&imageFileName=${userImg[1].imageFileName}" alt="" class="img-fluid">
		            </p>
	           </div> <!-- .col-md-8 -->
	           <!-- 소개 사진 한칸 -->
           		<div class="col-lg-7 ftco-animate">
		          		<h3>${user.id }</h3>
		          		<h3>${user.expName }</h3>
		          		<h3>${user.expEmail }</h3>
		          		<h3>${user.expBizField }</h3>
		          		<h3>${user.expTel }</h3>
	           </div>
           </c:if>

          <!-- user정보 -->
          <!-- user정보가 스타트업 이라면 모두 출력 -->
          <!-- user정보가 제조업체라면 견적내역만 출력-->
          <!-- user정보가 전문가라면 컨설팅내역만 출력-->
          <!-- 전문가 스크랩 한칸 -->
          <!-- 더보기 버튼 필요 -->
          <c:if test="${userType eq 'startup' }">
          		
	          <div class="col-md-12">
	          <div>
		          <h3 style="display: inline-block;">전문가 스크랩 리스트</h3>&nbsp;
		          <a href="${contextPath }/scrap/printScrapAll.do?compId=${user.id }" class="btn btn-primary" >More</a>
	          </div>
	          <c:forEach items="${expertList }" var="expert">
		        <div class="col-md-3 ftco-animate" style="display: inline-block;">
					<div class="staff">
							<div class="img-wrap d-flex align-items-stretch" >
								<c:forEach items="${expertImg}" var="expImg">
									<c:if test="${expert.id==expImg.id}">
										<div class="img align-self-stretch" style="background-image: url(${contextPath}/download.do?id=${expert.id}&imageFileName=${expImg.imageFileName}"></div>
									</c:if>
								</c:forEach>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>${expert.expName }</h3>
								<div class="faded">
									<p>${expert.expBizField }</p>
									<a href="${contextPath }/expSearch/viewExpert.do?id=${expert.id }" class="btn btn-primary">상세페이지</a>
			            		</div>
							</div>
						</div>
				</div>
				</c:forEach>
			  </div>
			  <!-- 전문가 스크랩 한칸 -->
			  <div class="col-md-12" style="height: 250px;"></div>
			  <!-- 제조업체 한칸 -->
			  <!-- 더보기 버튼 필요 -->
			  <div class="col-md-12">
			  <div>
				  <h3 style="display: inline-block;">제조업체 스크랩 리스트</h3>
				  <a href="${contextPath }/scrap/printScrapAll.do?compId=${user.id}" class="btn btn-primary" >More</a>
			  </div>
			  <c:forEach items="${manuList }" var="manu">
				  <div class="col-md-3 ftco-animate" style="display: inline-block;">
		 				<div class="book-wrap">
		 					<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath}/download.do?id=${manu.id}&imageFileName=${manu.manuImg});">
		 						<div class="in-text">
									<a href="${contextPath }/manufacSearch/viewManufac.do?id=${manu.id}" class="btn btn-primary">상세페이지</a>
		 						</div>
		 					</div>
		 					<div class="text px-4 py-3 w-100">
		 						<p class="mb-2"><span class="price">${manu.productPrice}</span></p>
		 						<h2><a href="${contextPath }/manufacSearch/viewManufac.do?id=${manu.id}">${manu.manuName}</a></h2>
		 						<p>${manu.manuBizType }</p>
		 					</div>
		 				</div>
				  	</div>
				  </c:forEach>
			  </div>
			  <!-- 제조업체 한칸 -->
			  
		  </c:if>
		  
		  <div class="col-md-12" style="height: 250px;"></div>
		  
		  <c:if test="${userType eq 'startup'||userType eq 'manu' }">
		  
			  <!-- 더보기 버튼 필요 -->
				  <div class="col-md-6">
					  <div class="col-md-12">
						  <h1 class="mb-3" style="display: inline-block;">Quotation List</h1>&nbsp;
						  <c:if test="${userType eq 'startup' }">
						  	<a href="${contextPath }/startuppage/manu_estilist.do?compId=${user.id}" class="btn btn-primary" >More</a>
						  </c:if>
						  <c:if test="${userType eq 'manu' }">
						  	<a href="${contextPath }/manufacpage/estilist.do?manuId=${user.id}" class="btn btn-primary" >More</a>
						  </c:if>
					  </div>
					  <ul style="line-height: 55px; list-style: none; font-size: 30px;">
					  	<c:forEach items="${quotationList }" var="quotation" >
					  		<li><a style="text-decoration: none;" href="${contextPath}/quotation/viewOneQuotation.do?no=${quotation.no}">${quotation.manuId} / ${quotation.item } / ${quotation.quantity }</a></li>
					  	</c:forEach>
					  </ul>
				  </div>
			</c:if>
			<c:if test="${userType eq 'startup'||userType eq 'expert'}">
			  <!-- 요청 컨설팅 리스트 -->
			  <!-- 더보기 버튼 필요 -->
				  <div class="col-md-6">
					  <div class="col-md-12">
						  <h1 class="mb-3" style="display: inline-block;">Consulting List</h1>&nbsp;
						  <c:if test="${userType eq 'startup'}">
						  	<a href="${contextPath }/startuppage/consultinglist.do?compId=${user.id}" class="btn btn-primary" >More</a>
						  </c:if>
						  <c:if test="${userType eq 'expert'}">
						  	<a href="${contextPath }/expertpage/consulting.do?expId=${user.id}" class="btn btn-primary" >More</a>
						  </c:if>
					  </div>
					  <ul style="line-height: 55px; list-style: none; font-size: 30px;">
					  	<c:forEach items="${consultingList }" var="consulting" >
					  		<li><a style="text-decoration: none;" href="${contextPath}/consulting/viewOneConsulting.do?no=${consulting.no}">${consulting.title }</a></li>
					  	</c:forEach>
					  </ul>
		        </div>
		        
	        </c:if>
        </div>
      </div>
    </section> <!-- .section -->
    
    <!-- side bar -->
	<div class="col-lg-4 pl-lg-5 " id="sidebar" style="position:absolute; top: 800px; right:0px; width:500px;">
	     <div class="sidebar-box ">
	       <div class="categories">
	         <h3>Services</h3>
	         <ul style="list-style: none;">
	         	<c:if test="${userType eq 'startup' }">
			         <li><a href="${contextPath}/startup/startUpSelectForm.do?id=${user.id}">내 정보 관리 <span class="fa fa-chevron-right"></span></a></li>
			         <li><a  href="${contextPath}/scrap/printScrapAll.do?compId=${user.id}">스크랩 리스트<span class="fa fa-chevron-right"></span></a></li>
			         <li><a  href="${contextPath }/startuppage/manu_estilist.do?compId=${user.id}">견적 관리<span class="fa fa-chevron-right"></span></a></li>
			         <li><a  href="${contextPath }/startuppage/consultinglist.do?compId=${user.id}">컨설팅 관리<span class="fa fa-chevron-right"></span></a></li>
	         	</c:if>
	         	<c:if test="${userType eq 'manu' }">
	         		 <li><a href="${contextPath}/manufac/manufacSelectForm.do?id=${user.id}">내 정보 관리 <span class="fa fa-chevron-right"></span></a></li>
			         <li><a  href="${contextPath }/manufacpage/estilist.do?manuId=${user.id}">견적 관리<span class="fa fa-chevron-right"></span></a></li>
	         	</c:if>
	         	<c:if test="${userType eq 'expert' }">
	         		 <li><a href="${contextPath}/expert/expertSelectForm.do?id=${user.id}">내 정보 관리 <span class="fa fa-chevron-right"></span></a></li>
			         <li><a  href="${contextPath }/expertpage/consulting.do?expId=${user.id}">컨설팅 관리<span class="fa fa-chevron-right"></span></a></li>
	         	</c:if>
	         </ul>
	       </div>
	     </div>
    </div>
    <!-- side bar -->
    
  

	  <!-- loader -->
	  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>
	
	
	  <script>
		var scrollper = function getCurrentScrollPercentage(){
			return (window.scrollY + window.innerHeight) / document.body.clientHeight * 100
			};
		
		var updown = document.querySelector("#sidebar");
		window.addEventListener("scroll",function(event){
			console.log(window.scrollY)
			if(window.scrollY >= 250){
				updown.style.top= 0
				updown.style.position = "fixed"
			}
			
			if(window.scrollY <=250){
				updown.style.top = "800px"
				updown.style.position = "absolute"
			}
			  /*if(scrollper()>= 50){
		    	updown.style.position = "fixed";
			    updown.style.top = "0px";
			    
			  }else{
				  updown.style.position = "absolute";
				  updown.style.top = "1000px"
			  }
			  console.log(updown.style)*/
		});
		
		
	  </script>
  </body>
</html>