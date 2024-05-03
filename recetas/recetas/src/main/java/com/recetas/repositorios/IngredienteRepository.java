package com.recetas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.recetas.entidades.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

}
