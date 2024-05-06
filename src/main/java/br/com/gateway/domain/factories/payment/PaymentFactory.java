package br.com.gateway.domain.factories.payment;

import br.com.gateway.domain.enums.PaymentTypeEnum;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PaymentFactory {

    private final Map<PaymentTypeEnum, PaymentStrategy> strategies = new HashMap<>();

    public PaymentFactory(Set<PaymentStrategy> strategy) {
        strategy.forEach(s -> strategies.put(s.getType(), s));
    }

    public PaymentStrategy getPaymentStrategy(PaymentTypeEnum paymentType) {
        return strategies.get(paymentType);
    }
}
