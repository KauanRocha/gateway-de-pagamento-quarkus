package br.com.gateway.services.produces;

import br.com.gateway.domain.exceptions.DefaultException;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;
import br.com.gateway.domain.strategy.payment.PixPaymentStrategy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.reflections.Reflections;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class StrategyImplementationsProducer {

    @Produces
    @ApplicationScoped
    public List<PaymentStrategy> producePaymentStrategies() {
        Reflections reflections = new Reflections(PixPaymentStrategy.class.getPackage().getName());
        return reflections.getSubTypesOf(PaymentStrategy.class).stream().map(clazz -> {
            try {
                return clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new DefaultException();
            }
        }).collect(Collectors.toList());
    }
}
