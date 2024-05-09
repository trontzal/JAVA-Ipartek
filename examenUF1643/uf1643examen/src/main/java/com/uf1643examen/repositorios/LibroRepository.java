package com.uf1643examen.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.uf1643examen.entidades.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long>{

	Libro findByIsbn(Long isbn);
	Iterable<Libro> findByNombreContainingIgnoreCase(String nombre);
}
