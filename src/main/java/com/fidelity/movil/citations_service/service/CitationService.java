package com.fidelity.movil.citations_service.service;

import com.fidelity.movil.citations_service.model.Citation;
import com.fidelity.movil.citations_service.repository.CitationRepository;
import com.fidelity.movil.citations_service.service.IMPCitationService.IMPCitationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitationService implements IMPCitationService {

    private final CitationRepository _citationRepository;

    public CitationService(CitationRepository citationRepository) {
        _citationRepository = citationRepository;
    }

    @Override
    public Citation add(Citation citation) {
        Citation oCitation = null;
        try {
            oCitation = _citationRepository.save(citation);
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
}
