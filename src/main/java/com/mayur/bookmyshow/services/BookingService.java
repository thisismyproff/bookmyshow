package com.mayur.bookmyshow.services;

import com.mayur.bookmyshow.exceptions.UserNotFoundException;
import com.mayur.bookmyshow.models.*;
import com.mayur.bookmyshow.repositories.ShowRepository;
import com.mayur.bookmyshow.repositories.ShowSeatRepository;
import com.mayur.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;

    @Autowired
    public BookingService(
            UserRepository userRepository,
            ShowRepository showRepository,
            ShowSeatRepository showSeatRepository
            ){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId , List<Long> showSeatsId) throws UserNotFoundException {
        Booking booking = new Booking();
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        User bookedBy = user.get();
        Optional<Show> show = showRepository.findById(showId);
        if(show.isEmpty()){
            throw new RuntimeException("Show not found");
        }
        Show bookedShow = show.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatsId);

        for(ShowSeat showSeat:showSeats) {
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new RuntimeException("Seat not available");
            }
        }
        List<ShowSeat> updatedShowSeats = new ArrayList<>();
        for(ShowSeat showSeat:showSeats) {
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            updatedShowSeats.add(showSeat);
        }
        showSeatRepository.saveAll(updatedShowSeats);
        booking.setUser(bookedBy);
        booking.setShow(bookedShow);
        booking.setBookedAt(new Date());
        booking.setShowSeats(updatedShowSeats);
        booking.setBookingStatus(BookingStatus.PENDING);






        return booking;
    }
 }
