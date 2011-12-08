package de.sharea.svnpad.dao.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Groups")
public class Group implements GrantedAuthority {
    @GeneratedValue
    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Spring Security Implementation

    @Override
    public String getAuthority() {
        if (name.equals("USER")) {
            return "USER";
        }
        return id + ":" + name;
    }
}
