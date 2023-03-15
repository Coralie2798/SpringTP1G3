package com.inti.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Soliste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nSoliste;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationnalite;
	
	@ManyToMany
	@JoinTable(name="Soliste_Oeuvre", joinColumns = @JoinColumn(name="nSoliste"), inverseJoinColumns = @JoinColumn(name="nOeuvre"))
	List<Oeuvre>listeOeuvre;
	
	public Soliste(String nom, String prenom, LocalDate dateNaissance, String nationnalite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.nationnalite = nationnalite;
	}
	
	
}
