package com.mustache.springbootmustache3.domain.dto;


import com.mustache.springbootmustache3.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleAddRequest {
    private String title;
    private String content;

    public Article toEntity(ArticleAddRequest dto) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        return article;
    }
}
