package com.springpruebas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.springpruebas.entidades.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long> {
	// Introducir metodos unicos para productos
}
