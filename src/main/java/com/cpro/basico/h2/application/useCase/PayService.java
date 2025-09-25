package com.cpro.basico.h2.application.useCase;

import com.cpro.basico.h2.application.dto.PayRequestDTO;
import com.cpro.basico.h2.application.dto.PayResponseDTO;
import com.cpro.basico.h2.application.manager.PayManager;
import com.cpro.basico.h2.domain.port.in.PayCreate;
import com.cpro.basico.h2.domain.port.in.PayExecute;
import com.cpro.basico.h2.domain.port.in.PayRead;
import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import com.cpro.basico.h2.infrastructure.persistence.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Inversion de dependencias, depender de abstracciones (interfaces)
 * */
@RequiredArgsConstructor
@Service
public class PayService implements PayCreate, PayRead {
    private final PayRepository payRepository;
    private final PayManager payManager;

    @Override
    public PayResponseDTO create(PayRequestDTO payRequestDTO) {

        Pay pay = payManager.payByType(payRequestDTO.type(), payRequestDTO.value());
        return  PayResponseDTO.of(pay);
    }

    @Override
    public PayResponseDTO getOne(Long id) {
        return payRepository.findById(id)
                .map(PayResponseDTO::of)
                .orElseThrow(
                        () -> new RuntimeException("No se pudo obtener %s".formatted(id))
                );
    }
}
