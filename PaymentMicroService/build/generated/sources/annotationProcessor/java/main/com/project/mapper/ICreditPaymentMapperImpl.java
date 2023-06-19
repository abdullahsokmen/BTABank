package com.project.mapper;

import com.project.dto.request.CreateCreditPaymentRequestDto;
import com.project.repository.entity.Credit;
import com.project.repository.enums.Currency;
import com.project.repository.enums.ECreditType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-19T22:21:58+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.5 (Amazon.com Inc.)"
)
@Component
public class ICreditPaymentMapperImpl implements ICreditPaymentMapper {

    @Override
    public Credit toCredit(CreateCreditPaymentRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Credit.CreditBuilder<?, ?> credit = Credit.builder();

        credit.customerId( dto.getCustomerId() );
        if ( dto.getCurrency() != null ) {
            credit.currency( Enum.valueOf( Currency.class, dto.getCurrency() ) );
        }
        credit.amount( dto.getAmount() );
        credit.creditDetails( dto.getCreditDetails() );
        credit.expiry( dto.getExpiry() );
        if ( dto.getCreditType() != null ) {
            credit.creditType( Enum.valueOf( ECreditType.class, dto.getCreditType() ) );
        }

        return credit.build();
    }
}
