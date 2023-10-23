package com.fidelity.movil.manager_service.repository.controller;

import com.fidelity.movil.cliente_service.routes.ROUTE;
import com.fidelity.movil.manager_service.model.FidelityManager;
import com.fidelity.movil.manager_service.request.FidelityManagerRequest;
import com.fidelity.movil.manager_service.response.FidelityResponse;
import com.fidelity.movil.manager_service.service.FidelityManagerService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ROUTE.MAIN)
public class FidelityManagerController {
    private final FidelityManagerService _fidelityManagerService;

    public FidelityManagerController(FidelityManagerService fidelityManagerService) {
        _fidelityManagerService = fidelityManagerService;
    }

    @GetMapping(ROUTE.FIDELITY_MANAGER)
    public ResponseEntity<FidelityResponse> getById(@RequestParam(value = "id", defaultValue = "0") long id) {
        FidelityResponse response = _fidelityManagerService.findById(id);
        if (response.getData() == null) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);

        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(ROUTE.FIDELITY_MANAGER_ALL)
    public  ResponseEntity<List<FidelityManager>> findAllManagerByType(){
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
}
