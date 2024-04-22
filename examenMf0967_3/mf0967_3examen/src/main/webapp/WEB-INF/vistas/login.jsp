<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main class="container mt-5 w-25">
	<c:if test="${not empty error}">
		<div class="alert alert-warning" role="alert">
			<strong>Error:</strong> ${error}
		</div>
	</c:if>
	<h2 class="mb-4">Login</h2>
	<form action="login" method="post">
		<div class="form-group mb-2">
			<label for="nombre">Nombre</label> <input type="text"
				class="form-control" id="nombre" name="nombre">
		</div>
		<div class="form-group mb-2">
			<label for="contrasena">Contraseña</label> <input type="password"
				class="form-control" id="contrasena" name="contrasena">
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
	</form>
</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>