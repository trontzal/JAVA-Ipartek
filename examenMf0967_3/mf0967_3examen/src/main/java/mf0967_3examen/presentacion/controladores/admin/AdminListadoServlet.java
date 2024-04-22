package mf0967_3examen.presentacion.controladores.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mf0967_3examen.configuraciones.Globales;

import java.io.IOException;

@WebServlet("/admin/libros")
public class AdminListadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("libros", Globales.DAO_LIBRO.listar());
		
		request.getRequestDispatcher("/WEB-INF/vistas/admin/listadoAdmin.jsp").forward(request, response);
	}
}