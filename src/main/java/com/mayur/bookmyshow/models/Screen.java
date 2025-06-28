package com.mayur.bookmyshow.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Screen extends BaseModel{
    private String name;
    @Enumerated
    @ElementCollection
    private List<Feature> features;
    @OneToMany
    private List<Seat> seats;

}
