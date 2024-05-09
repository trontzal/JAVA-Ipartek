package com.uf1643examen.servicios;

import com.uf1643examen.entidades.Libro;

public interface LibroService {
	default Iterable<Libro> listadoLibros() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default void anadirLibro(Libro libro) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Libro verLibro(Long id) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Libro buscarPorIsbn(Long isbn) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Libro> buscarPorNombre(String nombre) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
	
	default Iterable<Libro> todos() {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
