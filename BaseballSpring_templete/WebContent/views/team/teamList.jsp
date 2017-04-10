<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

    <title>BaseballTeam</title>
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
                    <h2>야구팀 목록</h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">홈</a></li>
                    <li class="active">야구팀 목록</li>
                </ol>
            </div>
        </div>
    </div>
</header>

<!-- Container ======================================================================================= -->
<div class="container">
    <div class="row">
       
        <div class="col-sm-12 col-lg-12">
            <div>
                <h3>야구팀 목록</h3>
            </div>
            
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <colgroup>
                        <col width="100"/>
                        <col width="*"/>
                        <col width="200"/>
                        <col width="200"/>
                        <col width="300"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th class="text-center">번호</th>
                        <th class="text-center">팀명</th>
                        <th class="text-center">연고지</th>
                        <th class="text-center">감독</th>
                        <th class="text-center">홈구장</th>
                    </tr>
                    </thead>
                    <tbody>
                    	<c:if test="${empty teams}">
	                        <tr>
	                            <th colspan="5" class="text-center">구단정보가 존재하지 않습니다.</th>
	                        </tr>
                        </c:if>
                        <c:forEach var="team" items="${teams}"
                                   varStatus="sts">
	                        <tr>
	                            <td class="text-center">${sts.count}</td>
	                            <td><a href="${pageContext.request.contextPath}/team/find.do?teamId=${team.teamId}">${team.name}</a></td>
	                            <td class="text-center">${team.region}</td>
	                            <td class="text-center">${team.manager}</td>
	                            <td>${team.stadium}</td>
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
        </div>
    </div>

<!-- Footer ========================================================================================== -->
<%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>