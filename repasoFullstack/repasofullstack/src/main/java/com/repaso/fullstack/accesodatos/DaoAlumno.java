package com.repaso.fullstack.accesodatos;

import com.repaso.fullstack.dto.AlumnoDto;
import com.repaso.fullstack.dto.AlumnoLoginDto;
import com.repaso.fullstack.dto.CursoDto;

public interface DaoAlumno extends Dao<AlumnoDto>{
	void apuntarseACurso(Long idAlumno, Long idCurso);
	Iterable<CursoDto> cursos(Long idAlumno);
	
	AlumnoLoginDto buscarPorEmail(String email);

}
