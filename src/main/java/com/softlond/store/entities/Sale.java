package com.softlond.store.entities;

import java.sql.Date;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float total;
    private Date date;

    public Sale(Long id, Float total, Date date) {
        this.id = id;
        this.total = total;
        this.date = date;
    }

    @JoinTable(name = "saleDetails", joinColumns = @JoinColumn(name = "FK_PRODUCT", nullable = false), 
    inverseJoinColumns = @JoinColumn(name = "FK_SALE", nullable = false))

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
