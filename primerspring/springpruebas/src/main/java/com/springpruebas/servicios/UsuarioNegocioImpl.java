package com.springpruebas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springpruebas.entidades.Producto;
import com.springpruebas.repositorios.ProductoRepository;

@Service
public class UsuarioNegocioImpl implements UsuarioNegocio{

	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Iterable<Producto> obtenerTodos() {
		return repo.findAll();
	}

}
