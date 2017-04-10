<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

    <title>BaseballTeam</title>
    <%@ include file="/views/layout/common.jsp" %>
	<script>
		var trade = function() {
			var targetPlayerId = $(":radio[name='targetPlayer']:checked").val();
			$("#targetPlayerId").val(targetPlayerId);
			$("#tradeForm").submit();
		};
	</script>
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
                    <h2>${tradePlayer.name} 선수 트래이드</h2>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12 col-lg-12">
                <ol class="breadcrumb">
                    <li><a href="#">홈</a></li>
                    <li><a href="#">선수목록</a></li>
                    <li class="active ">트레이드</li>
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
                <h3>트래이드 대상 선수 목록</h3>
            </div>
            
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <colgroup>
                        <col width="100"/>
                        <col width="200"/>
                        <col width="200"/>
                        <col width="200"/>
                        <col width="200"/>
                        <col width="*"/>
                    </colgroup>
                    <thead>
                    <tr>
                        <th class="text-center">선택</th>
                        <th class="text-center">이름</th>
                        <th class="text-center">등번호</th>
                        <th class="text-center">포지션</th>
                        <th class="text-center">특징</th>
                        <th class="text-center">팀명</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                    	<c:when test="${allPlayersCount == 0}">
	                        <tr>
	                            <th colspan="6" class="text-center">등록된 선수 정보가 존재하지 않습니다.</th>
	                        </tr>
                        </c:when>
                        <c:otherwise>
	                        <c:forEach var="team" items="${teams}">
	                        	<c:forEach var="player" items="${team.players}">
		                        <tr>
		                            <td class="text-center">
		                            	<input type="radio" name="targetPlayer" value="${player.playerId}">
		                            </td>
		                            <td class="text-center">${player.name}</td>
		                            <td class="text-center">${player.backNumber}</td>
		                            <td class="text-center">${player.position}</td>
		                            <td class="text-center">
			                            <c:choose>
				                            <c:when test="${player.throwHand eq 'L'}">
				                            	좌투
				                            </c:when>
				                            <c:otherwise>
				                            	우투
				                            </c:otherwise>
			                            </c:choose>
			                            <c:choose>
				                            <c:when test="${player.hittingHand eq 'L'}">
				                            	좌타
				                            </c:when>
				                            <c:otherwise>
				                            	우타
				                            </c:otherwise>
			                            </c:choose>
		                            </td>
		                            <td class="text-center">${team.name}</td>
		                        </tr>
	                        	</c:forEach>
	                        </c:forEach>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
            </div>

            <div class="text-right">
                <a href="javascript:trade();">
                	<button type="button" class="btn btn btn-warning">트래이드</button>
                </a>
            </div>
        </div>
    </div>
	<form id="tradeForm" action="${pageContext.request.contextPath}/player/trade.do" method="POST">
		<input type="hidden" name="sourcePlayerId" id="sourcePlayerId" value="${tradePlayer.playerId}">
		<input type="hidden" name="targetPlayerId" id="targetPlayerId" value="">
	</form>
<!-- Footer ========================================================================================== -->
<%@ include file="/views/layout/footer.jsp" %>
</div>

</body>
</html>