<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${ctx }/message/myMessage.do">나무소셜</a>
        </div>
        <div class="navbar-collapse collapse navbar-responsive-collapse">
            <ul class="nav navbar-nav">
            	<c:choose>
            		<c:when test="${thisPage eq 'messageList' }">
		                <li class="active"><a href="${ctx }/message/myMessage.do">소셜 홈</a></li>
		                <li><a href="${ctx }/user/following.do">팔로잉(${followingCount })</a></li>
		                <li><a href="${ctx }/user/follower.do">팔로워(${followerCount })</a></li>
		                <li><a href="#">공지사항</a></li>
            		</c:when>
            		<c:when test="${thisPage eq 'following' }">
		                <li><a href="${ctx }/message/myMessage.do">소셜 홈</a></li>
		                <li class="active"><a href="${ctx }/user/following.do">팔로잉(${followingCount })</a></li>
		                <li><a href="${ctx }/user/follower.do">팔로워(${followerCount })</a></li>
		                <li><a href="#">공지사항</a></li>
            		</c:when>
            		<c:when test="${thisPage eq 'follower' }">
		                <li><a href="${ctx }/message/myMessage.do">소셜 홈</a></li>
		                <li><a href="${ctx }/user/following.do">팔로잉(${followingCount })</a></li>
		                <li class="active"><a href="${ctx }/user/follower.do">팔로워(${followerCount })</a></li>
		                <li><a href="#">공지사항</a></li>
            		</c:when>
            	</c:choose>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ctx }/user/logout.do">로그아웃</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">관리 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">커뮤니티 관리센터</a></li>
                        <li><a href="#">클럽 관리센터</a></li>
                        <li><a href="#">팀 관리센터</a></li>
                        <li class="divider"></li>
                        <li><a href="#">홍보</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">설정 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">개인정보</a></li>
                        <li><a href="#">모바일 환경설정</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>