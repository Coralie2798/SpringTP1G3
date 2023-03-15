package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
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
@AllArgsConstructor
@NoArgsConstructor
public class Oeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nOeuvre;
	private String nom;
	private int duree;
	
	@ManyToMany
	@JoinTable(name="Soliste_Oeuvre", joinColumns = @JoinColumn(name="nOeuvre"), inverseJoinColumns = @JoinColumn(name="nSoliste"))
	List<Soliste>listeSolistes;
	
	@OneToMany(mappedBy = "oeuvreC")
	private List<Concert> concert;
	
	
	public Oeuvre(String nom, int duree) {
		super();
		this.nom = nom;
		this.duree = duree;
	}
	
}
