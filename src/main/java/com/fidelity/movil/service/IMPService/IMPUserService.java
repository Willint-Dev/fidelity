package com.fidelity.movil.service.IMPService;

import com.fidelity.movil.model.User;
import com.fidelity.movil.request.UserCreationRequest;

import java.util.List;

public interface IMPUserService {
    User create(UserCreationRequest userCreationRequest);
    User findById(long id);
    List<User> findAll();
}
