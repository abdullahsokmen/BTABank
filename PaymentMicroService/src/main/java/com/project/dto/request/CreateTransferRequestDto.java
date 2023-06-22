package com.project.dto.request;

import com.project.repository.enums.Currency;
import com.project.repository.enums.ETransferType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransferRequestDto {
    private String currency;
    private Double amount;
    private String transferDetails;
    private String transferType;
    private Long accountNo;
    private Long takerAccountNo;
    private Long takerName;
    private Long takerLastname;
    private Long customerId;
}
