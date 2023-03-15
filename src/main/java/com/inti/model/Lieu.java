package com.inti.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor @AllArgsConstructor
public class Lieu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeLieu;
	private String nomLieu;
	private int numRue;
	private String nomRue;
	private int nbFauteuils;
	
	@OneToMany
	@JoinTable(joinColumns = @JoinColumn(name ="id"))
	List<Concert> listeConcert;
}
