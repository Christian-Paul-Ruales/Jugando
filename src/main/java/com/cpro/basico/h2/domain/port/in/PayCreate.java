package com.cpro.basico.h2.domain.port.in;

import com.cpro.basico.h2.application.dto.PayRequestDTO;
import com.cpro.basico.h2.application.dto.PayResponseDTO;
import com.cpro.basico.h2.infrastructure.persistence.model.Pay;

/**
 * Segregacion de interfaces: las interfaces deben ser especificas, no forzar implementaciones innecesarias
 * Solo para este caso se usa un update nada mas, simulando un metodo para la modificacion de la entidad pay
 */
public interface PayCreate {
    PayResponseDTO create(PayRequestDTO payRequestDTO);
}
