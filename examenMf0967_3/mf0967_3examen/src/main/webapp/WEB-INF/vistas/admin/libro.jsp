<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main class="container">
	<h2>Libro admin</h2>


	<form action="admin/libro" method="post" class="mt-4">
		<div class="mb-3">
			<input type="hidden" id="id" name="id" value="${libro.id}"> <label
				for="nombre" class="form-label">Nombre:</label> <input type="text"
				id="nombre" name="nombre" class="form-control"
				value="${libro.nombre}">
			<p class="text-danger">${errores.nombre}</p>
		</div>
		<div class="mb-3">
			<label for="precio" class="form-label">Precio:</label> <input
				type="number" id="precio" name="precio" class="form-control"
				value="${libro.precio}">
			<p class="text-danger">${errores.precio}</p>
		</div>
		<div class="mb-3">
			<label for="descuento" class="form-label">Descuento:</label> <input
				type="number" id="descuento" name="descuento" class="form-control"
				value="${libro.descuento}">
			<p class="text-danger">${errores.descuento}</p>
		</div>
		<div class="mb-3">
			<label for="autor" class="form-label">Autor:</label> <input
				type="text" id="autor" name="autor" class="form-control"
				value="${libro.autor}">
			<p class="text-danger">${errores.autor}</p>
		</div>
		<div class="mb-3">
			<label for="url" class="form-label">URL:</label> <input type="text"
				id="url" name="url" class="form-control" value="${libro.url}">
		</div>
		<button type="submit" class="btn btn-primary">Añadir o editar</button>
	</form>


</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>