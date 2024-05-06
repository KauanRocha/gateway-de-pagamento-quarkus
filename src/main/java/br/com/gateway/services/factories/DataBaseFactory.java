package br.com.gateway.services.factories;

import br.com.gateway.domain.enums.RepositoryEnum;
import br.com.gateway.domain.repositoties.PaymentRepository;
import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DataBaseFactory {

    @All
    private List<PaymentRepository> implementations;

    private static final Map<RepositoryEnum, PaymentRepository> services = new HashMap<>();

    public DataBaseFactory(List<PaymentRepository> implementations) {
        this.implementations = implementations;
    }

    @PostConstruct
    public void init() {
        implementations.forEach(i -> services.put(i.getType(), i));
    }

    public PaymentRepository getImplementation(RepositoryEnum repositoryEnum) {
        return services.get(repositoryEnum);
    }
}