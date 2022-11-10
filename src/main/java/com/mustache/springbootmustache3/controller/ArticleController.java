package com.mustache.springbootmustache3.controller;

import com.mustache.springbootmustache3.domain.dto.ArticleDto;
import com.mustache.springbootmustache3.domain.entity.Article;
import com.mustache.springbootmustache3.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/new")
    public String createArticlePage() {
        return "new";
    }

    @PostMapping("")
    public String createArticle(ArticleDto articleDto) {
        log.info(articleDto.getTitle());
        Article savedArticle=articleRepository.save(articleDto.toEntity());
        return String.format("id : %d",savedArticle.getId()) ;
    }
}
