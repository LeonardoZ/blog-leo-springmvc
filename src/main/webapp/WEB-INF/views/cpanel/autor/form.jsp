<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags"%>

<div class="page-header">
	<h3>Cadastro de autor</h3>
	<ol class="breadcrumb">
		<spring:url value="/cp/post/posts" var="principal"></spring:url>
		<li><a href="${principal}">principal</a></li>
		<c:choose>
			<c:when test="${listar eq true}">
				<spring:url value="/cp/autor/listar" var="listar_autor"></spring:url>
				<li><a href="${listar_autor}">listar</a></li>
			</c:when>
			<c:when test="${perfil eq true}">
				<spring:url value="/cp/autor/perfil" var="perfil_autor"></spring:url>
				<li><a href="${perfil_autor}">perfil</a></li>
			</c:when>
		</c:choose>
		<li class="active">cadastro</li>
	</ol>
</div>
<div>

	<blog:temErros temErros="${temErros}" />

	<h3>Preencha as informações do Autor</h3>
	<sf:form role="form" method="POST" action="salvar.do"
		modelAttribute="autor">

		<sf:hidden path="id" />
		<div class="form-group">
			<sf:label path="nick">Nick</sf:label>
			<sf:input cssClass="form-control" path="nick" />
			<sf:errors path="nick" cssClass="help-block" />
		</div>
		<div class="form-group">
			<sf:label path="nomeCompleto">Nome completo</sf:label>
			<sf:input cssClass="form-control" path="nomeCompleto" />
			<sf:errors path="nomeCompleto" cssClass="help-block" />
		</div>
		<div class="form-group">
			<sf:label path="email">Email</sf:label>
			<sf:input cssClass="form-control" type="email" required="true"
				path="email" />
			<sf:errors path="email" cssClass="help-block" />
		</div>
		<div class="form-group">
			<sf:label path="hashSenha">Senha</sf:label>
			<sf:password cssClass="form-control" path="hashSenha" />
			<sf:errors path="hashSenha" cssClass="has-error help-block" />
		</div>

		<blog:botoesFormulario />

	</sf:form>
</div>
