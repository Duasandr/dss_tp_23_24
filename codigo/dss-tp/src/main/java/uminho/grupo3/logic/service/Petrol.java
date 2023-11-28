package uminho.grupo3.logic.service;

import uminho.grupo3.logic.vehicle.interfaces.IPetrol;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public class Petrol extends Service {

	/**
	 * Construtor parametrizado.
	 * @param details Detalhes do serviço
	 */
	public Petrol(Details details) {
		super(details);
	}

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	@Override
	public boolean canApplyTo(IVehicle vehicle) {
		return vehicle instanceof IPetrol;
	}

}