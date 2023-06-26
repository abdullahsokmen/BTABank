package com.project.service;

import com.project.repository.IAccountRepository;
import com.project.repository.entity.Account;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends ServiceManager<Account,Long> {
    private final IAccountRepository accountRepository;

    public AccountService(IAccountRepository accountRepository) {
        super(accountRepository);
        this.accountRepository = accountRepository;
    }
}
