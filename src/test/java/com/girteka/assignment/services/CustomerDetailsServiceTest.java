package com.girteka.assignment.services;

import com.girteka.assignment.data.transformations.AccountTransformer;
import com.girteka.assignment.data.transformations.CardTransformer;
import com.girteka.assignment.dtos.AccountDto;
import com.girteka.assignment.dtos.CardDto;
import com.girteka.assignment.dtos.CustomerDetailsDto;
import com.girteka.assignment.entities.Account;
import com.girteka.assignment.entities.Card;
import com.girteka.assignment.entities.Customer;
import com.girteka.assignment.repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerDetailsServiceTest {

    @MockBean
    private CustomerRepository customerRepository;

    @MockBean
    private AccountTransformer accountTransformer;

    @MockBean
    private CardTransformer cardTransformer;

    @Autowired
    private CustomerDetailsService customerDetailsService;

    private static Customer customer;
    private static List<CardDto> cardDtos;
    private static List<AccountDto> accounDtos;

    @BeforeAll
    public static void beforeAll() {
        Card card1 = new Card(2, null, "Credit", "7841 2345 83912 7452", LocalDateTime.parse("2022-03-07T10:34:59"));
        Card card2 = new Card(3, null, "Debit", "1254 2538 8965 1245", LocalDateTime.parse("2018-09-17T09:25:34"));
        List<Card> cards = List.of(card1, card2);

        Account account1 = new Account(2, null, "SE7280000810340009783242", "SEK", BigDecimal.valueOf(6231.84));
        Account account2 = new Account(3, null, "GB33BUKB20201555555555", "GBP", BigDecimal.valueOf(895.54));
        List<Account> accounts = List.of(account1, account2);

        customer = new Customer(1, "Jane Doe", "Business", cards, accounts);

        CardDto cardDto1 = new CardDto(2, "xxxx xxxx xxxx 7452 - Credit");
        CardDto cardDto2 = new CardDto(3, "xxxx xxxx xxxx 1245 - Debit");

        AccountDto accountDto1 = new AccountDto(2, "SE7280000810340009783242 - 6231.84 SEK");
        AccountDto accountDto2 = new AccountDto(3, "GB33BUKB20201555555555 - 895.54 GBP");

        cardDtos = List.of(cardDto1, cardDto2);
        accounDtos = List.of(accountDto1, accountDto2);
    }

    @Test
    void getCustomerDetails() {
    }

    @Test
    void customerToCustomerDetailsDto() {
        given(cardTransformer.getCartDtos(customer)).willReturn(cardDtos);
        given(accountTransformer.getAccountDtos(customer)).willReturn(accounDtos);

        CustomerDetailsDto customerDetailsDtoExpected = new CustomerDetailsDto(customer.getId(), customer.getFullName(),
                customer.getType(), cardDtos, accounDtos);

        CustomerDetailsDto customerDetailsDto = customerDetailsService.customerToCustomerDetailsDto(customer);

        Assertions.assertEquals(customerDetailsDtoExpected, customerDetailsDto);
    }
}