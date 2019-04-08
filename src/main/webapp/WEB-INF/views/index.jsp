<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="posts">
	<c:if test="${empty posts}">
		<p class="help-block">Nenhum post disponível.</p>
	</c:if>
	<c:forEach var="post" items="${posts}">
		<div class="post">
			<div class="post-title ">
				<h3>${post.titulo}</h3>
			</div>
			<div class="post-content">${post.conteudo}</div>
			<div class="post-footer">
				<span class="text-left"><a href="#">Compartilhar</a></span>
				<spring:url value="/blog/post?id=${post.id}" var="post_url" />
				<span class="pull-right"><a href="${post_url}">Comentarios(${post.numeroDeComentarios()})</a></span>
			</div>
		</div>
	</c:forEach>
	<div class="text-center">
		<ul class="pagination pagination-lg text-center">
			<c:forEach begin="1" end="${paginas}" var="pagina">
				<spring:url value="/blog?p=${pagina}" var="pagina_url" />
				<li><a href="${pagina_url}">${pagina}</a></li>
			</c:forEach>
		</ul>
	</div>

</div>

<spring:url value="/resources/js/jquery.js" var="jquery_js" />
<spring:url value="/resources/js/bootstrap.js" var="boot_js" />
<spring:url value="/resources/js/blog/blog.js" var="blog_js" />
<script type="text/javascript" src="${jquery_js}"></script>
<script type="text/javascript" src="${boot_js}"></script>
<script type="text/javascript" src="${blog_js}"></script>