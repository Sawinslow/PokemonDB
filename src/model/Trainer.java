package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "trainer")
public class Trainer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "TRAINER_ID")
	private int Trainer_ID;
	@Column(name = "TRAINER_NAME")
	private String Trainer_Name;
	@Column(name = "NUM_OF_BADGES")
	private int Num_of_badges;
	@Column(name = "birthday")
	private LocalDate birthday;

	public Trainer() {
		super();
	}


	public int getTrainer_ID() {
		return Trainer_ID;
	}


	public void setTrainer_ID(int trainer_ID) {
		Trainer_ID = trainer_ID;
	}


	public String getTrainer_Name() {
		return Trainer_Name;
	}


	public void setTrainer_Name(String trainer_Name) {
		Trainer_Name = trainer_Name;
	}


	public int getNum_of_badges() {
		return Num_of_badges;
	}


	public void setNum_of_badges(int num_of_badges) {
		Num_of_badges = num_of_badges;
	}


	public Trainer(int trainer_ID, String trainer_Name, int num_of_badges) {
		super();
		Trainer_ID = trainer_ID;
		Trainer_Name = trainer_Name;
		Num_of_badges = num_of_badges;
	}
	
	public Trainer(String trainer_Name, int num_of_badges) {
		super();
		Trainer_Name = trainer_Name;
		Num_of_badges = num_of_badges;
	}


	@Override
	public String toString() {
		return "trainer [Trainer_ID=" + Trainer_ID + ", Trainer_Name=" + Trainer_Name + ", Num_of_badges="
				+ Num_of_badges + "]";
	}
	
	
	
}