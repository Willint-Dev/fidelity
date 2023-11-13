package com.fidelity.movil.citations_service.controller;

import com.fidelity.movil.citations_service.model.Citation;
import com.fidelity.movil.citations_service.request.CitationRequest;
import com.fidelity.movil.citations_service.route.MAIN;
import com.fidelity.movil.citations_service.service.CitationService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class CitationController {
    private final CitationService _citationService;

    public CitationController(CitationService citationService) {
        _citationService = citationService;
    }

    @GetMapping(MAIN.CITATION_MANAGER)
    public ResponseEntity<List<Citation>> getAllByManager(
            @RequestParam(name = "id_manager", defaultValue = "1") long id_manager) {
        List<Citation> lstCitations = _citationService.getAllByManager(id_manager);
        if (lstCitations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lstCitations);
    }

    @GetMapping(MAIN.CITATION_ID)
    public ResponseEntity<Citation> getById(@RequestParam(name = "id_citation", defaultValue = "1") long id_citation) {
        Citation oCitation = _citationService.getById(id_citation);
        if (oCitation == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(oCitation);
    }

    @PostMapping(MAIN.CITATION)
    public ResponseEntity<Citation> add(@RequestBody CitationRequest citation) {
        Citation oCitation = _citationService.add(citation);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(oCitation);
    }

}
