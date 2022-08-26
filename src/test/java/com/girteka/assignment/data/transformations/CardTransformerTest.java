package com.girteka.assignment.data.transformations;

import com.girteka.assignment.dtos.CardDto;
import com.girteka.assignment.entities.Card;
import com.girteka.assignment.entities.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static com.girteka.assignment.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CardTransformerTest {
    public static Card card1;
    public static Card card2;
    public static Customer customer;
    public static String cardDtoValueExpected;
    @Autowired
    private CardTransformer cardTransformer;

    @BeforeAll
    public static void beforeAll() {
        card1 = new Card(2, null, CREDIT, CARD_NUMBER, LocalDateTime.parse(T_10_34_59));
        card2 = new Card(3, null, DEBIT, CARD_NUMBER_1, LocalDateTime.parse(T_09_25_34));
        customer = new Customer(1, JANE_DOE, BUSINESS, List.of(card1, card2), null);
        cardDtoValueExpected = XXXX_XXXX_XXXX_7452_CREDIT;
    }

    @Test
    void getCartDtos() {
        CardDto cardDto2 = new CardDto(card2.getId(), XXXX_XXXX_XXXX_1245_DEBIT);
        List<CardDto> expectedCardDtos = List.of(cardDto2);
        List<CardDto> cardDtos = cardTransformer.getCardDtos(customer);
        assertEquals(expectedCardDtos, cardDtos);
    }

    @Test
    void cardToCardDto() {
        CardDto cardDtoExpected = new CardDto(card1.getId(), cardDtoValueExpected);
        CardDto cardDto = cardTransformer.cardToCardDto(card1);
        assertEquals(cardDtoExpected, cardDto);
    }

    @Test
    void getCardDtoValue() {
        String cardDto = cardTransformer.getCardDtoValue(card1);
        assertEquals(cardDtoValueExpected, cardDto);
    }
}