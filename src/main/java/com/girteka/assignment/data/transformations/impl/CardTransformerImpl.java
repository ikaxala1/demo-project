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
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.girteka.assignment.constants.CustomerConstants.HIDDEN_NUMBERS;
import static com.girteka.assignment.constants.CustomerConstants.HYPHEN;
import static com.girteka.assignment.constants.TestConstants.BUSINESS;
import static com.girteka.assignment.constants.TestConstants.CREDIT;

@Component
class CardTransformerImpl implements CardTransformer {
    @Override
    public List<CardDto> getCardDtos(Customer customer) {
        Predicate<Card> notCreditCardForBusinessCustomer = card ->
                !(customer.getType().equals(BUSINESS) && card.getType().equals(CREDIT));
        return customer.getCards().stream()
                .filter(notCreditCardForBusinessCustomer)
                .map(this::cardToCardDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto cardToCardDto(Card card) {
        return new CardDto(card.getId(), getCardDtoValue(card));
    }

    @Override
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
