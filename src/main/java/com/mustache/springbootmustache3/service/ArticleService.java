package com.mustache.springbootmustache3.service;

import com.mustache.springbootmustache3.domain.dto.ArticleAddRequest;
import com.mustache.springbootmustache3.domain.dto.ArticleAddResponse;
import com.mustache.springbootmustache3.domain.dto.ArticleDto;
import com.mustache.springbootmustache3.domain.dto.HospitalResponse;
import com.mustache.springbootmustache3.domain.entity.Article;
import com.mustache.springbootmustache3.domain.entity.Hospital;
import com.mustache.springbootmustache3.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDto getArticleById(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        Article article = optionalArticle.get();
        ArticleDto articleDto = Article.of(article);
        return articleDto;
    }

    public ArticleAddResponse addArticle(ArticleAddRequest dto) {
        Article article = dto.toEntity();
        Article savedArticle = articleRepository.save(article);
        return new ArticleAddResponse(savedArticle.getId(), savedArticle.getTitle(), savedArticle.getContent());
    }
}
