package com.repaso.fullstack.rest;

import com.repaso.fullstack.configuraciones.Globales;
import com.repaso.fullstack.dto.AlumnoDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/alumnos")
public class AlumnoRest {

	@GET
	public Iterable<AlumnoDto> get(){
		return Globales.daoAlumno.obtenerTodos();
	}
}
