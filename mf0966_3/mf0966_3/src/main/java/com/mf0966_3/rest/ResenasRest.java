package com.mf0966_3.rest;

import com.mf0966_3.accesodatos.ResenaAccesodatos;
import com.mf0966_3.dtos.ResenaDTO;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/resenas")
public class ResenasRest {

	@POST
	public ResenaDTO insertar(ResenaDTO resena) {
		return ResenaAccesodatos.insertar(resena);
	}
	
	@PUT
	@Path("/{codigo}")
	public ResenaDTO modificar(@PathParam("codigo") Long codigo, ResenaDTO resena) {
		return ResenaAccesodatos.modificar(resena, codigo);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void eliminar(@PathParam("codigo") Long codigo) {
		ResenaAccesodatos.borrar(codigo);
	}
}
