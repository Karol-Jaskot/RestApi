package pl.jaskot.restapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.jaskot.restapi.dao.entity.Article;
import pl.jaskot.restapi.manager.ArticleManager;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/articles/", produces = "application/json")
public class ArticleController {

    private ArticleManager articleManager;

    @Autowired
    public ArticleController(ArticleManager articleManager) {
        this.articleManager = articleManager;
    }

    @GetMapping
    public Iterable<Article> getArticles(){
        return articleManager.findAll();
    }

    @GetMapping("{id}")
    public Optional<Article> getArticle(@PathVariable("id") Long id){
        return articleManager.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Article addArticle(@RequestBody Article article){
        return articleManager.save(article);
    }

    @PutMapping
    public Article updateArticle(@RequestBody Article article){
        return articleManager.save(article);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArticle(@PathVariable("id") Long id){
        articleManager.deleteById(id);
    }
}
