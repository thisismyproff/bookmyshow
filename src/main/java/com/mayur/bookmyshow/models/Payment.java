package com.mayur.bookmyshow.models;

import jakarta.persistence.*;

@Entity
public class Payment extends  BaseModel{
    private String refNumber;
    private int amount;

    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
