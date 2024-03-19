package com.examen.uf2216;

import com.examen.uf2216.entidades.Libro;
import com.examen.uf2216.entidades.daos.DaoFabricaProvider;
import com.examen.uf2216.entidades.daos.LibroDao;
import com.examen.uf2216.entidades.daos.LibroDaoFabrica;

public class pruebas {

	public static void main(String[] args) {
		LibroDaoFabrica fabrica = new DaoFabricaProvider();

		// Obtén una instancia del DAO
		LibroDao<Libro> dao = fabrica.getLibroDao();
		 // Crear un libro para insertar
	    Libro libroNuevo = new Libro("Otro", 9780345809L, 1178, false);

	    // Insertar el libro
	    dao.insertar(libroNuevo);

	    // Obtener todos los libros
	    Iterable<Libro> todosLosLibros = dao.obtenerTodos();

	    // Mostrar los libros obtenidos
	    System.out.println("Libros disponibles:");
	    for (Libro libro : todosLosLibros) {
	        System.out.println(libro);
	    }
	}
}
