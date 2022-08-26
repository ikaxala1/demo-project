package com.girteka.assignment.data.transformations;

import com.girteka.assignment.dtos.AccountDto;
import com.girteka.assignment.entities.Account;
import com.girteka.assignment.entities.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static com.girteka.assignment.constants.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class AccountTransformerTest {

    @Autowired
    private AccountTransformer accountTransformer;
    private static Account account1;
    private static Account account2;
    private static Customer customer;

    @BeforeAll
    public static void beforeAll() {
        account1 = new Account(3, null, GB_33_BUKB_20201555555555, GBP, BigDecimal.valueOf(895.54));
        account2 = new Account(2, null, SE_7280000810340009783242, SEK, BigDecimal.valueOf(6231.84));
        customer = new Customer(1, JANE_DOE, BUSINESS, null, List.of(account1, account2));
    }

    @Test
    void getAccountDtos() {
        AccountDto accountDto1 = new AccountDto(account1.getId(), GB_33_BUKB_20201555555555_895_54_GBP);
        AccountDto accountDto2 = new AccountDto(account2.getId(), SE_7280000810340009783242_6231_84_SEK);
        List<AccountDto> expectedAccountDtos = List.of(accountDto1, accountDto2);
        List<AccountDto> accountDtos = accountTransformer.getAccountDtos(customer);
        assertEquals(expectedAccountDtos, accountDtos);
    }

    @Test
    void accountToAccountDto() {
        AccountDto accountDtoExpected = new AccountDto(account1.getId(), "GB33BUKB20201555555555 - 895.54 GBP");
        AccountDto accountDto = accountTransformer.accountToAccountDto(account1);
        assertEquals(accountDtoExpected, accountDto);
    }
}