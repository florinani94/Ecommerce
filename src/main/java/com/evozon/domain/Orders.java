package com.evozon.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders extends Cart{

    public Orders() {
    }

    public Orders(int cartId, List<Entry> entryList, Double total, Address deliveryAddress, Address billingAddress, Payment payment, String email) {
        super(cartId, entryList, total, deliveryAddress, billingAddress, payment, email);
    }
}
