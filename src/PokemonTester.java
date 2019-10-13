import java.util.ArrayList;
import java.util.List;

import controller.PartyHelper;
import controller.PokemonHelper;
import controller.TrainerHelper;
import model.Party;
import model.Pokemon;
import model.Trainer;

//Use this for ease of use in testing different methods without using a web form
public class PokemonTester {

	public static void main(String[] args) {
		
		Trainer blue = new Trainer("Blue",16);
		TrainerHelper th = new TrainerHelper();
		
		th.insertTrainer(blue);
		
		Pokemon charmander = new Pokemon("Charmander", "Fire", 5, 25);
		Pokemon bulbsar = new Pokemon("bulbsar", "Leaf", 7, 50);
		
		List<Pokemon> Poke = new ArrayList<Pokemon>();
		
		Poke.add(bulbsar);
		Poke.add(charmander);
		
		Party blueParty = new Party("Blue's Party",blue);
		
		PartyHelper bluePartyHelper = new PartyHelper();
		
		blueParty.setTrainer(blue);
		th.insertTrainer(blue);
		blueParty.setPokemonParty(Poke);
		bluePartyHelper.insertParty(blueParty);
		
		List<Party> allPokemon = bluePartyHelper.showAllParty();
		
		for(Party p : allPokemon) {
			System.out.println(p.toString());
		}
		 
		
		
		
		
		
//		PokemonHelper ph = new PokemonHelper();
//		ph.insertPokemon(charmander);
//		List<Pokemon> allPokemon = ph.showAllPokemon();
//		
//		for(Pokemon p : allPokemon) {
//			System.out.println(p.toString());
//		}
	}

}
