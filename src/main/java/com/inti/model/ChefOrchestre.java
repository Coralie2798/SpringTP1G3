package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class ChefOrchestre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationalite;
	private Double cachet;
	private String commentaires;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@jakarta.persistence.JoinColumn (name = "nOeuvre")
	private Oeuvre oeuvre;
	
	
	public ChefOrchestre(String nom, String prenom, LocalDate dateNaissance, String nationalite, Double cachet,
			String commentaires) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationalite = nationalite;
		this.cachet = cachet;
		this.commentaires = commentaires;
	}
	
	

}


