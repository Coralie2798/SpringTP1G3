package com.inti.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Soliste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int nSoliste;
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String nationnalite;
}
