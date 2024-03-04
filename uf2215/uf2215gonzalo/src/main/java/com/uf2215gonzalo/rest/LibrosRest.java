package com.uf2215gonzalo.rest;

import java.util.ArrayList;

import com.uf2215gonzalo.accesodatos.LibroAccesodatos;
import com.uf2215gonzalo.dtos.LibroDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/libros")
public class LibrosRest {

	@GET
	public ArrayList<LibroDTO> obtenerListado(){
		return LibroAccesodatos.obtenerTodos();
	}
	
	@GET
	@Path("/{titulo}")
	public ArrayList<LibroDTO> buscar(@PathParam("titulo") String titulo){
		return LibroAccesodatos.buscar(titulo);
	}
}
