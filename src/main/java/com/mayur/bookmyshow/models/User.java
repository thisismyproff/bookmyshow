package com.mayur.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.awt.print.Book;
import java.util.List;
@Entity
public class User extends BaseModel{
    private String name;
    private String email;
    private String username;
    private String password;
    @OneToMany
    private List<Booking> bookings;
}
