<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UF2218 Examen</title>
</head>
<body>
	<h1>UF2218</h1>
	<h2>Listado libros</h2>

	<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Descuento</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${libros}" var="libro">
                <tr>
                    <td>${libro.id}</td>
                    <td>${libro.nombre}</td>
                    <td>${libro.precio}</td>
                    <td>${libro.descuento}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

	<h2>Insertar nuevo libro</h2>
	<form action="index" method="post">

		<label for="nombre">Titulo</label>
		<div>
			<input type="text" id="nombre" name="nombre" value="${libro.nombre}">
			<p>${errores.nombre}</p>
		</div>

		<label for="precio">Precio</label>
		<div>
			<input type="number" step=".01" id="precio" name="precio" value="${libro.precio}">
			<p>${errores.precio}</p>
		</div>

		<label for="descuento">Descuento</label>
		<div>
			<input type="number" id="descuento" name="descuento" value="${libro.descuento}">
			<p>${errores.descuento}</p>
		</div>

		<button>Insertar</button>
	</form>
</body>
</html>