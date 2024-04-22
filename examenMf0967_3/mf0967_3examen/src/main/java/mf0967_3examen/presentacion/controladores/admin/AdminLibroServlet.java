package mf0967_3examen.presentacion.controladores.admin;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import mf0967_3examen.configuraciones.Globales;
import mf0967_3examen.entidades.Libro;

@WebServlet("/admin/libro")
public class AdminLibroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		if (sId != null) {
			Long id = Long.valueOf(sId);
			request.setAttribute("libro", Globales.DAO_LIBRO.obtenerPorId(id));
		}

		request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String sPrecio = request.getParameter("precio");
		String sDescuento = request.getParameter("descuento");
		String autor = request.getParameter("autor");
		String urlFoto = request.getParameter("url");

		Long id = sId.isBlank() ? null : Long.valueOf(sId);
		BigDecimal precio = sPrecio.isBlank() ? null : new BigDecimal(sPrecio);
		Integer descuento = sDescuento.isBlank() ? null : Integer.parseInt(sDescuento);

		Libro libro = new Libro(id, nombre, precio, descuento, autor, urlFoto);

		Map<String, String> errores = validarProducto(libro);

		if (errores.size() > 0) {
			request.setAttribute("libro", libro);
			request.setAttribute("errores", errores);
			request.getRequestDispatcher("/WEB-INF/vistas/admin/libro.jsp").forward(request, response);

			return;
		}

		if (id != null) {
			Globales.DAO_LIBRO.modificar(libro);
		} else {
			Globales.DAO_LIBRO.darDeAlta(libro);
		}

		response.sendRedirect(request.getContextPath() + "/admin/libros");
	}
	
	private Map<String, String> validarProducto(Libro libro) {
		Map<String, String> errores = new HashMap<>();
		
		Validator validator = Globales.VALIDATOR_FACTORY.getValidator();
        Set<ConstraintViolation<Libro>> constraintViolations = validator.validate(libro);
		
        for(ConstraintViolation<Libro> constraintViolation: constraintViolations) {
        	errores.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
        }
        
        return errores;
	}
}