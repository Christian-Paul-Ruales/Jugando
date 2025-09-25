package com.cpro.basico.h2;

import com.cpro.basico.h2.application.dto.PayRequestDTO;
import com.cpro.basico.h2.application.dto.PayResponseDTO;
import com.cpro.basico.h2.application.manager.PayManager;
import com.cpro.basico.h2.application.service.CashPayExecute;
import com.cpro.basico.h2.application.useCase.PayService;
import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import com.cpro.basico.h2.infrastructure.persistence.repository.PayRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PayServiceTest {
    @Mock private PayRepository payRepository;
    @Mock private PayManager payManager;

    @InjectMocks private PayService payService;

    private static final String INVALID_TYPE = "TC";
    private static final double EXAMPLE_VALUE =15.5;
    private final PayRequestDTO payRequestDTO = PayRequestDTO.builder()
            .type(CashPayExecute.CASH_TYPE)
            .value(EXAMPLE_VALUE)
            .build();
    private final PayRequestDTO invalidRequestDTO = PayRequestDTO.builder()
            .type(INVALID_TYPE)
            .value(EXAMPLE_VALUE)
            .build();
    private final PayResponseDTO payResponseDTO = PayResponseDTO.builder()
            .id(1L)
            .type(CashPayExecute.CASH_TYPE)
            .value(EXAMPLE_VALUE)
            .build();

    private static final Pay VALID_PAY = new Pay(
        1L,
        CashPayExecute.CASH_TYPE,
        EXAMPLE_VALUE,
        LocalDateTime.now(),
        LocalDateTime.now(),
        true
    );
    @Test
    @DisplayName("Test para creacion")
    void create_withValidData_shouldRegisterPay() {
        when(payManager.payByType(CashPayExecute.CASH_TYPE, EXAMPLE_VALUE)).thenReturn(VALID_PAY);

        PayResponseDTO payResponseDTO = payService.create(payRequestDTO);
        assertEquals(payResponseDTO.id(), 1L);
        assertThat(payResponseDTO).isEqualTo(this.payResponseDTO);

    }

    @Test
    @DisplayName("Tipo de pago invalido")
    void create_withInvalidPayType_shouldThrowException() {
        when(payManager.payByType(INVALID_TYPE, EXAMPLE_VALUE)).thenThrow(
                 new IllegalArgumentException("Type %s not found".formatted(INVALID_TYPE))
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> payService.create(invalidRequestDTO)
        );


    }

}
