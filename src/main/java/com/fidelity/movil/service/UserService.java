package com.fidelity.movil.service;

import com.fidelity.movil.mapping.UserMapping;
import com.fidelity.movil.model.User;
import com.fidelity.movil.repository.UserRepository;
import com.fidelity.movil.request.UserCreationRequest;
import com.fidelity.movil.response.FidelityResponse;
import com.fidelity.movil.service.IMPService.IMPUserService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IMPUserService {
    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }


    @Override
    public FidelityResponse create(UserCreationRequest userCreationRequest) {
        User oUser = UserMapping.RequestToUser(userCreationRequest);
        FidelityResponse response = new FidelityResponse();
        try{
            System.out.println("------" + _userRepository.save(oUser));
            response.setData(_userRepository.save(oUser));
            response.setCode(201);
            response.setMessage("User created successfully");
        }catch (Exception e){
            response.setData(null);
            response.setCode(201);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @Override
    public FidelityResponse findById(long id) {
        FidelityResponse response = new FidelityResponse();
        try {
            response.setData(_userRepository.findById(id).get());
            response.setCode(200);
            response.setMessage("User finding successfully!");

        }catch (Exception e){
            response.setCode(404);
            response.setMessage("The provided user does not exist");
            response.setData(null);
        }
        return response;
    }

    @Override
    public FidelityResponse findAll() {
        return new FidelityResponse(200, "Users listed correctly", _userRepository.findAll());
    }
}
