package br.com.arenabook.arenabook.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arenabook.arenabook.core.models.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
    boolean existsByDocument(String document);
    boolean existsByEmail(String email);
}
