package com.fidelity.movil.citations_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidelity.movil.citations_service.model.Citation;
import com.fidelity.movil.citations_service.repository.CitationRepository;
import com.fidelity.movil.citations_service.request.CitationRequest;
import com.fidelity.movil.citations_service.service.IMPCitationService.IMPCitationService;
import com.fidelity.movil.cliente_service.model.Client;
import com.fidelity.movil.manager_service.model.FidelityManager;
import com.fidelity.movil.manager_service.response.FidelityResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

@Service
public class CitationService implements IMPCitationService {

    private final CitationRepository _citationRepository;

    public CitationService(CitationRepository citationRepository) {
        _citationRepository = citationRepository;
    }

    @Override
    public Citation add(CitationRequest citation) {
        Citation oCitation = null;
        System.out.println("-------------------" + new Date()) ;
        System.out.println();
        try {
            oCitation = Citation.builder()
                    .id(citation.getId())
                    .date_citation(citation.getDate_citation())
                    .reason_citation(citation.getReason_citation())
                    .status_citation(citation.getStatus_citation())
                    .creation_date(new Date())
                    .update_citation(new Date())
                    .id_manager(getManagerById(citation.getId_manager()))
                    .id_client(getClientById(citation.getId_client()))
                    .build();
            _citationRepository.saveCitation(oCitation.getId(), oCitation.getDate_citation(), oCitation.getReason_citation(), oCitation.getStatus_citation(), oCitation.getCreation_date(), oCitation.getUpdate_citation(), oCitation.getId_manager().getId(), oCitation.getId_client().getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return oCitation;
    }

    @Override
    public List<Citation> getAllByManager(long id_manager) {
        return _citationRepository.findByManager(id_manager);
    }

    @Override
    public Citation getById(long id_citation) {
        return _citationRepository.findById(id_citation).get();
    }

    public Client getClientById(long id_client) {
        String uri = "http://localhost:8080/v1/fidelity/client?id_client=" + id_client;
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForEntity(uri, Client.class).getBody());
        System.out.println();
        return restTemplate.getForEntity(uri, Client.class).getBody();
    }

    public FidelityManager getManagerById(long id_manager) {
        String uri = "http://localhost:8080/v1/fidelity/manger?id_manager=" + id_manager;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(uri, FidelityManager.class).getBody();

    }
}
