package com.evozon.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vladblana on 25/07/2016.
 */
@Entity
public class Order {
    @Column(nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

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

    @Column
    private Payment payment;//vezi tu cum faci aici poate trebuie cu embedded

    @Column
    @Email
    private String email;

    @Column
    private String status;

    @Column
    private List<Entry> entryList;

    @Column
    private Double total;

    public Order(){
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public List<Entry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<Entry> entryList) {
        this.entryList = entryList;
    }
}
