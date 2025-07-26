package br.com.arenabook.arenabook.core.mappers;

import br.com.arenabook.arenabook.core.models.Tenant;
import br.com.arenabook.arenabook.web.tenant.dtos.TenantRequest;
import br.com.arenabook.arenabook.web.tenant.dtos.TenantResponse;

public class TenantMapper {
    public static Tenant toEntity(TenantRequest request) {
        Tenant tenant = new Tenant();
        tenant.setName(request.getName());
        tenant.setDocument(request.getDocument());
        tenant.setEmail(request.getEmail());
        tenant.setPhone(request.getPhone());
        return tenant;
    }

    public static TenantResponse toResponse(Tenant tenant) {
        TenantResponse response = new TenantResponse();
        response.setId(tenant.getId());
        response.setName(tenant.getName());
        response.setDocument(tenant.getDocument());
        response.setEmail(tenant.getEmail());
        response.setPhone(tenant.getPhone());
        return response;
    }
}
