package br.com.arenabook.arenabook.core.exceptions.Reservation;

public class ReservationNotFoundException extends RuntimeException {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}
