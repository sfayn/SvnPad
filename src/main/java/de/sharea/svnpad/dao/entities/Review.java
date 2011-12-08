package de.sharea.svnpad.dao.entities;

import javax.persistence.*;
import java.util.List;


@Entity
public class Review {
    @GeneratedValue
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    private Commits oneToOne;

    public Commits getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(Commits oneToOne) {
        this.oneToOne = oneToOne;
    }

    @Basic
    private Integer score;

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @OneToMany
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
