package pl.jaskot.restapi.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Calendar;
import java.util.Date;

@Data
@Entity
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String message;
    private String author;
    private Date createdTime;

    public Article(String message, String author) {
        this.message = message;
        this.author = author;
        createdTime = Calendar.getInstance().getTime();
    }

    public Article(Long id, String message, String author) {
        this.id = id;
        this.message = message;
        this.author = author;
        createdTime = Calendar.getInstance().getTime();
    }
}
