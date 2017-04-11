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
                    <li><a href="#">게시판 관리</a></li>
                    <li><a>게시판명</a></li>
                    <li class="active">게시판 수정</li>
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
                <h3>게시판 수정</h3>
            </div>
           
            <div class="table-responsive">
                <div class="well">
                    <form action="${pageContext.request.contextPath}/board/modify.do"
                          class="form-horizontal" method="POST">
                        <fieldset>
                            <div class="form-group">
                                <label class="col-lg-2 control-label">게시판명</label>

                                <div class="col-lg-10">
                                    <input type="hidden" name="boardId" value="${boardDetail.boardId}">
                                    <input type="text" name="name" class="form-control" value="${boardDetail.name}">
                                </div>
                            </div>


                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">확인</button>
                                    <button type="reset" class="btn btn-default">취소</button>
                                    <a href="${pageContext.request.contextPath}/board/remove.do?boardId=${boardDetail.boardId}" class="btn btn-danger">삭제</a>
                                </div>
                            </div>

                        </fieldset>
                    </form>
                </div>

            </div>
        </div>
    </div>

<!-- Footer ========================================================================================== -->
 <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>