<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:set var="expertVO" value="${expMap.expertVO}" />
<c:set var="imageFileList" value="${expMap.imageFileList}" />
<!DOCTYPE html>
<html>
<head>
<style>
.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  
}
#use1 {
	width : 230px; 
	height : 20px;
	line-height : 3px;
}

span.price {
  float: right;
  color: grey;
}
#btnSignup{
	width : 120px;
	height : 50px;
	margin : 0 auto;
}
#btnCancel{
	width : 120px;
	height : 50px;
	margin : 0 auto; 
}


/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (and change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
  
 body > div > div > div > form > div > div:nth-child(2) > textarea{
 	margin-left : 5px;
 	padding-left: 10px; 
 }
}
</style>
<meta charset="UTF-8">
<title>전문가 수정창</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<body>
<div class="row">
  <div class="col-75">
    <div class="container" style=" height:980px; margin-bottom:200px; ">
      <form  method="post" action="${contextPath}/expert/updateexpert.do" enctype="multipart/form-data">

        <div class="row">
          <div class="col-50">
            <h3>전문가 수정창</h3>
            <label for="fname"><i class="fa fa-user"></i> 아이디</label>
            <input type="text" name="id" value="${expertVO.id}" readonly><br>
            <label for="email"><i class="fa fa-envelope"></i> 이메일</label>
            <input type="text" name="expEmail" value="${expertVO.expEmail}"><br>
            <label for="adr"><i class="fa fa-address-card-o"></i> 이름</label>
            <input type="text" name="expName" value="${expertVO.expName}"><br>

            <div class="row">
              <div class="col-50">
                <label for="state">State</label>
               <input type="hidden" name="expImg" value="${imageFileList[1].imageFileName}"><br>
			<img src="${contextPath}/download.do?id=${expertVO.id}&imageFileName=${imageFileList[1].imageFileName}" id="imgPreview" style="height:220px; width:150px;"/><br>
              </div>
              <div class="col-50">
                <input type="button" class="btn btn-warning" id="use1" onClick="enable();" value="사진을 수정하려면 누르세요"><br>
			<input type="file" name="newExpImg" id="i_newExpImg" onchange="readImgURL(this);"  disabled/><br>
              </div>
            </div>
          </div>

          <div class="col-50">
          <h3>         　</h3>
            <label for="cname">비밀번호</label>
            <input type="password" name="pwd" placeholder="password" style="width : 530px; height:45px; margin-bottom:13px;"><br>
            
            <label for="ccnum">전화번호</label>
            <input type="text" name="expTel" value="${expertVO.expTel}"><br>

            <div class="row">
              <div class="col-50">
                <label for="expyear">업종</label>
               <input type="text" name="expBizField" value="${expertVO.expBizField}" readonly><br>
              </div>
              <div class="col-50">
                <label for="cvv">경력</label>
                <input type="text" name="expCareer" value="${expertVO.expCareer}"><br>
              </div>
            </div>
             <label for="cname">상세정보</label>
            <textarea cols=75px; rows=10px; name="expDetail" >${expertVO.expDetail}</textarea><br>
          </div>
        </div>
        <input type="hidden" name="expAuth" value="${expertVO.expAuth}" >
        <div style="width: 50%; float: left; padding: 60px;">
      		    <button type="submit" class="btn btn-sm btn-primary" id="btnSignup">수정완료</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnCancel" onclick="history.go(-1);">취소</button>
				<input type="button" value="탈퇴" onclick="delete_button();" class="btn btn-danger btn-xs">
                
		</div>
      </form>
    </div>
  </div>
<script type="text/javascript">


function delete_button(){

if (confirm("정말 삭제하시겠습니까??") == true){    //확인

    location.href="${contextPath}/expert/deleteexpert.do?id=${expertVO.id}"

}else{   //취소

    return;

}

}


</script>
  
</div>
<style>
#content > div > div > div > form > div:nth-child(3) > a{
	width:245px;
}
</style>
		
			
			
			
			
			
			
			
			
			
    <script type="text/javascript">
  
	function readCertifURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload=function(e){
				$('#certifPreview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function readImgURL(input){
		if(input.files && input.files[0]){
			var reader = new FileReader();
			reader.onload=function(e){
				$('#imgPreview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	function enable(){
		var enable2 = document.getElementById('i_newExpImg');
		enable2.disabled=false;
		
	}
	</script>      	
</body>
</html>