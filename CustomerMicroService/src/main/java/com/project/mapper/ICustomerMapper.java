package com.project.mapper;

import com.project.dto.request.CustomerSaveRequestDto;
import com.project.dto.request.RegisterRequestDto;
import com.project.dto.response.CustomerDetailsResponseDto;
import com.project.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICustomerMapper {
    ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(final CustomerSaveRequestDto dto);
    RegisterRequestDto toRegisterRequestDto(final Customer customer);

    CustomerDetailsResponseDto fromCustomer(final Customer customer);
}
