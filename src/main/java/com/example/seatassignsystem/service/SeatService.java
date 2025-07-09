package com.example.seatassignsystem.service;

import com.example.seatassignsystem.model.*;
import com.example.seatassignsystem.repository.BookingRepository;
import com.example.seatassignsystem.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;
    private final BookingRepository bookingRepository;

    public SeatService(SeatRepository seatRepository, BookingRepository bookingRepository) {
        this.seatRepository = seatRepository;
        this.bookingRepository = bookingRepository;
    }

    public Booking autoAssignSeat(String userName) {
        Seat availableSeat = seatRepository
                .findFirstByStatus(SeatStatus.AVAILABLE)
                .orElseThrow(() -> new RuntimeException("No available seats!"));

        availableSeat.setStatus(SeatStatus.BOOKED);
        seatRepository.save(availableSeat);

        Booking booking = Booking.builder()
                .userName(userName)
                .seat(availableSeat)
                .build();

        return bookingRepository.save(booking);
    }

    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void cancelBooking(Long bookingId) {
    Booking booking = bookingRepository
            .findById(bookingId)
            .orElseThrow(() -> new RuntimeException("Booking not found!"));

    Seat seat = booking.getSeat();
    seat.setStatus(SeatStatus.AVAILABLE);
    seatRepository.save(seat);

    bookingRepository.delete(booking);
}

}
