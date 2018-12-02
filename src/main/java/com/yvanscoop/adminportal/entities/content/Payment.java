package com.yvanscoop.adminportal.entities.content;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPayement;

    private String type;
    private String cardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;

    @OneToOne(cascade = CascadeType.ALL)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "payment")
    private BillingAddress billingAddress;
}
