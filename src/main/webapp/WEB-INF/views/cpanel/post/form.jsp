<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="blog" tagdir="/WEB-INF/tags"%>

<div>
	<div class="page-header">
		<h3>${post.id == null ? 'Postar' : 'Editar post' }</h3>
		<ol class="breadcrumb">
			<sp:url value="/post/posts" var="principal"></sp:url>
			<li><a href="${principal}">principal</a></li>
			<li class="active">cadastro</li>
		</ol>
	</div>
	<h3>Post</h3>

	<blog:temErros temErros="${temErros}" />
	<sf:form cssClass="form" role="form" method="POST" action="salvar.do"
		modelAttribute="post">

		<div class="form-group">
			<sf:hidden path="id" />
		</div>
		<div class="form-group">
			<sf:hidden path="autor.id" />
		</div>
		<c:if test="${post.data != null}">
			<div class="form-group">
				<sf:label path="data">Data de criação</sf:label>
				<sf:input disabled="true" path="data" />
			</div>
		</c:if>
		<div class="form-group">
			<sf:label path="titulo">Titulo</sf:label>
			<sf:input type="text" cssClass="form-control" path="titulo" />
			<sf:errors path="titulo" cssClass="has-error help-block" />
		</div>
		<div class="form-group">
			<sf:label path="conteudo">Conteúdo</sf:label>
			<sf:textarea rows="12" cssClass="form-control" path="conteudo" />
			<sf:errors path="conteudo" cssClass="has-error help-block" />
		</div>

		<div class="form-group">
			<div class="input-group">
				<input id="categoria-input"
					placeholder="Digite parte do nome da categoria que deseja. Caso não for encontrada, pressione o botão ou a tecla Enter."
					class="form-control" type="text"> <span
					class="input-group-btn">
					<button id="btn-categoria" class="btn btn-default" type="button">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</button>
				</span>
			</div>
			<br />
			<!-- Categorias visiveis -->
			<label for="categorias-selecionadas">Categoria</label>
			<div id="categorias-selecionadas" class="categoria-box">
				<span id="nenhuma-categoria" class="label label-danger">Nenhuma
					categegoria selecionada</span>
			</div>
			<!-- Categorias invisiveis -->
			<div id="categorias-hidden"></div>
			<sf:errors path="categorias" cssClass="has-error help-block" />
		</div>

		<blog:botoesFormulario />
	</sf:form>
</div>
<sp:url value="/resources/js/jquery.js" var="jquery" />
<sp:url value="/resources/js/jquery-ui/jquery-ui.js" var="jquery_ui" />
<sp:url value="/resources/js/jquery-ui/jquery-ui.css"
	var="jquery_ui_css" />
<sp:url value="/resources/js/post/post.js" var="posts_js" />
<sp:url value="/resources/css/estilo.css" var="stylecss_org" />

<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${jquery_ui}"></script>
<script type="text/javascript" src="${posts_js}"></script>

<link href="${jquery_ui_css}" rel="stylesheet">

<!-- Include Font Awesome. -->
<sp:url value="/resources/css/font-awesome.min.css" var="font" />
<link href="${font}" rel="stylesheet" type="text/css" />

<!-- Include Editor style. -->
<sp:url value="/resources/css/froala_editor.min.css" var="editor" />
<link href="${editor }" rel="stylesheet"
	type="text/css" />

<sp:url value="/resources/css/froala_style.min.css" var="style" />
<link href="${style}" rel="stylesheet"
	type="text/css" />

<!-- Include JS files. -->
<sp:url value="/resources/js/froala_editor.min.js" var="js" />
<script src="${js}"></script>


