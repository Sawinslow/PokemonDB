package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "POKEMON_ID")
	private int id;
	@Column(name = "POKEMON_NAME")
	private String name;
	@Column(name = "POKEMON_TYPE")
	private String type;
	@Column(name = "level")
	private int level;
	@Column(name = "HP")
	private int hp;
	
	//Default no args constructor
	public Pokemon() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public Pokemon(int id, String name, String type, int level, int hp) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.level = level;
		this.hp = hp;
	}
	@Override
	public String toString() {
		return "Pokemon [id=" + id + ", name=" + name + ", type=" + type + ", level=" + level + ", hp=" + hp + "]";
	}


	public Pokemon(String name, String type, int level, int hp) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
		this.hp = hp;
	}
	
	
}