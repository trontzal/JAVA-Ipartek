package com.examen.uf2216.presentacion;

import com.examen.uf2216.entidades.Libro;
import com.examen.uf2216.entidades.bibliotecas.Consola;
import com.examen.uf2216.entidades.daos.DaoFabricaProvider;
import com.examen.uf2216.entidades.daos.LibroDao;
import com.examen.uf2216.entidades.daos.LibroDaoFabrica;

public class Presentacion {

	private static final String SALIR = "N";
	private static final boolean OBLIGATORIO = false;
	private static final boolean OPCIONAL = true;
	private static String ACEPTAR = "";

	public static void main(String[] args) {

		String opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (!opcion.equals(SALIR));

	}

	private static void mostrarMenu() {
		System.out.print("""

				Administracion Libros --------------

				""");
	}

	private static String pedirOpcion() {
		return Consola.leerString("Desea introducir un nuevo libro?? (S/N)", OBLIGATORIO);
	}

	private static void procesarOpcion(String opcion) {
		switch (opcion) {
		case "S" -> pedirDatos();
		case SALIR -> salir();

		default -> System.out.println("Opcion no reconocida");

		}
	}



	private static void pedirDatos() {
		Libro libro = pedirLibro();
		if (libro != null) {
			
			mostrarLibro(libro);
			ACEPTAR = pedirConfirmacion();
			switch (ACEPTAR) {
			case "S" -> insertarLibro(libro);
			case SALIR -> salir();
			}
			mostrarTodos();
			
		}else {
			System.out.println("El libro no puede ser nulo");
		}

	}

	private static Libro pedirLibro() {
	    String titulo = null;
	    Long isbn = null;
	    int nPaginas = 0;
	    boolean formato = false;

	    while (true) {
	        try {
	            if (titulo == null) {
	                titulo = Consola.leerString("Titulo del libro", OBLIGATORIO);
	            }
	            if (isbn == null) {
	                isbn = Consola.leerLong("ISBN del libro", OBLIGATORIO);
	            }
	            if (nPaginas == 0) {
	                nPaginas = Consola.leerInt("Numero de paginas del libro", OBLIGATORIO);
	            }
	            if (!formato) {
	                formato = Consola.leerBoolean("Formato del libro (true/false)", OPCIONAL);
	            }
	            return new Libro(titulo, isbn, nPaginas, formato);
	        } catch (RuntimeException e) {
	            System.out.println("Error: " + e.getMessage() + ". Por favor, inténtalo de nuevo.");
	            if (e.getMessage().contains("titulo")) {
	                titulo = null;
	            } else if (e.getMessage().contains("isbn")) {
	                isbn = null;
	            } else if (e.getMessage().contains("nPaginas")) {
	                nPaginas = 0;
	            }
	        }
	    }
	}






	private static void mostrarLibro(Libro libro) {
		System.out.println();
		System.out.println(libro);
		
	}

	private static String pedirConfirmacion() {
		return Consola.leerString("Seguro que desea introdicir este libro?? (S/N)", OBLIGATORIO);
	}

	private static void insertarLibro(Libro libroNuevo) {
		LibroDaoFabrica fabrica = new DaoFabricaProvider();

		LibroDao<Libro> dao = fabrica.getLibroDao();
		
		Libro libroInsertado = dao.insertar(libroNuevo);
		if (libroInsertado != null) {
	        System.out.println("Libro insertado correctamente: " + libroInsertado + "\n");
	    } else {
	        System.out.println("No se pudo insertar el libro.");
	    }
	}

	private static void mostrarTodos() {
		LibroDaoFabrica fabrica = new DaoFabricaProvider();
	
		LibroDao<Libro> dao = fabrica.getLibroDao();
		
		Iterable<Libro> todosLosLibros = dao.obtenerTodos();
		
		System.out.println("Estos son los libros que hay actualmente:");
		
		 for (Libro libro : todosLosLibros) {
		        System.out.println(libro);
		    }
		
	}

	private static void salir() {
		System.out.println("Hasta luego");
	}

}
