package com.fidelity.movil.mapping;

import com.fidelity.movil.model.FidelityManager;
import com.fidelity.movil.request.FidelityManagerRequest;

public class FidelityMangerMapping {
    public static FidelityManager RequestToFidelityMager(FidelityManagerRequest fidelityManagerRequest){
        return new FidelityManager(fidelityManagerRequest.getId(),fidelityManagerRequest.getName(),fidelityManagerRequest.getType() ,fidelityManagerRequest.getEmail(), fidelityManagerRequest.getPhone(), fidelityManagerRequest.getPassword())
;    }
}
