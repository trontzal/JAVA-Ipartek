<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main>
	<h2>Libro admin</h2>

	<p>${errores }</p>

	<form action="admin/libro" method="post">
		<input type="hidden" id="id" name="id" value="${libro.id}"> <label
			for="nombre">Nombre:</label> <input type="text" id="nombre"
			name="nombre" value="${libro.nombre}"><br> <br> <label
			for="precio">Precio:</label> <input type="number" id="precio"
			name="precio" value="${libro.precio}"><br> <br> <label
			for="descuento">Descuento:</label> <input type="number"
			id="descuento" name="descuento" value="${libro.descuento}"><br>
		<br> <label for="autor">Autor:</label> <input type="text"
			id="autor" name="autor" value="${libro.autor}"><br> <br>
		<label for="url">URL:</label> <input type="text" id="url" name="url"
			value="${libro.url}"><br> <br>

		<button type="submit">Añadir o editar</button>
	</form>

</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>