package com.project.mapper;

import com.project.dto.Request.CustomerCreateRequestDto;
import com.project.dto.Response.CustomerMinorDetailsResponseDto;
import com.project.dto.Response.GetCustomerDetailsResponseDto;
import com.project.repository.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,componentModel = "spring")
public interface ICustomerMapper {
    ICustomerMapper INSTANCE= Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(final CustomerCreateRequestDto dto);

    GetCustomerDetailsResponseDto toGetCustomerDetailsResponseDto(final Customer customer);

    CustomerMinorDetailsResponseDto fromCustomer(final Customer customer);
}
