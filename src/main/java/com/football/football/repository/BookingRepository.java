package com.football.football.repository;

import com.football.football.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

        boolean existsByLocalDateTime(LocalDateTime localDateTime);

        Booking findByLocalDateTime(LocalDateTime localDateTime);
}
