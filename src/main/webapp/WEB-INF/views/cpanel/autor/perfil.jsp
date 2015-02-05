<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="page-header">
		<h3>Perfil</h3>
		<ol class="breadcrumb">
			<spring:url value="/cp/post/posts" var="principal"></spring:url>
			<li><a href="${principal}">principal</a></li>
			<li>perfil</li>
		</ol>
	</div>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h3>${autor.nomeCompleto}</h3>
	</div>
	<div class="panel-content">
		<input type="hidden" id="${autor.id}" value="${autor.id}" />
		<p>
			<strong> Nick: </strong> ${autor.nick }
		</p>
		<p>
			<strong> E-mail </strong>${autor.email }</p>
		<p>
			<strong> Cadastrado em: </strong>
			<fmt:formatDate value="${autor.cadastrado }" pattern="dd/MM/yyyy" />
		</p>
		<spring:url value="/cp/autor/editar.do?id=${autor.id}" var="autor_editar" />
		<a class="btn btn-info btn-lg" href="${autor_editar }"
			role="button">Editar</a>
	</div>
</div>
