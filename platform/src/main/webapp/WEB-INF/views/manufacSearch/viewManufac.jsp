<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Publishing Company - Free Bootstrap 4 Template by Colorlib</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	var id='${member.id}';
	var manuId='${manufacVO.id}'
	console.log(id);
	console.log(manuId);
	
	$(function(){
		getProjectList();
		
	});
	
	function getProjectList(){
		$.ajax({
			url:"${contextPath}/manufacQnA/getManufacQnAList.do",
			data:{'manuId':manuId},
			type:"GET",
			success:function(data){
				console.log(data);
				var html="";
				if(data.length>0){
					for(i=0; i<data.length; i++){
						if(data[i].level == 1){
							html+="<div class='col-sm-6 border'>";
							html+="<input type='hidden' name='no' id='no' value='"+data[i].no+"'>";
							html+="<div class='form-inline text-center mb-2 mt-2'>";
							html+="<h5>"+data[i].id+"</h5><div class='ml-4'>";
							if(data[i].id == id){
								html+="<button class='btn btn-primary' onClick='mod_enable("+data[i].no+");'>수정</button>";
		                        html+="<button class='btn btn-warning' onClick='delPro("+data[i].no+");'>삭제</button>"	
							}
							if(data[i].manuId == id){
		                        html+="<button class='btn btn-danger' data-toggle='modal' data-target='#answer"+data[i].no+"'>답변</button>"								
							}
	                        html+="</div>"
	                        html+="<div class='ml-auto'>"+data[i].writeDate+"</div></div>"
	                        html+="<form><div class='form-group'>"
	                        html+="<input type='hidden' id='modify"+data[i].no+"' value='수정완료' class='btn btn-primary float-left mb-2' onClick='modPro("+data[i].no+");'>";
	                        html+="<input type='hidden' id='cancel"+data[i].no+"' value='취소' class='btn btn-danger float-left' onClick='backToList();'>";
	                        html+="<textarea class='form-control' id='area"+data[i].no+"'cols='20' rows='5' readonly>"+data[i].content+"</textarea>"
	                        html+="</div></form></div>"
	                        //답변 모달
	                        html+="<div class='modal fade' id='answer"+data[i].no+"'>";
	                        html+="<div class='modal-dialog'><div class='modal-content'><div class='modal-header'>";
	                        html+="<h4 class='modal-title'>답변하기</h4>";
	                        html+="<button type='button' class='close' data-dismiss='modal'>&times;<button></div>";
	                        html+="<form id='answerForm' action='${contextPath}/manufacQnA/addManufacQnAAnswer.do' method='POST'><div class='modal-body'>";
	                        html+="<input type='hidden' name='id' value='"+id+"'>";
	                        html+="<input type='hidden' name='manuId' value='"+manuId+"'>";
	                        html+="<input type='hidden' name='no' value='"+data[i].no+"'>";
	                        html+="<textarea class='form-control' cols='20' rows='5' name='content'></textarea></div>";
	                        html+="<div class='modal-footer'><button type='submit' class='btn btn-info'>등록</button>";
	                        html+="<button type='button' class='btn btn-danger' data-dismiss='modal'>닫기</button></div></form></div></div></div>";
						}else{
							html+="<div class='col-sm-6 pb-1 bg-secondary'>";
							html+="<div class='form-inline text-center mb-2'>";
							html+="<div class='form-inline'>"
							html+="<i class='material-icons'>subdirectory_arrow_right</i>"
							html+="<h5 class='mt-3'>"+data[i].id+"</h5></div>";
							html+="<div class='ml-4'>"
							if(data[i].id == id){
								html+="<button class='btn btn-primary' onClick='mod_enable("+data[i].no+");'>수정</button>";
		                        html+="<button class='btn btn-warning' onClick='delPro("+data[i].no+");'>삭제</button>"
							}
	                        html+="</div><div class='ml-auto'>"+data[i].writeDate+"</div></div>"
	                        html+="<form><div class='form-group'>"
	                        html+="<input type='hidden' id='modify"+data[i].no+"' value='수정완료' class='btn btn-primary float-left mb-2' onClick='modPro("+data[i].no+");'>";
	                        html+="<input type='hidden' id='cancel"+data[i].no+"' value='취소' class='btn btn-danger float-left' onClick='backToList();'>";
	                        html+="<textarea class='form-control' id='area"+data[i].no+"' cols='20' rows='5' readonly>"+data[i].content+"</textarea>"
	                        html+="</div></form></div>"
						}
					}
				}
				$("#manufacQnA").html(html);
			}
		});
	}
	
	function addQue(){
		$.ajax({
			url:"${contextPath}/manufacQnA/addManufacQnAQue.do",
			type:"POST",
			data:$('#queForm').serialize(),
			success:function(data){
				getProjectList();
			}
		});
	}
	
	function mod_enable(no){
		document.getElementById('area'+no).readOnly = false;
		var btn1 = document.getElementById('modify'+no);
		btn1.setAttribute('type', 'button');
		var btn2 = document.getElementById('cancel'+no);
		btn2.setAttribute('type', 'button');
	}
	
	function modPro(no){
		var content = document.getElementById('area'+no).value;
		$.ajax({
			url:"${contextPath}/manufacQnA/modManufacQnA.do",
			type:"POST",
			data:{'content':content, 'no':no},
			success:function(data){
				alert('수정 완료했습니다.');
				getProjectList();
			}
		});
	}
	
	function delPro(no){
		if(confirm("정말로 삭제하겠습니까?") != 0){
			$.ajax({
				url:"${contextPath}/manufacQnA/delManufacQnA.do",
				type:"POST",
				data:{'no':no},
				success:function(data){
					alert('정상적으로 삭제되었습니다.');
					getProjectList();
				}
			});			
		}else{
			getProjectList();
		}
	}
	
	function backToList(){
		location.href="${contextPath}/manufacSearch/viewManufac.do?id="+manuId
	}
	
