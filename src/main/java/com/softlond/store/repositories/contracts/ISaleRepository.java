package com.softlond.store.repositories.contracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.softlond.store.entities.Sale;

public interface ISaleRepository extends JpaRepository<Sale, Long>{
    
}
