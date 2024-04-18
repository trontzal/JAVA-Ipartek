<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>


<main>
	<h2>Listado de cursos</h2>

	<c:forEach items="${cursos}" var="curso">
		<a href="detalleCurso?id=${curso.id()}">${curso.nombre()}</a>
	</c:forEach>
</main>

<%@ include file="/WEB-INF/vistas/includes/footer.jsp"%>