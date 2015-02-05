<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<div class="page-header">
	<h3>Categorias - Lista de cadastradas</h3>
	<ol class="breadcrumb">
		<spring:url value="/cp/post/posts" var="principal"></spring:url>
		<li><a href="${principal}">principal</a></li>
		<li class="active">categorias</li>
	</ol>
</div>

<spring:url value="/cp/categoria/novo" var="categoria_novo" />
<div class="">
	<a href="${categoria_novo}" class="btn btn-sm btn-warning"> <span
		class="glyphicon glyphicon-plus">Novo</span>
	</a>
</div>
<br />
<div class="panel panel-primary" id="painel_tabela">
	<div class="panel-heading">
		<strong>Categorias</strong>
	</div>
	<table class="table table-striped">
		<thead>
			<tr>
				<th style="width: 80%">Descrição</th>

				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="cat" items="${categorias}">

				<tr>
					<td>${cat.descricao}</td>

					<td class="link-acoes"><spring:url
							value="/cp/categoria/editar?id=${cat.id}" var="categoria_editar" />
						<span class="label label-info"><a
							href="${categoria_editar }">Editar</a></span> <spring:url
							value="/cp/categoria/deletar.do?id=${cat.id}"
							var="categoria_deletar" /> <span class="label label-danger">
							<a href="${categoria_deletar}">Deletar</a>
					</span></td>

				</tr>

			</c:forEach>

		</tbody>
	</table>
</div>