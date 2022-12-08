package com.sndi.springbootTraining.dto;

import java.util.List;

import com.sndi.springbootTraining.entities.StatutCommande;

public class CommandeDto {
	public String code;
	public String date;
	public Long idVendeur;
	public Long idAcheteur;
	public Long idLivreur;
	public List<Long> articles;
	public StatutCommande statutCommande;
	public String statut;
}
