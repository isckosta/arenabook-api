package br.com.arenabook.arenabook.web.court.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arenabook.arenabook.core.services.CourtService;
import br.com.arenabook.arenabook.web.court.dtos.CourtRequest;
import br.com.arenabook.arenabook.web.court.dtos.CourtResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/courts")
public class CourtController {
    private final CourtService courtService;

    public CourtController(CourtService courtService) {
        this.courtService = courtService;
    }

    @PostMapping
    public ResponseEntity<CourtResponse> createCourt(
            @Valid @RequestBody CourtRequest request) {
        CourtResponse response = courtService.createCourt(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourtResponse> getCourtById(@PathVariable Long id) {
        CourtResponse response = courtService.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CourtResponse>> getAllCourts() {
        List<CourtResponse> courts = courtService.findAll();
        return ResponseEntity.ok(courts);
    }
}
