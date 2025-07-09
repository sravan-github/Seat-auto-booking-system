package com.example.seatassignsystem.repository;

import com.example.seatassignsystem.model.Seat;
import com.example.seatassignsystem.model.SeatStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    Optional<Seat> findFirstByStatus(SeatStatus status);
}
