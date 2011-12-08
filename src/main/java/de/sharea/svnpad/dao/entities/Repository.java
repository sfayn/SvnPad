package de.sharea.svnpad.dao.entities;

import javax.persistence.*;

@Entity
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @OneToOne
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Basic
    private Boolean publicRepository;

    public Boolean getPublicRepository() {
        return publicRepository;
    }

    public void setPublicRepository(Boolean publicRepository) {
        this.publicRepository = publicRepository;
    }
}
