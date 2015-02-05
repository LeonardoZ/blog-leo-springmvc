<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><tiles:getAsString name="titulo" /></title>
<spring:url value="/resources/css/bootstrap.css" var="stylecss" />
<link href="${stylecss}" rel="stylesheet" />
<spring:url value="/resources/css/estilo.css" var="stylecss_org" />
<link href="${stylecss_org}" rel="stylesheet" />
<spring:url value="/resources/css/sidebar.css" var="stylecss_bar" />
<link href="${stylecss_bar}" rel="stylesheet" />

</head>
<body>
	<!-- Navbar -->
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a href="#" class="navbar-brand"> <span
					class="glyphicon glyphicon-road"></span> leo's - cpanel4adm
				</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<spring:url value="/cp" var="principal_url" />
					<spring:url value="/blog" var="blog_url" />
					<li class="Active"><a href="${principal_url}">principal</a></li>
					<li class="Active"><a href="${blog_url}">blog</a></li>
				</ul>
			</div>
			<!-- div nav itens -->
			<!-- div nav header -->
		</div>
		<!-- div container -->
	</div>
	<!-- div nav deafult -->
	<!-- Header -->
	<div class="container">
		<div class="row center-block">
			<div class="col-sm-2">
				<div id="sidebar-wrapper">
					<ul class="sidebar-nav">
						<!-- Brand desnecessário por hora -->
						<!-- <li class="sidebar-brand"><a href="#">BLOG</a></li> -->
						<spring:url value="/cp/post/novo" var="novo_post_url" />
						<li><a href="${novo_post_url }"> <span
								class="glyphicon glyphicon-plus"></span> Novo Post
						</a></li>

						<spring:url value="/cp/autor/perfil" var="perfil_autor_url" />
						<li><a href="${perfil_autor_url}"> <span
								class="glyphicon glyphicon-user"></span> Perfil
						</a></li>

						<spring:url value="/cp/autor/listar" var="novo_autor_url" />
						<li><a href="${novo_autor_url}"> <span
								class="glyphicon glyphicon-tower"></span> Autores
						</a></li>

						<spring:url value="/cp/categoria/listar" var="categorias_url" />
						<li><a href="${categorias_url}"> <span
								class="glyphicon glyphicon-certificate"></span> Categorias
						</a></li>

						<li><a href="#"> <span class="glyphicon glyphicon-stats"></span>
								Análise
						</a></li>

						<spring:url value="/logout.do" var="logout_url" />
						<li><a href="${logout_url }"> <span
								class="glyphicon glyphicon-off"></span> Logout
						</a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-10 painel-principal" id="content">
				<tiles:insertAttribute name="conteudo" />
			</div>

		</div>
	</div>
	<!-- Rodape -->
</body>
</html>