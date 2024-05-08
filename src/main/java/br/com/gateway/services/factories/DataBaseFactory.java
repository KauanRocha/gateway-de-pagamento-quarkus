package br.com.gateway.services.factories;

import br.com.gateway.domain.enums.RepositoryEnum;
import br.com.gateway.domain.repositoties.PaymentRepository;
import io.quarkus.arc.All;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class DataBaseFactory {

    @All
    private List<PaymentRepository> implementation;

    private static final Map<RepositoryEnum, PaymentRepository> services = new EnumMap<>(RepositoryEnum.class);

    @PostConstruct
    public void init() {
        implementation.forEach( database -> services.put(database.getType(), database));
    }

    public PaymentRepository getImplementation(RepositoryEnum repositoryEnum) {
        return services.get(repositoryEnum);
    }
}