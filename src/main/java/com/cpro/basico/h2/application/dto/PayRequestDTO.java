package com.cpro.basico.h2.application.dto;

import lombok.Builder;

@Builder
public record PayRequestDTO(

        String type,
        Double value
) {
}
