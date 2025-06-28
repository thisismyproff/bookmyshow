package com.mayur.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;
    @Enumerated
    private SeatType seatType;
    private int price;
}
