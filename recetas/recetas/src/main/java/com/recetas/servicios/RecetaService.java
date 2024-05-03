package com.recetas.servicios;

import com.recetas.entidades.Dificultad;
import com.recetas.entidades.Ingrediente;
import com.recetas.entidades.Plato;
import com.recetas.entidades.PlatoIngrediente;
import com.recetas.entidades.TipoCocina;
import com.recetas.entidades.Usuario;
import com.recetas.entidades.Valoracion;


public interface RecetaService {
	default void anadirIngrediente(Ingrediente ingrediente) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Ingrediente> listarIngredientes() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Dificultad> listarDificultades() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<TipoCocina> listarTiposCocina() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void anadirPlato(Plato plato) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default void anadirIngredienteAPlato(PlatoIngrediente platoIngrediente) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default void registrarUsuario(Usuario usuario) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default void loginUsuario(Usuario usuario) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default Iterable<Plato> listadoPlatos() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default Plato verPlato(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}

	default Iterable<PlatoIngrediente> verIngredientesPlato(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void valorarPlato(Valoracion valoracion) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
