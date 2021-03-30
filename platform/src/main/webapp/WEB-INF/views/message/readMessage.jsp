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
<meta charset="UTF-8">
<title>쪽지보기</title>
</head>
<body>
	<div class="content" align="center">
        <div class="col-sm-8 border">
            <form>
                <div class="form-inline mt-2">
                    <label class="mr-2">받은사람</label>
                    <input type="text" class="form-control mr-5" value="${message.sendId}" readonly>
                    <label class="mr-2">보낸사람</label>
                    <input type="text" class="form-control mr-5" value="${message.receiveId}" readonly>
                    <label class="mr-2">받은날짜</label>
                    <input type="text" class="form-control" value="${message.writeDate}" readonly>
                </div>
                <div class="form-group">
                    <label class="float-left">쪽지내용</label>
                    <textarea class="form-control" cols="20" rows="15" readonly>${message.content}</textarea>
                </div>
            </form>
            <div class="mb-2">
               	<c:if test="${member.id==message.receiveId}">
                    <button class="btn btn-info" data-toggle="modal" data-target="#ReplyPop">답장하기</button>                		
               	</c:if>
            </div>
        </div>
    </div>
    <div class="modal fade" id="ReplyPop">
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
	                        <label for="inputreceiveId">수신자</label>
	                        <input type="text" name="receiveId" class="form-control" id="inputreceiveId" value="${message.sendId}" readonly>
	                    </div>
	                    <div class="form-group col-sm-10">
	                        <label for="InputContent">내용</label>
	                        <textarea class="form-control" name="content" id="InputContent" rows="5" cols="10"></textarea>
	                    </div>
	                    <button type="submit" class="btn btn-primary">전송</button>
	                    <button type="reset" class="btn btn-warning">다시입력</button>
	                    <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
	                </form>
		      	</div>
            </div>
        </div>
    </div>  
</body>
</html>