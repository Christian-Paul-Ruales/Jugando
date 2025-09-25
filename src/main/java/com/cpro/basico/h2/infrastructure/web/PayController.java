package com.cpro.basico.h2.infrastructure.web;

import com.cpro.basico.h2.application.dto.PayRequestDTO;
import com.cpro.basico.h2.application.dto.PayResponseDTO;
import com.cpro.basico.h2.domain.port.in.PayCreate;
import com.cpro.basico.h2.domain.port.in.PayRead;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("pay")
public class PayController {
    private final PayRead payRead;
    private final PayCreate payCreate;

    @GetMapping("/{id}")
    public ResponseEntity<PayResponseDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(payRead.getOne(id));
    }

    @PostMapping
    public ResponseEntity<PayResponseDTO> create(@RequestBody PayRequestDTO payRequestDTO) {
        return ResponseEntity.ok(payCreate.create(payRequestDTO));
    }

}

