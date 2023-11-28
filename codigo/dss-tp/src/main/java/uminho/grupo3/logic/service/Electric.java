package uminho.grupo3.logic.service;

import uminho.grupo3.logic.vehicle.interfaces.IElectric;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public class Electric extends Service {

	/**
	 * Construtor parametrizado.
	 * @param details Detalhes do serviço
	 */
	public Electric(Details details) {
		super(details);
	}

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	public boolean canApplyTo(IVehicle vehicle) {
		return vehicle instanceof IElectric;
	}

}