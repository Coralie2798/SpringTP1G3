package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Concert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private LocalDate dateConcert;

	@ManyToOne
	@JoinColumn(name="idOeuvreC")
	private Oeuvre oeuvreC;
	
	@ManyToOne
	@JoinColumn(name = "codeLieu")
	private Lieu lieuC;


	public Concert(String nom, LocalDate dateConcert) {
		super();
		this.nom = nom;
		this.dateConcert = dateConcert;
	}

	public Concert(String nom, LocalDate dateConcert, Oeuvre oeuvreC) {
		super();
		this.nom = nom;
		this.dateConcert = dateConcert;
		this.oeuvreC = oeuvreC;
	}
	
	
	
}
