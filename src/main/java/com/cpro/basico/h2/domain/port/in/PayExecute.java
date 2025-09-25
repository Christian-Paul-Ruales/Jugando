package com.cpro.basico.h2.domain.port.in;

import com.cpro.basico.h2.infrastructure.persistence.model.Pay;

public interface PayExecute {
    Pay pay(double pay);

    String getType();
}
