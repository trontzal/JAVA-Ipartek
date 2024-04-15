package com.repaso.fullstack.rest;

import com.repaso.fullstack.configuraciones.Globales;
import com.repaso.fullstack.dto.CursoDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/cursos")
public class CursoRest {

	
	// Falta la fabrica, comprobacion de metodos
	@GET
	public  Iterable<CursoDto> get(){
		return Globales.daoCurso.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public CursoDto getPorId(@PathParam(value = "id") Long id) {
		return Globales.daoCurso.obtenerPorId(id);
	}
}