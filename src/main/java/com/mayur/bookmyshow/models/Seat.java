package com.mayur.bookmyshow.models;

import jakarta.persistence.*;

@Entity
public class Seat extends BaseModel{
    private int rowVal;
    private int colVal;

    @Enumerated
    private SeatType seatType;
}
