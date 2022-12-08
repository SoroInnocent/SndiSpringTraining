package com.sndi.springbootTraining.entities;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Commande extends BaseEntity {
	private String code;

	private Date date;

	@ManyToMany
	private Set<Article> articles;

	@ManyToOne
	private Acheteur acheteur;

	@ManyToOne
	private Vendeur vendeur;

	@ManyToOne
	private Livreur livreur;

	@Enumerated(EnumType.STRING)
	private StatutCommande statutCommande;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<Article> getArticles() {
		return articles;
	}
	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}
	public Livreur getLivreur() {
		return livreur;
	}
	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}
	public Acheteur getAcheteur() {
		return acheteur;
	}
	public void setAcheteur(Acheteur acheteur) {
		this.acheteur = acheteur;
	}
	public StatutCommande getStatutCommande() {
		return statutCommande;
	}
	public void setStatutCommande(StatutCommande statutCommande) {
		this.statutCommande = statutCommande;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}
}
