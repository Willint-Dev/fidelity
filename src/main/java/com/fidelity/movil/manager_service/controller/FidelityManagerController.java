package com.fidelity.movil.manager_service.controller;

import com.fidelity.movil.citations_service.route.MAIN;
import com.fidelity.movil.cliente_service.routes.ROUTE;
import com.fidelity.movil.manager_service.model.FidelityManager;
import com.fidelity.movil.manager_service.request.FidelityManagerRequest;
import com.fidelity.movil.manager_service.response.FidelityResponse;
import com.fidelity.movil.manager_service.service.FidelityManagerService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ROUTE.MAIN)
public class FidelityManagerController {
    private final FidelityManagerService _fidelityManagerService;

    public FidelityManagerController(FidelityManagerService fidelityManagerService) {
        _fidelityManagerService = fidelityManagerService;
    }

    @GetMapping(ROUTE.FIDELITY_MANAGER)
    public ResponseEntity<Optional<FidelityManager>> getById(@RequestParam(value = "id_manager", defaultValue = "0") long id) {
        Optional<FidelityManager> response = _fidelityManagerService.findById(id);
        if (response == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);

        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(ROUTE.FIDELITY_MANAGER_ALL)
    public ResponseEntity<List<Object>> findAllManagerByType() {
        return ResponseEntity.ok(_fidelityManagerService.findAllManagerByType());
    }

    @PostMapping(ROUTE.FIDELITY_MANAGER)
    public ResponseEntity<FidelityResponse> add(@RequestBody FidelityManagerRequest fidelityManagerRequest) {
        FidelityResponse response = _fidelityManagerService.create(fidelityManagerRequest);
        if (response.getData() == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(ROUTE.FIDELITY_MANAGER_FOR_ASSIGN)
    public ResponseEntity<List<FidelityManager>> listMangersForAsing(){
    return ResponseEntity.ok(_fidelityManagerService.listManagerForAsing());
    }

}
