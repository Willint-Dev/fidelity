package com.fidelity.movil.response;

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
