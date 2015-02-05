<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div class="well">
	<h5>
		cpanel4adm - <strong>Poste, edite e exclua</strong> os posts não
		desejados;
	</h5>
</div>
<div class="panel panel-primary">
	<div class="panel-heading">
		<h4>Posts</h4>
	</div>
	<table class="table table-striped">
		<tr>
			<th style="width: 80%">Título</th>
			<th>Ações</th>
		</tr>
		<tbody>
			<c:forEach items="${posts}" var="post">
				<tr>
					<td>${post.titulo}</td>
					<td class="link-acoes"><spring:url
							value="/cp/post/editar?id=${post.id}" var="editar_url" /> <span
						class="label label-info"> <a href="${editar_url}">Editar</a></span>
						<spring:url value="/cp/post/deletar.do?id=${post.id}"
							var="deletar_url" /> <span class="label label-danger"> <a
							href="${deletar_url}">Deletar</a></span></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
