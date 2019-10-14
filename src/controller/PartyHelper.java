package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	 	public Party searchForTrainerById(Integer id) {
		EntityManager em = emfactory.createEntityManager();
		//Starting transaction
		em.getTransaction().begin();
		//Uses the em.find method to get the Party they are trying to delete
		Party idFound = em.find(Party.class, id);
		em.close();
		return idFound;
	}
	 
	 	public void deleteTrainer(Party partyToDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			//Query to delete based off user input
			TypedQuery<Party> typedQuery = em.createQuery("select d from Party d where d.partyId = :selectedid",Party.class);
			
			// putting the id into the query 
			typedQuery.setParameter("selectedid", partyToDelete.getPartyId());
			//Only getting one result so we only delete one thing no matter what
			typedQuery.setMaxResults(1);

			// Gets the result to remove it
			Party result = typedQuery.getSingleResult();
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			
		}
	 
}
