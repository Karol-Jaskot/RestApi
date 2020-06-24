package pl.jaskot.restapi.manager.article;

import pl.jaskot.restapi.dao.entity.Article;

import java.util.Optional;

public interface ArticleManager {

    Optional<Article> findById(Long id);

    Iterable<Article> findAll();

    Article save(Article article);

    void deleteById(Long id);

}
