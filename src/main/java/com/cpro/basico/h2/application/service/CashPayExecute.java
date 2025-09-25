package com.cpro.basico.h2.application.service;

import com.cpro.basico.h2.domain.port.in.PayExecute;
import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import com.cpro.basico.h2.infrastructure.persistence.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
OCP: abierto extencion, cerrado para modificacion, ejemplo muy basico
* **/
@Slf4j
@RequiredArgsConstructor
@Service
public class CashPayExecute implements PayExecute {
    public static final String CASH_TYPE = "CAS";
    private final PayRepository payRepository;

    public Pay pay(double payValue) {
        log.info(" _______________ AQUI LA LOGICA PARA UN PAGO DE EFECTIVO ___________________");

        Pay pay = new Pay();
        pay.setType(CASH_TYPE);
        pay.setAmount(payValue);

        return payRepository.save(pay);
    }

    @Override
    public String getType() {
        return CASH_TYPE;
    }
}
