package com.softlond.store.services.contracts;

import java.util.List;


import org.springframework.http.ResponseEntity;

import com.softlond.store.entities.Client;

public interface IClientService {
    public ResponseEntity<List<Client>> findAll();

    public ResponseEntity<Client> create(Client client);

    public ResponseEntity<Client> update(Client client);

    public ResponseEntity<Boolean> delete(Long id);


}
