package com.softlond.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softlond.store.entities.Product;
import com.softlond.store.entities.ShoppingCar;
import com.softlond.store.services.contracts.IShoppingCartService;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {


    @Autowired
    private IShoppingCartService shoppingCartService;



    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody Product product, @RequestParam int quantity) {
        try {
            shoppingCartService.addToCart(product, quantity);
            return ResponseEntity.ok("Product added to cart.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error adding product to cart.");
        }
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestParam Long productId, @RequestParam int quantity) {
        shoppingCartService.removeFromCart(productId, quantity);
        return ResponseEntity.ok("Product removed from cart.");
    }

    @GetMapping("/items")
    public ResponseEntity<List<ShoppingCar>> getCartItems() {
        List<ShoppingCar> cartItems = shoppingCartService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/total")
    public ResponseEntity<Float> getCartTotal() {
        float total = shoppingCartService.calculateTotal();
        return ResponseEntity.ok(total);
    }

    
}
