package com.mayur.bookmyshow.services;

import com.mayur.bookmyshow.models.Show;
import com.mayur.bookmyshow.models.ShowSeat;
import com.mayur.bookmyshow.models.ShowSeatType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingService {


    public Integer calculatePrice(List<ShowSeat> showSeats, ShowSeatType showSeatType, Show show){
         Integer price=0;

         return price;
    }
}
