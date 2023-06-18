package com.project.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCreditPaymentRequestDto {
    private String currency;
    private Double amount;
    private String creditDetails;
    private String expiry;
    private Long customerId;
    private String creditType;
}
