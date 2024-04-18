package com.repaso.fullstack.rest;

import com.repaso.fullstack.configuraciones.Globales;
import com.repaso.fullstack.dto.AlumnoDto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/alumnos")
public class AlumnoRest {

	@GET
	public Iterable<AlumnoDto> get(){
		return Globales.daoAlumno.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public AlumnoDto getPorId(@PathParam(value = "id") Long id) {
		return Globales.daoAlumno.obtenerPorId(id);
	}
	
	@POST
	public AlumnoDto nuevoAlumno(AlumnoDto alumno) {
		return Globales.daoAlumno.insertar(alumno);
	}
}
