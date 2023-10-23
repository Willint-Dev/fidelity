package com.fidelity.movil.manager_service.service.IMPService;

import com.fidelity.movil.manager_service.model.FidelityManager;
import com.fidelity.movil.manager_service.request.FidelityManagerRequest;
import com.fidelity.movil.manager_service.response.FidelityResponse;

import java.util.List;

public interface IMPFidelityManagerService {
    FidelityResponse create(FidelityManagerRequest fidelityManagerRequest);
    FidelityResponse findById(long id);
    List<FidelityManager> findAllManagerByType();
}
