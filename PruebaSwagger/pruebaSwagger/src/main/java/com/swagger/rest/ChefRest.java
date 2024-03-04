package com.swagger.rest;

import java.util.ArrayList;

import com.swagger.accesodatos.ChefAccesoDatos;
import com.swagger.dtos.ChefDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/chefs")
public class ChefRest {
	
	@GET
	public ArrayList<ChefDTO> obtenerTodos(){
		return ChefAccesoDatos.obtenerTodos();
	}
	
	@GET
	@Path("/{id}")
	public ChefDTO obtenerPorId(@PathParam("id") Long id) {
		return ChefAccesoDatos.obtenerPorId(id);
	}
}
