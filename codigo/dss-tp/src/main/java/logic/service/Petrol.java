package logic.service;

import logic.Service;
import logic.Vehicle;
import logic.vehicle.interfaces.IPetrol;

public class Petrol extends Service {

	public Petrol(String name, String description, float price, float duration) {
		super(name, description, price, duration);
	}

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	@Override
	public boolean canApplyTo(Vehicle vehicle) {
		return vehicle instanceof IPetrol;
	}

}