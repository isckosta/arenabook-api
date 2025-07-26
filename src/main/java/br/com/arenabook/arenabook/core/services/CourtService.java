package br.com.arenabook.arenabook.core.services;

import br.com.arenabook.arenabook.core.models.Business;
import br.com.arenabook.arenabook.core.models.Court;
import br.com.arenabook.arenabook.core.repositories.CourtRepository;
import br.com.arenabook.arenabook.core.repositories.BusinessRepository;
    import br.com.arenabook.arenabook.core.mappers.CourtMapper;
import br.com.arenabook.arenabook.web.court.dtos.CourtRequest;
import br.com.arenabook.arenabook.web.court.dtos.CourtResponse;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourtService {

    private final CourtRepository courtRepository;
    private final BusinessRepository businessRepository;

    public CourtService(CourtRepository courtRepository, BusinessRepository businessRepository) {
        this.courtRepository = courtRepository;
        this.businessRepository = businessRepository;
    }

    public CourtResponse createCourt(CourtRequest request) {
        Court court = CourtMapper.toEntity(request);
        
        Business business = businessRepository.findById(request.getBusinessId())
                .orElseThrow(() -> new EntityNotFoundException("Business não encontrado"));
        court.setBusiness(business);

        Court saved = courtRepository.save(court);
        return CourtMapper.toResponse(saved);
    }

    public CourtResponse findById(Long id) {
        Court court = courtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quadra não encontrada"));
        return CourtMapper.toResponse(court);
    }

    public Court findEntityById(Long id) {
        return courtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quadra não encontrada"));
    }

    public List<CourtResponse> findAll() {
        return courtRepository.findAll().stream()
                .map(CourtMapper::toResponse)
                .collect(Collectors.toList());
    }
}
