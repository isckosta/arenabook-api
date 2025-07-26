package br.com.arenabook.arenabook.core.mappers;

import br.com.arenabook.arenabook.core.models.Court;
import br.com.arenabook.arenabook.web.court.dtos.CourtRequest;
import br.com.arenabook.arenabook.web.court.dtos.CourtResponse;

public class CourtMapper {
    
    public static Court toEntity(CourtRequest request) {
        Court court = new Court();
        court.setName(request.getName());
        court.setPricePerHour(request.getPricePerHour());
        court.setDescription(request.getDescription());
        return court;
    }

    public static CourtResponse toResponse(Court court) {
        CourtResponse response = new CourtResponse();
        response.setId(court.getId());
        response.setName(court.getName());
        response.setPricePerHour(court.getPricePerHour());
        response.setDescription(court.getDescription());
        response.setBusinessId(court.getBusiness().getId());
        return response;
    }
}
