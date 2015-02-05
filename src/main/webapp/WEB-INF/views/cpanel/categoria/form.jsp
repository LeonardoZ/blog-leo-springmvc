<!DOCTYPE html>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags"%>

<div>
	<div class="page-header">
		<h3>Cadastro de categoria</h3>
		<ol class="breadcrumb">
			<sp:url value="/cp/post/posts" var="principal"></sp:url>
			<sp:url value="/cp/categoria/listar" var="categorias"></sp:url>
			<li><a href="${principal}">principal</a></li>
			<li><a href="${categorias}">categorias</a></li>
			<li class="active">cadastro</li>
		</ol>
	</div>
	<blog:temErros temErros="${temErros}" />
	<sf:form cssClass="form" role="form" method="POST" action="salvar.do"
		modelAttribute="categoria">
		<div class="form-group">
			<sf:hidden path="id" />
		</div>
		<div class="form-group">
			<sf:label path="descricao">Descricao</sf:label>
			<sf:input cssClass="form-control" path="descricao" />
			<sf:errors path="descricao" cssClass="has-error help-block" />
		</div>
		<blog:botoesFormulario  />

	</sf:form>
</div>