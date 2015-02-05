<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="page-header">
	<h3>Autores - Lista de cadastrados</h3>
	<ol class="breadcrumb">
		<spring:url value="/cp/post/posts" var="principal"></spring:url>
		<li><a href="${principal}">principal</a></li>
		<li class="active">listar</li>
	</ol>
</div>


<spring:url value="/cp/autor/novo" var="autor_novo" />
<div class="">
	<a  href="${autor_novo}" class="btn btn-sm btn-warning"> <span
		class="glyphicon glyphicon-plus">Novo</span>
	</a>
</div>
<br />
<div class="panel panel-primary" id="painel_tabela">
	<div class="panel-heading">
		<strong>Autores</strong>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th style="width: 20%">Nick</th>
				<th style="width: 50%">Nome</th>
				<th>E-mail</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${autores}" var="autor">
				<tr>
					<td>${autor.nick}</td>
					<td>${autor.nomeCompleto}</td>
					<td>${autor.email}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>