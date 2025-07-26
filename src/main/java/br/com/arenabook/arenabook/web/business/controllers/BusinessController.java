package br.com.arenabook.arenabook.web.business.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.arenabook.arenabook.core.services.BusinessService;
import br.com.arenabook.arenabook.web.business.dtos.BusinessRequest;
import br.com.arenabook.arenabook.web.business.dtos.BusinessResponse;

@RestController
@RequestMapping("/businesses")
public class BusinessController {
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping
    public List<BusinessResponse> getAllBusinesses() {
        return businessService.getAllBusinesses();
    }

    @GetMapping("/{id}")
    public BusinessResponse getBusinessById(@PathVariable Long id) {
        return businessService.getBusinessById(id);
    }

    @PostMapping
    public BusinessResponse createBusiness(@RequestBody BusinessRequest request) {
        return businessService.createBusiness(request);
    }
}
