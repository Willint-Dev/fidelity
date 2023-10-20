package com.fidelity.movil.mapping;

import com.fidelity.movil.model.User;
import com.fidelity.movil.request.UserCreationRequest;


public class UserMapping {

    public static User RequestToUser (UserCreationRequest userCreationRequest){
        return new User(userCreationRequest.getId(), userCreationRequest.getName(),userCreationRequest.getEmail(), userCreationRequest.getPassword(),
                userCreationRequest.getPhone());
    }
}
