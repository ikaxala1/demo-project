package com.girteka.assignment.data.transformations;

import com.girteka.assignment.dtos.AccountDto;
import com.girteka.assignment.entities.Account;
import com.girteka.assignment.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AccountTransformer {
    List<AccountDto> getAccountDtos(Customer customer);
    AccountDto accountToAccountDto(Account account);
}
