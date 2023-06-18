package com.project.service;

import com.project.dto.request.CreateCreditPaymentRequestDto;
import com.project.dto.response.CustomerInfoResponseDto;
import com.project.exception.EErrorType;
import com.project.exception.PaymentServiceException;
import com.project.manager.ICustomerManager;
import com.project.mapper.ICreditPaymentMapper;
import com.project.repository.ICreditRepository;
import com.project.repository.entity.Credit;
import com.project.repository.enums.Currency;
import com.project.repository.enums.ECreditType;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CreditService extends ServiceManager<Credit,Long> {
    private final ICreditRepository creditRepository;
    private final ICustomerManager customerManager;

    public CreditService(ICreditRepository creditRepository, ICustomerManager customerManager) {
        super(creditRepository);
        this.creditRepository = creditRepository;
        this.customerManager = customerManager;
    }

    public Boolean requestCreditPayment(CreateCreditPaymentRequestDto dto) {
        CustomerInfoResponseDto customerDto=customerManager.getCustomerInfo(dto.getCustomerId()).getBody();
        if (Objects.isNull(customerDto))
            throw new PaymentServiceException(EErrorType.CUSTOMER_NOT_EXIST);
        Credit credit= ICreditPaymentMapper.INSTANCE.toCredit(dto);
        credit.setCreditType(ECreditType.valueOf(dto.getCreditType()));
        credit.setCurrency(Currency.valueOf(dto.getCurrency()));
        credit.setAmount(dto.getAmount());
        credit.setCreditDetails(dto.getCreditDetails());
        credit.setExpiry(dto.getExpiry());
        credit.setCustomerId(dto.getCustomerId());
        save(credit);
        return true;
    }
}
