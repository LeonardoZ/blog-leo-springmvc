<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login - leos's cpanel4adm</title>

<spring:url value="/resources/css/bootstrap.css" var="stylecss" />
<link href="${stylecss}" rel="stylesheet" />

<spring:url value="/resources/css/login.css" var="stylecss_log" />
<link href="${stylecss_log}" rel="stylesheet" />

</head>
<body>
	<div class="container center-form well">
		<spring:url value="/login.do" var="url" />
		<h2>Login</h2>
		<form:form action="${url}" method="POST" class="form-horizontal">

			<form:label path="email" cssClass="sr-only">Email</form:label>
			<form:input cssClass="form-control" path="email"
				placeholder="Digite seu e-mail" required=""  />

			<form:label path="senha" cssClass="sr-only">Senha</form:label>
			<form:password path="senha" cssClass="form-control"
				placeholder="Digite sua senha" required="" />

			<button class="btn btn-lg btn-primary btn-block" type="submit">
				Log in</button>
		</form:form>
	</div>
</body>
</html>