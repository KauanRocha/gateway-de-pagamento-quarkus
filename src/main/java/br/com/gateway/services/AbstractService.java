package br.com.gateway.services;


import br.com.gateway.domain.usecases.ProcessPaymentUseCase;
import br.com.gateway.infra.database.postgres.repositories.PgPaymentRepository;
import br.com.gateway.services.factories.DataBaseFactory;
import jakarta.inject.Inject;

public abstract class AbstractService {

    @Inject
    PgPaymentRepository postgres;

    @Inject
    DataBaseFactory dataBaseFactory;

    @Inject
    ProcessPaymentUseCase useCase;

}