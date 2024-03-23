package logic.service;

import logic.Service;
import logic.Vehicle;

public class Universal extends Service {

    public Universal(String name, String description, float price, float duration) {
        super(name, description, price, duration);
    }

    /**
     * Testa se o serviço é aplicável a um dado veículo.
     * @param vehicle veículo a aplicar o serviço
     */
    public boolean canApplyTo(Vehicle vehicle) {
        return true;
    }

}