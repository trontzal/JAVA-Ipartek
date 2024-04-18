package com.repaso.fullstack.controladores;

import java.io.IOException;

import com.repaso.fullstack.configuraciones.Globales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var cursos = Globales.daoCurso.obtenerTodos();
		
		request.setAttribute("cursos", cursos);
		
		request.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(request, response);
	}


}
