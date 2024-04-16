package com.repaso.fullstack.rest;

import com.repaso.fullstack.configuraciones.Globales;
import com.repaso.fullstack.dto.CursoDto;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/cursos")
public class CursoRest {

	
	@GET
	public  Iterable<CursoDto> get(){
		return Globales.daoCurso.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public CursoDto getPorId(@PathParam(value = "id") Long id) {
		return Globales.daoCurso.obtenerPorId(id);
	}
	
	@POST
	public CursoDto post(CursoDto curso) {
		return Globales.daoCurso.insertar(curso);
	}
	
	@PUT
	@Path(value = "/{id}")
	public CursoDto put(@PathParam(value = "id") Long id, CursoDto curso) {
		return Globales.daoCurso.modificar(new CursoDto(id, curso.nombre()));
	}
	
	@DELETE
	@Path(value = "/{id}")
	public void delete(@PathParam(value = "id") Long id) {
		Globales.daoCurso.borrar(id);
	}
	
}