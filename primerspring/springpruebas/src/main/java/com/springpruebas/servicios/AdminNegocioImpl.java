package com.springpruebas.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.springpruebas.entidades.Producto;
import com.springpruebas.repositorios.ProductoRepository;

import lombok.extern.java.Log;

@Service
@Primary
@Log
public class AdminNegocioImpl extends UsuarioNegocioImpl implements AdminNegocio{

	@Autowired
	private ProductoRepository repo;
	
	@Override
	public Producto insertarProducto(Producto producto) {
		log.info("Insertando el producto " + producto);
		return repo.save(producto);
	}

}
