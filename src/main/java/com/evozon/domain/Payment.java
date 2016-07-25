package com.evozon.domain;

import javax.persistence.Entity;

/**
 * Created by vladblana on 25/07/2016.
 */
@Entity
public class Payment {

    private String paymentMethod;

    private String cardNumber;

    private String cardCode;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }
}
