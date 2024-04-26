package com.springpruebas.servicios;

import com.springpruebas.entidades.Producto;

public interface UsuarioNegocio {
	Iterable<Producto> obtenerTodos();
}
