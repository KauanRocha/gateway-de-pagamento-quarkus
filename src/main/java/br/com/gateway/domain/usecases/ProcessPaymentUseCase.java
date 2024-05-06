package br.com.gateway.domain.usecases;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.enums.PaymentTypeEnum;
import br.com.gateway.domain.factories.payment.PaymentFactory;
import br.com.gateway.domain.repositoties.PaymentRepository;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;

public class ProcessPaymentUseCase {

    private final PaymentFactory paymentFactory;

    private final PaymentRepository paymentRepository;


    public ProcessPaymentUseCase(PaymentFactory paymentFactory, PaymentRepository paymentRepository) {
        this.paymentFactory = paymentFactory;
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(PaymentRequest paymentRequest) {
        PaymentStrategy paymentStrategy = getPaymentStrategy(paymentRequest);

        var payment = paymentStrategy.processPayment(paymentRequest);
        return paymentRepository.save(payment);
    }
    
    private PaymentStrategy getPaymentStrategy(PaymentRequest paymentRequest) {
        PaymentTypeEnum paymentType = paymentRequest.paymentType();
        return paymentFactory.getPaymentStrategy(paymentType);
    }
}
