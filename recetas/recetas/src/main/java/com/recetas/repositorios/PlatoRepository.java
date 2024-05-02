package com.recetas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.recetas.entidades.Plato;

public interface PlatoRepository extends CrudRepository<Plato, Long> {

}
