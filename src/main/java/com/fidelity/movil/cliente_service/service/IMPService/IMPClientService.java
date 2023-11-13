package com.fidelity.movil.cliente_service.service.IMPService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidelity.movil.cliente_service.model.Client;
import com.fidelity.movil.manager_service.model.FidelityManager;

import java.util.List;
import java.util.Optional;

public interface IMPClientService {
    List<FidelityManager> loadManagers(JsonNode jsonBody);
    List<Client> loadClients();
    void assignManger(List<Client> lstClients, List<FidelityManager> lstManagers);
    Optional<Client> findClientById(long id_client);
}
