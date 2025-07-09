package com.example.seatassignsystem.controller;

import com.example.seatassignsystem.model.Booking;
import com.example.seatassignsystem.model.Seat;
import com.example.seatassignsystem.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @PostMapping("/book")
    public Booking bookSeat(@RequestParam String userName) {
        return seatService.autoAssignSeat(userName);
    }

    @GetMapping
    public List<Seat> listSeats() {
        return seatService.getAllSeats();
    }

    @GetMapping("/bookings")
    public List<Booking> listBookings() {
        return seatService.getAllBookings();
    }

    @DeleteMapping("/cancel/{bookingId}")
public String cancelBooking(@PathVariable Long bookingId) {
    seatService.cancelBooking(bookingId);
    return "Booking cancelled successfully!";
}

}
