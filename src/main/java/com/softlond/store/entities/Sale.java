package com.softlond.store.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;

@Entity
@Table(name = "sales")
@EntityListeners(AuditingEntityListener.class)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float total;

    @CreatedDate
    private Timestamp date;

    public Sale(Long id, Float total, Timestamp date) {
        this.id = id;
        this.total = total;
        this.date = date;
    }

    @JoinTable(name = "saleDetails", joinColumns = @JoinColumn(name = "FK_PRODUCT", nullable = false), 
    inverseJoinColumns = @JoinColumn(name = "FK_SALE", nullable = false))

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp currentTimestamp) {
        this.date = currentTimestamp;
    }

}
