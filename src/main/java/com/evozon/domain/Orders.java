package com.evozon.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {

    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ordersId;

    @Column
    private String ordersKey;

    @Column
    private String status;

    @Column
    @Email
    private String email;

    @AttributeOverrides({
            @AttributeOverride(name="paymentMethod",column=@Column(name="paymentMethod")),
            @AttributeOverride(name="cardNumber",column=@Column(name="cardNumber")),
            @AttributeOverride(name="cardCode",column=@Column(name="cardCode")),
    })
    @Embedded
    private Payment payment;

    @Column
    private Double total;

    @OneToMany(targetEntity=Entry.class,mappedBy="cart",cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    private List<Entry> entryList;

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

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public String getOrdersKey() {
        return ordersKey;
    }

    public void setOrdersKey(String ordersKey) {
        this.ordersKey = ordersKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
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
}
