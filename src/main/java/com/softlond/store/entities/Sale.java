package com.softlond.store.entities;

import java.sql.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.*;


@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float price;
    private Integer quantity;
    private Date date;
    
        
}
