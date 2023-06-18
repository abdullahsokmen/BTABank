package com.project.repository.entity;

import com.project.repository.enums.ECreditStatus;
import com.project.repository.enums.ECreditType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Currency;
import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tblcredit")
public class Credit extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerLastname;
    private Long customerId;
    @Builder.Default
    private Date requestDate = new Date();
    private Date confirmDate;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private Double amount;
    private String creditDetails;
    private String expiry;
    @Builder.Default
    private ECreditStatus status =ECreditStatus.PENDING;
    @Enumerated(EnumType.STRING)
    private ECreditType creditType;
}
