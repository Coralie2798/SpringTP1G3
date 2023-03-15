package com.inti.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
