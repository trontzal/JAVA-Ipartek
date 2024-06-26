package com.repaso.fullstack.accesodatos;

import com.repaso.fullstack.dto.CursoDto;
import com.repaso.fullstack.entidades.Curso;

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
		return AccesoDatosJpa.executeInTransaction(
				em -> em.createQuery("select c.id, c.nombre from Curso c where c.id = :id", CursoDto.class)
						.setParameter("id", id).getSingleResult());
	}

	@Override
	public CursoDto insertar(CursoDto curso) {
		return AccesoDatosJpa.executeInTransaction(em -> {
			Curso c = new Curso(null, curso.nombre(), null);
			em.persist(c);
			return new CursoDto(c.getId(), c.getNombre());
		});
	}

	@Override
	public CursoDto modificar(CursoDto curso) {
		return AccesoDatosJpa.executeInTransaction(em->{
			if(curso.id() == null) {
				throw new AccesoDatosException("Para modificar un curso es necesario el id");
			}else {
				Curso c = new Curso(curso.id(), curso.nombre(), null);
				em.merge(c);
				return new CursoDto(c.getId(), c.getNombre());
			}
		});
	}

	@Override
	public void borrar(Long id) {
		AccesoDatosJpa.executeTransactionVoid(em-> em.remove(em.find(Curso.class, id)));
	}

	// Forma de hacerlo sin el lambda
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
