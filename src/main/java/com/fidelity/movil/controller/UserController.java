package com.fidelity.movil.controller;

import com.fidelity.movil.request.UserCreationRequest;
import com.fidelity.movil.response.FidelityResponse;
import com.fidelity.movil.routes.ROUTE;
import com.fidelity.movil.service.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ROUTE.MAIN)
public class UserController {

    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping(ROUTE.USER_PARAM)
    public ResponseEntity<FidelityResponse> getById(@PathVariable("id") long id) {
        FidelityResponse response = _userService.findById(id);
        if(response.getData() == null){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(ROUTE.USER)
    public ResponseEntity<FidelityResponse> getAll(){
        FidelityResponse response = _userService.findAll();
        return ResponseEntity.ok(response);
    }

    @PostMapping(ROUTE.USER)
    public ResponseEntity<FidelityResponse> add(@RequestBody UserCreationRequest userCreationRequest){
        FidelityResponse response = _userService.create(userCreationRequest);
        if(response.getData() == null){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(response);
        }
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(response);
    }

}
