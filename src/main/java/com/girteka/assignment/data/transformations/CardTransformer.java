package com.girteka.assignment.data.transformations;

import com.girteka.assignment.dtos.CardDto;
import com.girteka.assignment.entities.Card;
import com.girteka.assignment.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CardTransformer {
    List<CardDto> getCartDtos(Customer customer);
    CardDto cardToCardDto(Card card);
    String getCardDtoValue(Card card);
}
