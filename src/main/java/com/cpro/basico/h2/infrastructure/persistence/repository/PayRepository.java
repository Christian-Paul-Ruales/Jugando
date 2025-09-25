package com.cpro.basico.h2.infrastructure.persistence.repository;

import com.cpro.basico.h2.infrastructure.persistence.model.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay, Long> {

}
