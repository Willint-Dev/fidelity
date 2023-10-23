package com.fidelity.movil.manager_service.mapping;

import com.fidelity.movil.manager_service.model.FidelityManager;
import com.fidelity.movil.manager_service.request.FidelityManagerRequest;

public class FidelityMangerMapping {
    public static FidelityManager RequestToFidelityMager(FidelityManagerRequest fidelityManagerRequest){
        return new FidelityManager(fidelityManagerRequest.getId(),fidelityManagerRequest.getName(),fidelityManagerRequest.getType() ,fidelityManagerRequest.getEmail(), fidelityManagerRequest.getPhone(), fidelityManagerRequest.getPassword())
;    }
}
