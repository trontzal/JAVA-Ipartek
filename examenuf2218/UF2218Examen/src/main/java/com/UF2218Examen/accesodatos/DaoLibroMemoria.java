package com.UF2218Examen.accesodatos;

import java.util.TreeMap;

import com.UF2218Examen.entidades.Libro;

public class DaoLibroMemoria implements DaoLibro {

	private TreeMap<Long, Libro> libros = new TreeMap<>();

	// Singleton

	private DaoLibroMemoria() {
	}

	private static final DaoLibroMemoria INSTANCIA = new DaoLibroMemoria();

	public static final DaoLibroMemoria getInstancia() {
		return INSTANCIA;
	}

	// Fin singleton

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libros.values();
	}

	@Override
	public Libro insertar(Libro libro) {
		Long id = libros.size() > 0L ? libros.lastKey() + 1L: 1L;
		libro.setId(id);
		libros.put(	id, libro);
		
		return libro;
	}

}
