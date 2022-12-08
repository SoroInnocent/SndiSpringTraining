package com.sndi.springbootTraining.service;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sndi.springbootTraining.dto.CommandeDto;
import com.sndi.springbootTraining.entities.Acheteur;
import com.sndi.springbootTraining.entities.Article;
import com.sndi.springbootTraining.entities.Commande;
import com.sndi.springbootTraining.entities.Livreur;
import com.sndi.springbootTraining.entities.StatutCommande;
import com.sndi.springbootTraining.entities.Vendeur;
import com.sndi.springbootTraining.repositories.AcheteurRepository;
import com.sndi.springbootTraining.repositories.ArticleRepository;
import com.sndi.springbootTraining.repositories.CommandeRepository;
import com.sndi.springbootTraining.repositories.LivreurRepository;
import com.sndi.springbootTraining.repositories.VendeurRepository;

@Service
public class CommandeService extends BaseService<Commande> {

	Logger logger = LoggerFactory.getLogger(CommandeService.class);

	private final CommandeRepository commandeRepository;
	private final ArticleRepository articleRepository;
	private final VendeurRepository vendeurRepository;
	private final AcheteurRepository acheteurRepository;
	private final LivreurRepository livreurRepository;

	public CommandeService(
		CommandeRepository commandeRepository,
		ArticleRepository articleRepository,
		VendeurRepository vendeurRepository,
		AcheteurRepository acheteurRepository,
		LivreurRepository livreurRepository
	) {

		this.commandeRepository = commandeRepository;
		this.articleRepository = articleRepository;
		this.vendeurRepository = vendeurRepository;
		this.acheteurRepository = acheteurRepository;
		this.livreurRepository = livreurRepository;
	}

	protected JpaRepository<Commande, Long> getRepository() {
		return this.commandeRepository;
	}

	protected Commande getNewInstance() {
		return new Commande();
	}

	protected Commande setData(Commande entity, Object dto) {
		CommandeDto commandeDto = (CommandeDto) dto;
		Acheteur acheteur = null;
		Vendeur vendeur = null;
		Livreur livreur = null;

		if ((commandeDto.idVendeur != null) && (commandeDto.idVendeur > 0)) {
			vendeur = vendeurRepository.findById(commandeDto.idVendeur).get();
		}

		if ((commandeDto.idAcheteur != null) && (commandeDto.idAcheteur > 0)) {
			acheteur = acheteurRepository.findById(commandeDto.idAcheteur).get();
		}

		if ((commandeDto.idLivreur != null) && (commandeDto.idLivreur > 0)) {
			livreur = livreurRepository.findById(commandeDto.idLivreur).get();
		}

		Set<Article> articles =  articleRepository.findByIdIn(commandeDto.articles);

		entity.setDate(new Date());
		entity.setCode(UUID.randomUUID().toString());
		entity.setVendeur(vendeur);
		entity.setAcheteur(acheteur);
		entity.setLivreur(livreur);
		entity.setArticles(articles);
		entity.setStatutCommande(StatutCommande.COMMANDE);

		return entity;
	}

	public Commande changerStatut(Long idCommande, CommandeDto dto) {
		Commande commande = null;

		try {
			commande = commandeRepository.findById(idCommande).get();

			if (dto.statutCommande == null) {
				StatutCommande statut = StatutCommande.valueOf(dto.statut);
				dto.statutCommande = statut;
			}

			Livreur livreur = null;

			if ((dto.idLivreur != null) && (dto.idLivreur > 0)) {
				livreur = livreurRepository.findById(dto.idLivreur).get();
			}

			commande.setStatutCommande(dto.statutCommande);
			commande.setLivreur(livreur);
			commandeRepository.save(commande);
		}
		catch (Exception e) {
		}

		return commande;
	}
}
