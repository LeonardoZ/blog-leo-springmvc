<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="post">
	<div class="post-title ">
		<h3>${post.titulo}</h3>
	</div>
	<div class="post-content">${post.conteudo}</div>
	<div class="post-comments">
		<span class="separator"></span>
		<h4>comentários - anônimos, tenha cuidado!</h4>
		<div class="well">
			<form:form role="form" method="POST" action="comentario/adicionar.do"
				modelAttribute="comentario">
				<form:hidden path="id" />
				<form:hidden path="post.id" />

				<div class="row">
					<div class="col-sm-9 form-group">
						<form:label path="titulo">Título</form:label>
						<form:input path="titulo" cssClass="form-control" />
					</div>
					<div class="col-sm-3 form-group">
						<form:label path="autor">Autor</form:label>
						<form:input path="autor" cssClass="form-control" />
					</div>
				</div>
				<div class="form-group">
					<form:label path="conteudo" cssClass="sr-only" />
					<form:textarea path="conteudo" cssClass="form-control"
						placeholder="Comente aqui!" />
				</div>
				<form:button class="btn btn-primary pull-right">Incluir</form:button>
			</form:form>

		</div>
		<c:if test="${empty post.comentarios }">
			<p class="text-center">Nenhum comentário</p>
		</c:if>
		
		<c:forEach var="comentario" items="${post.comentarios}">
			<div class="comentarios well">
				<div class="comentario-titulo">
					${comentario.titulo} - publicado por <strong>${comentario.autor }</strong>
				</div>
				<div class="comentario-conteudo">
					${comentario.conteudo}
				</div>
			</div>
		</c:forEach>
	</div>
</div>