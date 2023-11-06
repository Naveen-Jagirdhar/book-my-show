package com.learnings.bookmyshow.entities;

import com.learnings.bookmyshow.enums.PaymentMethodType;
import com.learnings.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "PAYMENT")
public class Payment extends Auditable{

    private String reference;
    private Double amount;
    @Enumerated
    private PaymentMethodType paymentMethodType;
    @Enumerated
    private PaymentStatus paymentStatus;
}
