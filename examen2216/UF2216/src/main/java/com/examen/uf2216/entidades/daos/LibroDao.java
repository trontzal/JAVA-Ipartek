package com.examen.uf2216.entidades.daos;

public interface LibroDao<Libro> {
	Iterable<Libro> obtenerTodos();
	Libro obtenerPorIsbn(Long isbn);
	
	Libro insertar(Libro libro);
}
