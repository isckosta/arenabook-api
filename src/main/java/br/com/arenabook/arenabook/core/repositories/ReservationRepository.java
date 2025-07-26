package br.com.arenabook.arenabook.core.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.arenabook.arenabook.core.models.Court;
import br.com.arenabook.arenabook.core.models.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUserId(Long userId);
    
    @Query("""
        SELECT r
        FROM Reservation r
        WHERE r.court = :court
          AND r.startTime < :end
          AND r.endTime > :start
    """)
    List<Reservation> findConflictingReservationsByCourt(
            Court court,
            LocalDateTime start,
            LocalDateTime end
    );
}
