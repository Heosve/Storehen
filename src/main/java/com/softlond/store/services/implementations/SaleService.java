package com.softlond.store.services.implementations;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Product;
import com.softlond.store.entities.Sale;
import com.softlond.store.services.contracts.ISaleServices;
import com.softlond.store.repositories.contracts.ISaleRepository;
@Service
public class SaleService implements ISaleServices{

    @Autowired
    private ISaleRepository saleRepository;

    @Override
    public ResponseEntity<List<Sale>> findAll() {
        ResponseEntity<List<Sale>> response = new ResponseEntity<List<Sale>>(HttpStatus.OK);
        try {
            List<Sale> sales = this.saleRepository.findAll();
            response = new ResponseEntity<List<Sale>>(sales, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            response = new ResponseEntity<List<Sale>>(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
    }

    }

    @Override
    public ResponseEntity<Sale> created(Sale sale) {
        ResponseEntity<Sale> response = new ResponseEntity<Sale>(HttpStatus.OK);
        try {
            Sale newSale = this.saleRepository.save(sale);
            response = new ResponseEntity<Sale>(newSale, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            response = new ResponseEntity<Sale>(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
    }

    @Override
    public ResponseEntity<Sale> update(Sale sale) {
        try {
            Sale saleUpdate = this.saleRepository.save(sale);
            return new ResponseEntity<Sale>(saleUpdate, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Sale>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            this.saleRepository.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Sale> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
}
