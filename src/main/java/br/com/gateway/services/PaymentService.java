package br.com.gateway.services;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentService extends AbstractService{

    public Payment create(PaymentRequest paymentRequest) {
        return useCase.processPayment(paymentRequest);
    }
}
