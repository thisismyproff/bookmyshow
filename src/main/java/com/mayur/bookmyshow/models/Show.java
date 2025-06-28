package com.mayur.bookmyshow.models;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity(name = "shows")
public class Show extends BaseModel{
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    private Date startTime;
    private Date endTime;
    @Enumerated
    @ElementCollection
    private List<Feature> features;

}
