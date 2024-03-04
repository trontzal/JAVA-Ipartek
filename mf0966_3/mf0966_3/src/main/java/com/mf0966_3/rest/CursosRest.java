package com.mf0966_3.rest;

import java.util.ArrayList;

import com.mf0966_3.accesodatos.CursoAccesodatos;
import com.mf0966_3.dtos.CursoDTO;
import com.mf0966_3.dtos.CursoResenaDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/cursos")
public class CursosRest {
	
	@GET
	public ArrayList<CursoDTO> obtenerTodos(){
		return CursoAccesodatos.obtenerTodos();
	}
	
	@GET
	@Path("/{codigo}")
	public CursoResenaDTO obtenerPorCodigo(@PathParam("codigo") Long codigo) {
		return CursoAccesodatos.obtenerPorCodigo(codigo);
	}
}
