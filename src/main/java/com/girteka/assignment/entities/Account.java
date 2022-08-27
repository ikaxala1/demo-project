package com.girteka.assignment.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Account {
    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String iban;
    private String currency;
    private BigDecimal balance;

    public Account() {
    }

    public Account(long id, Customer customer, String iban, String currency, BigDecimal balance) {
        this.id = id;
        this.customer = customer;
        this.iban = iban;
        this.currency = currency;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
