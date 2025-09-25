package com.cpro.basico.h2.infrastructure.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * Principio de responsabilidad unica
 * */
@Entity
@Table(name = "pay")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pay")
    private Long idPay;

    @Column(nullable = false)
    private String type;
    @Column(nullable = false, name = "amount")
    private Double amount;

    @Column(nullable = false, name = "creation_date")
    private LocalDateTime creationDate;
    @Column(nullable = false, name = "modification_date")
    private LocalDateTime modificationDate;

    private boolean status;

    @PrePersist
    public void onSave() {

        creationDate = LocalDateTime.now();
        modificationDate = LocalDateTime.now();
        status = true;
    }

    @PreUpdate
    public void onUpdate() {
        modificationDate = LocalDateTime.now();
    }

}
