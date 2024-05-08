package br.com.gateway.services.factories;

import br.com.gateway.domain.enums.PaymentTypeEnum;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;
import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class PaymentFactory {

    @All
    private List<PaymentStrategy> strategy;

    private final Map<PaymentTypeEnum, PaymentStrategy> strategies = new EnumMap<>(PaymentTypeEnum.class);

    @PostConstruct
    public void init() {
        strategy.forEach(s -> strategies.put(s.getType(), s));
    }

    public PaymentStrategy getPaymentStrategy(PaymentTypeEnum paymentType) {
        return strategies.get(paymentType);
    }
}
