package com.project.service;

import com.project.dto.request.CreateAccountRequestDto;
import com.project.dto.request.UpdateAccountRequestDto;
import com.project.dto.response.AccountDetailsResponseDto;
import com.project.dto.response.CustomerInfoResponseDto;
import com.project.exception.AccountServiceException;
import com.project.exception.EErrorType;
import com.project.manager.ICustomerManager;
import com.project.mapper.IAccountMapper;
import com.project.repository.IAccountRepository;
import com.project.repository.entity.Account;
import com.project.repository.enums.EAccountStatus;
import com.project.repository.enums.EAccountType;
import com.project.repository.enums.ECurrency;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AccountService extends ServiceManager<Account,Long> {
    private final IAccountRepository accountRepository;
    private final ICustomerManager customerManager;

    public AccountService(IAccountRepository accountRepository, ICustomerManager customerManager) {
        super(accountRepository);
        this.accountRepository = accountRepository;
        this.customerManager = customerManager;
    }

    public Boolean createAccount(CreateAccountRequestDto dto) {
        CustomerInfoResponseDto customerDto=customerManager.getCustomerInfo(dto.getCustomerId()).getBody();
        if (Objects.isNull(customerDto))
            throw new AccountServiceException(EErrorType.CUSTOMER_NOT_EXIST);
        Account account= IAccountMapper.INSTANCE.toAccount(dto);
        account.setCustomerName(customerDto.getName());
        account.setCustomerLastname(customerDto.getSurname());
        account.setCustomerId(customerDto.getId());
        account.setAccountType(EAccountType.valueOf(dto.getAccountType()));
        account.setCurrency(ECurrency.valueOf(dto.getCurrency()));
        save(account);
        return true;
    }

    public Boolean updateAccount(UpdateAccountRequestDto dto) {
        Optional<Account>account=findById(dto.getId());
        if (account.isEmpty())
            throw new AccountServiceException(EErrorType.ACCOUNT_NOT_EXIST);
        Account toUpdate=account.get();
        toUpdate.setBalance(dto.getBalance());
        toUpdate.setCreditDept(dto.getCreditDept());
        update(toUpdate);
        return true;
    }

    public Boolean deleteAccount(Long id) {
        Optional<Account>account=findById(id);
        if (account.isEmpty())
            throw new AccountServiceException(EErrorType.ACCOUNT_NOT_EXIST);
        deleteById(id);
        return true;
    }

    public Boolean blokeAccount(Long id) {
        Optional<Account>account=findById(id);
        if (account.isEmpty())
            throw new AccountServiceException(EErrorType.ACCOUNT_NOT_EXIST);
        account.get().setStatus(EAccountStatus.BLOKED);
        update(account.get());
        return true;
    }

    public AccountDetailsResponseDto getAccountDetails(Long id) {
        Optional<Account>account=findById(id);
        if (account.isEmpty())
            throw new AccountServiceException(EErrorType.ACCOUNT_NOT_EXIST);
        return AccountDetailsResponseDto.builder()
                .customerName(account.get().getCustomerName())
                .customerLastname(account.get().getCustomerLastname())
                .customerId(account.get().getCustomerId())
                .accountNo(account.get().getAccountNo())
                .balance(account.get().getBalance())
                .creditDept(account.get().getCreditDept())
                .build();
    }
}
