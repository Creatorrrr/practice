<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>나무소셜</title>
    <%@ include file="/views/layout/common.jsp" %>
</head>
<body>

<c:set var="thisPage" value="join" />

<!-- Main Navigation ========================================================================================== -->
<%@ include file="/views/layout/mainNavForJoin.jsp" %>

<!-- Header ========================================================================================== -->
<%@ include file="/views/layout/header.jsp" %>

<!-- Container ======================================================================================= -->
<div class="container">
    <div class="row">
        <div class="col-lg-12">

            <div class="page-header">
                <h2 id="container">회원 가입하기</h2>
            </div>
            <div class="well">
                <p>회원가입을 위해 아래 내용들을 작성해 주세요.</p>
                <form action="${ctx }/user/join.do" method="post" class="form-horizontal">
                    <fieldset>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">아이디</label>

                            <div class="col-lg-10">
                                <input type="text" name="id" class="form-control" placeholder="아이디">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">이름</label>

                            <div class="col-lg-10">
                                <input type="text" name="name" class="form-control" placeholder="이름">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">이메일</label>

                            <div class="col-lg-10">
                                <input type="text" name="email" class="form-control" placeholder="이메일">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">비밀번호</label>

                            <div class="col-lg-10">
                                <input type="password" name="password" class="form-control" placeholder="비밀번호">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">비밀번호 확인</label>

                            <div class="col-lg-10">
                                <input type="password" class="form-control" placeholder="비밀번호 확인">
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

<!-- Footer ========================================================================================== -->
    <%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>