package com.girteka.assignment.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    @Id
    private long id;
    private String fullName;
    private String type;

    public Customer() {
    }

    public Customer(long id, String fullName, String type, List<Card> cards, List<Account> accounts) {
        this.id = id;
        this.fullName = fullName;
        this.type = type;
        this.cards = cards;
        this.accounts = accounts;
    }

    @OneToMany(mappedBy = "customer")
    private List<Card> cards;

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
