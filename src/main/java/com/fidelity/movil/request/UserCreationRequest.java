package com.fidelity.movil.request;

import lombok.Data;

@Data
public class UserCreationRequest {
    private long id;
    private String name;
    private String email;
    private String password;
    private String phone;

    public UserCreationRequest() {
        super();
    }

    public UserCreationRequest(long id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
}
