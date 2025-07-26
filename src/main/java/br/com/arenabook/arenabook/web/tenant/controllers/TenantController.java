package br.com.arenabook.arenabook.web.tenant.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arenabook.arenabook.core.services.TenantService;
import br.com.arenabook.arenabook.web.tenant.dtos.TenantRequest;
import br.com.arenabook.arenabook.web.tenant.dtos.TenantResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tenants")
public class TenantController {
    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping
    public ResponseEntity<TenantResponse> createTenant(
            @Valid @RequestBody TenantRequest request) {
        TenantResponse response = tenantService.createTenant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantResponse> getTenantById(@PathVariable Long id) {
        TenantResponse response = tenantService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TenantResponse>> getAllTenants() {
        List<TenantResponse> tenants = tenantService.findAll();
        return ResponseEntity.ok(tenants);
    }
}
