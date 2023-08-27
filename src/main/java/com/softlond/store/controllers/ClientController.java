package com.softlond.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.softlond.store.entities.Client;
import com.softlond.store.services.contracts.IClientService;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping("/list")
    private ResponseEntity<List<Client>> getAllCategories() {
        return this.clientService.findAll();
    }
    
    
}
