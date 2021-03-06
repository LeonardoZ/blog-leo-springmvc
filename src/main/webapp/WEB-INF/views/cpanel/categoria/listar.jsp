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
<a href="${categoria_novo}" class="btn btn-sm btn-warning">
<span class="glyphicon glyphicon-plus">Novo</span>
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
<th style="width: 80%">Descri��o</th>

<th>A��es</th>
</tr>
</thead>
<tbody>
<c:forEach var="cat" items="${categorias}">

<tr>
<td>${cat.descricao}</td>

<td class="link-acoes">
<spring:url
value="/cp/categoria/editar?id=${cat.id}" var="categoria_editar" /> 
<span class="btn btn-info  btn-xs">
	<a href="${categoria_editar }">Editar</a>
</span> 
</td>
<!--  -->
<td>
<spring:url value="/cp/categoria/deletar.do" var="categoria_deletar" />
 <form action="${categoria_deletar}" method="POST">
 	<input type="hidden" name="id" value="${cat.id}">
	<button class="btn btn-danger btn-xs" >Deletar</button>
</form>

</td>

</tr>

</c:forEach>

</tbody>
</table>
</div>