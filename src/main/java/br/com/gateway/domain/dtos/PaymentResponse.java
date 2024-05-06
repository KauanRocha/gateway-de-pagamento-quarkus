package br.com.gateway.domain.dtos;

import br.com.gateway.domain.enums.PaymentStatusEnum;
import br.com.gateway.domain.enums.PaymentTypeEnum;

import java.math.BigDecimal;

public record PaymentResponse(Integer id, BigDecimal value, BigDecimal tax, String beneficiary, String payer, PaymentTypeEnum paymentType, PaymentStatusEnum status) {
}
