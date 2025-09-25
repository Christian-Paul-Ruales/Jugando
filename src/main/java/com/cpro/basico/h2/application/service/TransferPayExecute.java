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
public class TransferPayExecute implements PayExecute {
    private final String TRANSFER_TYPE = "TRAN";
    private final PayRepository payRepository;

    @Override
    public Pay pay(double payValue) {
        log.info(" _______________ AQUI LA LOGICA PARA UN PAGO DE TRANSFERENCIAS ___________________");
        Pay pay = new Pay();
        pay.setType(TRANSFER_TYPE);
        pay.setAmount(payValue);
        payRepository.save(pay);
        return pay;
    }

    @Override
    public String getType() {
        return TRANSFER_TYPE;
    }


}
