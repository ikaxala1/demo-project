package com.girteka.assignment.data.transformations.impl;

import com.girteka.assignment.constants.CustomerConstants;
import com.girteka.assignment.data.transformations.AccountTransformer;
import com.girteka.assignment.dtos.AccountDto;
import com.girteka.assignment.entities.Account;
import com.girteka.assignment.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.girteka.assignment.constants.CustomerConstants.HYPHEN;

@Component
class AccountTransformerImpl implements AccountTransformer {

    public List<AccountDto> getAccountDtos(Customer customer) {
        return customer.getAccounts().stream()
                .map(this::accountToAccountDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto accountToAccountDto(Account account) {
        return new AccountDto(account.getId(),
                account.getIban() + HYPHEN + account.getBalance() + CustomerConstants.SPACE + account.getCurrency());
    }
}
