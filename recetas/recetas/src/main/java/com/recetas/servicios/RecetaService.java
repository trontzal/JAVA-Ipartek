package com.recetas.servicios;

import com.recetas.entidades.Ingrediente;
import com.recetas.entidades.Plato;
import com.recetas.entidades.PlatoIngrediente;


public interface RecetaService {

	void anadirIngrediente(Ingrediente ingrediente);
	
	void anadirPlato(Plato plato);
	
	void anadirIngredienteAPlato(PlatoIngrediente platoIngrediente);
	
	Iterable<Plato> listadoPlatos();
	
	Plato verPlato();
	
}
