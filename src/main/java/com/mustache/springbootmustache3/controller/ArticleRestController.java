package com.mustache.springbootmustache3.controller;

import com.mustache.springbootmustache3.domain.dto.ArticleAddRequest;
import com.mustache.springbootmustache3.domain.dto.ArticleAddResponse;
import com.mustache.springbootmustache3.domain.dto.ArticleDto;
import com.mustache.springbootmustache3.domain.dto.HospitalResponse;
import com.mustache.springbootmustache3.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {
    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id) { // ResponseEntity도 DTO타입
        ArticleDto articleDto = articleService.getArticleById(id); // DTO
        return ResponseEntity.ok().body(articleDto); // Return은 DTO로
    }

    @PostMapping
    public ResponseEntity<ArticleAddResponse> addArticle(@RequestBody ArticleAddRequest dto) {
        ArticleAddResponse response = articleService.addArticle(dto);
        return ResponseEntity.ok().body(response);
    }
}
