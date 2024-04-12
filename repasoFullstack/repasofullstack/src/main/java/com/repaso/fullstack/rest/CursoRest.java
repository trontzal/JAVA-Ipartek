package com.repaso.fullstack.rest;

import com.repaso.fullstack.accesodatos.DaoCursoJpa;
import com.repaso.fullstack.dto.CursoDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/cursos")
public class CursoRest {

	
	// Falta la fabrica, comprobacion de metodos
	@GET
	public  Iterable<CursoDto> get(){
		return new DaoCursoJpa().obtenerTodos();
	}
}