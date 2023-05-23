package com.project.repository.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tblcustomer")
@Entity
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String identityNumber;
    private String customerNo;
    private int age;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Address address;
}
