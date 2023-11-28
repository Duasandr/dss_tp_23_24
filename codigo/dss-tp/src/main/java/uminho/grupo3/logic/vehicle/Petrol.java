package uminho.grupo3.logic.vehicle;

import uminho.grupo3.logic.vehicle.interfaces.IPetrol;

public class Petrol extends Vehicle implements IPetrol {

	/**
	 * Construtor parametrizado.
	 * @param licensePlate matrícula do veículo
	 */
	public Petrol(String licensePlate) {
		super(licensePlate);
	}

}