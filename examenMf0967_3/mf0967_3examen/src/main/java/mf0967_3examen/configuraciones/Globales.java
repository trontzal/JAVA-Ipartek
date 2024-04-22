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
		DAO_LIBRO.darDeAlta(new Libro(null, "Libro 1", new BigDecimal(10), null, null, null));
		DAO_LIBRO.darDeAlta(new Libro(null, "Libro 2", new BigDecimal(144), 20, "Carlos Areilza", null));
	}
}
