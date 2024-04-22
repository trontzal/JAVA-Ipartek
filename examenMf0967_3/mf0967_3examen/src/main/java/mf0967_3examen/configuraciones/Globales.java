package mf0967_3examen.configuraciones;

import java.math.BigDecimal;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import mf0967_3examen.accesodatos.DaoLibro;
import mf0967_3examen.accesodatos.DaoLibroMemoria;
import mf0967_3examen.entidades.Libro;

public class Globales {
	
	public static final DaoLibro DAO_LIBRO = DaoLibroMemoria.getInstancia();
	public static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
	
	static {
	    DAO_LIBRO.darDeAlta(new Libro(null, "Libro 1 con título largo para ver si funciona bien", new BigDecimal(10), 20, "Autor 1", "https://picsum.photos/300/200"));
	    DAO_LIBRO.darDeAlta(new Libro(null, "Libro 2", new BigDecimal(144), null, null, null));
	    DAO_LIBRO.darDeAlta(new Libro(null, "Libro 3", new BigDecimal(25), 15, "Autor 2", "https://picsum.photos/300/200"));
	    DAO_LIBRO.darDeAlta(new Libro(null, "Libro 4", new BigDecimal(30), null, "Autor 3", "https://picsum.photos/300/200"));
	    DAO_LIBRO.darDeAlta(new Libro(null, "Libro 5", new BigDecimal(50), 10, "Autor 4", "https://picsum.photos/300/200"));
	    DAO_LIBRO.darDeAlta(new Libro(null, "Libro 6", new BigDecimal(20), null, null, "https://picsum.photos/300/200"));
	}

}
