package com.project.service;

import com.project.dto.request.CreateTransferRequestDto;
import com.project.dto.response.CustomerInfoResponseDto;
import com.project.dto.response.TransferInfoResponseDto;
import com.project.exception.EErrorType;
import com.project.exception.PaymentServiceException;
import com.project.manager.ICustomerManager;
import com.project.mapper.ITransferPaymentMapper;
import com.project.repository.ITransferRepository;
import com.project.repository.entity.Transfer;
import com.project.repository.enums.Currency;
import com.project.repository.enums.ETransferType;
import com.project.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TransferService extends ServiceManager<Transfer,Long> {
    private final ITransferRepository transferRepository;
    private final ICustomerManager customerManager;

    public TransferService(ITransferRepository transferRepository, ICustomerManager customerManager) {
        super(transferRepository);
        this.transferRepository = transferRepository;
        this.customerManager = customerManager;
    }

    public Boolean requestTransfer(CreateTransferRequestDto dto) {
        CustomerInfoResponseDto customerDto=customerManager.getCustomerInfo(dto.getCustomerId()).getBody();
        if (Objects.isNull(customerDto))
            throw new PaymentServiceException(EErrorType.CUSTOMER_NOT_EXIST);
        Transfer transfer= ITransferPaymentMapper.INSTACE.toTransfer(dto);
        transfer.setCurrency(Currency.valueOf(dto.getCurrency()));
        transfer.setAmount(dto.getAmount());
        transfer.setTransferDetails(dto.getTransferDetails());
        transfer.setTransferType(ETransferType.valueOf(dto.getTransferType()));
        transfer.setAccountNo(dto.getAccountNo());
        transfer.setTakerAccountNo(dto.getTakerAccountNo());
        transfer.setTakerName(dto.getTakerName());
        transfer.setTakerLastname(dto.getTakerLastname());
        transfer.setCustomerId(dto.getCustomerId());
        save(transfer);
        return true;
    }

    public TransferInfoResponseDto getTransfersByAccountNo(Long accountNo) {
        Optional<Transfer>transfer=transferRepository.findByAccountNo(accountNo);
        if (transfer.isEmpty())
            throw new PaymentServiceException(EErrorType.TRANSFER_NOT_EXIST);
        return TransferInfoResponseDto.builder()
                .currency(transfer.get().getCurrency().toString())
                .amount(transfer.get().getAmount())
                .transferDetails(transfer.get().getTransferDetails())
                .transferType(transfer.get().getTransferType().toString())
                .accountNo(transfer.get().getAccountNo())
                .takerAccountNo(transfer.get().getAccountNo())
                .takerName(transfer.get().getTakerName())
                .takerLastname(transfer.get().getTakerLastname())
                .customerId(transfer.get().getCustomerId())
                .build();
    }
}
