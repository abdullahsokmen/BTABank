package com.project.mapper;

import com.project.dto.request.AddressCreateRequestDto;
import com.project.dto.request.PersonalSaveRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.dto.response.PersonalDetailsResponseDto;
import com.project.repository.entity.Address;
import com.project.repository.entity.Personal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-16T20:18:29+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class IPersonalMapperImpl implements IPersonalMapper {

    @Override
    public Personal toPersonal(PersonalSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Personal.PersonalBuilder<?, ?> personal = Personal.builder();

        personal.name( dto.getName() );
        personal.surname( dto.getSurname() );
        personal.email( dto.getEmail() );
        personal.phone( dto.getPhone() );
        personal.identityNumber( dto.getIdentityNumber() );
        personal.address( addressCreateRequestDtoToAddress( dto.getAddress() ) );

        return personal.build();
    }

    @Override
    public RegisterRequestDto toRegisterRequestDto(Personal personal) {
        if ( personal == null ) {
            return null;
        }

        RegisterRequestDto.RegisterRequestDtoBuilder registerRequestDto = RegisterRequestDto.builder();

        registerRequestDto.name( personal.getName() );
        registerRequestDto.surname( personal.getSurname() );
        registerRequestDto.email( personal.getEmail() );
        registerRequestDto.password( personal.getPassword() );

        return registerRequestDto.build();
    }

    @Override
    public PersonalDetailsResponseDto fromPersonal(Personal personal) {
        if ( personal == null ) {
            return null;
        }

        PersonalDetailsResponseDto.PersonalDetailsResponseDtoBuilder personalDetailsResponseDto = PersonalDetailsResponseDto.builder();

        personalDetailsResponseDto.name( personal.getName() );
        personalDetailsResponseDto.surname( personal.getSurname() );
        personalDetailsResponseDto.email( personal.getEmail() );
        personalDetailsResponseDto.password( personal.getPassword() );
        personalDetailsResponseDto.phone( personal.getPhone() );

        return personalDetailsResponseDto.build();
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
