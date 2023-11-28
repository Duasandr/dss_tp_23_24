package uminho.grupo3.logic.vehicle;

import uminho.grupo3.logic.vehicle.interfaces.IPetrol;

public class PetrolEV extends Electric implements IPetrol {

	/**
	 * Construtor parametrizado.
	 * @param licensePlate matrícula do veículo
	 */
	public PetrolEV(String licensePlate) {
		super(licensePlate);
	}

}