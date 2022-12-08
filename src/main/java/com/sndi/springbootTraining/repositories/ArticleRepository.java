package com.sndi.springbootTraining.repositories;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sndi.springbootTraining.entities.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

	Optional<Article> findByName(String name);

	Set<Article> findByIdIn(List<Long> articles);

}
