package com.shiraz.librarymanagement.controllers;

import com.shiraz.librarymanagement.domain.Booking;
import com.shiraz.librarymanagement.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("")
    public List<Booking> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @PutMapping("{memberId}/{bookId}")
    public Booking reserveBook(@PathVariable("memberId") Long memberId, @PathVariable("bookId") Long bookId) throws Exception{
        return bookingService.reserveBook(memberId, bookId);
    }

    @PutMapping("return/{memberId}/{bookId}")
    public Booking returnBook(@PathVariable("memberId") Long memberId, @PathVariable("bookId") Long bookId) throws Exception{
        return bookingService.returnBook(memberId, bookId);
    }

    @GetMapping("active")
    public List<Booking> getActiveBookings(){
        return bookingService.getActiveBookings();
    }

    @GetMapping("delayed")
    public List<Booking> getDelayedBookings(){
        return bookingService.getDelayedBookings();
    }
}
