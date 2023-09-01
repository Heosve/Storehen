package com.softlond.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.store.entities.Sale;
import com.softlond.store.services.contracts.ISaleServices;

@RestController
@RequestMapping("/sales")
public class SaleController {

    @Autowired
    private ISaleServices saleService;

    @GetMapping("/list")
    private ResponseEntity<List<Sale>> getAllSales() {
        return this.saleService.findAll();
    }
    
    @PostMapping("/create")
    private ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        return this.saleService.created(sale);
    }

    @PutMapping("/update")
    private ResponseEntity<Sale> updateSale(@RequestBody Sale sale) {
        return this.saleService.update(sale);
    }

    @DeleteMapping("/delete")
    private ResponseEntity<Boolean> deleteSale(@RequestParam Long id) {
        return this.saleService.delete(id);
    }

}
