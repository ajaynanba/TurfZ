package com.football.football.transformer;

import com.football.football.dto.resDto.BookingRes;
import com.football.football.entity.Booking;

public class BookingTransformer {

    public static BookingRes bookingToBookingResponse(Booking booking){
        return BookingRes.builder().
                email(booking.getEmail()).
                localDateTime(booking.getLocalDateTime()).
                build();
    }
}