</script>
    <meta charset="utf-8">
    
  </head>
  <body>
		
	<section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
          <div class="col-lg-8 ftco-animate" >
            <!--여기부터 본문 시작-->
            <div class="col-12" style="font-size: 0;">
              <div class="col-8" style="display: inline-block; vertical-align: middle;">
                <p>
                  <img src="${contextPath}/download.do?id=${manufacVO.id}&imageFileName=${manufacVO.manuImg}" alt="" class="img-fluid" width="500" height="350">
                </p>
              </div>
              <div style="display: inline-block; vertical-align: middle; font-size: 16px; width: 150px;">
                <ul style="list-style:none">
                  <li> ${manufacVO.manuName}</li>
                  <li> ${manufacVO.manuCeoName}</li>
                  <li> ${manufacVO.manuTel}</li>
                  <li> ${manufacVO.manuBizType}</li>
                </ul>
                <c:if test="${member.type=='startup' }">
	                <a href="${contextPath }/quotation/insertQuotationForm.do?manuId=${manufacVO.id}" class="btn btn-primary mb-3" style="width: 150px">견적요청</a>
	                <br>
                </c:if>
                <a href="${contextPath }/manufacSearch/allManufac.do" class="btn btn-primary mb-3" style="width: 150px">목록으로</a>
                <br>
                <c:if test="${member.type=='startup'}">
	                <a data-toggle="modal" href="#messageToManufac" class="btn btn-primary" style="width: 150px">쪽지 보내기</a>
                </c:if>
              </div>
            </div>
            <div style="float: left;">
              <br><br>
              <!--상단 본문 시작부-->
              <p>
                <h3>${manufacVO.manuName }</h3>
                <p> ${manufacVO.manuDetail }</p>
                <p> ${manufacVO.productPrice }</p>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis, eius mollitia suscipit, quisquam doloremque distinctio perferendis et doloribus unde architecto optio laboriosam porro adipisci sapiente officiis nemo accusamus ad praesentium? Esse minima nisi et. Dolore perferendis, enim praesentium omnis, iste doloremque quia officia optio deserunt molestiae voluptates soluta architecto tempora.
              </p>
              
              <!--여기까지 상단부-->
              <p>
                <img src="${contextPath }/resources/images/image_2.jpg" alt="" class="img-fluid">
              </p>
              <p> ${manufacVO.manuAddr} ${manufacVO.manuDetailAddr }</p>
             
              <p>Voluptas dolores dignissimos dolorum temporibus, autem aliquam ducimus at officia adipisci quasi nemo a perspiciatis provident magni laboriosam repudiandae iure iusto commodi debitis est blanditiis alias laborum sint dolore. Dolores, iure, reprehenderit. Error provident, pariatur cupiditate soluta doloremque aut ratione. Harum voluptates mollitia illo minus praesentium, rerum ipsa debitis, inventore?</p>
              <!--여기까지 본문-->
			    <div id="map" style="width: 80%; height:350px" class="${manufacVO.manuAddr}"></div>
            </div>
          </div> <!-- .col-md-8 -->
      	</div>
      </div>
    </section> <!-- .section -->
    <!--Qna설치-->
	<div class="container" align="center">
		<div class="form-row col-sm-6 border">
            <div>
                <h2>문의</h2>
            </div>
            <div class="ml-auto mt-1">
            	<c:if test="${member.type=='startup'}">
	                <button type="button" class="btn btn-info" data-toggle="modal" data-target="#question">질문하기</button>
            	</c:if>
            </div>
        </div>
        <div class="form-group" id="manufacQnA">
        
        </div>
	</div>
	<!-- 질문하기 모달 -->
    <div class="modal fade" id="question">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">질문하기</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
                <form id="queForm">
                    <div class="modal-body">
                    	<input type="hidden" name="id" value="${member.id}">
                    	<input type="hidden" name="manuId" value="${manufacVO.id}">
						<textarea class="form-control" cols="20" rows="5" name="content"></textarea>
                    </div>
                    <div class="modal-footer">
                    	<button type="button" class="btn btn-info" onClick="addQue()">등록</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
	<!-- message Modal -->
     <div class="modal fade" id="messageToManufac">
        <div class="modal-dialog">
            <div class="modal-content" align="center">
            	<!-- Modal Header -->
		        <div class="modal-header">
		        	<h4 class="modal-title">쪽지 보내기</h4>
		        	<button type="button" class="close" data-dismiss="modal">&times;</button>
		      	</div>
		      	<div class="modal-body">
	                <form class="py-4" method="post" action="${contextPath}/message/sendMessage.do">
	                	<input type="hidden" name="sendId" value="${member.id}"> 
	                    <div class="form-group col-sm-10">
	                        <label for="inputReceiveId">수신자</label>
	                        <input type="hidden" name="receiveId" value="${manufacVO.id}">
	                        <input type="text" name="manuName" class="form-control" id="inputReceiveId" value="${manufacVO.manuName}" readonly">
	                    </div>
	                    <div class="form-group col-sm-10">
	                        <label for="InputContent">내용</label>
	                        <textarea class="form-control" name="content" id="InputContent" rows="5" cols="10" placeholder="내용을 입력하세요."></textarea>
	                    </div>
	                    <button type="submit" class="btn btn-primary">전송</button>
	                    <button type="reset" class="btn btn-secondary">다시입력</button>
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	                </form>
		      	</div>
            </div>
        </div>
    </div>
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>

  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=5cb49ebebf3987887f76ee04385397f2&libraries=services"></script>
  	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		//마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(33.450701, 126.570667); 
		
		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});
		var loc = document.querySelector("#map").className
		console.log(loc)
		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);
		var geocoder = new kakao.maps.services.Geocoder();
		geocoder.addressSearch(loc,function(result,status){
		   if (status === kakao.maps.services.Status.OK) {

		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });

		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
		        });
		        infowindow.open(map, marker);

		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});
	
	</script>
  </body>
</html>