package com.girteka.assignment.dtos;

import java.util.Objects;

public class CardDto {
    private long id;
    private String value;

    public CardDto(long id, String value) {
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardDto cardDto = (CardDto) o;
        return id == cardDto.id && Objects.equals(value, cardDto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }
}
