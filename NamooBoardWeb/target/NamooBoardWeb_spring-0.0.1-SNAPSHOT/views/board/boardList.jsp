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
                    <h2>게시판 관리</h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">홈</a></li>
                    <li><a href="#">게시판 관리</a></li>
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
                    <h4>게시판 관리</h4>
                </div>
                <div>
                	<c:choose>
                		<c:when test="${empty boards}">
                    		<a class="list-group-item hidden-xs">개설된 게시판이 없습니다.</a>
                		</c:when>
                		<c:otherwise>
                			<c:forEach var="board" items="${boards}">
			                    <a href="${pageContext.request.contextPath}/board/modify.do?boardId=${board.boardId}" class="list-group-item hidden-xs">${board.name}</a>
                			</c:forEach>
                		</c:otherwise>
                	</c:choose>
                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-xs-6 col-sm-12 col-md-6 col-lg-6 text-left">
                            <a class="btn btn-link btn-sm btn-block" 
                               href="${pageContext.request.contextPath}/board/regist.do">신규게시판 개설</a>
                        </div>
                        <div class="col-xs-6 col-sm-12 col-md-6 col-lg-6 text-left">
                            <a class="btn btn-link btn-sm btn-block" href="#">전체 메일발송</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-sm-9 col-lg-9">
            <div>
                <h5>신규게시판 개설을 클릭해주세요.</h5>
            </div>
        </div>

    </div>

<!-- Footer ========================================================================================== -->
 <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>