package com.fidelity.movil.service.IMPService;

import com.fidelity.movil.model.User;
import com.fidelity.movil.request.UserCreationRequest;
import com.fidelity.movil.response.FidelityResponse;

import java.util.List;
import java.util.Optional;

public interface IMPUserService {
    FidelityResponse create(UserCreationRequest userCreationRequest);
    FidelityResponse findById(long id);
    FidelityResponse findAll();
}
