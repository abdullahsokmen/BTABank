package com.project.mapper;

import com.project.dto.request.AddressCreateRequestDto;
import com.project.dto.request.CustomerSaveRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.repository.entity.Address;
import com.project.repository.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-17T20:19:13+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICustomerMapperImpl implements ICustomerMapper {

    @Override
    public Customer toCustomer(CustomerSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Customer.CustomerBuilder<?, ?> customer = Customer.builder();

        customer.name( dto.getName() );
        customer.surname( dto.getSurname() );
        customer.birthDate( dto.getBirthDate() );
        customer.birthPlace( dto.getBirthPlace() );
        customer.identity( dto.getIdentity() );
        customer.email( dto.getEmail() );
        customer.address( addressCreateRequestDtoToAddress( dto.getAddress() ) );

        return customer.build();
    }

    @Override
    public RegisterRequestDto toRegisterRequestDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        RegisterRequestDto.RegisterRequestDtoBuilder registerRequestDto = RegisterRequestDto.builder();

        registerRequestDto.name( customer.getName() );
        registerRequestDto.surname( customer.getSurname() );
        registerRequestDto.email( customer.getEmail() );
        registerRequestDto.password( customer.getPassword() );

        return registerRequestDto.build();
    }

    protected Address addressCreateRequestDtoToAddress(AddressCreateRequestDto addressCreateRequestDto) {
        if ( addressCreateRequestDto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.town( addressCreateRequestDto.getTown() );
        address.city( addressCreateRequestDto.getCity() );
        address.country( addressCreateRequestDto.getCountry() );

        return address.build();
    }
}
