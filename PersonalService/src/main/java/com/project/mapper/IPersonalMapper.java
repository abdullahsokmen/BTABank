package com.project.mapper;

import com.project.dto.request.PersonalSaveRequestDto;
import com.project.repository.entity.Personal;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IPersonalMapper {
    IPersonalMapper INSTANCE= Mappers.getMapper(IPersonalMapper.class);

    Personal toPersonal(final PersonalSaveRequestDto dto);
}
