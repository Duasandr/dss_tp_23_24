package uminho.grupo3.logic.vehicle;

import uminho.grupo3.logic.vehicle.interfaces.IDiesel;

public class Diesel extends Vehicle implements IDiesel {

	/**
	 * Construtor parametrizado.
	 * @param licensePlate matrícula do veículo
	 */
	public Diesel(String licensePlate) {
		super(licensePlate);
	}

}