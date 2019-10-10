package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
