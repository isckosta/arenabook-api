package br.com.arenabook.arenabook.web.reservation.dtos;

import java.time.LocalDateTime;

import br.com.arenabook.arenabook.core.enums.ReservationStatus;

public class ReservationResponse {
    private Long id;
    private Long userId;
    private Long courtId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Double totalValue;
    private ReservationStatus status;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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
    
    public Double getTotalValue() {
        return totalValue;
    }
    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
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
