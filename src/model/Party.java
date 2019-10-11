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
	private Trainer Trainer;
	
	@OneToMany(cascade= CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(
			name="pokemon_list",joinColumns= {@JoinColumn(name="PARTY_ID",referencedColumnName="PARTY_ID")},
			inverseJoinColumns= {@JoinColumn(name="POKEMON_ID",referencedColumnName="POKEMON_ID",unique=true)}
			)
	private List<Pokemon> pokemonParty;
	
	public Party() {
		super();
	}
	
	public Party(String trainerName, model.Trainer trainer) {
		super();
		this.trainerName = trainerName;
		Trainer = trainer;
	}
	
	public String getPartyname() {
		return trainerName;
	}

	public void setPartyname(String trainerName) {
		this.trainerName = trainerName;
	}

	public Trainer getTrainer() {
		return Trainer;
	}

	public void setTrainer(Trainer trainer) {
		Trainer = trainer;
	}



	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public List<Pokemon> getPokemonParty() {
		return pokemonParty;
	}

	public void setPokemonParty(List<Pokemon> pokemonParty) {
		this.pokemonParty = pokemonParty;
	}

	@Override
	public String toString() {
		return "Party [partyId=" + partyId + ", trainerName=" + trainerName + ", Trainer=" + Trainer + ", pokemonParty="
				+ pokemonParty + "]";
	}



}