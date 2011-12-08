package de.sharea.svnpad.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Commits {
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
    private Repository oneToOne;

    public Repository getOneToOne() {
        return oneToOne;
    }

    public void setOneToOne(Repository oneToOne) {
        this.oneToOne = oneToOne;
    }
}
