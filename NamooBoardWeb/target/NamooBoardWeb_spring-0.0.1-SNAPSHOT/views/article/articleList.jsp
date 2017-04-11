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

</head>
<body>

<!-- Main Navigation ================================================================================= -->
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
            
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <colgroup>
                        <col width="100"/>
                        <col width="*"/>
                        <col width="120"/>
                        <col width="70"/>
                        <col width="50"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th class="text-center">번호</th>
                        <th class="text-center">제목</th>
                        <th class="text-center">작성일</th>
                        <th class="text-center">작성자</th>
                        <th class="text-center">조회</th>
                    </tr>
                    </thead>
                    <tbody>
                    	<c:choose>
                    		<c:when test="${empty boardDetail.articles}">
		                        <tr>
		                            <th colspan="5" class="text-center">게시물이 존재하지 않습니다.</th>
		                        </tr>
                    		</c:when>
                    		<c:otherwise>
                    			<c:forEach var="article" items="${boardDetail.articles}">
			                        <tr>
			                            <td class="text-center">${article.articleId}</td>
			                            <td>
			                            	<a href="${pageContext.request.contextPath}/article/find.do?articleId=${article.articleId}">${article.title}</a>
			                            </td>
			                            <td class="text-center">
			                            	<fmt:formatDate value="${article.regDate}" pattern="yyyy-MM-dd"/>
			                            </td>
			                            <td class="text-center">${article.authorName}</td>
			                            <td class="text-center">110</td>
			                        </tr>
		                        </c:forEach>
                    		</c:otherwise>
                    	</c:choose>
                    </tbody>
                </table>
            </div>

            <div class="text-right">
                <a href="${pageContext.request.contextPath}/article/regist.do?boardId=${boardDetail.boardId}">
                	<button type="button" class="btn btn btn-warning">등록</button>
                </a>
            </div>
        </div>
    </div>

<!-- Footer ========================================================================================== -->
<%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>