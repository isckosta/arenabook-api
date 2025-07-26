package br.com.arenabook.arenabook.web.reservation.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arenabook.arenabook.core.services.ReservationService;
import br.com.arenabook.arenabook.web.reservation.dtos.ReservationRequest;
import br.com.arenabook.arenabook.web.reservation.dtos.ReservationResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Cria uma reserva
    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(
            @Valid @RequestBody ReservationRequest request) {
        ReservationResponse response = reservationService.createReservation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Busca uma reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservationResponse> getReservationById(@PathVariable Long id) {
        ReservationResponse response = reservationService.findById(id);
        return ResponseEntity.ok(response);
    }

    // Busca todas as reservas
    @GetMapping
    public ResponseEntity<List<ReservationResponse>> getAllReservations() {
        List<ReservationResponse> reservations = reservationService.findAll();
        return ResponseEntity.ok(reservations);
    }
}
