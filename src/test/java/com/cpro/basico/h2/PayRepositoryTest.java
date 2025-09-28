package com.cpro.basico.h2;

import com.cpro.basico.h2.application.service.CashPayExecute;
import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import com.cpro.basico.h2.infrastructure.persistence.repository.PayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PayRepositoryTest {

    @Autowired
    private PayRepository payRepository;
    private static final double EXAMPLE_VALUE =12.4;

    private static final Pay VALID_PAY = new Pay(
            null,
            CashPayExecute.CASH_TYPE,
            EXAMPLE_VALUE,
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
    );



    @Test
    void create_whenValidData_shouldRegisterPay() {
        Pay response = payRepository.save(VALID_PAY);

        assertThat(response).isNotNull();
        assertThat(response.getIdPay()).isInstanceOf(Long.class);
        assertThat(response.getAmount()).isEqualTo(EXAMPLE_VALUE);
    }
}
