package com.evozon.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mihai on 7/12/2016.
 */
@Entity
@Table(name = "category")
public class Category {

    @Id
    private Integer id;

    @Column(nullable  = false, length = 30)
    private String name;

    @Column(nullable  = false, length = 30)
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> products = new HashSet<Product>();



    public Set<Product> getProducts() {
        return products;

    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Category() {
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Category(Integer id, String name, Set<Product> products, String description) {
        this.id = id;
        this.name = name;
        this.products = products;
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
