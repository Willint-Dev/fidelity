package com.fidelity.movil.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidelity.movil.model.Client;
import com.fidelity.movil.model.FidelityManager;
import com.fidelity.movil.routes.ROUTE;
import com.fidelity.movil.service.ClientService;
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
        String uri = "http://localhost:8081/v1/fidelity/mangerAll";
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
