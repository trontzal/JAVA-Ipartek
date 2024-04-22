<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp" %>
<main>
	<h2>Login</h2>
	
	<form action="login" method="post">
		<div>
			<label for="nombre">Nombre</label>
			<div >
				<input type="text" id="nombre" name="nombre">
			</div>
		</div>
		<div>
			<label for="contrasena">Contraseña</label>
			<div>
				<input type="password" id="contrasena" name="contrasena">
			</div>
		</div>

		<div>
			<div>
				<button>Login</button>
			</div>
		</div>

	</form>
</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp" %>