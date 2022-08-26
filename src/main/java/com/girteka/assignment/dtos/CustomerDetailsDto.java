package com.girteka.assignment.dtos;

import java.util.List;
import java.util.Objects;

public class CustomerDetailsDto {
    private long id;
    private String fullName;
    private String type;
    private List<CardDto> cards;
    private List<AccountDto> accounts;

    public CustomerDetailsDto(long id, String fullName, String type, List<CardDto> cards, List<AccountDto> accounts) {
        this.id = id;
        this.fullName = fullName;
        this.type = type;
        this.cards = cards;
        this.accounts = accounts;
    }

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

    public List<CardDto> getCards() {
        return cards;
    }

    public void setCards(List<CardDto> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDetailsDto that = (CustomerDetailsDto) o;
        return id == that.id && Objects.equals(fullName, that.fullName) && Objects.equals(type, that.type) && Objects.equals(cards, that.cards) && Objects.equals(accounts, that.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, type, cards, accounts);
    }

    public List<AccountDto> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDto> accounts) {
        this.accounts = accounts;
    }
}
