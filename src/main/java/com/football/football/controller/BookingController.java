package com.football.football.controller;


import com.football.football.dto.resDto.BookingRes;
import com.football.football.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/turf")
public class BookingController {

    @Autowired
    BookingService bookingService;
    @PostMapping("/book")
    public String book(@RequestParam("email") String email, @RequestParam("time")LocalDateTime localDateTime) throws Exception {
        return bookingService.book(email, localDateTime);
    }

    @GetMapping("/getDetails")
    public List<BookingRes> getDetails(@RequestParam("email")String email) throws Exception {
        return bookingService.getDetails(email);
    }

    @DeleteMapping("/cancel")
    public String cancel(@RequestParam("email") String email, @RequestParam("time")LocalDateTime localDateTime) throws Exception {
        return bookingService.cancelBooking(email, localDateTime);
    }
}
