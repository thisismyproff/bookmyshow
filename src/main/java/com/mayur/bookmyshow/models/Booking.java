package com.mayur.bookmyshow.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Booking extends BaseModel {
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;
    @ManyToOne
    private Show show;
    @ManyToMany
    private List<Seat> showSeats;
    @ManyToOne
    private User user;
    private Date bookedAt;
    private int amount;
    @OneToMany
    private List<Payment> payments;

}
