package com.sndi.springbootTraining;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sndi.springbootTraining.entities.Article;
import com.sndi.springbootTraining.entities.Vendeur;
import com.sndi.springbootTraining.repositories.ArticleRepository;
import com.sndi.springbootTraining.repositories.VendeurRepository;

@SpringBootTest
public class ArticleTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private VendeurRepository vendeurRepository;

    @Test
    public void testSave() {
        Vendeur vendeur = vendeurRepository.findById(1L).get();

        Article article = new Article();
        article.setName("Article_1");
        article.setDescription("Article 1");
        article.setPrix(2000);
        article.setVendeur(vendeur);
        articleRepository.save(article);

        Optional<Article> findedArticle = articleRepository.findByName("Article_1");
        article = findedArticle.orElse(null);
        assertNotNull(article);
    }
}
