package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Party;

public class PartyHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pokemon");

	public void insertParty(Party p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}

	public List<Party> showAllParty() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Party> allParty = em.createQuery("SELECT p FROM Party p").getResultList();
		return allParty;
	}
}
