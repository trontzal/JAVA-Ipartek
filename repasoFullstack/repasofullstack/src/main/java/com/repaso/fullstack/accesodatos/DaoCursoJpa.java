package com.repaso.fullstack.accesodatos;

import com.repaso.fullstack.dto.CursoDto;

public class DaoCursoJpa implements DaoCurso {

//	private static final EntityManagerFactory emf = Persistence
//			.createEntityManagerFactory("com.repaso.fullstack.entidades");

	@Override
	public Iterable<CursoDto> obtenerTodos() {
		return AccesoDatosJpa.executeInTransaction(
				em -> em.createQuery("select c.id, c.nombre from Curso c", CursoDto.class).getResultList());
	}

	@Override
	public CursoDto obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoDto insertar(CursoDto objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CursoDto modificar(CursoDto objeto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(Long id) {
		// TODO Auto-generated method stub

	}

//	@Override
//	public Iterable<CursoDto> obtenerTodos() {
//		EntityTransaction t;
//		
//		EntityManager em = emf.createEntityManager();
//		t = em.getTransaction();
//		t.begin();
//		
//		List<CursoDto> cursos = em.createQuery("select c from Curso c", CursoDto.class).getResultList();
//		
//		t.commit();
//		
//		return cursos;
//	}
}
