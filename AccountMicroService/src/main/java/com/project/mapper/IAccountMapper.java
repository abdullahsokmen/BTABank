package com.project.mapper;

import com.project.dto.request.CreateAccountRequestDto;
import com.project.repository.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface IAccountMapper {
    IAccountMapper INSTANCE= Mappers.getMapper(IAccountMapper.class);

    Account toAccount(final CreateAccountRequestDto dto);
}
