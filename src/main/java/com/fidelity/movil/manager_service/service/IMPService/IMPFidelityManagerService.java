package com.fidelity.movil.manager_service.service.IMPService;

import com.fidelity.movil.manager_service.model.FidelityManager;
import com.fidelity.movil.manager_service.request.FidelityManagerRequest;
import com.fidelity.movil.manager_service.response.FidelityResponse;

import java.util.List;
import java.util.Optional;

public interface IMPFidelityManagerService {
    FidelityResponse create(FidelityManagerRequest fidelityManagerRequest);
    Optional<FidelityManager> findById(long id);
    List<FidelityManager> findAllManagerByType();
}
