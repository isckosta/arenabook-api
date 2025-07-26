package br.com.arenabook.arenabook.core.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.arenabook.arenabook.core.exceptions.Business.BusinessNotFoundException;
import br.com.arenabook.arenabook.core.exceptions.Tenant.TenantNotFoundException;
import br.com.arenabook.arenabook.core.mappers.BusinessMapper;
import br.com.arenabook.arenabook.core.models.Business;
import br.com.arenabook.arenabook.core.models.Tenant;
import br.com.arenabook.arenabook.core.repositories.BusinessRepository;
import br.com.arenabook.arenabook.core.repositories.TenantRepository;
import br.com.arenabook.arenabook.web.business.dtos.BusinessRequest;
import br.com.arenabook.arenabook.web.business.dtos.BusinessResponse;

@Service
public class BusinessService {
    private final BusinessRepository businessRepository;
    private final TenantRepository tenantRepository;

    public BusinessService(BusinessRepository businessRepository, TenantRepository tenantRepository) {
        this.businessRepository = businessRepository;
        this.tenantRepository = tenantRepository;
    }

    public BusinessResponse createBusiness(BusinessRequest request) {

        Tenant tenant = tenantRepository.findById(request.getTenantId())
                .orElseThrow(() -> new TenantNotFoundException("Locatário com ID " + request.getTenantId() + " não encontrado."));
                
        Business business = BusinessMapper.toEntity(request);
        business.setTenant(tenant);

        Business saved = businessRepository.save(business);
        return BusinessMapper.toResponse(saved);
    }

    public List<BusinessResponse> getAllBusinesses() {
        return businessRepository.findAll().stream().map(BusinessMapper::toResponse).collect(Collectors.toList());
    }

    public BusinessResponse getBusinessById(Long id) {
        return businessRepository.findById(id)
                .map(BusinessMapper::toResponse)
                .orElseThrow(() -> new BusinessNotFoundException("Business com ID " + id + " não encontrado."));
    }
}
