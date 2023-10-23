package com.fidelity.movil.manager_service.response;

import lombok.Data;

@Data
public class FidelityResponse {
    private int code;
    private String message;
    private Object data;


    public FidelityResponse() {
    }

    public FidelityResponse(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
