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
    private Integer cartId;

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private Set<Entry> entrySet;

    @Column
    private Double total;

    @AttributeOverrides({
            @AttributeOverride(name="street",column=@Column(name="deliveryStreet")),
            @AttributeOverride(name="number",column=@Column(name="deliveryNumber")),
            @AttributeOverride(name="city",column=@Column(name="deliveryCity")),
            @AttributeOverride(name="phone",column=@Column(name="deliveryPhone"))
            })
    @Embedded
    private Address deliveryAddress;

    @AttributeOverrides({
            @AttributeOverride(name="street",column=@Column(name="billingStreet")),
            @AttributeOverride(name="number",column=@Column(name="billingNumber")),
            @AttributeOverride(name="city",column=@Column(name="billingCity")),
            @AttributeOverride(name="phone",column=@Column(name="billingPhone"))
    })
    @Embedded
    private Address billingAddress;

    public Cart(){

    }

    public Cart(int cartId, Set<Entry> entrySet, Double total, Address deliveryAddress, Address billingAddress) {
        this.cartId = cartId;
        this.entrySet = entrySet;
        this.total = total;
        this.deliveryAddress = deliveryAddress;
        this.billingAddress = billingAddress;
    }

    public int getCartId() {

        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    public Set<Entry> getEntrySet() {
        return entrySet;
    }

    public void setEntrySet(Set<Entry> entrySet) {
        this.entrySet = entrySet;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
   }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", entrySet=" + entrySet +
                ", total=" + total +
                ", deliveryAddress='" + deliveryAddress.toString() + '\'' +
                ", billingAddress='" + billingAddress.toString() + '\'' +
                '}';
    }
}
