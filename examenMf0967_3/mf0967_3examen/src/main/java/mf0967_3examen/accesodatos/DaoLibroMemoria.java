package mf0967_3examen.accesodatos;

import java.util.TreeMap;

import mf0967_3examen.entidades.Libro;

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
	public Iterable<Libro> listar() {
		return libros.values();
	}

	@Override
	public Libro darDeAlta(Libro libro) {
		Long id = libros.size() > 0L ? libros.lastKey() + 1L : 1L;
		libro.setId(id);
		libros.put(id, libro);

		return libro;
	}

	@Override
	public Libro modificar(Libro libro) {
		libros.put(libro.getId(), libro);

		return libro;
	}

	@Override
	public void eliminar(Long id) {
		libros.remove(id);
	}

	@Override
	public Libro obtenerPorId(Long id) {
		return libros.get(id);
	}

}
