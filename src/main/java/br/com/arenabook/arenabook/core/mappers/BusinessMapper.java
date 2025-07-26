package br.com.arenabook.arenabook.core.mappers;

import br.com.arenabook.arenabook.core.models.Business;
import br.com.arenabook.arenabook.web.business.dtos.BusinessRequest;
import br.com.arenabook.arenabook.web.business.dtos.BusinessResponse;

public class BusinessMapper {
    public static Business toEntity(BusinessRequest request) {
        Business business = new Business();
        business.setAddress(request.getAddress());
        business.setCity(request.getCity());
        business.setLatitude(request.getLatitude());
        business.setLongitude(request.getLongitude());
        business.setNeighborhood(request.getNeighborhood());
        business.setZipCode(request.getZipCode());
        return business;
    }

    public static BusinessResponse toResponse(Business business) {
        BusinessResponse response = new BusinessResponse();
        response.setId(business.getId());
        response.setAddress(business.getAddress());
        response.setCity(business.getCity());
        response.setLatitude(business.getLatitude());
        response.setLongitude(business.getLongitude());
        response.setNeighborhood(business.getNeighborhood());
        response.setZipCode(business.getZipCode());
        response.setTenantId(business.getTenant().getId());
        return response;
    }
}
