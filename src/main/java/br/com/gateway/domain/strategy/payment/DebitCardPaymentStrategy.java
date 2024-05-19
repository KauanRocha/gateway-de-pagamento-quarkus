package br.com.gateway.services.strategy.imp;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentStatusEnum;
import br.com.gateway.domain.enums.PaymentTypeEnum;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.math.MathContext;

@ApplicationScoped
public class DebitCardPaymentStrategy implements PaymentStrategy {

    private static final BigDecimal TAX_PERCENT = new BigDecimal("0.0399");

    @Override
    public Payment processPayment(PaymentRequest paymentRequest) {
        var tax = calculateTax(paymentRequest.value());

        var payment = paymentRequest.toPayment();
        payment.setType(getType());
        payment.setTax(tax);
        payment.setStatus(PaymentStatusEnum.SUCCESS);

        return payment;
    }

    @Override
    public PaymentTypeEnum getType() {
        return PaymentTypeEnum.DEBIT_CARD;
    }

    @Override
    public BigDecimal calculateTax(BigDecimal value) {
        return value.multiply(TAX_PERCENT, MathContext.DECIMAL32);
    }

}