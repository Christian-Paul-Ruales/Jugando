package com.cpro.basico.h2.application.manager;

import com.cpro.basico.h2.domain.port.in.PayExecute;
import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Sustitucion de Liskov: los objetos derivados deben ser sustituibles por sus tipos base
 * */
@RequiredArgsConstructor
@Service
public class PayManager {
    private final List<PayExecute> payExecutes;

    public Pay payByType(String type, Double value) {
        PayExecute payExecute = payExecutes.stream()
                .filter(services -> services.getType().equals(type))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Type %s not found".formatted(type))
                );

        return payExecute.pay(value);
    }

}
