package uminho.grupo3.logic.service;

import uminho.grupo3.logic.vehicle.interfaces.ICombustion;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public class Combustion extends Service {

	/**
	 * Construtor parametrizado.
	 * @param details Detalhes do serviço
	 */
	public Combustion(Details details) {
		super(details);
	}

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	public boolean canApplyTo(IVehicle vehicle) {
		return vehicle instanceof ICombustion;
	}

}