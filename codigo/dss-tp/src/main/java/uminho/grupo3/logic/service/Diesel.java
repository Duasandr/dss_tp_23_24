package uminho.grupo3.logic.service;

import uminho.grupo3.logic.vehicle.interfaces.IDiesel;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public class Diesel extends Service {

	/**
	 * Construtor parametrizado.
	 * @param details Detalhes do serviço
	 */
	public Diesel(Details details) {
		super(details);
	}

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	public boolean canApplyTo(IVehicle vehicle) {
		return vehicle instanceof IDiesel;
	}

}