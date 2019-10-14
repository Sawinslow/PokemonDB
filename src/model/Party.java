package model;

import java.util.List;

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
	@Column(name = "PARTY_ID")
	private int partyId;
	@Column(name = "TRAINER_NAME")
	private String trainerName;
	@ManyToOne
	@JoinColumn(name = "TRAINER_ID")
	private Trainer trainer;
	
	@OneToMany(cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="pokemon_list",joinColumns= {@JoinColumn(name="PARTY_ID",referencedColumnName="PARTY_ID")},
			inverseJoinColumns= {@JoinColumn(name="POKEMON_ID",referencedColumnName="POKEMON_ID",unique=true)}
			)
	private List<Pokemon> pokemonParty;
	
	public Party() {
		super();
	}
	
	public Party(String trainerName, Trainer trainer) {
		super();
		this.trainerName = trainerName;
		this.trainer = trainer;
	}
	
	public Party(String trainerName, Trainer trainer, List<Pokemon> pokemonParty) {
		super();
		this.trainerName = trainerName;
		this.trainer = trainer;
		this.pokemonParty = pokemonParty;
	}

	

	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public List<Pokemon> getPokemonParty() {
		return pokemonParty;
	}

	public void setPokemonParty(List<Pokemon> pokemonParty) {
		this.pokemonParty = pokemonParty;
	}

	@Override
	public String toString() {
		return "Party [partyId=" + partyId + ", trainerName=" + trainerName + ", Trainer=" + trainer + ", pokemonParty="
				+ pokemonParty + "]";
	}



}