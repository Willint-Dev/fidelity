package com.fidelity.movil.service;

import com.fidelity.movil.model.Client;
import com.fidelity.movil.repository.ClientRepository;
import com.fidelity.movil.response.FidelityResponse;
import com.fidelity.movil.service.IMPService.IMPClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IMPClientService {
    private final ClientRepository _clientRepository;

    public ClientService(ClientRepository clientRepository) {
        _clientRepository = clientRepository;
    }

    @Override
    public FidelityResponse findByIdManager(long id_manager) {
        List<Client> lstClient = _clientRepository.findAllByManager(id_manager);
        return new FidelityResponse(200, "Mensaje de listado", lstClient);
    }
}
