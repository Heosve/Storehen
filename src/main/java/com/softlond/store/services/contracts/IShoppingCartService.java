package com.softlond.store.services.contracts;

import java.util.List;

import com.softlond.store.entities.Product;
import com.softlond.store.entities.ShoppingCar;

public interface IShoppingCartService {
    
    void addToCart(Product product, int quantity);

    void removeFromCart(Long productId, int quantity);

    List<ShoppingCar> getCartItems();

    float calculateTotal();
}
