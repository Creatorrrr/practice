<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>나무소셜</title>
    <%@ include file="/views/layout/common.jsp" %>
</head>
<body>

<c:set var="thisPage" value="follower" />

<!-- Main Navigation ========================================================================================== -->
<%@ include file="/views/layout/mainNav.jsp" %>

<!-- Header ========================================================================================== -->
<%@ include file="/views/layout/header.jsp" %>

<!-- Container ======================================================================================= -->
<div class="container">
    <div class="row">

        <!-- ★★★ Contents -->
        <div class="col-lg-12">
            <div class="page-header2">
                <h3>팔로워 사용자 목록</h3>
            </div>

            <!-- ★★★ Tab Panel -->
            <div id="communityList" class="tab-content">
                <!-- ★★★ 전체회원 -->
                <div class="tab-pane fade active in" id="all">

                    <!-- ★★★ 검색조건 -->
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <form action="${ctx }/user/follower.do" method="post" class="form-search">
                                <div class="input-group">
                                    <input type="text" name="keyword" class="form-control" placeholder="회원명 또는 ID">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary">검색</button>
                                    </span>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- ★★★ 회원목록 -->
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th class="text-center">번호</th>
                                <th class="text-center">ID</th>
                                <th class="text-center">회원명</th>
                                <th class="text-center">이메일</th>
                            </tr>
                            </thead>
                            <tbody>
                            	<c:choose>
                            		<c:when test="${fn:length(users) == 0}">
                            			<tr><td colspan="5" class="text-center">나를 추가한 팔로워가 없습니다.</td></tr>
                            		</c:when>
                            		<c:otherwise>
                            			<c:forEach items="${users }" var="user" varStatus="status">
	                            			<tr>
	                            				<td class="text-center">${status.count }</td>
			                                    <td class="text-center">${user.id }</td>
			                                    <td class="text-center">${user.name }</td>
			                                    <td class="text-center">${user.email }</td>
			                                </tr>
                            			</c:forEach>
                            		</c:otherwise>
                            	</c:choose>
                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
    </div>

<!-- Footer ========================================================================================== -->
    <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>