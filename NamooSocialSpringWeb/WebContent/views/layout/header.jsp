<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="jumbotron">
	                <c:choose>
	            		<c:when test="${thisPage eq 'messageList' }">
		                    <h1>나무 소셜과 함께!</h1>
		                    <p>오늘은 어땠나요? 나무 소셜과 함께 대화를 시작하세요.</p>
	            		</c:when>
	            		<c:when test="${thisPage eq 'following' }">
							<h2>팔로잉으로 인연을 이어가세요</h2>
	            		</c:when>
	            		<c:when test="${thisPage eq 'follower' }">
		               		<h2>나의 팬들과 함께하세요~</h2>
	            		</c:when>
	            		<c:when test="${thisPage eq 'join' }">
		                	<h1>나무소셜과 함께!</h1>
							<p>나무 소셜과 함께 특정 취미와 관심사, 특정 그룹 또는 조직에 관한 대화를 시작하세요.</p>
	            		</c:when>
            		</c:choose>
                </div>
            </div>
        </div>
    </div>
</header>