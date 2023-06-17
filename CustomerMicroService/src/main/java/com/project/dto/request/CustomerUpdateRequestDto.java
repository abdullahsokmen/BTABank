package com.project.dto.request;

import com.project.repository.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateRequestDto {
    private Long id;
    private String name;
    private String surname;
    private String birthPlace;
    private String email;
    private AddressCreateRequestDto address;
    private String phone;
}
