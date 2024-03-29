package com.project.mapper;

import com.project.dto.request.AddressCreateRequestDto;
import com.project.repository.entity.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-17T20:33:14+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IAddressMapperImpl implements IAddressMapper {

    @Override
    public Address toAddress(AddressCreateRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.town( dto.getTown() );
        address.city( dto.getCity() );
        address.country( dto.getCountry() );

        return address.build();
    }
}
