<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="titulo" /></title>
<spring:url value="/resources/css/bootstrap.css" var="stylecss" />
<link href="${stylecss}" rel="stylesheet" />
<spring:url value="/resources/css/estilo_blog.css" var="stylecss_org" />
<link href="${stylecss_org}" rel="stylesheet" />
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<spring:url value="/blog" var="principal_url" />
				<a href="${principal_url}" class="navbar-brand"> <span
					class="glyphicon glyphicon-road"></span> leo's - blog
				</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<spring:url value="/post/posts" var="blog_url" />
					<li class="Active"><a href="${blog_url}">o autor</a></li>
					<li class="Active"><a href="${blog_url}">sobre</a></li>

				</ul>
			</div>
			<!-- div nav itens -->
			<!-- div nav header -->
		</div>
		<!-- div container -->
	</div>
	<!-- Cabecalho -->
	<div class="page-header">
		<h1 class="text-center">
			Leo's<br /> <small>dev notes, java, android, js</small>
		</h1>

	</div>

	<!-- Conteudo -->
	<div class="container">
		<div class="row center-block">
			<div class="col-md-12">
				<tiles:insertAttribute name="conteudo" />
			</div>

		</div>
	</div>

	<!-- Rodape -->
	<div class="footer text-center">

		leo's blog - 2015

	</div>

</body>
</html>