package com.girteka.assignment.data.transformations.impl;

import com.girteka.assignment.constants.CustomerConstants;
import com.girteka.assignment.data.transformations.CardTransformer;
import com.girteka.assignment.dtos.CardDto;
import com.girteka.assignment.entities.Card;
import com.girteka.assignment.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.girteka.assignment.constants.CustomerConstants.HIDDEN_NUMBERS;
import static com.girteka.assignment.constants.CustomerConstants.HYPHEN;

@Component
class CardTransformerImpl implements CardTransformer {
    public List<CardDto> getCartDtos(Customer customer) {
        return customer.getCards().stream()
                .map(this::cardToCardDto)
                .collect(Collectors.toList());
    }
    public CardDto cardToCardDto(Card card) {
        return new CardDto(card.getId(), getCardDtoValue(card));
    }

    public String getCardDtoValue(Card card) {
        String[] cardNumberArray = card.getCardNumber().split(" ");

        Optional<String> lastNumbersOptional = Arrays
                .stream(cardNumberArray)
                .skip(cardNumberArray.length - 1)
                .findFirst();

        return lastNumbersOptional
                .map(number -> HIDDEN_NUMBERS + number + HYPHEN + card.getType())
                .orElse(CustomerConstants.CARD_NUMBER_NOT_FOUND);
    }
}
