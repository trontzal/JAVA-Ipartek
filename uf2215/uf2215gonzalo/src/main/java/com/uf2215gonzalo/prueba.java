package com.uf2215gonzalo;

import com.uf2215gonzalo.accesodatos.LibroAccesodatos;

public class prueba {

	public static void main(String[] args) {
		System.out.println(LibroAccesodatos.obtenerTodos());
		System.out.println();
		System.out.println(LibroAccesodatos.buscar("J"));
	}

}
