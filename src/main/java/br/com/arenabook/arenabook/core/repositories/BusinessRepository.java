package br.com.arenabook.arenabook.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.arenabook.arenabook.core.models.Business;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    
}
