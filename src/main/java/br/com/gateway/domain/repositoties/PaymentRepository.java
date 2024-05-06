package br.com.gateway.domain.repositoties;

import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.RepositoryEnum;

public interface PaymentRepository {

    Payment save(Payment payment);

    RepositoryEnum getType();

}
