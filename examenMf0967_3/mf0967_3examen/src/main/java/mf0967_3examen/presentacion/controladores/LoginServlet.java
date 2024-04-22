package mf0967_3examen.presentacion.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("contrasena");
		
		if("administrador".equals(nombre) && "123456".equals(contrasena)) {
			request.getSession().setAttribute("usuario", nombre);
			
			response.sendRedirect(request.getContextPath() + "/admin/libros");
			
			return;
		}
		
		request.setAttribute("error", "El usuario o contraseña son incorrectos");
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}
}