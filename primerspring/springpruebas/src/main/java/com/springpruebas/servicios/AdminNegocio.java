package com.springpruebas.servicios;

import com.springpruebas.entidades.Producto;

public interface AdminNegocio extends UsuarioNegocio{
	Producto insertarProducto(Producto producto);
}
