package com.softlond.store.repositories.contracts;

import com.softlond.store.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
