package com.fidelity.movil.request;

import lombok.Data;

@Data
public class FidelityManagerRequest {
    private long id;
    private String name;
    private String email;
    private String phone;
    private String type;
    private String password;
}
