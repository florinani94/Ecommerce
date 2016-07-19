package com.evozon.domain;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by vladblana on 19/07/2016.
 */
@Entity
public class Cart {

    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Entry> entrySet;

    @Column
    private Double total;

    @Column
    private String deliveryAddress;

    @Column
    private String billingAddress;

    public Cart(){

    }

    public Cart(int cartId, Set<Entry> entrySet, Double total, String deliveryAddress, String billingAddress) {
        this.cartId = cartId;
        this.entrySet = entrySet;
        this.total = total;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
    }

    public int getCartId() {

        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    public Set<Entry> getentrySet() {
        return entrySet;
    }

    public void setentrySet(Set<Entry> entrySet) {
        this.entrySet = entrySet;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", entrySet=" + entrySet +
                ", total=" + total +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                '}';
    }
}
