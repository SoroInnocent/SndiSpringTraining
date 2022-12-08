package com.sndi.springbootTraining.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.sndi.springbootTraining.dto.ArticleDto;
import com.sndi.springbootTraining.entities.Article;
import com.sndi.springbootTraining.entities.Vendeur;
import com.sndi.springbootTraining.repositories.ArticleRepository;
import com.sndi.springbootTraining.repositories.VendeurRepository;

@Service
public class ArticleService extends BaseService<Article> {

	private final ArticleRepository articleRepository;
	private final VendeurRepository vendeurRepository;

	public ArticleService(ArticleRepository articleRepository, VendeurRepository vendeurRepository) {
		this.articleRepository = articleRepository;
		this.vendeurRepository = vendeurRepository;
	}

	protected JpaRepository<Article, Long> getRepository() {
		return this.articleRepository;
	}

	protected Article getNewInstance() {
		return new Article();
	}

	protected Article setData(Article entity, Object dto) {
		ArticleDto articleDto = (ArticleDto) dto;
		Vendeur vendeur = null;

		if ((articleDto.idVendeur != null) && (articleDto.idVendeur > 0)) {
			vendeur = vendeurRepository.findById(articleDto.idVendeur).get();
		}

		entity.setName(articleDto.name);
		entity.setDescription(articleDto.description);
		entity.setPrix(articleDto.prix);
		entity.setVendeur(vendeur);

		return entity;
	}
}
