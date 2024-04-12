package com.repaso.fullstack.accesodatos;

import com.repaso.fullstack.dto.CursoDto;

public interface DaoCurso extends Dao<CursoDto>{

	Iterable<CursoDto> obtenerTodos();
	
}
