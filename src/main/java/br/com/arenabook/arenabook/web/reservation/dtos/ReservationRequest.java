package br.com.arenabook.arenabook.web.reservation.dtos;

import java.time.LocalDateTime;

import br.com.arenabook.arenabook.core.enums.ReservationStatus;
import jakarta.validation.constraints.NotNull;

public class ReservationRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long courtId;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    @NotNull
    private ReservationStatus status;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getCourtId() {
        return courtId;
    }
    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    
    public ReservationStatus getStatus() {
        return status;
    }
    
    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
