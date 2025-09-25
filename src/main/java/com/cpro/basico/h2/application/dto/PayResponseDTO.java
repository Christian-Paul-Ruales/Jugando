package com.cpro.basico.h2.application.dto;

import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import lombok.Builder;

@Builder
public record PayResponseDTO(
        Long id,
        String type,
        Double value
) {
    public static PayResponseDTO of(Pay pay) {
        return PayResponseDTO.builder()
                .id(pay.getIdPay())
                .type(pay.getType())
                .value(pay.getAmount())
                .build();
    }
}
