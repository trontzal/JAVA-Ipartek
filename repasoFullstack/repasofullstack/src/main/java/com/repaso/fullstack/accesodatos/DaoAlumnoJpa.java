package com.repaso.fullstack.accesodatos;

import com.repaso.fullstack.dto.AlumnoDto;
import com.repaso.fullstack.dto.CursoDto;

public class DaoAlumnoJpa extends AccesoDatosJpa implements DaoAlumno {

	@Override
	public Iterable<AlumnoDto> obtenerTodos() {
		return AccesoDatosJpa.executeInTransaction(em -> em
				.createQuery("select a.id, a.nombre, a.apellidos, a.fechaNacimiento from Alumno a", AlumnoDto.class)
				.getResultList());
	}

	@Override
	public AlumnoDto obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoDto insertar(AlumnoDto objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoDto modificar(AlumnoDto objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void apuntarseACurso(Long idAlumno, Long idCurso) {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterable<CursoDto> cursos(Long idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

}
