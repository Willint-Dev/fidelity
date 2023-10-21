package com.fidelity.movil.service.IMPService;

import com.fidelity.movil.model.FidelityManager;
import com.fidelity.movil.request.FidelityManagerRequest;
import com.fidelity.movil.response.FidelityResponse;

import java.util.List;

public interface IMPFidelityManagerService {
    FidelityResponse create(FidelityManagerRequest fidelityManagerRequest);
    FidelityResponse findById(long id);
    List<FidelityManager> findAllManagerByType();
}
