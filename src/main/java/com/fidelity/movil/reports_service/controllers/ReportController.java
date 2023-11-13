package com.fidelity.movil.reports_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/fidelity")
public class ReportController {

    @GetMapping("/report")
    public void generate() {

    }

}