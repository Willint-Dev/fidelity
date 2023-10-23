package com.fidelity.movil.cliente_service.service.IMPService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidelity.movil.cliente_service.model.Client;
import com.fidelity.movil.manager_service.model.FidelityManager;

import java.util.List;

public interface IMPClientService {
    List<FidelityManager> loadManagers(JsonNode jsonBody);
    List<Client> loadClients();
    void assignManger(List<Client> lstClients, List<FidelityManager> lstManagers);
    List<Client> findClientByManager(long id_manager);
}
