package com.project.repository.entity;

import com.project.repository.enums.Currency;
import com.project.repository.enums.ECreditStatus;
import com.project.repository.enums.ETransferStatus;
import com.project.repository.enums.ETransferType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbltransfer")
public class Transfer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerLastname;
    private Long customerId;
    @Builder.Default
    private Date requestDate = new Date();
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double amount;
    private String transferDetails;
    @Enumerated(EnumType.STRING)
    private ETransferType transferType;
    @Builder.Default
    private ETransferStatus status =ETransferStatus.PENDING;
    private Long accountNo;
    private Long takerAccountNo;
    private Long takerName;
    private Long takerLastname;

}
