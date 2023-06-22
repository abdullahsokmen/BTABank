package com.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferInfoResponseDto {
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
