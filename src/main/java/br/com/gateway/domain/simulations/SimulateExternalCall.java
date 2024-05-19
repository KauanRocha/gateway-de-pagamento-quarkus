package br.com.gateway.domain.simulations;

import java.util.Random;

public class SimulateExternalCall {

    private SimulateExternalCall() {
    }

    public static void simulateBankAccountCheck() {
        if(new Random().nextBoolean()) {
            throw new RuntimeException();
        }
    }
}
