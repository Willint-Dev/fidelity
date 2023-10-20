package com.fidelity.movil.routes;

public interface ROUTE {
    String MAIN = "/v1/fidelity";
    String USER = "/user";
    String USER_PARAM = USER + "/{id}";

    String FIDELITY_MANAGER = "/manger";
    String FIDELITY_MANAGER_ALL = "/mangerAll";

    String CLIENT = "/client";
}
