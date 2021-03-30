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
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="utf-8">
  </head>
  <body>
	<section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
          <div class="col-lg-9 ftco-animate">
					<div class="row con">
					<c:forEach var = "manufac" items = "${manufacList}">
						<!--한칸-->
		    			<div class="col-md-4 d-flex">
		    				<div class="book-wrap">
		    					<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath}/download.do?id=${manufac.id}&imageFileName=${manufac.manuImg});">
		    						<div class="in-text">
		    						
		    							<a href="${contextPath}/scrap/scrapManu.do?manuId=${manufac.id}&compId=${member.id}" class="icon d-flex align-items-center justify-content-center scrapClass" data-toggle="tooltip" data-placement="left" title="Scrap">
		    								<span id="${manufac.id}" class="flaticon-heart-1"></span>
		    							</a>
		    							
		    							
		    							<a href="${contextPath}/manufacSearch/viewManufac.do?id=${manufac.id}" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">
		    								<span class="flaticon-search"></span>
		    							</a>
		    						</div>
		    					</div>
		    					<div class="text px-4 py-3 w-100">
		    						<p class="mb-2"><span class="price">${manufac.productPrice} </span></p>
		    						<h2><a href="${contextPath}/manufacSearch/viewManufac.do?id=${manufac.id}"> ${manufac.manuName}</a></h2>
		    						<p> ${manufac.manuAddr}</p>
		    					</div>
		    				</div>
		    			</div>
						<!--한칸-->
					</c:forEach>
		    		
	    		<div class="row mt-5">
	          		<div class="col text-center">
	            		<div class="block-27">
	              			<ul>
	                 			<c:if test="${pageVO.startPage != 1}">
	                   				<li><a href="${contextPath}/manufacSearch/allManufac.do?nowPage=${pageVO.startPage -1}&cntPerPage=${pageVO.cntPerPage}">&lt;</a></li>
	               				</c:if>
	               				<c:forEach begin = "${pageVO.startPage}" end = "${pageVO.endPage}" var="idx">
		                  			<c:choose>
			                  			<c:when test="${idx == pageVO.nowPage }">
			                   				<li class="active"><span> ${idx} </span></li>
			                   			</c:when>
			                   			<c:when test="${idx != pageVO.nowPage}">
			                   				<li><a href="${contextPath}/manufacSearch/allManufac.do?nowPage=${idx}&cntPerPage=${pageVO.cntPerPage}"> ${idx} </a></li>
			                  			</c:when>
		                     		</c:choose>
	                			</c:forEach>
	                			<c:if test="${pageVO.endPage != pageVO.lastPage }">
		                   			<li><a href="${contextPath }/manufacSearch/allManufac.do?nowPage=${pageVO.endPage + 1}&cntPerPage=${pageVO.cntPerPage}">&gt;</a></li>
	                			</c:if>
	              			</ul>
	            		</div>
	          		</div>
	        	</div>
        	</div>
          </div> <!-- .col-md-8 -->

          <div class="col-lg-3 sidebar pl-lg-3 ftco-animate">
            <div class="sidebar-box">
              <form action="#" class="search-form">
              </form>
          </div>
          <div id="sidebar" class="sidebar-box ftco-animate">
            <div class="categories">
              <!-- <h5>업종별 검색</h5> -->
              <select id="manufacType" class="custom-select" style="width:75%">
                <option value="box">업종</option>
                <option value="도서">도서</option>
                <option value="가전">가전</option>
                <option value="홈인테리어">홈인테리어</option>
                <option value="패션의류">패션의류</option>
                <option value="기타">기타</option>
              </select>
              <button id="serchByTypebtn" class="btn btn-primary search">검색</button>
              <!-- id기준으로 자바스크립트에서 button선택 하여 onClick메서드 이용하여 ajax작동 -->
              <hr>
              <!-- <h5>지역별 검색</h5> -->
              <select id="manufacLoc" class="custom-select" style="width:75%">
                <option value="box">지역</option>
                <option value="서울">서울</option>
                <option value="부산">부산</option>
                <option value="대구">대구</option>
                <option value="인천">인천</option>
                <option value="광주">광주</option>
                <option value="대전">대전</option>
                <option value="경기">경기도</option>
                <option value="강원">강원도</option>
                <option value="경북">경상북도</option>
                <option value="경남">경상남도</option>
                <option value="전북">전라북도</option>
                <option value="전남">전라남도</option>
                <option value="충북">충청북도</option>
                <option value="충남">충청남도</option>
                <option value="세종">세종특별자치시</option>
              </select>
              <button id="serchByLocbtn" class="btn btn-primary search">검색</button>
              <hr>
              <!-- <h5>최소 발주 금액</h5> -->
			  <label for="최소발주금액">최소 발주 금액</label><br>
			  <div style="width:80%">
              <input type="range" id="manufacPrice" class="form-control-range" id="formControlRange" min="100" max="1000" value="90" step="10">
              <div class="changeRange" style ="width:80%; height:50px;">
              	100만원
              </div>
              <button style="float:left" id="serchByPricebtn" class="btn btn-primary search">검색</button>
              </div>
            </div>
          </div>
        </div>
      </div>
     </div>
   </section> <!-- .section -->
  <!-- loader -->
  <script>
	  var serchArray = document.querySelectorAll(".search");
	  var changeHtml ="";
	  console.log(serchArray)
	  var rangebox = document.querySelector(".form-control-range")
	  var changeRange = document.querySelector(".changeRange");
	  
	  var scrapArray = document.querySelectorAll(".scrapClass")
	  console.log(scrapArray)
	  
	  for(var i = 0 ; i<scrapArray.length; i++){
			
			scrapArray[i].addEventListener("click",function(e){
				console.log(e.target.id)
				var manuId = e.target.id
				$.ajax({
	          	url:"${contextPath}/scrap/scrapManu.do",
	          	type:"GET",
	          	data:{"id":manuId},
	          	success:function(data){
	          		console.log("success")
	          	}
	          });
			})
		}
        
        
        rangebox.addEventListener("change",function(e){
        	console.log(e.target.value);
        	console.log(changeRange);
        	changeRange.innerText = e.target.value+"만원";
        })
        for(var i = 0 ; i<serchArray.length; i++){
            serchArray[i].addEventListener("click",function(e){
                var target = e.target.id
                var select = "";
                
                if(target === "serchByTypebtn"){
                    select = document.querySelector("#manufacType").value
                    console.log(select)
                    changeHtml ="";
                    if(select != "box"){
	                    typeAjax(select);
                    }else{
                    	window.location.reload(true);
                    }
                }else if(target === "serchByLocbtn"){
                    select = document.querySelector("#manufacLoc").value
                    console.log(select)
                    changeHtml ="";
                    if(select != "box"){
	                    locAjax(select);
                    }else{
                    	window.location.reload(true);
                    }
                }else if(target === "serchByPricebtn"){
                    select = document.querySelector("#manufacPrice").value
                    console.log(select)
                    changeHtml ="";
                    priceAjax(select);
                }
            })
        }
		function typeAjax(select){
			$.ajax({
            	url:"${contextPath}/manufacSearch/serchByManuType",
            	type:"GET",
            	data:{"manuType":select},
            	dataType:"json",
            	success:function(data){
            		if(Object.keys(data).length == 0){
            			alert("해당 데이터가 없습니다.")
            		}
            		for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manufac = data[i];
                		console.log(manufac);
                		
          				fixHtml(manufac);
           			}
            	}
            });
		}
		
		function locAjax(select){
			console.log(typeof(select) + " " +select)
			$.ajax({
                url:"${contextPath}/manufacSearch/serchBymanufacLoc.do?loc=" + select,
                type:"GET",
                success:function(data){
                	if(Object.keys(data).length == 0){
            			alert("해당 데이터가 없습니다.")
            		}
                	for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manufac = data[i];
                		console.log(manufac);
          				fixHtml(manufac);
           			}
                }
            });
		}
		
		function priceAjax(select){
			$.ajax({
                url:"${contextPath}/manufacSearch/serchByPrice.do",
                type:"GET",
                data:{"price":select},
                success:function(data){
                	for(var i = 0 ; i<Object.keys(data).length; i++){
                		var manufac = data[i];
                		console.log(manufac);
          				fixHtml(manufac);
                    }
                }
            });
		}
		
		
		
		function fixHtml(manufac){
				changeHtml += '<div class="col-md-4 d-flex">'        				
				changeHtml += 	'<div class="book-wrap">'
				changeHtml +=		'<div class="img d-flex justify-content-end w-100" style="background-image: url(${contextPath}/resources/pltImage/' + manufac.id + '/' + manufac.img + ');">'
				changeHtml +=			'<div class="in-text">'
				changeHtml +=				'<a href="${contextPath}/scrap/scrapManu.do?manuId='+manufac.id + '&compId='+ compId +'" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Add to Wishlist">'
				changeHtml +=						'<span class="flaticon-heart-1"></span>'
				changeHtml +=				'</a>'
				changeHtml +=				'<a href="${contextPath}/manufacSearch/viewManufac.do?id=' + manufac.id +  '" class="icon d-flex align-items-center justify-content-center" data-toggle="tooltip" data-placement="left" title="Quick View">'
				changeHtml +=					'<span class="flaticon-search"></span>'
				changeHtml +=				'</a>'
				changeHtml +=			'</div>'
				changeHtml +=		'</div>'
				changeHtml +=		'<div class="text px-4 py-3 w-100">'
				changeHtml +=			'<p class="mb-2"><span class="price">' +manufac.price  + '</span></p>'
				changeHtml +=			"<h2><a href=${contextPath}/manufacSearch/viewManufac.do?id="+ manufac.id +">"+manufac.name+"</a></h2>"
				changeHtml +=			'<p> ' + manufac.addr + '</p>'
				changeHtml +=		'</div>'
				changeHtml +=	'</div>'
				changeHtml +='</div>'
			
  				console.log(changeHtml);
				$(".con").html(changeHtml);
		}
  </script>
    
  </body>
</html>