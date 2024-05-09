package com.uf1643examen.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uf1643examen.entidades.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long>{

	Libro findByIsbn(Long isbn);
	Iterable<Libro> findByNombreContainingIgnoreCase(String nombre);
	
	// Pongo una query especifica para que solo haha una select para libros y autores
	@Query("SELECT l FROM Libro l JOIN FETCH l.autor")
	Iterable<Libro> todos();
}
