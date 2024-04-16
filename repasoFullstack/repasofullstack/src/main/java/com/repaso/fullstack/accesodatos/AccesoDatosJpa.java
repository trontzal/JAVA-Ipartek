package com.repaso.fullstack.accesodatos;

import java.util.function.Consumer;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AccesoDatosJpa {

	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.repaso.fullstack.entidades");

//	@FunctionalInterface
//	public interface EntityManagerOperation<T>{
//		T execute(EntityManager em);
//	}

	public static <T> T executeInTransaction(Function<EntityManager, T> lambda) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			t.begin();
			T result = lambda.apply(em);
			t.commit();
			return result;
		} catch (RuntimeException e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw new AccesoDatosException("No se han podido consulatar los cursos", e);
		} finally {
			em.close();
		}
	}

	public static void executeTransactionVoid(Consumer<EntityManager> lambda) {
		executeInTransaction(em -> {
			lambda.accept(em);
			return null;
		});
	}

}
