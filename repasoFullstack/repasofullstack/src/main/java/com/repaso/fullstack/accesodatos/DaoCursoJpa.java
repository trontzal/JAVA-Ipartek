package com.repaso.fullstack.accesodatos;

import java.util.List;

import com.repaso.fullstack.dto.CursoDto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoCursoJpa implements DaoCurso{

	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.repaso.fullstack.entidades");
	
	@Override
	public Iterable<CursoDto> obtenerTodos() {
		EntityTransaction t;
		
		EntityManager em = emf.createEntityManager();
		t = em.getTransaction();
		t.begin();
		
		List<CursoDto> cursos = em.createQuery("select c from Curso c", CursoDto.class).getResultList();
		
		t.commit();
		
		return cursos;
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

}
