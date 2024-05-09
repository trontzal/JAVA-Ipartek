package com.uf1643examen.servicios;

import com.uf1643examen.entidades.Autor;

public interface AutorService {
//	default Iterable<Autor> listadoAutores() {
//		throw new UnsupportedOperationException("NO IMPLEMENTADO");
//	}
	
	default void anadirAutor(Autor autor) {
		throw new UnsupportedOperationException("NO IMPLEMENTADO");
	}
}
