package com.fidelity.movil.service;

import com.fidelity.movil.mapping.UserMapping;
import com.fidelity.movil.model.User;
import com.fidelity.movil.repository.UserRepository;
import com.fidelity.movil.request.UserCreationRequest;
import com.fidelity.movil.service.IMPService.IMPUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IMPUserService {
    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public User create(UserCreationRequest userCreationRequest) {
        return _userRepository.save(UserMapping.RequestToUser(userCreationRequest));
    }

    @Override
    public User findById(long id) {
        return _userRepository.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return _userRepository.findAll();
    }
}
