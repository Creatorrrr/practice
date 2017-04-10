<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>나무소셜</title>
    <%@ include file="/views/layout/common.jsp" %>
</head>
<body>

<c:set var="thisPage" value="messageList" />

<!-- Main Navigation ========================================================================================== -->
<%@ include file="/views/layout/mainNav.jsp" %>

<!-- Header ========================================================================================== -->
<%@ include file="/views/layout/header.jsp" %>

<!-- Container ======================================================================================= -->
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <!-- ★★★ Tab Menu -->
            <ul class="nav nav-tabs" style="margin-bottom: 15px;">
            	<c:choose>
            		<c:when test="${sender eq 'myMessage' }">
		                <li class="active"><a href="${ctx }/message/myMessage.do" data-toggle="tab">나의메시지</a></li>
		                <li><a href="${ctx }/message/newestMessage.do" data-toggle="tab">최신메시지</a></li>
            		</c:when>
            		<c:when test="${sender eq 'newestMessage' }">
		                <li><a href="${ctx }/message/myMessage.do" data-toggle="tab">나의메시지</a></li>
		                <li class="active"><a href="${ctx }/message/newestMessage.do" data-toggle="tab">최신메시지</a></li>
            		</c:when>
            	</c:choose>
            </ul>

            <!-- ★★★ Tab Panel -->
            <div id="communityList" class="tab-content">
                <!-- ★★★ 가입 커뮤니티 -->
                <div class="tab-pane fade active in" id="joined">
                    <div class="page-header">
                        <h3 id="container">오늘의 상태 업데이트</h3>
                        <form action="${ctx }/message/create.do" method="post" class="form-search">
                            <div class="input-group">
                        		<input type="text" name="contents" class="form-control" placeholder="내용을 입력하세요">
                                <span class="input-group-btn">
                                    <button class="btn btn-primary">등록</button>
                                </span>
                            </div>
                        </form>
                    </div>

                    <ul class="list-group">
                    	<c:forEach items="${messages }" var="message">
	                    	<li class="list-group-item">
	                            <span class="badge">${message.registDate }</span>
	                            <h4><a href="#">${message.writerId }</a></h4>
	                            <p>${message.contents }</p>
	                        </li>
                    	</c:forEach>
                    </ul>

                    <button type="button" class="btn btn-default btn-lg btn-block">메시지 목록 더보기</button>
                </div>
            </div>
        </div>
    </div>

<!-- Footer ========================================================================================== -->
    <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>