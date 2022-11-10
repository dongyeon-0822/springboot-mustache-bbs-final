package com.mustache.springbootmustache3.repository;

import com.mustache.springbootmustache3.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
