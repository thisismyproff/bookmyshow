package com.mayur.bookmyshow.dtos;


import com.mayur.bookmyshow.models.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDto {
    private Long bookingId;
    private ResponseStatus responseStatus;
    private int amount;
}
