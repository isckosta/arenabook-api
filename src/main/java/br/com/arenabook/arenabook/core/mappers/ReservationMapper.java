package br.com.arenabook.arenabook.core.mappers;

import java.math.BigDecimal;

import br.com.arenabook.arenabook.core.models.Court;
import br.com.arenabook.arenabook.core.models.Reservation;
import br.com.arenabook.arenabook.core.models.User;
import br.com.arenabook.arenabook.core.repositories.CourtRepository;
import br.com.arenabook.arenabook.core.repositories.UserRepository;
import br.com.arenabook.arenabook.web.reservation.dtos.ReservationRequest;
import br.com.arenabook.arenabook.web.reservation.dtos.ReservationResponse;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    
    private final CourtRepository courtRepository;
    private final UserRepository userRepository;
    
    public ReservationMapper(CourtRepository courtRepository, UserRepository userRepository) {
        this.courtRepository = courtRepository;
        this.userRepository = userRepository;
    }
    
    public Reservation toEntity(ReservationRequest request) {
        if (request == null) {
            return null;
        }
        
        Court court = courtRepository.findById(request.getCourtId())
            .orElseThrow(() -> new IllegalArgumentException("Court not found with id: " + request.getCourtId()));
            
        User user = userRepository.findById(request.getUserId())
            .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getUserId()));
        
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setCourt(court);
        reservation.setStartTime(request.getStartTime());
        reservation.setEndTime(request.getEndTime());
        reservation.setStatus(request.getStatus());
        
        return reservation;
    }

    public ReservationResponse toResponse(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        
        ReservationResponse response = new ReservationResponse();
        response.setId(reservation.getId());
        response.setUserId(reservation.getUser() != null ? reservation.getUser().getId() : null);
        response.setCourtId(reservation.getCourt() != null ? reservation.getCourt().getId() : null);
        response.setStartTime(reservation.getStartTime());
        response.setEndTime(reservation.getEndTime());
        response.setTotalValue(reservation.getTotalValue().doubleValue());
        response.setStatus(reservation.getStatus());
        
        return response;
    }
}
