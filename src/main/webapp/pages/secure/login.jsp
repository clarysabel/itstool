<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Login</h1>

<!--<c:url var="googleLogoUrl" value="/images/sign-in-with-google.png" />
<img src="${googleLogoUrl}"></img>-->
<c:url var="openIDLoginUrl" value="/j_spring_openid_security_check" />
<form action="${openIDLoginUrl}" method="post">
	   For Google users:
	  <input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id"/>
	  <input type="submit" value="Sign with Google"/>
</form>
<c:if test="${not empty error}">
	<div class="errorblock">
		<br>
		<p class="align_center">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</p>
	</div>
</c:if>

</body>
</html>