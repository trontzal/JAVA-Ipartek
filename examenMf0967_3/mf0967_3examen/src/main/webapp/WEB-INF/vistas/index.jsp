<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<main>

	<h2>Listado de libros</h2>


	<div class="container-fluid">
		<div class="containerCards d-flex flex-wrap justify-content-around gap-3">
			<c:forEach items="${libros}" var="libro">
					<div class="card" style="width: 15rem;">
						<img src="${libro.url}" class="card-img-top" onerror="this.onerror=null; this.src='imgs/error-img.webp'" />

						<div class="card-body">
							<div class="d-flex justify-content-between">
								<p class="card-text">${libro.nombre}</p>
								<span class="icon-link icon-link-hover" ><i class="bi bi-heart" ></i></span>
							</div>
							<p class="fw-bold">${libro.autor}</p>
							<div class="d-flex">

								<c:if test="${libro.descuento eq null}">
									<p class="me-2">
										<fmt:formatNumber type="currency" value="${libro.precio}" />
									</p>

								</c:if>
								<c:if test="${libro.descuento ne null}">
									<p class="me-2 text-danger">
										<fmt:formatNumber type="currency" value="${libro.precio - (libro.precio * (libro.descuento / 100.0))}" />
									</p>
									<p class="text-decoration-line-through">
										<fmt:formatNumber type="currency" value="${libro.precio}" />
									</p>
									<p class="ms-5 p-1 bg-danger text-white">${libro.descuento}%</p>
								</c:if>


							</div>
						</div>
						<div class="btn btn-success w-100 p-3">
							<a href="#" class="text-white">Comprar</a>
						</div>
					</div>
			</c:forEach>

		</div>
	</div>

</main>
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>