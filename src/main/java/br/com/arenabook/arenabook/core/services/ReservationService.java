package br.com.arenabook.arenabook.core.services;

import java.math.BigDecimal;

import br.com.arenabook.arenabook.core.models.Reservation;
import br.com.arenabook.arenabook.core.repositories.ReservationRepository;
import br.com.arenabook.arenabook.core.exceptions.Reservation.ReservationConflictException;
import br.com.arenabook.arenabook.core.exceptions.Reservation.ReservationNotFoundException;
import br.com.arenabook.arenabook.core.mappers.ReservationMapper;
import br.com.arenabook.arenabook.core.services.CourtService;
import br.com.arenabook.arenabook.web.reservation.dtos.ReservationRequest;
import br.com.arenabook.arenabook.web.reservation.dtos.ReservationResponse;
import br.com.arenabook.arenabook.core.models.Court;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final CourtService courtService;

    public ReservationService(
            ReservationRepository reservationRepository,
            ReservationMapper reservationMapper,
            CourtService courtService) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.courtService = courtService;
    }

    public ReservationResponse createReservation(ReservationRequest request) {
        if (request.getStartTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Horário inicial não pode estar no passado.");
        }

        if (request.getEndTime().isBefore(request.getStartTime())) {
            throw new IllegalArgumentException("Horário final não pode ser anterior ao horário inicial.");
        }

        Court court = courtService.findEntityById(request.getCourtId());

        if (hasConflict(court, request.getStartTime(), request.getEndTime())) {
            throw new ReservationConflictException("Já existe uma reserva para este horário nesta quadra.");
        }

        double totalValue = calculateTotalValue(
                court,
                request.getStartTime(),
                request.getEndTime());

        Reservation reservation = reservationMapper.toEntity(request);
        reservation.setTotalValue(new BigDecimal(totalValue));

        Reservation saved = reservationRepository.save(reservation);
        return reservationMapper.toResponse(saved);
    }

    public ReservationResponse findById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reserva não encontrada."));
        return reservationMapper.toResponse(reservation);
    }

    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<ReservationResponse> findByUser(Long userId) {
        return reservationRepository.findByUserId(userId).stream()
                .map(reservationMapper::toResponse)
                .collect(Collectors.toList());
    }

    private boolean hasConflict(Court court,
            LocalDateTime startTime,
            LocalDateTime endTime) {
        return !reservationRepository
                .findConflictingReservationsByCourt(
                        court, startTime, endTime)
                .isEmpty();
    }

    private double calculateTotalValue(Court court, LocalDateTime start, LocalDateTime end) {
        long minutes = java.time.Duration.between(start, end).toMinutes();
            double hours = minutes / 60.0;

        return hours * court.getPricePerHour().doubleValue();
    }
}
