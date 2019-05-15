<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.servletContext.contextPath }/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<!-- Header -->
		<%-- <jsp:include page="/WEB-INF/views/includes/header.jsp" /> --%>
		<c:import url='/WEB-INF/views/includes/header.jsp' />
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="${pageContext.servletContext.contextPath }/user">
					<input type="hidden" name="a" value="login">
					
					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="">
					
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
					<c:choose>
						<c:when test='${result == "fail" }'>
							<p>
								로그인이 실패 했습니다.
							</p>
						</c:when>
					</c:choose>
					<%-- <%
						String result = (String)request.getAttribute("result");
						if("fail".equals(result)){
					%> --%>
					<%-- <p>
						로그인이 실패 했습니다.
					</p>
					<%} %> --%>
					<input type="submit" value="로그인">
				</form>
			</div>
		</div>
		<!-- 네비게이션 바  -->
		<%-- <jsp:include page="/WEB-INF/views/includes/navigation.jsp" /> --%>
		<c:import url='/WEB-INF/views/includes/navigation.jsp'>
			<c:param name="menu" value="" />
		</c:import>

		<%-- <jsp:include page="/WEB-INF/views/includes/footer.jsp" /> --%>
		<c:import url='/WEB-INF/views/includes/footer.jsp' />
	</div>
</body>
</html>