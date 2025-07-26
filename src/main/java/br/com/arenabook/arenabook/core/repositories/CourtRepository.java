package br.com.arenabook.arenabook.core.repositories;

import br.com.arenabook.arenabook.core.models.Court;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourtRepository extends JpaRepository<Court, Long> {
}
