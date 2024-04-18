package com.repaso.fullstack.accesodatos;

import com.repaso.fullstack.dto.AlumnoDto;
import com.repaso.fullstack.dto.AlumnoLoginDto;
import com.repaso.fullstack.dto.CursoDto;
import com.repaso.fullstack.entidades.Alumno;

public class DaoAlumnoJpa extends AccesoDatosJpa implements DaoAlumno {

	@Override
	public Iterable<AlumnoDto> obtenerTodos() {
		return AccesoDatosJpa.executeInTransaction(em -> em
				.createQuery("select a.id, a.nombre, a.apellidos, a.fechaNacimiento from Alumno a", AlumnoDto.class)
				.getResultList());
	}

	@Override
	public AlumnoDto obtenerPorId(Long id) {
		return AccesoDatosJpa.executeInTransaction(em -> em
				.createQuery("select a.id, a.nombre, a.apellidos, a.fechaNacimiento from Alumno a where id = :id",
						AlumnoDto.class)
				.setParameter("id", id).getSingleResult());
	}

	@Override
	public AlumnoDto insertar(AlumnoDto alumno) {
		return AccesoDatosJpa.executeInTransaction(em -> {
			Alumno a = new Alumno(null, alumno.nombre(), alumno.apellidos(), alumno.fechaNacimiento(), null, null);
			em.persist(a);
			return new AlumnoDto(a.getId(), a.getNombre(), a.getApellidos(), a.getFechaNacimiento());
		});
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
		AccesoDatosJpa.executeTransactionVoid(em ->{
			em.createNativeQuery("INSERT INTO cursos_alumnos (cursos_id, alumnos_id) VALUES (:idCurso, :idAlumno)").setParameter("idAlumno", idAlumno).setParameter("idCurso", idCurso).executeUpdate();
		});
	}

	@Override
	public Iterable<CursoDto> cursos(Long idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AlumnoLoginDto buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
