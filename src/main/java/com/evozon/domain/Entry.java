package com.evozon.domain;
import javax.persistence.*;
import java.io.Serializable;
/**
 * Created by vladblana on 19/07/2016.
 *
 * Auxiliary table to solve many to many relationship
 */
@Entity
public class Entry {

    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entryId;

    @ManyToOne
    @JoinColumn(name="cartId_FK")
    private Cart cart;

    @Column(nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double subTotal;

    public Entry(){

    }

    public Entry(Integer entryId, Cart cart, Product product, Integer quantity, Double subTotal) {
        this.entryId = entryId;
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }

    @ManyToOne
    @JoinColumn(name="cart_id", nullable = false)
    public Cart getCart() {

        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @OneToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="productId_FK")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "entryId=" + entryId +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
