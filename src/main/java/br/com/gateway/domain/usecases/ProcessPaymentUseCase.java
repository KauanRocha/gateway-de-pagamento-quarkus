package br.com.gateway.domain.usecases;

import br.com.gateway.domain.dtos.PaymentRequest;
import br.com.gateway.domain.entities.Payment;
import br.com.gateway.domain.exceptions.PartnerException;
import br.com.gateway.domain.repositoties.PaymentRepository;
import br.com.gateway.domain.strategy.payment.PaymentStrategy;
import br.com.gateway.simulations.SimulateExternalCall;

public class ProcessPaymentUseCase {

    private final PaymentStrategy paymentStrategy;

    private final PaymentRepository paymentRepository;

    public ProcessPaymentUseCase(PaymentStrategy paymentStrategy, PaymentRepository paymentRepository) {
        this.paymentStrategy = paymentStrategy;
        this.paymentRepository = paymentRepository;
    }

    public Payment processPayment(PaymentRequest paymentRequest) {
        var payment = paymentStrategy.processPayment(paymentRequest);
        //This method simulates a possible error coming from a partner API
        try {
            SimulateExternalCall.simulateBankAccountCheck();
        } catch (Exception e) {
            throw new PartnerException();
        }
        return paymentRepository.save(payment);
    }

}
