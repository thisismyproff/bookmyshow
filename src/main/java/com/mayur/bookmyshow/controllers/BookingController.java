package com.mayur.bookmyshow.controllers;

import com.mayur.bookmyshow.dtos.BookingRequestDto;
import com.mayur.bookmyshow.dtos.BookingResponseDto;
import com.mayur.bookmyshow.dtos.ResponseStatus;
import com.mayur.bookmyshow.models.Booking;
import com.mayur.bookmyshow.models.BookingStatus;
import com.mayur.bookmyshow.services.BookingService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

public class BookingController {

    private BookingService bookingService;
    public BookingResponseDto bookMovie(BookingRequestDto bookingRequestDto){
        BookingResponseDto bookingResponseDto = new BookingResponseDto();
        Booking booking = null;
        try{
            booking = bookingService.bookMovie(
                    bookingRequestDto.getUserId(),
                    bookingRequestDto.getShowId(),
                    bookingRequestDto.getShowSeatIds());
        } catch (Exception e) {
        }
        if(booking!=null) {
            bookingResponseDto.setBookingId(booking.getId());
            bookingResponseDto.setAmount(booking.getAmount());
            bookingResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        } else {
            bookingResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return  bookingResponseDto;

    }
}
