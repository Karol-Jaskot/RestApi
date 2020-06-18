package pl.jaskot.restapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.jaskot.restapi.dao.ArticleRepo;
import pl.jaskot.restapi.dao.entity.Article;

import java.util.Optional;

@Service
public class ArticleManager {

    private ArticleRepo articleRepo;

    @Autowired
    public ArticleManager(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public Optional<Article> findById(Long id){
        return articleRepo.findById(id);
    }

    public Iterable<Article> findAll(){
        return articleRepo.findAll();
    }

    public Article save(Article article){
        if(article.getAuthor()=="" || article.getAuthor() == null){
            return null;
        }
        return articleRepo.save(article);
    }

    public void deleteById(Long id){
        articleRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Article(1L, "Nowe info", "Stefan"));
        save(new Article(2L, "Następna message", "Franek"));
    }

}
