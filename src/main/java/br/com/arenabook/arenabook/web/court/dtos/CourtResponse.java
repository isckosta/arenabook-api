package br.com.arenabook.arenabook.web.court.dtos;

import java.math.BigDecimal;

import br.com.arenabook.arenabook.core.models.Business;

public class CourtResponse {
    private Long id;
    private String name;
    private BigDecimal pricePerHour;
    private String description;
    private Long businessId;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }
    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Long getBusinessId() {
        return businessId;
    }
    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }
}
