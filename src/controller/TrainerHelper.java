package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Trainer;


public class TrainerHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pokemon");
	

	public void insertPokemon(Trainer t) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}
	

	public List<Trainer> showAllPokemon() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Trainer> allTrainers = em.createQuery("SELECT p FROM Pokemon p").getResultList();
		return allTrainers;
	}
}
