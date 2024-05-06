package br.com.gateway.infra.database.postgres.converters;

import br.com.gateway.domain.entities.Payment;
import br.com.gateway.infra.database.postgres.models.PgPayment;

public class PaymentConverter {

    private PaymentConverter() {
    }

    public static Payment toDomain(PgPayment pgPayment) {
        var payment = new Payment();
        payment.setId(pgPayment.getId());
        payment.setValue(pgPayment.getValue());
        payment.setTax(pgPayment.getTax());
        payment.setBeneficiary(pgPayment.getBeneficiary());
        payment.setPayer(pgPayment.getPayer());
        payment.setType(pgPayment.getType());

        return payment;
    }

    public static PgPayment toEntity(Payment payment) {
        var pgPayment = new PgPayment();
        pgPayment.setId(payment.getId());
        pgPayment.setValue(payment.getValue());
        pgPayment.setTax(payment.getTax());
        pgPayment.setBeneficiary(payment.getBeneficiary());
        pgPayment.setPayer(payment.getPayer());
        pgPayment.setType(payment.getType());

        return pgPayment;
    }
}
