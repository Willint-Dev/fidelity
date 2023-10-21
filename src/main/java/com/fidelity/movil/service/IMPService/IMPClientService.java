package com.fidelity.movil.service.IMPService;

import com.fasterxml.jackson.databind.JsonNode;
import com.fidelity.movil.model.Client;
import com.fidelity.movil.model.FidelityManager;

import java.util.List;

public interface IMPClientService {
    List<FidelityManager> loadManagers(JsonNode jsonBody);
    List<Client> loadClients();
    void assignManger(List<Client> lstClients, List<FidelityManager> lstManagers);
    List<Client> findClientByManager(long id_manager);
}
