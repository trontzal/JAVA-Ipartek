package com.repaso.fullstack.accesodatos;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AccesoDatosJpa {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.repaso.fullstack.entidades");
	
	@FunctionalInterface
	public interface EntityManagerOperation<T>{
		T execute(EntityManager em);
	}
	
	public static <T> T executeInTransaction(EntityManagerOperation<T> operation) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			T result = operation.execute(em);
			t.commit();
			return result;
		} catch (RuntimeException e) {
			if(t.isActive()) {
				t.rollback();
			}
			throw new AccesoDatosException("No se han podido consulatar los cursos", e);
		} finally {
			em.close();
		}
	}
	

}
