<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html lang="es">
<head>

<base href="${pageContext.request.contextPath}/">

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MF0967</title>

<link rel="icon" type="image/svg+xml" href="imgs/favicon.svg">

<link rel="stylesheet" href="css/bootstrap-icons.min.css">

<link rel="stylesheet" href="css/bootstrap.min.css">
<script defer src="js/bootstrap.bundle.min.js"></script>

<script defer src="js/jquery-3.7.1.min.js"></script>

<link rel="stylesheet" href="css/dataTables.bootstrap5.css">
<script defer src="js/dataTables.js"></script>
<script defer src="js/dataTables.bootstrap5.js"></script>

<script defer src="js/mf0967.js"></script>

</head>
<body>

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">MF0967</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="index">Libros</a></li>
				</ul>
				<ul class="navbar-nav mb-2 mb-sm-0">
					<c:choose>
						<c:when test="${usuario == null}">
							<li class="nav-item"><a class="nav-link" href="login">Log
									in</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item"><a class="nav-link" href="logout">Log out</a></li>
							<li class="nav-item"><a class="nav-link"
								href="admin/libros">Administración</a></li>
							<li class="navbar-text">${usuario}</li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</div>
	</nav>