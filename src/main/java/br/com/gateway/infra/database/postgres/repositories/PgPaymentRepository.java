package br.com.gateway.infra.database.postgres.repositories;

import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.RepositoryEnum;
import br.com.gateway.domain.repositoties.PaymentRepository;
import br.com.gateway.infra.database.postgres.converters.PaymentConverter;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PgPaymentRepository implements PaymentRepository  {

    @Override
    @Transactional
    public Payment save(Payment payment) {
        var pgPayment  = PaymentConverter.toEntity(payment);
        pgPayment.persistAndFlush();
        payment.setId(pgPayment.getId());
        return payment;
    }

    @Override
    public RepositoryEnum getType() {
        return RepositoryEnum.POSTGRES;
    }
}
