package com.fidelity.movil.cliente_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fidelity.movil.cliente_service.model.Client;
import com.fidelity.movil.cliente_service.repository.ClientRepository;

import com.fidelity.movil.cliente_service.service.IMPService.IMPClientService;
import com.fidelity.movil.manager_service.model.FidelityManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IMPClientService {
    private final ClientRepository _clientRepository;

    public ClientService(ClientRepository clientRepository) {
        _clientRepository = clientRepository;
    }

    /* ESTE METODO RECIBE UN JSONNODE, LUEGO TRANSFORMA ESE JSON EN UN OBJETO DE TIPO FIDELITYMANAGER PARA HACER MAS FACIL EL TRABAJAR CON LOS DATOS */
    /* GENERA UNA LISTA DE MANAGERS BASADOS EN EL JSON QUE DEVUELVE EL OTRO ENDPOINT */
    @Override
    public List<FidelityManager> loadManagers(JsonNode jsonBody) {
        List<FidelityManager> lstManager = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            assert jsonBody != null;
            for (JsonNode iteration : jsonBody) {
                FidelityManager manager = objectMapper.treeToValue(iteration, FidelityManager.class);
                lstManager.add(manager);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lstManager;
    }

    @Override
    public List<Client> loadClients() {
        return _clientRepository.loadCLients();
    }

    /* ASIGNA DE FORMA AUTOMATICA GESTOR A LOS CLIENTES, TENIENDO EN CUENTA SI SON EMPRESARIAL, SENIOR, COMERCIAL Y RESIDENCIAL JUNIOR. */
    /* LA LISTA RECIBIDA DE GESTORES, VIENE ORDENADA POR EL GESTOR QUE TENGA MENOS CLIENTES ASIGNADOS. */
    @Override
    public void assignManger(List<Client> lstClients, List<FidelityManager> lstManagers) {
        for (Client client : lstClients){
            for(FidelityManager manager: lstManagers){
                if(client.getType().equals("Empresarial") && manager.getType().equals("Senior")){
                    client.setManager(manager);
                    break;
                }else if(client.getType().equals("Comercial") || client.getType().equals("Residencial") && manager.getType().equalsIgnoreCase("Junior")){
                    client.setManager(manager);
                    break;
                }
            }
        }
        _clientRepository.saveAll(lstClients);
    }

    @Override
    public Optional<Client> findClientById(long id_client) {
        return _clientRepository.findById(id_client);
    }
}
