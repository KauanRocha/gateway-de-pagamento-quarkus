package br.com.gateway.domain.dtos;

import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentTypeEnum;

import java.math.BigDecimal;

public record PaymentRequest(BigDecimal value, String beneficiary, String payer, PaymentTypeEnum paymentType) {

    public Payment toPayment() {
        return new Payment(value, beneficiary, payer, paymentType);
    }
}
