package br.com.gateway.domain.strategy.payment;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentTypeEnum;

import java.math.BigDecimal;

public interface PaymentStrategy {

    Payment processPayment(PaymentRequest paymentRequest);

    PaymentTypeEnum getType();

    BigDecimal calculateTax(BigDecimal value);
}
