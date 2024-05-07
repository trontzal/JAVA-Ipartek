package com.recetas.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.recetas.entidades.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

}
