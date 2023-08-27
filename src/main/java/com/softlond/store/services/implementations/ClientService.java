package com.softlond.store.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Client;
import com.softlond.store.repositories.contracts.IClientRepository;
import com.softlond.store.services.contracts.IClientService;

@Service
public class ClientService implements IClientService{

    @Autowired
    private IClientRepository clientRepository;
    @Override
        public ResponseEntity<List<Client>> findAll() {
        try {
            List<Client> clients = this.clientRepository.findAll();
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<Client> create(Client client) {
        try{
            Client clientSaved = this.clientRepository.save(client);
            return new ResponseEntity<Client>(clientSaved, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<Client> update(Client client) {
        try{
            Client clientUpdated = this.clientRepository.save(client);
            return new ResponseEntity<Client>(clientUpdated, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try{
            this.clientRepository.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
}
