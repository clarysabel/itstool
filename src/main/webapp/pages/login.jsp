<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE HTML>
<html>
<head>

<link media="all" rel="stylesheet" type="text/css" href="../css/all.css" />

<title>ITS Tool</title>
<meta charset="UTF-8" />
</head>

<body>
	<div id="login_wrapper">
		<div class="logo">
			<img src="../images/logo-white.png" alt="Logo" />
		</div>

		<div id="login_container">
			<form id="login" action="process_login" method="post">

				<div id="login_form_body">
					<label class="label_login">User</label><input class="login_input"
						id="username" type="text" tabindex="1" name="j_username" autofocus
						required> <br> <br> <label class="label_login">Pass</label><input
						class="login_input" id="password" type="password" tabindex="2"
						name="j_password" required> <br> <br>
				</div>

				<div id="login_action">
					<input id="loginkeeping" type="checkbox" value="loginkeeping"
						name="loginkeeping" tabindex="4"> <label
						for="loginkeeping">Remember me</label> <label id="label_forgot">Forgot password?</label>
						<br>
						<br>
				</div>

				<div id="login_submit">
					<button type="submit" class="login_btn" tabindex="4">Log in</button>
				</div>
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
		</div>
	</div>

	<%-- 	<footer><spring:message code="login.footer.text" /> --%>
	<!-- 	</footer> -->
</body>
</html>
