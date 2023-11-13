package com.fidelity.movil.cliente_service.routes;

public interface ROUTE {
    String MAIN = "/v1/fidelity";
    String USER = "/user";
    String USER_PARAM = USER + "/{id}";

    String FIDELITY_MANAGER = "/manger";
    String FIDELITY_MANAGER_ALL = "/mangerAll";
    String FIDELITY_MANAGER_FOR_ASSIGN = "/list-manager";

    String CLIENT = "/client/all";
    String CLIENT_PATCH_VARIABLE = "/client";
    String ASSIGN = CLIENT + "/assignClient";
    String MANAGER_CLIENT = CLIENT + "/manager";
}
