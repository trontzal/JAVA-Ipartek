package com.uf1643examen.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uf1643examen.entidades.Libro;
import com.uf1643examen.repositorios.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	public Iterable<Libro> listadoLibros() {
		return libroRepository.findAll();
	}

	@Override
	public void anadirLibro(Libro libro) {
		libroRepository.save(libro);
	}

	@Override
	public Libro verLibro(Long id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	public Libro buscarPorIsbn(Long isbn) {
		return libroRepository.findByIsbn(isbn);
	}

	@Override
	public Iterable<Libro> buscarPorNombre(String nombre) {
		return libroRepository.findByNombreContainingIgnoreCase(nombre);
	}
	
	

}
