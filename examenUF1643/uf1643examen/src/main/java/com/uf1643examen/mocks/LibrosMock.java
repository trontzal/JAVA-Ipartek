package com.uf1643examen.mocks;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.uf1643examen.entidades.Autor;
import com.uf1643examen.entidades.Libro;
import com.uf1643examen.repositorios.AutorRepository;
import com.uf1643examen.repositorios.LibroRepository;

@Component
public class LibrosMock {
	public LibrosMock(LibroRepository libroRepository, AutorRepository autorRepository) {

		var autor1 = autorRepository.save(Autor.builder().nombre("Eduardo").build());
		var autor2 = autorRepository.save(Autor.builder().nombre("Ana").build());

		for (int i = 1; i <= 10; i++) {
			Autor autor = i % 2 == 0 ? autor1 : autor2;
			libroRepository.save(Libro.builder().nombre("Libro mock " + i).precio(new BigDecimal(10 + i)).autor(autor)
					.isbn(9783161484100L + i).build());
		}
	}
}
