package uminho.grupo3.logic.service;

import uminho.grupo3.logic.service.interfaces.IService;
import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public abstract class Service implements IService {

	private final Details details;

	/**
	 * Construtor parametrizado.
	 * @param details Detalhes do serviço
	 */
	public Service(Details details) {
		this.details = details;
	}

	/**
	 * Devolve o preço do veículo.
	 * @return float em euros
	 */
	public float getPrice() {
		return details.price();
	}

	/**
	 * Devolve o tempo estimado a completar o serviço.
	 * @return float em horas
	 */
	public float getDuration() {
		return details.duration();
	}

	/**
	 * Devolve a descrição do serviço.
	 * @return String
	 */
	public String getDescription() {
		return details.description();
	}

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	public abstract boolean canApplyTo(IVehicle vehicle);

}