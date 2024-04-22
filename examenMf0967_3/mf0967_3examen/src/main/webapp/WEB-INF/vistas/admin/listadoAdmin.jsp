<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main>
	<h2>Listado amin</h2>

	<p>${libros }</p>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Precio</th>
				<th>Descuento</th>
				<th>Autor</th>
				<th>URL</th>
				<th>Acciones</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr>
					<td>${libro.id}</td>
					<td>${libro.nombre}</td>
					<td>${libro.precio}</td>
					<td>${libro.descuento}</td>
					<td>${libro.autor}</td>
					<td>${libro.url}</td>
					<td><a href="admin/libro?id=${libro.id}">Editar</a> <a
						href="admin/borrar?id=${libro.id}">Borrar</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="admin/libro">Añadir</a></td>
			</tr>
		</tfoot>
	</table>
</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>