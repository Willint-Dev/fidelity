package com.fidelity.movil.cliente_service.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidelity.movil.cliente_service.model.Client;
import com.fidelity.movil.cliente_service.routes.ROUTE;
import com.fidelity.movil.cliente_service.service.ClientService;
import com.fidelity.movil.manager_service.model.FidelityManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(ROUTE.MAIN)
public class ClientController {
    private final ClientService _clientService;

    public ClientController(ClientService clientService) {
        _clientService = clientService;
    }

    @GetMapping(ROUTE.MANAGER_CLIENT)
    public List<FidelityManager> loadManagers() {
        String uri = "http://localhost:8080/v1/fidelity/mangerAll";
        RestTemplate restTemplate = new RestTemplate();
        JsonNode result = restTemplate.getForEntity(uri, JsonNode.class).getBody();
        List<FidelityManager> lstManager = _clientService.loadManagers(result);
        return _clientService.loadManagers(result);
    }

    @GetMapping(ROUTE.CLIENT)
    public List<Client> loadClients(){
        return _clientService.loadClients();
    }

    @GetMapping(ROUTE.ASSIGN)
    public void findClients() throws ExecutionException, InterruptedException {
        List<FidelityManager> lstManagers = loadManagers();
        List<Client> lstClient = loadClients();

        _clientService.assignManger(lstClient, lstManagers);
    }
}
