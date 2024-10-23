package com.api.domain.interfaces.outgoing.jpaORM;

import com.api.domain.models.Logistic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogisticORM extends JpaRepository<Logistic, Long>{
}
