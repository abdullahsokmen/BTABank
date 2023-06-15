package com.project.repository.entity;

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
@Table(name = "tblcustomer")
public class Customer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Date birthDate;
    private String birthPlace;
    private String identity;
    private String email;
    private String password;
    private Long authId;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Address address;
    private String phone;
    @Builder.Default
    private EStatus status=EStatus.ACTIVE;

}
