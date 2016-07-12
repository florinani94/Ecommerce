package com.evozon.domain;

import javax.persistence.*;

/**
 * Created by mihai on 7/12/2016.
 */
@Entity
public class Category {

    @Id
    private Integer id;

    @Column(nullable  = false, length = 30)
    private String name;

    @Column(nullable  = false, length = 30)
    private String description;

    public Category() {
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
