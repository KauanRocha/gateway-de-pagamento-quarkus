package br.com.gateway.services.factories;

import br.com.gateway.domain.enums.PaymentTypeEnum;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;
import br.com.gateway.services.produces.StrategyImplementationsProducer;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.EnumMap;
import java.util.Map;

@ApplicationScoped
public class PaymentFactory {

    private final StrategyImplementationsProducer strategyImplementationsProducer;

    private final Map<PaymentTypeEnum, PaymentStrategy> strategies = new EnumMap<>(PaymentTypeEnum.class);

    public PaymentFactory(StrategyImplementationsProducer strategyImplementationsProducer) {
        this.strategyImplementationsProducer = strategyImplementationsProducer;
    }

    @PostConstruct
    public void init() {
        strategyImplementationsProducer.producePaymentStrategies()
                .forEach(s -> strategies.put(s.getType(), s));
    }

    public PaymentStrategy getPaymentStrategy(PaymentTypeEnum paymentType) {
        return strategies.get(paymentType);
    }
}
