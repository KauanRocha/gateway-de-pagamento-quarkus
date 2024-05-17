package br.com.gateway.services;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentTypeEnum;
import br.com.gateway.domain.enums.RepositoryEnum;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;
import br.com.gateway.domain.usecases.ProcessPaymentUseCase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentService extends AbstractService{

    public Payment create(PaymentRequest paymentRequest) {
        var strategy = getPaymentStrategy(paymentRequest.paymentType());
        var process = new ProcessPaymentUseCase(strategy, dataBaseFactory.getImplementation(RepositoryEnum.POSTGRES));
        return process.processPayment(paymentRequest);
    }

    private PaymentStrategy getPaymentStrategy(PaymentTypeEnum type) {
        return paymentFactory.getPaymentStrategy(type);
    }
}
