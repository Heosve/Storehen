package com.softlond.store.repositories.contracts;
import com.softlond.store.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepository  extends JpaRepository<Client, Long>{
    
}
