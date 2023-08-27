package com.softlond.store.repositories.contracts;

import com.softlond.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
