package com.softlond.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.softlond.store.entities.Client;
import com.softlond.store.services.contracts.IClientService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping("/list")
    private ResponseEntity<List<Client>> getAllCategories() {
        return this.clientService.findAll();
    }
    
    @PostMapping("/create")
    private ResponseEntity<Client> createCategory(@RequestBody Client client) {
        return this.clientService.create(client);
    }
    
    @PutMapping("/update")
    private ResponseEntity<Client> updateCategory(@RequestBody Client client) {
        return this.clientService.update(client);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Boolean> deleteCategory(@RequestParam Long id) {
        return this.clientService.delete(id);
    }
    
}
