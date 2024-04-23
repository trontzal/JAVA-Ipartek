package com.UF2218Examen.controladores;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.UF2218Examen.configuraciones.Globales;
import com.UF2218Examen.entidades.Libro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("libros", Globales.DAO_LIBRO.obtenerTodos());

		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Para que al dar error no se pierda el lsitado en la recarga
		request.setAttribute("libros", Globales.DAO_LIBRO.obtenerTodos());

		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sDescuento = request.getParameter("descuento");

		BigDecimal precio = sPrecio.isBlank() ? null : new BigDecimal(sPrecio);
		Integer descuento = sDescuento.isBlank() ? null : Integer.parseInt(sDescuento);

		Libro libro = new Libro(null, nombre, precio, descuento);

		Map<String, String> errores = validarLibro(libro);

		if (errores.size() > 0) {
			request.setAttribute("libro", libro);
			request.setAttribute("errores", errores);

			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
			return;
		} else {
			Globales.DAO_LIBRO.insertar(libro);
		}
		response.sendRedirect(request.getContextPath() + "/index");
	}

	private Map<String, String> validarLibro(Libro libro) {
		Map<String, String> errores = new HashMap<>();

		Validator validator = Globales.VALIDATOR_FACTORY.getValidator();
		Set<ConstraintViolation<Libro>> constraintViolations = validator.validate(libro);

		for (ConstraintViolation<Libro> constraintViolation : constraintViolations) {
			errores.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}

		return errores;
	}
}