package uminho.grupo3.logic.service.interfaces;

import uminho.grupo3.logic.vehicle.interfaces.IVehicle;

public interface IService {

	/**
	 * Devolve o preço do veículo.
	 * @return float em euros
	 */
	float getPrice();

	/**
	 * Devolve o tempo estimado a completar o serviço.
	 * @return float em horas
	 */
	float getDuration();

	/**
	 * Devolve a descrição do serviço.
	 * @return String
	 */
	String getDescription();

	/**
	 * Testa se o serviço é aplicável a um dado veículo.
	 * @param vehicle veículo a aplicar o serviço
	 */
	boolean canApplyTo(IVehicle vehicle);

}