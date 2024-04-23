package com.UF2218Examen.configuraciones;

import com.UF2218Examen.accesodatos.DaoLibro;
import com.UF2218Examen.accesodatos.DaoLibroMemoria;

import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;

public class Globales {

	public static final DaoLibro DAO_LIBRO = DaoLibroMemoria.getInstancia();

	public static final ValidatorFactory VALIDATOR_FACTORY = Validation.buildDefaultValidatorFactory();
	
	
//	static {
//		DAO_LIBRO.insertar(new Libro(null, "Libro prueba", new BigDecimal(10), null));
//	}
}
