package com.project.mapper;

import com.project.dto.request.CreateCreditPaymentRequestDto;
import com.project.repository.entity.Credit;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICreditPaymentMapper {
    ICreditPaymentMapper INSTANCE= Mappers.getMapper(ICreditPaymentMapper.class);
    Credit toCredit(final CreateCreditPaymentRequestDto dto);
}
