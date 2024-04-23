package com.UF2218Examen.accesodatos;

public interface Dao<T> {
	
	Iterable<T> obtenerTodos();
	
	T insertar(T objeto);
}
