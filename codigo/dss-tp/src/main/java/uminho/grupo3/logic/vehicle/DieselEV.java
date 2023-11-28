package uminho.grupo3.logic.vehicle;

import uminho.grupo3.logic.vehicle.interfaces.IDiesel;

public class DieselEV extends Electric implements IDiesel {

	/**
	 * Construtor parametrizado.
	 * @param licensePlate matrícula do veículo
	 */
	public DieselEV(String licensePlate) {
		super(licensePlate);
	}

}