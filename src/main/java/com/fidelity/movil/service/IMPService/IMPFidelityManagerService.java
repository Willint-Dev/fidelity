package com.fidelity.movil.service.IMPService;

import com.fidelity.movil.request.FidelityManagerRequest;
import com.fidelity.movil.response.FidelityResponse;

public interface IMPFidelityManagerService {
    FidelityResponse create(FidelityManagerRequest fidelityManagerRequest);
    FidelityResponse findById(long id);
    FidelityResponse findAll();
}
