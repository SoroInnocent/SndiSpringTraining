package com.sndi.springbootTraining.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Article extends BaseEntity {
	private String name;

	private String description;

	private double prix;

	@ManyToOne
	@JoinColumn(nullable = false)

	private Vendeur vendeur;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
}
