<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script src = "${contextPath}/ckeditor/ckeditor.js"></script>
<script type="text/javascript">
	function noticeCheck(){
		var writeForm = document.writeForm;
		var ckeditor = CKEDITOR.instances['description'];
		console.log(ckeditor.getData());
		if(writeForm.title.value==""){
			alert("제목을 입력하세요");
			writeForm.title.focus();
			return false;
		}
		if(ckeditor.getData()==""){
			alert("내용을 입력하세요");
			writeForm.content.focus();
			return false;
		}
	}
</script>
<meta charset="UTF-8">
<title>공지사항 작성</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-10">
		<c:if test="${notice == null}">
		</c:if>
           <form name="writeForm" class="py-4" method="post" action="${contextPath}/notice/writeNotice.do" onsubmit="return noticeCheck()">
               <table class="table">
                   <h2>공지사항 작성</h2>
                   <tr class="col-sm-12">
                       <td align="center">작성자</td>
                       <td><input name="writer" id="writer" type="text" class="form-control" value="관리자" readonly></td>
                   </tr>
                   <tr class="col-sm-12">
                       <td align="center">제목</td>
                       <td><input name="title" id="title" type="text" class="form-control"></td>
                   </tr>
                   <tr class="col-sm-12">
                       <td align="center">내용</td>
                       <td>
	                   <textarea id = "description" class="form-group" name="content" rows = "15" cols = "100"></textarea>
                       <script>
                       var id='${member.id}';
					   //id가 description인 태그에 ckeditor를 적용시킴
					   CKEDITOR.replace("description",{
						   filebrowserImageUploadUrl  : "${contextPath}/imageUpload.do?id="+id //이미지 업로드 기능을 추가하기위한 코드
					   });
					   </script>
                       </td>
                   </tr>
				  <tr>
				  	<td></td>
				  	<td></td>
				  </tr>
               </table>
	           <button type="submit" class="btn btn-primary">글쓰기</button>               
               <a class="btn btn-secondary" href="${contextPath}/notice/noticeList.do">목록</a>
           </form>
        </div>
	</div>
</body>
</html>