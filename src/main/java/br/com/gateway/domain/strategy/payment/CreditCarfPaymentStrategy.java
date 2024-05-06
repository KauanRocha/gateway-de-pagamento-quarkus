package br.com.gateway.domain.strategy.payment;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentTypeEnum;

import java.math.BigDecimal;
import java.math.MathContext;

public class CreditCarfPaymentStrategy implements PaymentStrategy {

    private static final BigDecimal TAX_PERCENT = new BigDecimal("4.99");

    @Override
    public Payment processPayment(PaymentRequest paymentRequest) {
        var tax = calculateTax(paymentRequest.value());

        var payment = paymentRequest.toPayment();
        payment.setType(getType());
        payment.setTax(tax);
        return payment;
    }

    @Override
    public PaymentTypeEnum getType() {
        return PaymentTypeEnum.CREDIT_CARD;
    }

    @Override
    public BigDecimal calculateTax(BigDecimal value) {
        return value.multiply(TAX_PERCENT, MathContext.DECIMAL32);
    }

}