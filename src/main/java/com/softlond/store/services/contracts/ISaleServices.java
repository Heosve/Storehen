package com.softlond.store.services.contracts;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.softlond.store.entities.Sale;

public interface ISaleServices {
        public ResponseEntity<List<Sale>> findAll();
        
    public ResponseEntity<Sale> created(Sale sale);

    public ResponseEntity<Sale> update(Sale sale);

    public ResponseEntity<Boolean> delete(Long id);

    public ResponseEntity<Sale> findById(Long id);
}
