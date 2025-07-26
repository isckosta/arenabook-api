package br.com.arenabook.arenabook.core.exceptions.Reservation;

public class ReservationConflictException extends RuntimeException {
    public ReservationConflictException(String message) {
        super(message);
    }
}
