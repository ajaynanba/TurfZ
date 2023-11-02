package com.football.football.service;


import com.football.football.dto.resDto.BookingRes;
import com.football.football.entity.Booking;
import com.football.football.entity.User;
import com.football.football.repository.BookingRepository;
import com.football.football.repository.UserRepository;
import com.football.football.transformer.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;
    public String book(String email, LocalDateTime localDateTime) throws Exception {

        if(!userRepository.existsByEmail(email)){
            throw new Exception("Customer does not exist");
        }
        if(bookingRepository.existsByLocalDateTime(localDateTime)){
            throw new Exception("This time slot is already booked");
        }
        Booking booking = new Booking();
        booking.setEmail(email);
        booking.setLocalDateTime(localDateTime);
        booking.setUser(userRepository.findByEmail(email));
        bookingRepository.save(booking);


        return "Turf Booking completed successfully";

    }

    public List<BookingRes> getDetails(String email) throws Exception {
        if(!userRepository.existsByEmail(email)){
            throw new Exception("Customer does not exist");
        }
        User user = userRepository.findByEmail(email);
        List<Booking> bookings = user.getBookingList();
        List<BookingRes> bookingResList = new ArrayList<>();
        for(Booking booking : bookings){
            bookingResList.add(BookingTransformer.bookingToBookingResponse(booking));
        }
        return bookingResList;

    }

    public String cancelBooking(String email, LocalDateTime localDateTime) throws Exception {
        if(!userRepository.existsByEmail(email)){
            throw new Exception("Customer does not exist");
        }
        if(!bookingRepository.existsByLocalDateTime(localDateTime)){
            throw new Exception("There is no booking at this time");
        }
        Booking booking = bookingRepository.findByLocalDateTime(localDateTime);
        User user = userRepository.findByEmail(email);
        user.getBookingList().remove(booking);
        bookingRepository.delete(booking);

        return "Booking Cancelled successfully";
    }
}
