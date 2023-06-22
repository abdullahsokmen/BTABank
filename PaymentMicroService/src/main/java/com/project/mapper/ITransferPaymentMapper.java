package com.project.mapper;

import com.project.dto.request.CreateTransferRequestDto;
import com.project.repository.entity.Transfer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ITransferPaymentMapper {
    ITransferPaymentMapper INSTACE= Mappers.getMapper(ITransferPaymentMapper.class);
    Transfer toTransfer(final CreateTransferRequestDto dto);
}
