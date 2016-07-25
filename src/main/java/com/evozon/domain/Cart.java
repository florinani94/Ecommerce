package com.evozon.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

/**
 * Created by vladblana on 19/07/2016.
 */
@Entity
public class Cart {

    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<Entry> entryList;

    @Column
    private Double total;



    public Cart(){

    }

    public Cart(int cartId, List<Entry> entryList, Double total) {
        this.cartId = cartId;
        this.entryList = entryList;
        this.total = total;

    }

    public int getCartId() {

        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    public List<Entry> getEntryList() {
        return entryList;
    }

    public void settEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", entryList=" + entryList +
                ", total=" + total +
                '}';
    }
}
