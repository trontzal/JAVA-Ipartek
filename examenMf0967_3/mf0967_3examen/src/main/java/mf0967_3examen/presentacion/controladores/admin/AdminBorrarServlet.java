package mf0967_3examen.presentacion.controladores.admin;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mf0967_3examen.configuraciones.Globales;

@WebServlet("/admin/borrar")
public class AdminBorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		try {
			Long id = Long.valueOf(sId);

			if (Globales.DAO_LIBRO.obtenerPorId(id) != null) {
				Globales.DAO_LIBRO.eliminar(id);
				response.sendRedirect(request.getContextPath() + "/admin/libros");
			} else {
				throw new LibroNoEncontradoException("El libro con ID " + id + " no existe");
			}
		} catch (NumberFormatException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El ID del libro debe ser un número válido");
		} catch (LibroNoEncontradoException e) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, e.getMessage());
		}
	}
}

// Extraer clase
class LibroNoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public LibroNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}