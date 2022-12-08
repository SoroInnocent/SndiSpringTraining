package com.sndi.springbootTraining.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sndi.springbootTraining.dto.ArticleDto;
import com.sndi.springbootTraining.entities.Article;
import com.sndi.springbootTraining.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController<Article, ArticleDto, ArticleService> {

	private final ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	protected ArticleService getService() {
		return articleService;
	}
}
