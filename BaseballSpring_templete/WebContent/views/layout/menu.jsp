<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">BaseballTeam</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}">홈</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/team/list.do">팀목록</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li ><a href="${pageContext.request.contextPath}/player/allList.do">선수목록</a></li>
            </ul>
        </div>
    </div>
</div>