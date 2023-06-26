package com.project.repository.entity;

import com.project.repository.enums.EAccountStatus;
import com.project.repository.enums.EAccountType;
import com.project.repository.enums.ECurrency;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tblaccount")
public class Account extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerLastname;
    private Long customerId;
    private Long accountNo;
    private Double balance;
    private Double creditDept;
    @Enumerated(EnumType.STRING)
    private EAccountType accountType;
    @Builder.Default
    private EAccountStatus status=EAccountStatus.ACTIVE;
    @Builder.Default
    private Date accountCreateDate = new Date();
    private String iban;
    @Enumerated(EnumType.STRING)
    private ECurrency currency;
}
