package com.examen.uf2216.entidades.daos;

import java.util.ArrayList;

import com.examen.uf2216.entidades.Libro;

public class LibroDaoArrayList implements LibroDao<Libro> {

	private ArrayList<Libro> libro = new ArrayList<>();

	public LibroDaoArrayList() {
		libro.add(new Libro("El nombre del viento", 1234567890L, 500));
		libro.add(new Libro("Otro libro", 1234567891L, 1, true));
	}

	@Override
	public Iterable<Libro> obtenerTodos() {
		return libro;
	}

	@Override
	public Libro obtenerPorIsbn(Long isbn) {
		return libro.stream().filter(libro -> libro.getIsbn().equals(isbn)).findFirst().orElse(null);
	}

	@Override
	public Libro insertar(Libro nuevolibro) {
		libro.add(nuevolibro);
		return nuevolibro;
	}

}
