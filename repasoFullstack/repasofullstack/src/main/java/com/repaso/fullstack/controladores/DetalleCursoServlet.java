package com.repaso.fullstack.controladores;

import java.io.IOException;

import com.repaso.fullstack.configuraciones.Globales;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/detalleCurso")
public class DetalleCursoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		Long id = Long.valueOf(sId);
		
		var curso = Globales.daoCurso.obtenerPorId(id);
		
		request.setAttribute("curso", curso);
		
		request.getRequestDispatcher("/WEB-INF/vistas/detalleCurso.jsp").forward(request, response);
	}


}
