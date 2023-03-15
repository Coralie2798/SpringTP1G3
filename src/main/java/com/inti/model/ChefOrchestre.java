package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String Nationalite;
	private Double cachet;
	private String commentaires;
	public ChefOrchestre(String nom, String prenom, LocalDate dateNaissance, String nationalite, Double cachet,
			String commentaires) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		Nationalite = nationalite;
		this.cachet = cachet;
		this.commentaires = commentaires;
	}
	
	

}


