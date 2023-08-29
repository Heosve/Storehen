package com.softlond.store.entities;

public class ShoppingCar extends Product{
    
    private int quantity;

    public ShoppingCar(Long id,String name, Float price ,int quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    public void increaseAmount(int quantity){
        this.quantity++;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return getPrice()*quantity;
    }


}
