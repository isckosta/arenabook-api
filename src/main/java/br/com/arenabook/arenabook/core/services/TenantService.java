package br.com.arenabook.arenabook.core.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.arenabook.arenabook.core.exceptions.Tenant.TenantAlreadyExistsException;
import br.com.arenabook.arenabook.core.mappers.TenantMapper;
import br.com.arenabook.arenabook.core.models.Tenant;
import br.com.arenabook.arenabook.core.repositories.TenantRepository;
import br.com.arenabook.arenabook.web.tenant.dtos.TenantRequest;
import br.com.arenabook.arenabook.web.tenant.dtos.TenantResponse;

@Service
public class TenantService {
    private final TenantRepository tenantRepository;

    public TenantService(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    public TenantResponse createTenant(TenantRequest request) {
        if (tenantExists(request.getDocument(), request.getEmail())) {
            throw new TenantAlreadyExistsException("Locatário com documento " + request.getDocument() + " ou email " + request.getEmail() + " já existe.");
        }

        Tenant tenant = TenantMapper.toEntity(request);
        Tenant saved = tenantRepository.save(tenant);
        return TenantMapper.toResponse(saved);
    }

    public TenantResponse findById(Long id) {
        Tenant tenant = tenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locatário não encontrado"));
        return TenantMapper.toResponse(tenant);
    }

    public List<TenantResponse> findAll() {
        return tenantRepository.findAll().stream()
                .map(TenantMapper::toResponse)
                .collect(Collectors.toList());
    }

    private boolean tenantExists(String document, String email) {
        return tenantRepository.existsByDocument(document) || tenantRepository.existsByEmail(email);
    }
}
