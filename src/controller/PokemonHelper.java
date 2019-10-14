package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Pokemon;

public class PokemonHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pokemon");
	
	/**
	 * Inserts a Pokemon object into the Pokemon table 
	 * @param Pokemon p - pokemon to be inserted
	 */
	public void insertPokemon(Pokemon p) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
	}
	
	/**
	 * Returns a list of all the pokemon from the database
	 * @return allPokemon
	 */
	public List<Pokemon> showAllPokemon() {
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Pokemon> allPokemon = em.createQuery("SELECT p FROM Pokemon p").getResultList();
		return allPokemon;
	}
	
	public Pokemon searchForPokemonById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Pokemon found = em.find(Pokemon.class, idToEdit);
		em.close();
		return found;
	}
	public void updatePokemon(Pokemon toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deletePokemon(Pokemon pokemonToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		//Query to delete based off user input
		TypedQuery<Pokemon> typedQuery = em.createQuery("select p from Pokemon p where p.id = :selectedid",Pokemon.class);
		
		// putting the id into the query 
		typedQuery.setParameter("selectedid", pokemonToDelete.getId());
		//Only getting one result so we only delete one thing no matter what
		typedQuery.setMaxResults(1);

		// Gets the result to remove it
		Pokemon result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
}
