package com.fidelity.movil.controller;

import com.fidelity.movil.response.FidelityResponse;
import com.fidelity.movil.routes.ROUTE;
import com.fidelity.movil.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ROUTE.MAIN)
public class ClientController {
    private final ClientService _clientService;

    public ClientController(ClientService clientService) {
        _clientService = clientService;
    }

    @GetMapping(ROUTE.CLIENT)
    public ResponseEntity<FidelityResponse> findByIdManager(@RequestParam(value = "id_manager", defaultValue = "0")long id_manager){
        return ResponseEntity.ok(_clientService.findByIdManager(id_manager));
    }

    @PatchMapping
    public void assignManager(){
        String uri = "";
    }
}
