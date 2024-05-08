package br.com.gateway.domain.dtos;

import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentTypeEnum;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRequest(@NotNull BigDecimal value,@NotNull  String beneficiary,@NotNull String payer,@NotNull PaymentTypeEnum paymentType) {

    public Payment toPayment() {
        return new Payment(value, beneficiary, payer, paymentType);
    }
}
