package pl.jaskot.restapi.manager.article;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.jaskot.restapi.dao.ArticleRepo;
import pl.jaskot.restapi.dao.entity.Article;

import java.util.Optional;

@SpringBootTest
public class ArticleManagerTest {

    @MockBean
    private ArticleRepo articleRepo;

    private ArticleManager articleManager;

    @BeforeEach
    void setUp() {
        articleManager = new ArticleManagerImpl(articleRepo);
    }

    @Test
    void findOneById() {
        Article article = new Article("Message", "Author");
        Mockito.when(articleRepo.findById(1L)).thenReturn(Optional.of(article));

        articleManager.save(article);
        assertEquals(article.hashCode(), (articleManager.findById(1L).hashCode()));
    }
}
