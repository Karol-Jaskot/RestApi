package pl.jaskot.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.jaskot.restapi.dao.entity.Article;

@Repository
public interface ArticleRepo extends CrudRepository<Article, Long> {
}
