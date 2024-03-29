package com.project.service;

import com.project.dto.request.CreateCreditPaymentRequestDto;
import com.project.dto.request.UpdateCreditPaymentRequestDto;
import com.project.dto.response.CustomerInfoResponseDto;
import com.project.exception.EErrorType;
import com.project.exception.PaymentServiceException;
import com.project.manager.ICustomerManager;
import com.project.mapper.ICreditPaymentMapper;
import com.project.repository.ICreditRepository;
import com.project.repository.entity.Credit;
import com.project.repository.enums.Currency;
import com.project.repository.enums.ECreditStatus;
import com.project.repository.enums.ECreditType;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

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
        credit.setCustomerName(customerDto.getName());
        credit.setCustomerLastname(customerDto.getSurname());
        save(credit);
        return true;
    }

    public Boolean updateCreditPayment(UpdateCreditPaymentRequestDto dto) {
        Optional<Credit>credit=findById(dto.getId());
        if (credit.isEmpty())
            throw new PaymentServiceException(EErrorType.CREDIT_NOT_EXIST);
        Credit toUpdate=credit.get();
        toUpdate.setAmount(dto.getAmount());
        toUpdate.setCreditDetails(dto.getCreditDetails());
        toUpdate.setExpiry(dto.getExpiry());
        update(toUpdate);
        return true;
    }

    public Boolean confirmCreditPayment(Long id) {
        Optional<Credit>credit=findById(id);
        if (credit.isEmpty())
            throw new PaymentServiceException(EErrorType.CREDIT_NOT_EXIST);
        if (!credit.get().getStatus().equals(ECreditStatus.PENDING))
            throw new PaymentServiceException(EErrorType.PENDING_STATUS_ERROR);
        credit.get().setStatus(ECreditStatus.APPROVED);
        credit.get().setConfirmDate(new Date());
        update(credit.get());
        return true;
    }

    public Boolean declineCreditPayment(Long id) {
        Optional<Credit>credit=findById(id);
        if (credit.isEmpty())
            throw new PaymentServiceException(EErrorType.CREDIT_NOT_EXIST);
        if (!credit.get().getStatus().equals(ECreditStatus.PENDING))
            throw new PaymentServiceException(EErrorType.PENDING_STATUS_ERROR);
        credit.get().setStatus(ECreditStatus.DECLINED);
        update(credit.get());
        return true;
    }

    public Boolean deleteCreditPayment(Long id) {
        Optional<Credit>credit=findById(id);
        if (credit.isEmpty())
            throw new PaymentServiceException(EErrorType.CREDIT_NOT_EXIST);
        delete(credit.get());
        return true;
    }
}
