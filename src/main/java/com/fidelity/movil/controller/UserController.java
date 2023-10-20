package com.fidelity.movil.controller;

import com.fidelity.movil.model.User;
import com.fidelity.movil.routes.Main;
import com.fidelity.movil.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Main.MAIN)
public class UserController {

    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping(Main.USER)
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(_userService.findAll());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public ResponseEntity<User> getById(@RequestParam(name = "id", defaultValue = "0") long id){
        return ResponseEntity.ok(_userService.findById(id));
    }

}
