<!-- 
 * COPYRIGHT (c) Nextree Consulting 2015
 * This software is the proprietary of Nextree Consulting.  
 * 
 * @author <a href="mailto:eschoi@nextree.co.kr">Choi, Eunsun</a>
 * @since 2015. 1. 9.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

    <title>소셜보드</title>
    <%@ include file="/views/layout/common.jsp" %>
	
	<style type="text/css">
		.progressBox {
			display: none;
		}
	</style>
	
	<script>
		var registComment = function() {
			$.ajax({
				url:"${pageContext.request.contextPath}/comment/regist.ajax"
				,type:"post"
				,data:{articleId:$("#articleId").val(), comment:$("#comment").val()}
				,success:displayComment
				,error:errorCallback
			});
		};
		
		var removeComment = function(commentId) {
			$.ajax({
				url:"${pageContext.request.contextPath}/comment/remove.ajax"
				,type:"get"
				,data:{articleId:$("#articleId").val(), commentId:commentId}
				,success:displayComment
				,error:errorCallback
			});
		};
		
		var displayComment = function(resultData) {
			var commentHtml = "";
			$.each(resultData.comments, function(index, comment){
				commentHtml += '<table class="table" style="font-size:13px; padding:20px;">';
				commentHtml += '<tr>';
				commentHtml += '<td><strong>'+comment.authorName+'</strong></td>';
     			commentHtml += '<td class="text-right">'+comment.regDate;
     			commentHtml += '<a class="glyphicon glyphicon-trash" href="javascript:removeComment('+comment.commentId+');"></a>';
     			commentHtml += '</td></tr>';
     			commentHtml += '<tr><td colspan="2">';
     			commentHtml += '<p class="txt">'+comment.comment+'</p>';
     			commentHtml += '</td></tr></table>';
			});
			
			$("#commenArea").empty();
			$("#commenArea").append(commentHtml);
			$("#comment").val("");
		};
		
		var errorCallback = function() {
			alert("수행중 오류가 발생했습니다.");
		};
		
    	$(document).ajaxStart(function() {
    		$.blockUI({
    			message:$("#progress"),
    			css: { 
    		        border: "0px", 
    		        backgroundColor: "rgba(0,0,0,0)"
    		    }
    		});
    	});
    	
    	$(document).ajaxStop(function() {
    		$.unblockUI();
    	});
    	
	</script>
</head>
<body>
	
<!-- progress -->
<div id="progress" class="progressBox">
	<img src="${pageContext.request.contextPath}/resources/images/ajaxSpinner.gif">
</div>
	
<!-- Main Navigation ========================================================================================== -->
<%@ include file="/views/layout/menu.jsp" %>
<!-- Header ========================================================================================== -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="jumbotron">
                    <h2>게시판</h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">홈</a></li>
                    <li><a href="#">게시판</a></li>
                    <li class="active">${boardDetail.name}</li>
                </ol>
            </div>
        </div>
    </div>
</header>

<!-- Container ======================================================================================= -->


<div class="container">
    <div class="row">

        <div style="z-index:1020" class="col-xs-12 col-sm-3 col-md-3 col-lg-3">
            <div class="list-group panel panel-success">
                <div class="panel-heading list-group-item text-center hidden-xs">
                    <h4>게시판</h4>
                </div>
                <div>
                    <c:forEach var="board" items="${boards}">
                    	<a href="${pageContext.request.contextPath}/board/find.do?boardId=${board.boardId}"
	                       class="list-group-item hidden-xs">${board.name}</a>
                	</c:forEach>
                </div>
            </div>
        </div>

        <div class="col-sm-9 col-lg-9">
            <div>
                <h3>${boardDetail.name}</h3>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                   ${article.title}
                </div>
                <div class="panel-body">
                    <div class="post">
                        
                         <strong>${article.authorName}</strong>
                         &nbsp;<span class="text-muted">${article.regDate}</span>
                         &nbsp;<span class="text-muted">110 읽음</span>

                         <a href="${pageContext.request.contextPath}/article/modify.do?articleId=${article.articleId}&boardId=${article.boardId}" class="glyphicon glyphicon-cog pull-right" style="padding:10px">수정</a>
                         <a href="${pageContext.request.contextPath}/article/remove.do?articleId=${article.articleId}&boardId=${article.boardId}" class="glyphicon glyphicon-trash pull-right" style="padding:10px">삭제</a>
                    </div>
                    <br>

                    <p style="padding:20px">
                        ${article.contents}
                    </p>
                    <div id="commenArea">
                    <c:forEach var="comment" items="${article.comments}">
	                    <table class="table" style="font-size:13px; padding:20px;">
	                 		<tr>
	                 			<td>
	                 				<strong>${comment.authorName}</strong>
	                 			</td>
	                 			<td class="text-right">
	                 				${comment.regDate}
	                 				<a class="glyphicon glyphicon-trash"
	                 				   href="javascript:removeComment(${comment.commentId});"></a>
	                 			</td>
	                 		</tr>
	                 		<tr>
	                 			<td colspan="2">
	                 				<p class="txt">${comment.comment}</p>
	                 			</td>
	                 		</tr>
	                    </table>
                    </c:forEach>
                    </div>
                </div>
                <div class="panel-footer">
                	<div class="write_area">
                		<form onsubmit="registComment(); return false;">
                			<div>
                				<input type="hidden" id="articleId" value="${article.articleId}">
                				<textarea class="input_write_comment" id="comment" placeholder="댓글쓰기"></textarea>
                				<input type="submit" class="comment_submit" value="전송">
                			</div>
                		</form>
                	</div>
                </div>
            </div>

            <div class="text-center">
                <a href="${pageContext.request.contextPath}/board/find.do?boardId=${boardDetail.boardId}">
                    <button type="button" class="btn btn-default">목록</button>
                </a>
            </div>
        </div>
    </div>

    <!-- Footer ========================================================================================== -->
    <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>