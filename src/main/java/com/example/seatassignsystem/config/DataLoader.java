package com.example.seatassignsystem.config;

import com.example.seatassignsystem.model.Seat;
import com.example.seatassignsystem.model.SeatStatus;
import com.example.seatassignsystem.repository.SeatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final SeatRepository seatRepository;

    public DataLoader(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public void run(String... args) {
        if (seatRepository.count() == 0) {
            for (int i = 1; i <= 10; i++) {
                Seat seat = Seat.builder()
                        .seatNumber(i)
                        .status(SeatStatus.AVAILABLE)
                        .build();
                seatRepository.save(seat);
            }
        }
    }
}
