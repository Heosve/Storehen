package com.softlond.store.services.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.softlond.store.entities.Product;
import com.softlond.store.entities.ShoppingCar;
import com.softlond.store.services.contracts.IProductService;
import com.softlond.store.services.contracts.IShoppingCartService;

@Service
public class ShoppingCarSerivce implements IShoppingCartService {
    private Map<Long, ShoppingCar> shoppingCart = new HashMap<>();
    
    @Autowired
    private IProductService productService;


    public void addToCart(Long productId, int quantity) {
        ResponseEntity<Product> productResponse = productService.findById(productId);

        if (productResponse.getStatusCode() == HttpStatus.OK) {
            Product product = productResponse.getBody();
            if (product != null) {
                if (shoppingCart.containsKey(productId)) {
                    ShoppingCar cartItem = shoppingCart.get(productId);
                    cartItem.increaseAmount(quantity);
                } else {
                    shoppingCart.put(productId,
                            new ShoppingCar(product.getId(), product.getName(), product.getPrice(), quantity));
                }
            } else {
                // Manejo si el producto no existe en la base de datos
            }
        }
    }

    public void removeFromCart(Long productId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }

        if (shoppingCart.containsKey(productId)) {
            ShoppingCar cartItem = shoppingCart.get(productId);
            int currentQuantity = cartItem.getQuantity();

            if (quantity >= currentQuantity) {
                shoppingCart.remove(productId);
            } else {
                cartItem.setQuantity(currentQuantity - quantity);
            }
        }
    }

    public List<ShoppingCar> getCartItems() {
        return new ArrayList<>(shoppingCart.values());
    }

    public float calculateTotal() {
        float total = 0;
        for (ShoppingCar cartItem : shoppingCart.values()) {
            total += cartItem.getTotal();
        }
        return total;
    }

    @Override
    public void addToCart(Product product, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCart'");
    }
}
