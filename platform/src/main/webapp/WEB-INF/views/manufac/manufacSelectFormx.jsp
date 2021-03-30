<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- 우편주소 받는거 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
<script>
function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           
           document.getElementById('manuAddr').value = fullRoadAddr;
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       }
    }).open();
}
</script>
<head>
<style>
* {box-sizing: border-box}

/* Add padding to containers */
.container {
  padding: 16px;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit/register button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity:1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

body > form > div:nth-child(1){
	width : 40%;
	margin : 0 auto;
	
}

body > form > div.container.signin{
	width : 40%;
	margin : 0 auto;
}
#btnSignup{
	width : 100px;
	height : 40px;
}
#btnCancel{
	width : 100px;
	height : 40px;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
<meta charset="UTF-8">
<title>제조업체 등록창</title>
</head>
<body>
<form  method="post" action="${contextPath}/manufac/updatemanufac.do" enctype="multipart/form-data">
  <div class="container">
    <h1>제조업체 등록 신청서</h1>
    <p>Application for registration of experts.</p>
    <hr>

    <label for="email"><b>아이디</b></label>
    <input type="text" name="id" value="${manufacVO.id}" readonly><br>

    <input type="hidden" name="pwd" value="${manufacVO.pwd}" readonly><br>

    <label for="psw-repeat"><b>회사 이름</b></label>
    <input type="text" name="manuName" value="${manufacVO.manuName}" readonly><br>

    <label for="psw-repeat"><b>전문가 이름</b></label>
    <input type="text" name="manuCeoName" value="${manufacVO.manuCeoName}" readonly><br>
   
	<label for="email"><b>이메일</b></label>
    <input type="text" name="manuEmail" value="${manufacVO.manuEmail}" readonly><br>

    <label for="psw"><b>사업자 번호</b></label>
    <input type="text" name="manuBizNo" value="${manufacVO.manuBizNo}" readonly><br>

    <label for="psw"><b>사업자 번호</b></label>
    <input type="text" name="manuBizType" value="${manufacVO.manuBizType}" readonly><br>
    
    <label for="psw"><b>회사 주소</b></label>
    <input class="form-control"  value="${manufacVO.manuAddr}" name="manuAddr"  readonly ><br>

    <label for="psw-repeat"><b>상세 주소</b></label>
    <input class="form-control"  value="${manufacVO.manuDetailAddr}" name="manuDetailAddr"  readonly /><br>
   
	<label for="email"><b>전화번호</b></label>
    <input type="text" name="manuTel" value="${manufacVO.manuTel}" readonly><br>

	<label for="email"><b>경력</b></label>
    <input type="text" name="manuStart" value="${manufacVO.manuStart}" readonly><br>

    <label for="email"><b>최소 발주 금액</b></label>
    <input type="text" name="productPrice" value="${manufacVO.productPrice}" readonly/><p>
    
	<label for="email"><b>회사사진</b></label>
	<img src="${contextPath}/download.do?id=${manufacVO.id}&imageFileName=${manufacVO.manuImg}" style="height:220px; width:150px;" id="imgPreview" /><br><br><br><br>
	
			
    <label for="psw"><b>세부사항</b></label><br>
    <input type="hidden" name="manuAuth" value="o" />
   <textarea rows="10px" cols="100px" name="manuDetail" readonly >${manufacVO.manuDetail}</textarea><br>

  </div>

  <div class="container signin" style="background:white;">
    		<button type="submit" class="btn btn-sm btn-primary" id="btnSignup">등록</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnCancel" onclick="history.go(-1);">취소</button>  
  </div>
  
  </form>                  	
</body>
</html>