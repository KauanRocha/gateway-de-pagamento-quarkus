package br.com.gateway.services;


import br.com.gateway.services.factories.DataBaseFactory;
import br.com.gateway.services.factories.PaymentFactory;
import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    DataBaseFactory dataBaseFactory;

    @Inject
    PaymentFactory paymentFactory;

}