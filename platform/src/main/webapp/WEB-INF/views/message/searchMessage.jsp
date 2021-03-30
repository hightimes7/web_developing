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
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#allCheck").click(function(){
			if($("#allCheck").prop("checked")){
				$("input[type=checkbox]").prop("checked", true);
			}else{
				$("input[type=checkbox]").prop("checked", false);
			}
		});
	});
	
	function deleteMessage(){
		var cnt = $("input[name='delChkBoxRow']:checked").length;
		var arr = new Array();
		$("input[name='delChkBoxRow']:checked").each(function(){
			arr.push($(this).attr('id'));
		});
		if(cnt == 0){
			alert("선택된 쪽지가 없습니다.");
		}else{
			$.ajax({
				url:"${contextPath}/message/deleteMessage.do",
				type:"POST",
				data:"arr="+arr,
				success:function(data){
					alert("정상적으로 삭제되었습니다.")
					location.href="${contextPath}/message/messageList.do?id=${member.id}";
				},
				error:function(data){
					alert("오류가 발생했습니다.")
					location.href="${contextPath}/message/messageList.do?id=${member.id}";
				}
			});
		}
	}
	
	/*function searchMessage(){
		$.ajax({
			url:"${contextPath}/message/searchMessage.do",
			type:"GET",
			data:$('#search').serialize(),
			success:function(data){
				var html="";
				if(data.length>0){
					for(i=0; i<data.length; i++){
						
					}
				}
			}
		});
	}*/
</script>
<style>
	#messageTable{
		table-layout: fixed;
	}
	#messageContent{
		max-width: 55%;
		white-space: nowrap;
		overflow: hidden;
		text-overflow: ellipsis;
	}
</style>
<meta charset="UTF-8">
<title>쪽지함</title>
</head>
<body>
	<div class="container" align="center">
		<div class="col-sm-8">
			<div class="form-inline mb-1">
				<input type="button" class="btn btn-danger" onClick="deleteMessage()" value="삭제">
				<form class="ml-auto" action="${contextPath}/message/searchMessage.do">
				<input type="hidden" name="id" value="${member.id}">
				    <select class="form-control" name="catetory">
                        <option>모두</option>
                        <option>받은쪽지</option>
                        <option>보낸쪽지</option>
				    </select>
				    <input class="form-control col-sm-10" name="keyword" type="text" placeholder="검색">
				    <!-- <button type="button" class="btn btn-primary" id="search" onClick="searchMessage()">찾기</button> -->
				    <input type="submit" class="btn btn-primary" id="search" value="검색">
				</form>
			</div>
			<table class="table table-striped table-hover table-sm table-bordered" id="messageTable">
				<thead align="center">
                    <tr class="table-active">
                    	<th style="width:5%"><input type="checkbox" id="allCheck"></th>
                        <th style="width:10%">발신자</th>
                        <th style="width:10%">수신자</th>
                        <th style="width:55%">내용</th>
                        <th style="width:20%">보낸날짜</th>
                    </tr>
                </thead>
                <tbody id="messageBody">
                	<c:choose>
                    	<c:when test="${messageList.isEmpty()}">
                    		<tr align="center">
	                    		<td colspan="5">
	                    			<p align="center">
										<b><span style="font-size:9pt;">쪽지가 없습니다.</span></b>
									</p>
	                    		</td>
                    		</tr>
                    	</c:when>
                    	<c:when test="${messageList != null}">
                    		<c:forEach var="message" items="${messageList}" varStatus="messageNum">
                    			<c:if test="${member.id==message.sendId && message.seAva == 0}"> <!-- 보낸쪽지 -->
                   					<tr align="center">
                   						<td>
                   							<input type="checkbox" name="delChkBoxRow" id="send${message.NO}">
                   						</td>
                    					<td style="width:10%">${message.sendId}</td>
                    					<td style="width:10%">${message.receiveId}</td>
                    					<c:if test="${message.seRead == 0}">
                    						<td class="text-right text-info bg-warning" id="messageContent">
                    							<a class="text-info" href="${contextPath}/message/readMessage.do?messageNO=send${message.NO}">${message.content}</a>
                    						</td>
                    					</c:if>
                    					<c:if test="${message.seRead == 1}">
                    						<td class="text-right text-muted bg-warning" id="messageContent">
                    							<a class="text-muted" href="${contextPath}/message/readMessage.do?messageNO=send${message.NO}">${message.content}</a>
                    						</td>
                    					</c:if>
                    					<td style="width:20%">${message.writeDate}</td>
                   					</tr>
                    			</c:if>
                    			<c:if test="${member.id==message.receiveId && message.reAva == 0}"> <!-- 받은쪽지 -->
                    				<tr align="center">
                    					<td>
                   							<input type="checkbox" name="delChkBoxRow" id="receive${message.NO}">
                   						</td>
                    					<td style="width:10%">${message.sendId}</td>
                    					<td style="width:10%">${message.receiveId}</td>
                    					<c:if test="${message.reRead == 0}">
	                    					<td class="text-left text-info bg-light" id="messageContent">
	                    						<a class="text-info" href="${contextPath}/message/readMessage.do?messageNO=receive${message.NO}">${message.content}</a>
	                    					</td>
                    					</c:if>
                    					<c:if test="${message.reRead == 1}">
                    						<td class="text-left text-muted bg-light" id="messageContent">
	                    						<a class="text-muted" href="${contextPath}/message/readMessage.do?messageNO=receive${message.NO}">${message.content}</a>
	                    					</td>
                    					</c:if>
                    					<td style="width:20%">${message.writeDate}</td>
                   					</tr>
                    			</c:if>
							</c:forEach>
                    	</c:when>
                    </c:choose>
                </tbody>
			</table>
		</div>
	</div>
</body>
</html>