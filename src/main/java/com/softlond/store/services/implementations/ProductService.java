package com.softlond.store.services.implementations;

import com.softlond.store.entities.Product;
import com.softlond.store.repositories.contracts.IProductRepository;
import com.softlond.store.services.contracts.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Override
    public ResponseEntity<List<Product>> findAll() {
        ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(HttpStatus.OK);
        try {
            List<Product> products = this.productRepository.findAll();
            response = new ResponseEntity<List<Product>>(products, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            response = new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
    }

    @Override
    public ResponseEntity<Product> created(Product product) {
        try {
            Product productSaved = this.productRepository.save(product);
            return new ResponseEntity<Product>(productSaved, HttpStatus.OK);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
            System.out.println("No puede ser null");
            return  new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);

        } catch (OptimisticLockingFailureException e) {
            return  new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return  new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Product> update(Product product) {
        try {
            Product productUpdated = this.productRepository.save(product);
            return new ResponseEntity<Product>(productUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) {
        try {
            this.productRepository.deleteById(id);
            return new ResponseEntity<Boolean>(true, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
