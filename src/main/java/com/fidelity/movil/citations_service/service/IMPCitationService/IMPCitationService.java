package com.fidelity.movil.citations_service.service.IMPCitationService;

import com.fidelity.movil.citations_service.model.Citation;

import java.util.List;

public interface IMPCitationService {
    Citation add(Citation citation);
    List<Citation> getAllByManager(long id_manager);
    Citation getById(long id_citation);
}
