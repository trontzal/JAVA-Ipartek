package com.uf1643examen.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uf1643examen.entidades.Autor;
import com.uf1643examen.repositorios.AutorRepository;

@Service
public class AutorServiceImpl implements AutorService{

	@Autowired
	private AutorRepository autorRepository;

	@Override
	public void anadirAutor(Autor autor) {
		autorRepository.save(autor);
	}
	
	
}
