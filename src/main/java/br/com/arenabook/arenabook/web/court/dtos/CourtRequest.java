package br.com.arenabook.arenabook.web.court.dtos;

import java.math.BigDecimal;

import br.com.arenabook.arenabook.core.models.Business;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CourtRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotNull
    private BigDecimal pricePerHour;

    @NotBlank
    @Size(max = 255)
    private String description;

    @NotNull(message = "businessId é obrigatório")
    private Long businessId;

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
