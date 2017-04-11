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
                <h3>게시글 등록</h3>
            </div>
          
            <div class="table-responsive">
                <div class="well">
                    <form action="${pageContext.request.contextPath}/article/regist.do" 
                          class="bs-example form-horizontal" method="POST">
                        <fieldset>
                            <div class="form-group">
                            	<input type="hidden" name="boardId" value="${boardDetail.boardId}">
                                <label class="col-lg-2 control-label">제목</label>

                                <div class="col-lg-10">
                                    <input type="text" name="title" class="form-control">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-lg-2 control-label">내용</label>

                                <div class="col-lg-10">
                                    <textarea class="form-control" name="contents" rows="3" id="textArea"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-lg-10 col-lg-offset-2">
                                    <button type="submit" class="btn btn-primary">확인</button>
                                    <button type="reset" class="btn btn-default">취소</button>
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