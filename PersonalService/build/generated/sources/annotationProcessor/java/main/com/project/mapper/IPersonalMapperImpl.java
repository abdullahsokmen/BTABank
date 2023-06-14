package com.project.mapper;

import com.project.dto.request.PersonalSaveRequestDto;
import com.project.repository.entity.Personal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-14T21:17:28+0300",
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

        return personal.build();
    }
}
