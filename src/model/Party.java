package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "party")
public class Party {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TRAINER_ID")
	private int Trainerid;
	@Column(name = "POKEMON_ID")
	private int pokemonid;
	@ManyToOne
	@JoinColumn(name = "TRAINER_ID")
	private Trainer Trainer;
	public Party(int trainerid, int pokemonid) {
		super();
		Trainerid = trainerid;
		this.pokemonid = pokemonid;
	}

	public Party() {
		super();
	}

	@Override
	public String toString() {
		return "party [Trainerid=" + Trainerid + ", pokemonid=" + pokemonid + "]";
	}

	public int getTrainerid() {
		return Trainerid;
	}

	public void setTrainerid(int trainerid) {
		Trainerid = trainerid;
	}

	public int getPokemonid() {
		return pokemonid;
	}

	public void setPokemonid(int pokemonid) {
		this.pokemonid = pokemonid;
	}

}