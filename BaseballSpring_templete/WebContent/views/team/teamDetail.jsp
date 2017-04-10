<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

    <title>BaseballTeam</title>
    <%@ include file="/views/layout/common.jsp" %>
	
	<style>
		.feature {
		    display: block;
		    width: 100%;
		    margin: 0;
		}
		
		.blog-stripe .block-title {
		    background: black;
		    width: 100%;
		    color: white;
		    height: 100px;
		    padding-top: 20px;
		}
		
		.all-blogs .media {
		    margin-left: -40px;
		    padding-bottom: 20px;
		    border-bottom: 1px solid #CCCCCC;
		}
	</style>

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
                    <h2>야구팀 정보</h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">홈</a></li>
                    <li><a href="${pageContext.request.contextPath}/team/list.do">야구팀</a></li>
                    <li class="active">${team.name}</li>
                </ol>
            </div>
        </div>
    </div>
</header>

<!-- Container ======================================================================================= -->


<div class="container">
    <div class="row">
	    <div class="col-md-6 col-lg-6">
	        <div class="blog-stripe">
	            <a href="#">
	                <img src="${pageContext.request.contextPath}/resources/img/${team.logo}" alt="${team.name}" class="feature">
	            </a>
	            <div class="block-title">
	                <h2 class="text-center">${team.name}</h2>
	            </div>
	        </div>
	    </div>
	    <div class="col-md-6 col-lg-6">
	        <ul class="all-blogs">
	            <li class="media">
	                <div class="media-body">
	                    <h4 class="media-heading">${team.name}</h4>
	                </div>
	            </li>
	            <li class="media">
	                <div class="media-body">
	                    <h4 class="media-heading">감독 : ${team.manager}</h4>
	                </div>
	            </li>
	            <li class="media">
	                <div class="media-body">
	                    <h4 class="media-heading">연고지 : ${team.region}</h4>
	                </div>
	            </li>
	            <li class="media">
	                <div class="media-body">
	                    <h4 class="media-heading">홈구장 : ${team.stadium}</h4>
	                </div>
	            </li>
	            <li class="media">
	                <div class="media-body">
	                    <h4 class="media-heading">
	                    	등록선수 : 
	                    	<a href="${pageContext.request.contextPath}/player/list.do?teamId=${team.teamId}">${team.numberOfPlayers}</a>
	                    	명
	                    </h4>
	                </div>
	            </li>
	        </ul>
	    </div>
	    
        <div class="text-right">
        	<a href="${pageContext.request.contextPath}/team/list.do">
        		<button type="button" class="btn btn btn-warning">팀목록</button>
            </a>
        </div>
	</div>

    <!-- Footer ========================================================================================== -->
    <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>