<%@ attribute name="temErros" required="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:if test="${temErros}">
	<div class="alert alert-danger" role="alert">
		<p>Existem erros no seu formulário.</p>
	</div>
</c:if>
