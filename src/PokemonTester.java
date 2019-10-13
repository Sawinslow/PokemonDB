import java.util.List;

import controller.PokemonHelper;
import model.Pokemon;

//Use this for ease of use in testing different methods without using a web form
public class PokemonTester {
// Tester
	public static void main(String[] args) {
		Pokemon charmander = new Pokemon("Charmander", "Fire", 5, 25);
		PokemonHelper ph = new PokemonHelper();
		ph.insertPokemon(charmander);
		List<Pokemon> allPokemon = ph.showAllPokemon();
		
		for(Pokemon p : allPokemon) {
			System.out.println(p.toString());
		}
	}

}
